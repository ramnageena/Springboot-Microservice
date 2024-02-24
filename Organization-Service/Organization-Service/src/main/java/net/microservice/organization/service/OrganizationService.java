package net.microservice.organization.service;

import net.microservice.organization.Dto.OrganizationDto;

public interface OrganizationService {

    OrganizationDto saveOrganization(OrganizationDto organizationDto);

    OrganizationDto getOrganizations(String organizationCode);
}
