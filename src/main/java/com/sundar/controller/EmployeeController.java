package com.sundar.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sundar.dao.EmployeeDao;
import com.sundar.model.Employee;
import com.sundar.service.CRUDService;
import com.sundar.service.Impl.EmployeeServiceImpl;

@Controller
public class EmployeeController {

	 
	@Autowired
	 private CRUDService crudService;
	
	public CRUDService getCrudService() {
		return crudService;
	}

	public void setCrudService(CRUDService crudService) {
		this.crudService = crudService;
	}

	@RequestMapping("/add")
	public ModelAndView addEmployee(HttpServletRequest request, HttpServletResponse response){
		
		System.out.println("EmployeeController.addEmployee");
		Employee employee = new Employee();
		long id;
		ModelAndView mv = new ModelAndView();
		
		String name = request.getParameter("name");
		String department = request.getParameter("department");
		
		employee.setName(name);
		employee.setDepartment(department);
		
		/*id = employeeDao.add(employee);*/
		id = crudService.save(employee);
		
		
		mv.setViewName("success");
		mv.addObject("empId", id);
		
		return mv;
		
	}
	
	@RequestMapping("/getList")
	public ModelAndView getEmployeeList(HttpServletRequest request, HttpServletResponse response){
		
		System.out.println("EmployeeController.getEmployeeList");
		ModelAndView mv = new ModelAndView();
		List<Employee> employeeList = crudService.get();
		/*for (Employee employee : employeeList) {
			employee.toString();
			System.out.println(employee.getId()+"----"+ employee.getName()+"----"+employee.getDepartment()); 
		}*/
		mv.setViewName("list");
		mv.addObject("employeeList", employeeList);
		return mv;
	}
	
	@RequestMapping("/view")
	public ModelAndView viewEmployeeById(@RequestParam int id, HttpServletRequest request, HttpServletResponse response){
		System.out.println("EmployeeController.viewEmployeeById");
		ModelAndView mv = new ModelAndView();
		Employee employee = crudService.getById(id);
		mv.setViewName("view");
		mv.addObject("employee", employee);
		return mv;
	}
}
