package net.microservice.deparment.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.microservice.deparment.dto.DepartmentDto;
import net.microservice.deparment.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Tag(
        name = "DEPARTMENT-SERVICE DepartmentController",
        description = "Department Controller for Expose REST APIs for DEPARTMENT-SERVICE"
)
@RestController
@RequestMapping("api/departments")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @Operation(
            summary = "Save Department Rest API",
            description = "Save Department Rest API is used to save department Object in a DB"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HttpStatus 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto saveDepartment = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(saveDepartment, HttpStatus.CREATED);
    }


    @Operation(
            summary = "Get Department Rest API",
            description = "Get Department Rest API is used to GET department Object in a DB"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HttpStatus 200 FOUND"
    )
    @GetMapping("{department-code}")
    public  ResponseEntity<DepartmentDto> getDepartments(@PathVariable("department-code") String departmentCode){
        DepartmentDto departmentDto = departmentService.getByDepartments(departmentCode);
        return  new ResponseEntity<>(departmentDto,HttpStatus.FOUND);
    }
}
