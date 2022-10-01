package com.cims.dao;

import java.util.List;

import com.cims.bean.Case;
import com.cims.bean.CaseDTO;
import com.cims.bean.Criminal;
import com.cims.bean.CriminalDTO;
import com.cims.exceptions.CaseException;
import com.cims.exceptions.CriminalException;

public interface CaseDao {
	public String registerACase(Case c, Criminal criminal) throws CriminalException, CaseException;
	
	public String updateCaseStatus(int caseId) throws CaseException;
	
	public List<CriminalDTO> getCriminalsByCrimeType(String typeOfCrime) throws CriminalException;
	
	public List<CaseDTO> getCasesByCriminalNames(String suspectName) throws CaseException;
	
	public List<String> getTotalCaseByArea(String areaName) throws CaseException;
}
