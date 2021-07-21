package com.example.weather.weather.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.weather.weather.model.Employee;
import com.example.weather.weather.model.Weather;
import com.example.weather.weather.repository.EmployeeRepository;
import com.example.weather.weather.repository.WeatherService;

@RestController
@RequestMapping("/api/v2")
public class WeatherController {

	@Autowired
	EmployeeRepository employeeRepo;
	
	@Autowired
	WeatherService weatherservice;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeRepo.findAll();	
	}
	
	@RequestMapping("/now/{country}/{city}")
	public Weather getWeather(@PathVariable String country,
			@PathVariable String city) {
		System.out.println("country"+country +"city"+ city);
		return this.weatherservice.getWeather(country, city);
	}
	
}
