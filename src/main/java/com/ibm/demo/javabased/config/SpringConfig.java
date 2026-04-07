package com.ibm.demo.javabased.config;

import org.springframework.context.annotation.Bean;

import com.ibm.demo.javabased.model.Employee;

public class SpringConfig {

	@Bean
	public Employee employee() {
		return new Employee(1, "Tonu", 95000);
	}
}
