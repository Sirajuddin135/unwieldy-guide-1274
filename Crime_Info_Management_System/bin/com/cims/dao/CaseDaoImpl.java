package com.cims.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cims.bean.Case;
import com.cims.bean.CaseDTO;
import com.cims.bean.Criminal;
import com.cims.bean.CriminalDTO;
import com.cims.exceptions.CaseException;
import com.cims.exceptions.CriminalException;
import com.cims.utility.CIMSDB;

public class CaseDaoImpl implements CaseDao {
	@Override
	public String registerACase(Case c, Criminal criminal) throws CriminalException, CaseException {
		String message = "Case not filed...";
		
		try(Connection conn = CIMSDB.provideConnection()) {
			PreparedStatement ps1 = conn.prepareStatement("insert into cases(date, place, typeOfCrime, victims, description, suspect) values(?,?,?,?,?,?)");
			
			ps1.setString(1, c.getDate());
			ps1.setString(2, c.getPlace());
			ps1.setString(3, c.getTypeOfCrime());
			ps1.setString(4, c.getVictims());
			ps1.setString(5, c.getDescription());
			ps1.setString(6, c.getSuspect());
			
			int x = ps1.executeUpdate();
			
			if(x > 0) {
				PreparedStatement ps2 = conn.prepareStatement("insert into criminal(name, age, gender, address, identificationMarks, areaOfCrime, typeOfCrime) values(?,?,?,?,?,?,?)");

				ps2.setString(1, criminal.getName());
				ps2.setInt(2, criminal.getAge());
				ps2.setString(3, criminal.getGender());
				ps2.setString(4, criminal.getAddress());
				ps2.setString(5, criminal.getIdentificationMarks());
				ps2.setString(6, criminal.getAreaOfCrime());
				ps2.setString(7, criminal.getTypeOfCrime());
				
				int y = ps2.executeUpdate();
				
				if(y > 0) {
					PreparedStatement ps3 = conn.prepareStatement("insert into criminal_case_status(caseId, criminalId, status) values(?,?,?)");
					
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
					} else {
						message = "Technical error! Please try again...";
					}
				} else {
					message = "Please enter correct details of criminal";
					throw new CriminalException(message);
				}
			} else {
				message = "Please enter correct details of case";
				throw new CaseException(message);
			}
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		return message;
	}

	@Override
	public String updateCaseStatus(int caseId) throws CaseException {
		String message = "Invalid case id...";
		
		try(Connection conn = CIMSDB.provideConnection()) {
			PreparedStatement ps1 = conn.prepareStatement("select * from criminal_case_status where caseId = ?");
			ps1.setInt(1, caseId);
			
			ResultSet rs1 = ps1.executeQuery();
			
			if(rs1.next()) {
				String status = rs1.getString("status");
	
				if(status.equals("solved")) {
					message = "Status already updated...";
				} else {
					PreparedStatement ps2 = conn.prepareStatement("update criminal_case_status set status = 'solved' where caseId = ?");
					
					ps2.setInt(1, caseId);
					
					int x = ps2.executeUpdate();
					
					if(x > 0) {
						message = "Status updated successfully";
					}
				}
			}
		} catch (SQLException e) {
			throw new CaseException(e.getMessage());
		}
		
		return message;
	}

	@Override
	public List<CriminalDTO> getCriminalsByCrimeType(String typeOfCrime) throws CriminalException {
		List<CriminalDTO> criminalsList = new ArrayList<>();
		
		try(Connection conn = CIMSDB.provideConnection()) {
			PreparedStatement ps1 = conn.prepareStatement("select * from criminal where typeOfCrime = ?");
			
			ps1.setString(1, typeOfCrime);
			
			ResultSet rs1 = ps1.executeQuery();
			
			while(rs1.next()) {
				int criminalId = rs1.getInt("criminalId");
				String criminalName = rs1.getString("name");
				int age = rs1.getInt("age");
				String gender = rs1.getString("gender");
				String identificationMarks = rs1.getString("identificationMarks");
				String address = rs1.getString("address");
				String areaOfCrime = rs1.getString("areaOfCrime");
				
				PreparedStatement ps2 = conn.prepareStatement("select * from criminal_case_status where criminalId = ?");
				
				ps2.setInt(1, criminalId);
				
				ResultSet rs2 = ps2.executeQuery();
				
				if(rs2.next()) {
					int caseId = rs2.getInt("caseId");
					String status = rs2.getString("status");
					
					PreparedStatement ps3 = conn.prepareStatement("select * from cases where caseId = ?");
					
					ps3.setInt(1, caseId);
					
					ResultSet rs3 = ps3.executeQuery();
					
					if(rs3.next()) {
						String description = rs3.getString("description");
						String victimName = rs3.getString("victims");
						
						CriminalDTO criminalDTO = new CriminalDTO(criminalId, criminalName, age, gender, identificationMarks, address, areaOfCrime, typeOfCrime, description, caseId, victimName, status);
						
						criminalsList.add(criminalDTO);
					}
				}
			}
		} catch(SQLException se) {
			throw new CriminalException(se.getMessage());
		}
		
		return criminalsList;
	}
	
