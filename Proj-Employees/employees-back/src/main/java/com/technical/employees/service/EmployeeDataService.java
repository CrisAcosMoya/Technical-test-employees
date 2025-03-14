package com.technical.employees.service;

import com.technical.employees.model.ApiResponse;
import com.technical.employees.model.Employee;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeDataService {
    private final RestTemplate restTemplate = new RestTemplate();

    public ApiResponse<Employee[]> getAllEmployees() {
        String url = "http://dummy.restapiexample.com/api/v1/employees";
        ApiResponse<Employee[]> response = restTemplate.getForObject(url, ApiResponse.class);
        return response;
    }

    public ApiResponse<Employee> getEmployeeById(int id) {
        String url = "http://dummy.restapiexample.com/api/v1/employee/" + id;
        ApiResponse<Employee> response = restTemplate.getForObject(url, ApiResponse.class);
        return response;
    }
}
