package com.employee.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeDao;
import com.employee.model.EmployeeRequestModel;
import com.employee.model.EmployeeResponse;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public String generateReferenceNumber() {
		String referenceNumber = UUID.randomUUID().toString();
		return referenceNumber;
	}

	@Override
	public String createEmailId(String firstName, String lastName) {
		String emailId = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@gmail.com";
		return emailId;
	}

	@Override
	public EmployeeResponse saveEmployee(EmployeeRequestModel employeeRequestModel) {

		String referenceNumber = generateReferenceNumber();

		String emailId = createEmailId(employeeRequestModel.getFirstName(), employeeRequestModel.getLastName());

		employeeRequestModel.setEmailId(emailId);
		employeeRequestModel.setEmployeeReferenceNumber(referenceNumber);
		
		EmployeeResponse employeeResponse = employeeDao.saveEmployee(employeeRequestModel);

		return employeeResponse;
	}

}
