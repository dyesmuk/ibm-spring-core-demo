package com.ibm.demo.javabased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.ibm.demo.javabased.config.SpringConfig;
import com.ibm.demo.javabased.model.Employee;

public class App {
	public static void main(String[] args) {
		System.out.println("Start");
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

		Employee emp1 = context.getBean(Employee.class);
		System.out.println(emp1.toString());
		System.out.println("End");
		((AbstractApplicationContext) context).close();
	}
}
