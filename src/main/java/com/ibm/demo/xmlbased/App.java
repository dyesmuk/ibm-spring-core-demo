package com.ibm.demo.xmlbased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ibm.demo.xmlbased.model.Employee;

public class App {
	public static void main(String[] args) {
		System.out.println("Start");
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		Employee emp1 = context.getBean(Employee.class);
		System.out.println(emp1.toString());
		System.out.println("End");
		((AbstractApplicationContext) context).close();
	}
}
