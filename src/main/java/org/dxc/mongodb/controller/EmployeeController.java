package org.dxc.mongodb.controller;

import java.util.Collection;

import java.util.Optional;

import org.dxc.mongodb.model.Employee;
import org.dxc.mongodb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/findall")
	public Collection<Employee> findAllEmployee() {
		Collection<Employee> employee = employeeService.getAllEmployees();

		System.out.println(employee);
		return employee;
	}

	/*
	 * @RequestMapping("/findbyid") public Optional<Employee>
	 * findById(@RequestParam("id") double id) { Optional<Employee> result =
	 * employeeService.findEmployeeById(id); return result; }
	 */

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public HttpStatus insertEmployee(@RequestBody Employee employee) {
		boolean status = employeeService.saveEmployee(employee);
		return status ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	}

	@RequestMapping(value = "/updateemployee/{id}", method = RequestMethod.PUT)
	public void updateEmployee(@PathVariable("id") double id, @RequestBody Employee employee) {

		employee.setId(id);
		employeeService.updateEmployee(employee);

	}
		@RequestMapping(value= "/delete/{id}",method = RequestMethod.DELETE)
		public void deleteEmployee(@PathVariable("id")double id) {
			employeeService.deleteEmployeeById(id);
		}
		 

	}

