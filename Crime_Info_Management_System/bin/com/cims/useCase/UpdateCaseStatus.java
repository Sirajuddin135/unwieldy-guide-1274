package com.cims.useCase;

import java.util.Scanner;

import com.cims.dao.CaseDao;
import com.cims.dao.CaseDaoImpl;
import com.cims.exceptions.CaseException;

public class UpdateCaseStatus {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter case id which status want to be updated: ");
		int caseId = sc.nextInt();
		
		CaseDao c = new CaseDaoImpl();
		
		try {
			String result = c.updateCaseStatus(caseId);
			System.out.println(result);
		} catch (CaseException e) {
			System.out.println(e.getMessage());
		}
		
		sc.close();
	}
}
