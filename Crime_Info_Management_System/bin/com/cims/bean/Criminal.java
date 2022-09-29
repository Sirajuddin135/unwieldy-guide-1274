package com.cims.bean;

public class Criminal {
	private String name;
	private int age;
	private String gender;
	private String address;
	private String identificationMarks;
	private String areaOfCrime;
	private String typeOfCrime;
	
	public Criminal() {}
	
	public Criminal(String name, int age, String gender, String address, String identificationMarks, String areaOfCrime,
			String typeOfCrime) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.identificationMarks = identificationMarks;
		this.areaOfCrime = areaOfCrime;
		this.typeOfCrime = typeOfCrime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIdentificationMarks() {
		return identificationMarks;
	}

	public void setIdentificationMarks(String identificationMarks) {
		this.identificationMarks = identificationMarks;
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

	@Override
	public String toString() {
		return "Criminal [name=" + name + ", age=" + age + ", gender=" + gender + ", address=" + address
				+ ", identificationMarks=" + identificationMarks + ", areaOfCrime=" + areaOfCrime + ", typeOfCrime="
				+ typeOfCrime + "]";
	}
}
