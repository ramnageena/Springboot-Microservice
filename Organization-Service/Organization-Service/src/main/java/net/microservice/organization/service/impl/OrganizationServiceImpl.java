package net.microservice.organization.service.impl;

import net.microservice.organization.Dto.OrganizationDto;
import net.microservice.organization.entity.Organization;
import net.microservice.organization.repository.OrganizationRepository;
import net.microservice.organization.service.OrganizationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private OrganizationRepository organizationRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        Organization org = modelMapper.map(organizationDto, Organization.class);
        Organization savedOrg = organizationRepository.save(org);
        return modelMapper.map(savedOrg,OrganizationDto.class);
    }


    @Override
    public OrganizationDto getOrganizations(String organizationCode) {
        Organization byOrganizationCode = organizationRepository.findByOrganizationCode(organizationCode);
        return modelMapper.map(byOrganizationCode,OrganizationDto.class);
    }
}
