package digital.project.employeemanagement.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table (name = "Employees_Details")
@DynamicInsert
@DynamicUpdate
public class EmployeeDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "Employee_Id", unique = true, nullable = false)
	private String employeeId;
	
	@Column(name = "Employee_Code", nullable = false)
	private int employeeCode;
	
	@Column (name = "Employee_Name", nullable = false, length = 100)
	private String employeeName;
	
	@Column (name = "Manager_Name")
	private String employeeManagerName;
	
	@Column (name = "Date_Of_Birth")
	private LocalDate dateOfBirth;
	
	@Column (name = "Employee_Salary")
	private BigDecimal employeeSalary;
	
	@Column (name = "Date_Of_Joining")
	private LocalDate dateOfJoining;
	
	@Column (name = "Job_Id")
	private int jobId;

	@Column (name = "Department_Id")
	private long departmentId;
	
	@Column (name = "Department_Name")
	private String departmentName;
	
	@Column (name = "Designation")
	private String employeeDesignation;
	
	@Column (name = "Mobile", nullable = false)
	private String mobileNumber;
	
	@Column (name = "Personal_Email", unique = true, length = 255)
	private String personalEmailAddress;
	
	@Column (name = "Domain_Email", unique = true, length = 255)
	private String domainEmailAddress;
	
	@Column (name = "Gender")
	private String gender;
	
	@Column (name = "Job_Type")
	private String jobType;
	
	@Column (name = "Marital_Status")
	private String maritalStatus;
	
	@Column (name = "Blood_Group")
	private String bloodGroup;
	
	@Column (name = "Pan_Card_Number", nullable = false, unique = true)
	private String panNumber;
	
	@Column (name = "Aadhar_Card_Number", nullable = false, unique = true)
	private String aadharCardNumber;
	
	@Column (name = "Passport_Number")
	private String passportNumber;
	
	@Column (name = "Father_Name")
	private String fatherName;

	public int getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(int employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeManagerName() {
		return employeeManagerName;
	}

	public void setEmployeeManagerName(String employeeManagerName) {
		this.employeeManagerName = employeeManagerName;
	}


	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public BigDecimal getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(BigDecimal employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	
	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getEmployeeDesignation() {
		return employeeDesignation;
	}

	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}


	public String getPersonalEmailAddress() {
		return personalEmailAddress;
	}

	public void setPersonalEmailAddress(String personalEmailAddress) {
		this.personalEmailAddress = personalEmailAddress;
	}

	public String getDomainEmailAddress() {
		return domainEmailAddress;
	}

	public void setDomainEmailAddress(String domainEmailAddress) {
		this.domainEmailAddress = domainEmailAddress;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getAadharCardNumber() {
		return aadharCardNumber;
	}

	public void setAadharCardNumber(String aadharCardNumber) {
		this.aadharCardNumber = aadharCardNumber;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	
	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "EmployeeDetails [employeeCode=" + employeeCode + ", employeeName=" + employeeName + ", employeeId="
				+ employeeId + ", employeeManagerName=" + employeeManagerName + ", dateOfBirth=" + dateOfBirth
				+ ", employeeSalary=" + employeeSalary + ", dateOfJoining=" + dateOfJoining + ", jobId=" + jobId
				+ ", departmentId=" + departmentId + ", departmentName=" + departmentName + ", employeeDesignation="
				+ employeeDesignation + ", mobileNumber=" + mobileNumber + ", personalEmailAddress="
				+ personalEmailAddress + ", domainEmailAddress=" + domainEmailAddress + ", gender=" + gender
				+ ", jobType=" + jobType + ", maritalStatus=" + maritalStatus + ", bloodGroup=" + bloodGroup
				+ ", panNumber=" + panNumber + ", aadharCardNumber=" + aadharCardNumber + ", passportNumber="
				+ passportNumber + ", fatherName=" + fatherName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aadharCardNumber == null) ? 0 : aadharCardNumber.hashCode());
		result = prime * result + ((bloodGroup == null) ? 0 : bloodGroup.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((dateOfJoining == null) ? 0 : dateOfJoining.hashCode());
		result = prime * result + (int) (departmentId ^ (departmentId >>> 32));
		result = prime * result + ((departmentName == null) ? 0 : departmentName.hashCode());
		result = prime * result + ((domainEmailAddress == null) ? 0 : domainEmailAddress.hashCode());
		result = prime * result + employeeCode;
		result = prime * result + ((employeeDesignation == null) ? 0 : employeeDesignation.hashCode());
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
		result = prime * result + ((employeeManagerName == null) ? 0 : employeeManagerName.hashCode());
		result = prime * result + ((employeeName == null) ? 0 : employeeName.hashCode());
		result = prime * result + ((employeeSalary == null) ? 0 : employeeSalary.hashCode());
		result = prime * result + ((fatherName == null) ? 0 : fatherName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + jobId;
		result = prime * result + ((jobType == null) ? 0 : jobType.hashCode());
		result = prime * result + ((maritalStatus == null) ? 0 : maritalStatus.hashCode());
		result = prime * result + ((mobileNumber == null) ? 0 : mobileNumber.hashCode());
		result = prime * result + ((panNumber == null) ? 0 : panNumber.hashCode());
		result = prime * result + ((passportNumber == null) ? 0 : passportNumber.hashCode());
		result = prime * result + ((personalEmailAddress == null) ? 0 : personalEmailAddress.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeDetails other = (EmployeeDetails) obj;
		if (aadharCardNumber == null) {
			if (other.aadharCardNumber != null)
				return false;
		} else if (!aadharCardNumber.equals(other.aadharCardNumber))
			return false;
		if (bloodGroup == null) {
			if (other.bloodGroup != null)
				return false;
		} else if (!bloodGroup.equals(other.bloodGroup))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (dateOfJoining == null) {
			if (other.dateOfJoining != null)
				return false;
		} else if (!dateOfJoining.equals(other.dateOfJoining))
			return false;
		if (departmentId != other.departmentId)
			return false;
		if (departmentName == null) {
			if (other.departmentName != null)
				return false;
		} else if (!departmentName.equals(other.departmentName))
			return false;
		if (domainEmailAddress == null) {
			if (other.domainEmailAddress != null)
				return false;
		} else if (!domainEmailAddress.equals(other.domainEmailAddress))
			return false;
		if (employeeCode != other.employeeCode)
			return false;
		if (employeeDesignation == null) {
			if (other.employeeDesignation != null)
				return false;
		} else if (!employeeDesignation.equals(other.employeeDesignation))
			return false;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		if (employeeManagerName == null) {
			if (other.employeeManagerName != null)
				return false;
		} else if (!employeeManagerName.equals(other.employeeManagerName))
			return false;
		if (employeeName == null) {
			if (other.employeeName != null)
				return false;
		} else if (!employeeName.equals(other.employeeName))
			return false;
		if (employeeSalary == null) {
			if (other.employeeSalary != null)
				return false;
		} else if (!employeeSalary.equals(other.employeeSalary))
			return false;
		if (fatherName == null) {
			if (other.fatherName != null)
				return false;
		} else if (!fatherName.equals(other.fatherName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (jobId != other.jobId)
			return false;
		if (jobType == null) {
			if (other.jobType != null)
				return false;
		} else if (!jobType.equals(other.jobType))
			return false;
		if (maritalStatus == null) {
			if (other.maritalStatus != null)
				return false;
		} else if (!maritalStatus.equals(other.maritalStatus))
			return false;
		if (mobileNumber == null) {
			if (other.mobileNumber != null)
				return false;
		} else if (!mobileNumber.equals(other.mobileNumber))
			return false;
		if (panNumber == null) {
			if (other.panNumber != null)
				return false;
		} else if (!panNumber.equals(other.panNumber))
			return false;
		if (passportNumber == null) {
			if (other.passportNumber != null)
				return false;
		} else if (!passportNumber.equals(other.passportNumber))
			return false;
		if (personalEmailAddress == null) {
			if (other.personalEmailAddress != null)
				return false;
		} else if (!personalEmailAddress.equals(other.personalEmailAddress))
			return false;
		return true;
	}
	
	
	
}
