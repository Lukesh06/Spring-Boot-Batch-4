package com.employee.dao;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee.entity.EmployeeEntity;
import com.employee.model.EmployeeRequestModel;
import com.employee.model.EmployeeResponse;
import com.employee.repository.EmployeeRepository;

@Component
public class EmployeeDao {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public EmployeeResponse saveEmployee(EmployeeRequestModel employeeRequestModel) {
		
		EmployeeResponse employeeResponse = new EmployeeResponse();
		
		EmployeeEntity employeeEntity = new EmployeeEntity();
		
		BeanUtils.copyProperties(employeeRequestModel, employeeEntity);
		
		employeeEntity = employeeRepository.save(employeeEntity);
		
		BeanUtils.copyProperties(employeeEntity, employeeResponse);
		
		return employeeResponse;
		
	}
	
}
