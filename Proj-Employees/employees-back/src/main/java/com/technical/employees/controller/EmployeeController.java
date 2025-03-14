package com.technical.employees.controller;

import com.technical.employees.model.ApiResponse;
import com.technical.employees.model.Employee;
import com.technical.employees.service.BusinessService;
import com.technical.employees.service.EmployeeDataService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeDataService employeeDataService;

    @Autowired
    private BusinessService businessService;


    @GetMapping("/employees")
    public ApiResponse<Employee[]> getAllEmployees() {
        ApiResponse<Employee[]> response = employeeDataService.getAllEmployees();
        if(response != null && response.getData() != null) {
            for (Employee emp : response.getData()) {
                int annualSalary = businessService.calculateAnnualSalary(emp);
                emp.setEmployeeAnnualSalary(annualSalary);
            }
        }
        return response;
    }

    @GetMapping("/employees/{id}")
    public ApiResponse<Employee> getEmployeeById(@PathVariable int id) {
        ApiResponse<Employee> response = employeeDataService.getEmployeeById(id);
        if(response != null && response.getData() != null) {
            int annualSalary = businessService.calculateAnnualSalary(response.getData());
            response.getData().setEmployeeAnnualSalary(annualSalary);
        }
        return response;
    }
}
