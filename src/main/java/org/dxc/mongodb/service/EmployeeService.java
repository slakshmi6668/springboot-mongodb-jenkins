package org.dxc.mongodb.service;

import java.util.Collection;

import java.util.Optional;

import org.dxc.mongodb.model.Employee;

public interface EmployeeService {
public boolean saveEmployee(Employee employee);
public Collection<Employee>getAllEmployees();
public Optional<Employee>findEmployeeById(double id);
void deleteEmployeeById(double id);
void updateEmployee(Employee employee);


}
