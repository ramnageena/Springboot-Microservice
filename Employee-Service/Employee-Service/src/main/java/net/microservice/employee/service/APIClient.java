package net.microservice.employee.service;

import net.microservice.employee.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(url = "http://localhost:8080", value = "DEPARTMENT-SERVICE")
public interface APIClient {
    // Build get department rest api
    @GetMapping("api/departments/{department-code}")
    DepartmentDto getDepartments(@PathVariable("department-code") String departmentCode);
}

