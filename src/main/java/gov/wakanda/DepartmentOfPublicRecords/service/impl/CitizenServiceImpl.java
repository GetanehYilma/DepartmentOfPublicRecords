package gov.wakanda.DepartmentOfPublicRecords.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import gov.wakanda.DepartmentOfPublicRecords.model.Citizen;
import gov.wakanda.DepartmentOfPublicRecords.repository.CitizenRepository;
import gov.wakanda.DepartmentOfPublicRecords.service.CitizenService;

@Service
public class CitizenServiceImpl implements CitizenService {
	@Autowired
	private CitizenRepository citizenRepository;

	@Override
	public List<Citizen> getAllCitizens() {
		
		return citizenRepository.findAll();
	}

	@Override
	public Page<Citizen> getAllCitizens(int pageNo) {
		
		return citizenRepository.findAll(PageRequest.of(pageNo, 4, Sort.by("lastName")));
	}

	@Override
	public Citizen addNewCitizen(Citizen citizen) {
		
		return citizenRepository.save(citizen);
	}
	
	@Override
    public Double computeYearlyIncome() {
        Double income = 0.0;
        List<Citizen> citizens = citizenRepository.findAll();
        for(Citizen citizen : citizens) {
            
                income += citizen.getYearlyIncome();
            }
        
        return income;
    }

}
