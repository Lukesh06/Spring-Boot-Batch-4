package com.employee.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.EmployeeRequestModel;
import com.employee.model.EmployeeResponse;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@GetMapping(value = "/details", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<EmployeeResponse> getEmployeeDetails() {

		EmployeeResponse employeeResponse = new EmployeeResponse(100, "Poonam", "Saket", "Kolar Road", "Bhopal",
				"Madhya Pradesh", 487125, 9652478569l, "poonam.saket@gmail.com");

		ResponseEntity<EmployeeResponse> responseObject = new ResponseEntity<EmployeeResponse>(employeeResponse,
				HttpStatus.ACCEPTED);

		return responseObject;

	}

	@GetMapping(value = "/all/details", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public List<EmployeeResponse> getAllEmployeeDetails() {

		EmployeeResponse employeeResponse1 = new EmployeeResponse(100, "Poonam", "Saket", "Kolar Road", "Bhopal",
				"Madhya Pradesh", 487125, 9652478569l, "poonam.saket@gmail.com");

		EmployeeResponse employeeResponse2 = new EmployeeResponse(101, "Gauri", "Sharma", "Maharana Pratap Nagar",
				"Bhopal", "Madhya Pradesh", 487125, 9854712589l, "gauri.sharma@gmail.com");

		EmployeeResponse employeeResponse3 = new EmployeeResponse(102, "Manoj", "Kumar", "Station Road", "Gwalior",
				"Madhya Pradesh", 425145, 9856325412l, "manoj.kumar@gmail.com");

		List<EmployeeResponse> listOfEmployee = new ArrayList<EmployeeResponse>();

		listOfEmployee.add(employeeResponse1);
		listOfEmployee.add(employeeResponse2);
		listOfEmployee.add(employeeResponse3);

		return listOfEmployee;
	}

	@PostMapping(value = "/create")
	public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody EmployeeRequestModel employeeRequestModel) {

		EmployeeResponse employeeResponse = new EmployeeResponse();

		String referenceNumber = UUID.randomUUID().toString();
		String emailId = employeeRequestModel.getFirstName().toLowerCase() + "."
				+ employeeRequestModel.getLastName().toLowerCase() + "@gmail.com";
		
		employeeResponse.setEmailId(emailId);
		employeeResponse.setEmployeeReferenceNumber(referenceNumber);
		
		
		BeanUtils.copyProperties(employeeRequestModel, employeeResponse);
		
		ResponseEntity<EmployeeResponse> response = new ResponseEntity<EmployeeResponse>(employeeResponse, HttpStatus.CREATED);
		
		return response;
		

	}

}
