package com.sundar.dao;

import java.util.List;

import com.sundar.model.Employee;

public interface EmployeeDao {

	long add(Employee e);
	List<Employee> list();
	Employee getById(long id);
}
