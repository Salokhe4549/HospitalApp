package controller;

import java.util.List;
import java.util.Scanner;

import dao.StaffsDao;
import model.Staffs;


public class StaffApp {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		int op;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Press 1 for Add a Staff");
		System.out.println("Press 2 for Modify Staff Details");
		System.out.println("Press 3 for Remove a Staff");
		System.out.println("Press 4 for Retrive All Data");
		System.out.println("Press 0 for Exit");
		System.out.print("Enter Your Choice:");
	
		op = sc.nextInt();
		int res = 0;
		StaffsDao dao = new StaffsDao();

		do {
			
		switch (op) {
		case 1:
			System.out.println("Addding Data");
			System.out.println("Enter Staff ID");
			int staff_id = sc.nextInt();
			
			System.out.println("Enter Staff Name");
			sc.nextLine();
			String name = sc.nextLine();
			
			System.out.println("Enter Staff Role");
			String role = sc.nextLine();
			
			System.out.println("Enter Staff Contact_Info");
			String contact_info = sc.nextLine();
		
			Staffs staff = new Staffs(staff_id, name , role, contact_info);
			res = dao.insertStaff(staff);
			if (res>0) {
				System.out.println("Adding Done");
			} else {
				System.out.println("Work Failed");
			}
			break;
			
		case 2:
			System.out.println("Modifying Staff Details");
			System.out.println("Enter id");
			int id = sc.nextInt();
			res = dao.modifyStaff(id);
			if (res>0) {
				System.out.println("\nModifying Done");
			} else {
				System.out.println("Modifying Failed");
			}
			break;
			
		case 3:
			System.out.println("Removing a Staff");
			System.out.println("Enter Staff ID to Delete");
			int id1 = sc.nextInt();
			res = dao.deleteStaff(id1);
			if (res>0) {
				System.out.println("Removing Done");
			} else {
				System.out.println("Removing Failed");
			}
			break;
			
		case 4:
			System.out.println("Retriving All Data");
			List<Staffs> showStaff = dao.showStaff();
			showStaff.forEach((obj)->System.out.println(obj));
			System.out.println("Data Retrived ");
			break;
		
		case 0:
                System.out.println("Exiting application...");
                break;

		default:
			throw new IllegalArgumentException("Wrong Operation Choice"+ op);
		}
		
		
		System.out.println("Do You Want to Continue.. Or Press 0");
		op = sc.nextInt();
		} while (op!=0);
		System.out.println("Exited...");
		sc.close();		
	}
	

}
