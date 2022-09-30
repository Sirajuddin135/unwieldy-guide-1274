package com.cims.useCase;

import java.util.List;
import java.util.Scanner;

import com.cims.dao.CaseDao;
import com.cims.dao.CaseDaoImpl;

public class GetTotalCaseByArea {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter area/police station name to get total cases: ");
		String areaName = sc.nextLine();
		
		CaseDao c = new CaseDaoImpl();
		
		List<String> totalCasesDetails = c.getTotalCaseByArea(areaName);
		
		totalCasesDetails.forEach(System.out::println);
		
		sc.close();
	}
}
