package gov.wakanda.DepartmentOfPublicRecords.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.wakanda.DepartmentOfPublicRecords.model.Citizen;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long> {

}
