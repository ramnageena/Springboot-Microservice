package net.microservice.employee.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Schema(
        description = "EmployeeDto Model Information"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Long id;

    @Schema(
            description = "EmployeeDto First Name"
    )
    private String firstName;

    @Schema(
            description = "EmployeeDto Last Name"
    )
    private String lastName;

    @Schema(
            description = "EmployeeDto Email"
    )
    private String email;

    @Schema(
            description = "DepartmentDto Code"
    )
    private String departmentCode;

    @Schema(
            description = "OrganizationDto Code"
    )
    private String organizationCode;
}
