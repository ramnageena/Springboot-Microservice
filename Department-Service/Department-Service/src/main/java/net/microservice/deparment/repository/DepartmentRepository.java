package net.microservice.deparment.repository;

import net.microservice.deparment.dto.DepartmentDto;
import net.microservice.deparment.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    Department findByDepartmentCode(String departmentCode);
}
