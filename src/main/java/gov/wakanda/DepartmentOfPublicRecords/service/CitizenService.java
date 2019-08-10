package gov.wakanda.DepartmentOfPublicRecords.service;

import java.util.List;

import org.springframework.data.domain.Page;

import gov.wakanda.DepartmentOfPublicRecords.model.Citizen;

public interface CitizenService {
	
	List<Citizen> getAllCitizens();
	Page<Citizen> getAllCitizens(int pageNo);
	Citizen addNewCitizen(Citizen citizen);
	public Double computeYearlyIncome();

}
