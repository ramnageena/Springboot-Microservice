package net.microservice.employee.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Schema(
        description = "APIResponseDto Model Information"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIResponseDto {
    @Schema(
            description = "EmployeeDto Code"
    )
    private  EmployeeDto employeeDto;

    @Schema(
            description = "DepartmentDto Code"
    )
    private  DepartmentDto departmentDto;

    @Schema(
            description = "OrganizationDto Code"
    )
    private OrganizationDto organizationDto;
}
