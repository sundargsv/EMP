package com.sundar.service;

import java.util.List;

import com.sundar.model.Employee;

public interface CRUDService {

	long save(Employee e);
	List<Employee> get();
	Employee getById(long id);
}
