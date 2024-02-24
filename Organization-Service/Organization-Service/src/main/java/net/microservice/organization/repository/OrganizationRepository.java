package net.microservice.organization.repository;

import net.microservice.organization.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository  extends JpaRepository<Organization ,Long> {
    Organization findByOrganizationCode(String organizationCode);
}
