package com.cims.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cims.bean.Case;
import com.cims.bean.CaseDTO;
import com.cims.bean.Criminal;
import com.cims.utility.CIMSDB;

public class CaseDaoImpl implements CaseDao {
	@Override
	public String registerACase(Case c, Criminal criminal) {
		
		String message = "Case not filed...";
		
		try(Connection conn = CIMSDB.provideConnection()) {
			PreparedStatement ps1 = conn.prepareStatement("insert into cases(date, place, typeOfCrime, victims, description, suspect) values(?,?,?,?,?,?)");
			PreparedStatement ps2 = conn.prepareStatement("insert into criminal(name, age, gender, address, identificationMarks, areaOfCrime, typeOfCrime) values(?,?,?,?,?,?,?)");
			PreparedStatement ps3 = conn.prepareStatement("insert into criminal_case_status(caseId, criminalId, status) values(?,?,?)");
			
			ps1.setString(1, c.getDate());
			ps1.setString(2, c.getPlace());
			ps1.setString(3, c.getTypeOfCrime());
			ps1.setString(4, c.getVictims());
			ps1.setString(5, c.getDescription());
			ps1.setString(6, c.getSuspect());
			
			int x = ps1.executeUpdate();
			
			if(x > 0) {
				ps2.setString(1, criminal.getName());
				ps2.setInt(2, criminal.getAge());
				ps2.setString(3, criminal.getGender());
				ps2.setString(4, criminal.getAddress());
				ps2.setString(5, criminal.getIdentificationMarks());
				ps2.setString(6, criminal.getAreaOfCrime());
				ps2.setString(7, criminal.getTypeOfCrime());
				
				int y = ps2.executeUpdate();
				
				if(y > 0) {
					ps1 = conn.prepareStatement("select * from cases where caseId = (select max(caseId) from cases)");
					
					ResultSet rs1 = ps1.executeQuery();
					
					int caseId = 0;
					int criminalId = 0;
					
					if(rs1.next()) {
						caseId = rs1.getInt("caseId");
					}
					
					ps2 = conn.prepareStatement("select * from criminal where criminalId = (select max(criminalId) from criminal)");
					
					ResultSet rs2 = ps2.executeQuery();
					
					if(rs2.next()) {
						criminalId = rs2.getInt("criminalId");
					}
					
					ps3.setInt(1, caseId);
					ps3.setInt(2, criminalId);
					ps3.setString(3, "not solved");
					
					int z = ps3.executeUpdate();
					
					if(z > 0) {
						message = "case filed successfully";
					}
				} else {
					message = "Please enter correct details of criminal";
				}
			} else {
				message = "Please enter correct details of case";
			}
			
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		return message;
	}

	@Override
	public List<CaseDTO> getCasesByCriminalNames(String suspectName) {
		List<CaseDTO> caseList = new ArrayList<>();
		
		return caseList;
	}

	@Override
	public List<CaseDTO> getCriminalsByCrimeType(String typeOfCrime) {
		List<CaseDTO> criminalsList = new ArrayList<>();
		
		return criminalsList;
	}

	@Override
	public String updateCaseStatus(int caseId) {
		String message = "Invalid case id...";
		
		return message;
	}

	@Override
	public List<Integer> getTotalCaseByArea(String areaName) {
		List<Integer> totalCaseDetails = new ArrayList<>();
		
		return totalCaseDetails;
	}
}
