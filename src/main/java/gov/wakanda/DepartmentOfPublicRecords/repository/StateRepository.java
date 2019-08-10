package gov.wakanda.DepartmentOfPublicRecords.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.wakanda.DepartmentOfPublicRecords.model.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
