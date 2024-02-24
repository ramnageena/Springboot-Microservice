package net.microservice.employee.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Schema(
        description = "OrganizationDto Model Information"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDto {
    private Long id;
    @Schema(
            description = "OrganizationDto Name"
    )
    private String organizationName;
    @Schema(
            description = "OrganizationDto Description"
    )
    private String organizationDescription;
    @Schema(
            description = "OrganizationDto Code"
    )
    private String organizationCode;
    @Schema(
            description = "OrganizationDto CreatedDate"
    )
    private LocalDateTime createdDate;
}
