package com.employee.service;

import com.employee.model.EmployeeRequestModel;
import com.employee.model.EmployeeResponse;

public interface EmployeeService {

	public String generateReferenceNumber();
	
	public String createEmailId(String firstName, String lastName);
	
	public EmployeeResponse saveEmployee(EmployeeRequestModel employeeRequestModel);
	
}
