package com.technical.employees.service;

import com.technical.employees.model.ApiResponse;
import com.technical.employees.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class EmployeeDataServiceTest {

    @InjectMocks
    private EmployeeDataService employeeDataService;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        ReflectionTestUtils.setField(employeeDataService, "restTemplate", restTemplate);
    }

    @Test
    void testGetAllEmployees() {
        String url = "http://dummy.restapiexample.com/api/v1/employees";

        ApiResponse<Employee[]> dummyResponse = new ApiResponse<>();
        Employee[] employees = new Employee[1];
        Employee emp = new Employee();
        emp.setId(1);
        emp.setEmployeeName("Test Employee");
        emp.setEmployeeSalary(2000);
        employees[0] = emp;
        dummyResponse.setStatus("success");
        dummyResponse.setData(employees);
        dummyResponse.setMessage("Fetched");

        when(restTemplate.getForObject(url, ApiResponse.class)).thenReturn(dummyResponse);

        ApiResponse<Employee[]> result = employeeDataService.getAllEmployees();

        assertNotNull(result, "La respuesta no debe ser nula");
        assertEquals("success", result.getStatus(), "El estado debe ser success");
    }

    @Test
    void testGetEmployeeById() {
        int id = 1;
        String url = "http://dummy.restapiexample.com/api/v1/employee/" + id;

        ApiResponse<Employee> dummyResponse = new ApiResponse<>();
        Employee emp = new Employee();
        emp.setId(1);
        emp.setEmployeeName("Test Employee");
        emp.setEmployeeSalary(3000);
        dummyResponse.setStatus("success");
        dummyResponse.setData(emp);
        dummyResponse.setMessage("Fetched");

        when(restTemplate.getForObject(url, ApiResponse.class)).thenReturn(dummyResponse);

        ApiResponse<Employee> result = employeeDataService.getEmployeeById(id);

        assertNotNull(result, "La respuesta no debe ser nula");
        assertEquals("success", result.getStatus(), "El estado debe ser success");
    }
}
