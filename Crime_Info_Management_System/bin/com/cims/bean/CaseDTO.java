package com.cims.bean;

public class CaseDTO {
	private String victimName;
	private String suspectName;
	private int criminalId;
	private String date;
	
	private int caseId;
	private String typeOfCrime;
	
	private String status;

	public CaseDTO() {}
	
	public CaseDTO(String victimName, String suspectName, int criminalId, String date, int caseId, String typeOfCrime,
			String status) {
		this.victimName = victimName;
		this.suspectName = suspectName;
		this.criminalId = criminalId;
		this.date = date;
		this.caseId = caseId;
		this.typeOfCrime = typeOfCrime;
		this.status = status;
	}

	public String getVictimName() {
		return victimName;
	}

	public void setVictimName(String victimName) {
		this.victimName = victimName;
	}

	public String getSuspectName() {
		return suspectName;
	}

	public void setSuspectName(String suspectName) {
		this.suspectName = suspectName;
	}

	public int getCriminalId() {
		return criminalId;
	}

	public void setCriminalId(int criminalId) {
		this.criminalId = criminalId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CaseDTO [victimName=" + victimName + ", suspectName=" + suspectName + ", criminalId=" + criminalId
				+ ", date=" + date + ", caseId=" + caseId + ", typeOfCrime=" + typeOfCrime + ", status=" + status + "]";
	}
}
