package com.cims.bean;

public class CaseDTO {
	private String date;
	private String policeStation;
	private int caseId;
	private String typeOfCrime;
	private String desc;
	private String victimName;
	private int criminalId;
	private String criminalName;
	private String status;

	public CaseDTO() {}

	public CaseDTO(String date, String policeStation, int caseId, String typeOfCrime, String desc, String victimName,
			int criminalId, String criminalName, String status) {
		this.date = date;
		this.policeStation = policeStation;
		this.caseId = caseId;
		this.typeOfCrime = typeOfCrime;
		this.desc = desc;
		this.victimName = victimName;
		this.criminalId = criminalId;
		this.criminalName = criminalName;
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPoliceStation() {
		return policeStation;
	}

	public void setPoliceStation(String policeStation) {
		this.policeStation = policeStation;
	}

	public int getCaseId() {
		return caseId;
	}

	public void setCaseId(int caseId) {
		this.caseId = caseId;
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

	public String getVictimName() {
		return victimName;
	}

	public void setVictimName(String victimName) {
		this.victimName = victimName;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CaseDTO [date=" + date + ", policeStation=" + policeStation + ", caseId=" + caseId + ", typeOfCrime="
				+ typeOfCrime + ", desc=" + desc + ", victimName=" + victimName + ", criminalId=" + criminalId
				+ ", criminalName=" + criminalName + ", status=" + status + "]";
	}
}
