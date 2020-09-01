package org.dxc.mongodb.service;

import java.util.Collection;

import java.util.Optional;

import org.dxc.mongodb.model.Employee;
import org.dxc.mongodb.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Collection<Employee> getAllEmployees() {

		Collection<Employee> e = employeeRepository.findAll();
		return e;
	}


	public Optional<Employee> findEmployeeById(double id) {		
		Optional<Employee>result=employeeRepository.findById(id);
		return result;
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
    employeeRepository.save(employee);
	}

	@Override
	public boolean saveEmployee(Employee employee) {
		boolean e = employeeRepository.save(employee) != null;
		return e;

	}
	@Override
	public void deleteEmployeeById(double id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}


	
}