package com.ibm.demo.annotationbased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.AbstractApplicationContext;

import com.ibm.demo.annotationbased.model.Employee;
//import com.ibm.demo.xmlbased.model.Employee; // will not work 

//@ComponentScan(basePackageClasses = )
@ComponentScan
public class App {

	public static void main(String[] args) {
		System.out.println("Start");
		ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		Employee emp1 = 
//				 new Employee();
//				 null;
				context.getBean(Employee.class);
		System.out.println(emp1.toString());
		System.out.println("End");
		((AbstractApplicationContext) context).close();
	}
}
