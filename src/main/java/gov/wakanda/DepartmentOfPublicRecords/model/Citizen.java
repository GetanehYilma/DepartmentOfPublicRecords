package gov.wakanda.DepartmentOfPublicRecords.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "citizens")
public class Citizen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long citizenId;
	@NotNull
	private String socialSecurityNumber;
	@NotNull
	private String firstName;
	@NotNull
	private String middleName;
	@NotNull
	private String lastName;
	@NotNull
	@NotNull(message = "* Date of birth is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfBirth;
	private double yearlyIncome;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "state_id", nullable = false)
	@NotNull(message = "* State is required")
	private State state;
	
	public Citizen() {
		
	}

	public Citizen(long citizenId, @NotNull String socialSecurityNumber, @NotNull String firstName,
			@NotNull String middleName, @NotNull String lastName, @NotNull LocalDate dateOfBirth, double yearlyIncome,
			@NotNull(message = "* State is required") State state) {
		this.citizenId = citizenId;
		this.socialSecurityNumber = socialSecurityNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.yearlyIncome = yearlyIncome;
		this.state = state;
	}

	public long getCitizenId() {
		return citizenId;
	}

	public void setCitizenId(long citizenaId) {
		this.citizenId = citizenaId;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public double getYearlyIncome() {
		return yearlyIncome;
	}

	public void setYearlyIncome(double yearlyIncome) {
		this.yearlyIncome = yearlyIncome;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	
	

}
