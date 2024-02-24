package net.microservice.deparment.service.impl;

import net.microservice.deparment.dto.DepartmentDto;
import net.microservice.deparment.entity.Department;
import net.microservice.deparment.repository.DepartmentRepository;
import net.microservice.deparment.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    DepartmentRepository departmentRepository;

    //convert dto to department
    public Department mapToDepartment(DepartmentDto departmentDto){
        Department department= modelMapper.map(departmentDto,Department.class);
        return  department;
    }

    //convert department dto to
    public DepartmentDto mapToDto(Department department){
        DepartmentDto departmentDto= modelMapper.map(department,DepartmentDto.class);
        return  departmentDto;
    }

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        DepartmentDto departmentDtoSaved = mapToDto(savedDepartment);
        return departmentDtoSaved;
    }

    @Override
    public DepartmentDto getByDepartments(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        DepartmentDto departmentDto = mapToDto(department);
        return departmentDto;
    }
}
