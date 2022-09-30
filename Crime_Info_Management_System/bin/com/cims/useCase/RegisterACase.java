package com.cims.useCase;

import java.util.Scanner;

import com.cims.bean.Case;
import com.cims.bean.Criminal;
import com.cims.dao.CaseDao;
import com.cims.dao.CaseDaoImpl;

public class RegisterACase {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter date of crime (yyyy/mm/dd): ");
		String dateOfCrime = sc.nextLine();
		
		System.out.println("Enter place: ");
		String place = sc.nextLine();
		
		System.out.println("Enter type of crime: ");
		String typeOfCrime = sc.nextLine();
		
		System.out.println("Enter victim name: ");
		String victimName = sc.nextLine();
		
		System.out.println("Enter description: ");
		String description = sc.nextLine();
		
		System.out.println("Enter criminal name: ");
		String suspectName = sc.nextLine();
		
		System.out.println("Enter age: ");
		int age = sc.nextInt();
		
		System.out.println("Enter gender: ");
		String gender = sc.next();
		
		System.out.println("Enter address: ");
		String address = sc.next();
		
		System.out.println("Enter identification marks: ");
		String identificationMarks = sc.next();
		
		System.out.println("Enter area of suspect arrested: ");
		String areaOfArrest = sc.next();
		
		CaseDao crime = new CaseDaoImpl();
		
		Case c = new Case(dateOfCrime, place, typeOfCrime, victimName, description, suspectName);
		
		Criminal criminal = new Criminal(suspectName, age, gender, address, identificationMarks, areaOfArrest, typeOfCrime);
		
		String result = crime.registerACase(c, criminal);
		
		System.out.println(result);
		
		sc.close();
	}
}
