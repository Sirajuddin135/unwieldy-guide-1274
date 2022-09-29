package com.cims.dao;

import java.util.List;

import com.cims.bean.Case;
import com.cims.bean.CaseDTO;
import com.cims.bean.Criminal;

public interface CaseDao {
	public String registerACase(Case c, Criminal criminal);
	
	public List<CaseDTO> getCasesByCriminalNames(String suspectName);
	
	public List<CaseDTO> getCriminalsByCrimeType(String typeOfCrime);
	
	public String updateCaseStatus(int caseId);
	
	public List<Integer> getTotalCaseByArea(String areaName);
}
