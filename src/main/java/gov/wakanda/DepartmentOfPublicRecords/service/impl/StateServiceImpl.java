package gov.wakanda.DepartmentOfPublicRecords.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import gov.wakanda.DepartmentOfPublicRecords.model.State;
import gov.wakanda.DepartmentOfPublicRecords.repository.StateRepository;
import gov.wakanda.DepartmentOfPublicRecords.service.StateService;

@Service
public class StateServiceImpl implements StateService {
	@Autowired
	private StateRepository stateRepository;

	@Override
	public List<State> getAllStates() {
		
		return stateRepository.findAll();
	}

	@Override
	public Page<State> getAllStates(int pageNo) {
		
		return stateRepository.findAll(PageRequest.of(pageNo, 4, Sort.by("stateName")));
	}

}
