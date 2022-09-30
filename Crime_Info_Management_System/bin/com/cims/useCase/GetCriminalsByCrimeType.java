package com.cims.useCase;

import java.util.List;
import java.util.Scanner;

import com.cims.bean.CriminalDTO;
import com.cims.dao.CaseDao;
import com.cims.dao.CaseDaoImpl;
import com.cims.exceptions.CriminalException;

public class GetCriminalsByCrimeType {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter type of crime to get criminals data: ");
		String crimeType = sc.nextLine();
		
		CaseDao c = new CaseDaoImpl();
		
		try {
			List<CriminalDTO> criminalsList = c.getCriminalsByCrimeType(crimeType);
		
			criminalsList.forEach(criminal -> {
				System.out.println("Criminal ID: " + criminal.getCriminalId());
				System.out.println("Criminal name: " + criminal.getCriminalName());
				System.out.println("Age: " + criminal.getAge());
				System.out.println("Gender: " + criminal.getGender());
				System.out.println("Identification Marks: " + criminal.getIdentificationMarks());
				System.out.println("Address: " + criminal.getAddress());
				System.out.println("Case ID: " + criminal.getCaseId());
				System.out.println("Type of crime: " + criminal.getTypeOfCrime());
				System.out.println("Details of crime: " + criminal.getDesc());
				System.out.println("Victim name: " + criminal.getVictimName());
				System.out.println("Area of crime: " + criminal.getAreaOfCrime());
				System.out.println("Case status: " + criminal.getStatus());
				System.out.println("=========================================");
			});
		} catch (CriminalException e) {
			System.out.println(e.getMessage());
		}
		
		sc.close();
	}
}
