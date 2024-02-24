package net.microservice.employee.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Schema(
        description = "DepartmentDto Model Information"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    private Long id;
    @Schema(
            description = "DepartmentDto Name"
    )
    private String departmentName;
    @Schema(
            description = "DepartmentDto Description"
    )
    private String departmentDescription;
    @Schema(
            description = "DepartmentDto Code"
    )
    private String departmentCode;
}