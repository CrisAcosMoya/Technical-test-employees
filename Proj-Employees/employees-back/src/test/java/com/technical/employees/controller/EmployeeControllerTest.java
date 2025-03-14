package com.technical.employees.controller;

import com.technical.employees.model.ApiResponse;
import com.technical.employees.model.Employee;
import com.technical.employees.service.BusinessService;
import com.technical.employees.service.EmployeeDataService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private EmployeeDataService employeeDataService;

    @Mock
    private BusinessService businessService;

    @Test
    void testGetAllEmployees() throws Exception {
        Employee emp = new Employee();
        emp.setId(1);
        emp.setEmployeeName("John Doe");
        emp.setEmployeeSalary(3000);
        emp.setEmployeeAnnualSalary(0);

        Employee[] employees = new Employee[] { emp };

        ApiResponse<Employee[]> apiResponse = new ApiResponse<>();
        apiResponse.setStatus("success");
        apiResponse.setData(employees);
        apiResponse.setMessage("Fetched");

        when(employeeDataService.getAllEmployees()).thenReturn(apiResponse);
        when(businessService.calculateAnnualSalary(any(Employee.class))).thenReturn(36000);

        mockMvc.perform(get("/api/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0].employeeAnnualSalary").value(36000));
    }

    @Test
    void testGetEmployeeById() throws Exception {
        Employee emp = new Employee();
        emp.setId(1);
        emp.setEmployeeName("Jane Doe");
        emp.setEmployeeSalary(4000);
        emp.setEmployeeAnnualSalary(0);

        ApiResponse<Employee> apiResponse = new ApiResponse<>();
        apiResponse.setStatus("success");
        apiResponse.setData(emp);
        apiResponse.setMessage("Fetched");

        when(employeeDataService.getEmployeeById(1)).thenReturn(apiResponse);
        when(businessService.calculateAnnualSalary(any(Employee.class))).thenReturn(48000);

        mockMvc.perform(get("/api/employees/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.employeeAnnualSalary").value(48000));
    }
}