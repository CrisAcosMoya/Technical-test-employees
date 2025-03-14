package com.technical.employees.service;

import com.technical.employees.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {

    public int calculateAnnualSalary(Employee employee) {
        return employee.getEmployeeSalary() * 12;
    }
}
