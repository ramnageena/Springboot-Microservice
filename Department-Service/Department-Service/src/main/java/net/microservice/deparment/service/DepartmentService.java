package net.microservice.deparment.service;

import net.microservice.deparment.dto.DepartmentDto;

public interface DepartmentService {
   DepartmentDto saveDepartment(DepartmentDto departmentDto);

   DepartmentDto getByDepartments(String deparmentCode);
}
