package net.microservice.employee.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.microservice.employee.dto.APIResponseDto;
import net.microservice.employee.dto.EmployeeDto;
import net.microservice.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Tag(
        name = "EMPLOYEE-SERVICE EmployeeController",
        description = "Employee Controller for Expose REST APIs for EMPLOYEE-SERVICE"
)
@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @Operation(
            summary = "Save Employee Rest API",
            description = "Save Employee Rest API is used to save Employee Object in a DB"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HttpStatus 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployeeDto = employeeService.saveEmployee(employeeDto);
        return  new ResponseEntity<>(savedEmployeeDto, HttpStatus.CREATED);
    }
    @Operation(
            summary = "Get Employee Rest API",
            description = "Get Employee Rest API is used to GET Employee Object in a DB"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HttpStatus 200 FOUND"
    )
    @GetMapping("/{id}")
    public  ResponseEntity<APIResponseDto>getEmployeeById(@PathVariable Long id){
        APIResponseDto apiResponseDto = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(apiResponseDto,HttpStatus.FOUND);
    }
}
