package com.technical.employees.service;

import com.technical.employees.model.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusinessServiceTest {

    private final BusinessService businessService = new BusinessService();

    @Test
    void testCalculateAnnualSalary() {
        Employee employee = new Employee();
        employee.setEmployeeSalary(3000);

        int expectedAnnualSalary = 3000 * 12;
        int actualAnnualSalary = businessService.calculateAnnualSalary(employee);

        assertEquals(expectedAnnualSalary, actualAnnualSalary, "El salario anual debe ser el salario mensual multiplicado por 12");
    }
}