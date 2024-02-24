package net.microservice.organization.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.microservice.organization.Dto.OrganizationDto;
import net.microservice.organization.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Tag(
        name = "ORGANIZATION-SERVICE OrganizationController",
        description = "Organization Controller  for Expose REST APIs for ORGANIZATION-SERVICE"
)
@RestController
@RequestMapping("api/organizations")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;
    @Operation(
            summary = "Save Organization Rest API",
            description = "Save Organization Rest API is used to save Organization Object in a DB"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HttpStatus 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
        OrganizationDto organizationDto1 = organizationService.saveOrganization(organizationDto);
        return  new ResponseEntity<>(organizationDto1, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Organization Rest API",
            description = "Get Organization Rest API is used to GET Organization Object in a DB"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HttpStatus 200 FOUND"
    )
    @GetMapping("{organizationCode}")
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable String organizationCode){
        OrganizationDto organizations = organizationService.getOrganizations(organizationCode);
        return  new ResponseEntity<>(organizations, HttpStatus.FOUND);
    }
}
