package gov.wakanda.DepartmentOfPublicRecords.service;

import java.util.List;


import org.springframework.data.domain.Page;

import gov.wakanda.DepartmentOfPublicRecords.model.State;

public interface StateService {
	
	List<State> getAllStates();
	Page<State> getAllStates(int pageNo);

}
