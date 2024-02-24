package net.microservice.employee.service;

import net.microservice.employee.dto.APIResponseDto;
import net.microservice.employee.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    APIResponseDto getEmployeeById(Long id);
}