	@Override
	public List<CaseDTO> getCasesByCriminalNames(String criminalName) throws CaseException {
		List<CaseDTO> caseList = new ArrayList<>();
		
		try(Connection conn = CIMSDB.provideConnection()) {
			PreparedStatement ps1 = conn.prepareStatement("select * from criminal where name = ?");
			
			ps1.setString(1, criminalName);
			
			ResultSet rs1 = ps1.executeQuery();
			
			while(rs1.next()) {
				int criminalId = rs1.getInt("criminalId");
				
				PreparedStatement ps2 = conn.prepareStatement("select * from criminal_case_status where criminalId = ?");
				
				ps2.setInt(1, criminalId);
				
				ResultSet rs2 = ps2.executeQuery();
				
				if(rs2.next()) {
					int caseId = rs2.getInt("caseId");
					String status = rs2.getString("status");
					
					PreparedStatement ps3 = conn.prepareStatement("select * from cases where caseId = ?");
					
					ps3.setInt(1, caseId);
					
					ResultSet rs3 = ps3.executeQuery();
					
					if(rs3.next()) {
						String date = rs3.getString("date");
						String place = rs3.getString("place");
						String typeOfCrime = rs3.getString("typeOfCrime");
						String description = rs3.getString("description");
						String victimName = rs3.getString("victims");
						
						CaseDTO caseDTO = new CaseDTO(date, place, caseId, typeOfCrime, description, victimName, criminalId, criminalName, status);
						
						caseList.add(caseDTO);
					}
				}
			}
		} catch(SQLException se) {
			throw new CaseException(se.getMessage());
		}
		
		return caseList;
	}
	
	@Override
	public List<String> getTotalCaseByArea(String areaName) throws CaseException {
		List<String> totalCaseDetails = new ArrayList<>();
		
		try(Connection conn = CIMSDB.provideConnection()) {
			int solvedCases = 0, unsolvedCases = 0, currentMonthRecordedCases = 0;
			boolean flag = true;
			
			PreparedStatement ps1 = conn.prepareStatement("select * from cases where place = ?");
			
			ps1.setString(1, areaName);
			
			ResultSet rs1 = ps1.executeQuery();

			while(rs1.next()) {
				flag = false;
				
				int caseId = rs1.getInt("caseId");
				String date1 = rs1.getString("date");
		
				String pattern = "yyyy-MM-dd";
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
				String date2 = simpleDateFormat.format(new Date());
	
				LocalDate parseDate1 = LocalDate.parse(date1);
				LocalDate parseDate2 = LocalDate.parse(date2);

				if(parseDate1.getMonth() == parseDate2.getMonth() && parseDate1.getYear() == parseDate2.getYear()) {
					currentMonthRecordedCases++;
				}
				
				PreparedStatement ps2 = conn.prepareStatement("select status from criminal_case_status where caseId = ?");

				ps2.setInt(1, caseId);
				
				ResultSet rs2 = ps2.executeQuery();
				
				if(rs2.next()) {
					if(rs2.getString("status").equals("solved")) {
						solvedCases++;
					} else {
						unsolvedCases++;
					}
				}
			}
			
			if(flag) {
				System.out.println("Please enter correct area/policeStation name!!!");
			} else {
				totalCaseDetails.add("Total solved cases: " + solvedCases);
				totalCaseDetails.add("Total unsolved cases: " + unsolvedCases);
				totalCaseDetails.add("Cases recorded in current month: " + currentMonthRecordedCases);
			}
		} catch (SQLException e) {
			throw new CaseException(e.getMessage());
		}
		
		return totalCaseDetails;
	}
}
