import java.util.List;
import java.util.Scanner;

import com.cims.bean.Case;
import com.cims.bean.CaseDTO;
import com.cims.bean.Criminal;
import com.cims.bean.CriminalDTO;
import com.cims.dao.CaseDao;
import com.cims.dao.CaseDaoImpl;
import com.cims.exceptions.CaseException;
import com.cims.exceptions.CriminalException;

public class CIMS {
	private static CaseDao cimsService = new CaseDaoImpl();
	
	public static void selectOption() {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		
		try {
			while(flag) {
				System.out.println("\nEnter an option to continue: ");
				System.out.println("1. Register a case"
								+ "\n2. Update case status"
								+ "\n3. Get criminals by type of crime"
								+ "\n4. Get cases by criminal name"
								+ "\n5. Get total no. of cases"
								+ "\n6. Exit");
				int option = sc.nextInt();
				sc.nextLine();
				
				switch(option) {
				case 1:
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
					sc.nextLine();
					
					System.out.println("Enter gender: ");
					String gender = sc.nextLine();
					
					System.out.println("Enter address: ");
					String address = sc.nextLine();
					
					System.out.println("Enter identification marks: ");
					String identificationMarks = sc.nextLine();
					
					System.out.println("Enter area of suspect arrested: ");
					String areaOfArrest = sc.nextLine();
					
					Case case1 = new Case(dateOfCrime, place, typeOfCrime, victimName, description, suspectName);
					Criminal criminal1 = new Criminal(suspectName, age, gender, address, identificationMarks, areaOfArrest, typeOfCrime);
					
					try {
						String result = cimsService.registerACase(case1, criminal1);
						System.out.println(result);
					} catch (CriminalException | CaseException e1) {
						System.out.println(e1.getMessage());
					}
					
					break;
				case 2:
					System.out.println("Enter case id which status want to be updated: ");
					int caseId = sc.nextInt();
					
					try {
						String status = cimsService.updateCaseStatus(caseId);
						System.out.println(status);
					} catch (CaseException e) {
						System.out.println(e.getMessage());
					}
					
					break;
				case 3:
					System.out.println("Enter type of crime to get criminals data: ");
					String crimeType = sc.nextLine();
					
					try {
						List<CriminalDTO> criminalsList = cimsService.getCriminalsByCrimeType(crimeType);
						
						if(criminalsList.isEmpty()) {
							System.out.println("No criminal record exists with " + crimeType + " case type");
						} else {
							criminalsList.forEach(criminal -> {
								System.out.println(criminal);
								System.out.println("==========================");
							});
						}
					} catch (CriminalException e) {
						System.out.println(e.getMessage());
					}
					
					break;
				case 4:
					System.out.println("Enter criminal name to get cases on that name: ");
					String criminalName = sc.nextLine();
					
					try {
						List<CaseDTO> caseList = cimsService.getCasesByCriminalNames(criminalName);
						if(caseList.isEmpty()) {
							System.out.println("No criminal record exists on criminal name: " + criminalName);
						} else {
							caseList.forEach(c1 -> {
								System.out.println(c1);
								System.out.println("=========================================");
							});
						}
					} catch (CaseException e) {
						System.out.println(e.getMessage());
					}
					
					break;
				case 5:
					System.out.println("Enter area/police station name to get total cases: ");
					String areaName = sc.nextLine();
					
					try {
						List<String> totalCasesDetails = cimsService.getTotalCaseByArea(areaName);
						totalCasesDetails.forEach(System.out::println);
					} catch (CaseException e) {
						System.out.println(e.getMessage());
					}
					
					break;
				case 6:
					flag = false;
					System.out.println("Closing app...");
					break;
				default:
					System.out.println("Invalid option...");
				}
			}
		} catch (Exception e) {
			System.out.println("Select a valid option...");
			selectOption();
		}
		
		System.out.println("Thank you!!!");
		
		sc.close();
	}
}
