package com.sundar.service.Impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sundar.dao.EmployeeDao;
import com.sundar.dao.Impl.EmployeeDaoImpl;
import com.sundar.model.Employee;
import com.sundar.service.CRUDService;

@Service
public class EmployeeServiceImpl implements CRUDService{

	@Autowired
	private EmployeeDao employeeDao;
	
	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Transactional
	public long save(Employee e) {
		
		System.out.println("EmployeeServiceImpl.save");
		long id = employeeDao.add(e);
		return id;
	}

	@Transactional
	public List<Employee> get(){
		System.out.println("EmployeeServiceImpl.get");
		List<Employee> employeeList = employeeDao.list();
		for (Employee employee : employeeList) {
			employee.toString();
		}
		return employeeList;
	}

	public Employee getById(long id) {
		System.out.println("EmployeeServiceImpl.getById");
		Employee employee = employeeDao.getById(id);
		return employee;
	}
	
}
