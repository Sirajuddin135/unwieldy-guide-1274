package com.cims.bean;

public class CriminalDTO {
	private int criminalId;
	private String criminalName;
	private int age;
	private String gender;
	private String identificationMarks;
	private String address;
	private String areaOfCrime;
	private String typeOfCrime;
	private String desc;
	private int caseId;
	private String victimName;
	private String status;
	
	public CriminalDTO() {}

	public CriminalDTO(int criminalId, String criminalName, int age, String gender, String identificationMarks, String address, String areaOfCrime,
			String typeOfCrime, String desc, int caseId, String victimName, String status) {
		this.criminalId = criminalId;
		this.criminalName = criminalName;
		this.age = age;
		this.gender = gender;
		this.identificationMarks = identificationMarks;
		this.address = address;
		this.areaOfCrime = areaOfCrime;
		this.typeOfCrime = typeOfCrime;
		this.desc = desc;
		this.caseId = caseId;
		this.victimName = victimName;
		this.status = status;
	}

	public int getCriminalId() {
		return criminalId;
	}

	public void setCriminalId(int criminalId) {
		this.criminalId = criminalId;
	}

	public String getCriminalName() {
		return criminalName;
	}

	public void setCriminalName(String criminalName) {
		this.criminalName = criminalName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIdentificationMarks() {
		return identificationMarks;
	}

	public void setIdentificationMarks(String identificationMarks) {
		this.identificationMarks = identificationMarks;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAreaOfCrime() {
		return areaOfCrime;
	}

	public void setAreaOfCrime(String areaOfCrime) {
		this.areaOfCrime = areaOfCrime;
	}

	public String getTypeOfCrime() {
		return typeOfCrime;
	}

	public void setTypeOfCrime(String typeOfCrime) {
		this.typeOfCrime = typeOfCrime;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public int getCaseId() {
		return caseId;
	}

	public void setCaseId(int caseId) {
		this.caseId = caseId;
	}

	public String getVictimName() {
		return victimName;
	}

	public void setVictimName(String victimName) {
		this.victimName = victimName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "\nCriminal ID: " + criminalId + "\nCriminal name: " + criminalName + "\nAge: " + age + "\nGender: " +
				gender + "\nIdentification Marks: " + identificationMarks + "\nAddress: " + address + "\nArea of crime: " + 
				areaOfCrime + "\nType of crime: " + typeOfCrime	+ "\nDescription: " + desc + "\nCase ID:  " + caseId + 
				"\nVictim name: " + victimName + "\nStatus: " + status;
	}
}
