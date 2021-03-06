package com.encore.service;

import java.util.ArrayList;

import com.encore.vo.Employee;

//기능의 Template을 모아놓은 인터페이스

public interface EmployeeMapService {
	
	void addEmployee(Employee e); // public abstract 생략

	void deleteEmployee(String empId);

	void updateEmployee(Employee e);

	//Method overloading
	ArrayList<Employee> findEmployees(String addr);
	ArrayList<Employee> findEmployees();

}
