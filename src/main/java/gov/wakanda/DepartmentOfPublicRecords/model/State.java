package gov.wakanda.DepartmentOfPublicRecords.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "states")
public class State {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stateId;
	@NotNull
	private String stateCode;
	@NotNull
	private String stateName;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "state")
	private List<Citizen> citizens;
	
	public State() {
		
	}

	public State(int stateId, @NotNull String stateCode, @NotNull String stateName, List<Citizen> citizens) {
		
		this.stateId = stateId;
		this.stateCode = stateCode;
		this.stateName = stateName;
		this.citizens = citizens;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public List<Citizen> getCitizens() {
		return citizens;
	}

	public void setCitizens(List<Citizen> citizens) {
		this.citizens = citizens;
	}
	
	

}
