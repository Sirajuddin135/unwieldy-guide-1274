package com.cims.useCase;

import java.util.List;
import java.util.Scanner;

import com.cims.bean.CaseDTO;
import com.cims.dao.CaseDao;
import com.cims.dao.CaseDaoImpl;
import com.cims.exceptions.CaseException;

public class GetCasesByCriminalNames {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter criminal name to get cases on that name: ");
		String criminalName = sc.nextLine();
		
		CaseDao cases = new CaseDaoImpl();
	
		try {
			List<CaseDTO> caseList = cases.getCasesByCriminalNames(criminalName);
			
			caseList.forEach(c -> {
				System.out.println("Police Station: " + c.getPoliceStation());
				System.out.println("Case ID: " + c.getCaseId());
				System.out.println("Date: " + c.getDate());
				System.out.println("Type of crime: " + c.getTypeOfCrime());
				System.out.println("Description: " + c.getDesc());
				System.out.println("Victim name: " + c.getVictimName());
				System.out.println("Criminal ID: " + c.getCriminalId());
				System.out.println("Criminal name: " + c.getCriminalName());
				System.out.println("Status of case: " + c.getStatus());
				System.out.println("=========================================");
			});
		} catch (CaseException e) {
			System.out.println(e.getMessage());
		}
		
		sc.close();
	}
}
