package controller;

import java.util.List;
import java.util.Scanner;

import dao.DoctorsDao;
import dao.StaffsDao;
import model.Doctors;
import model.Staffs;


public class DoctorApp {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		int op;
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Press 1 for Add a Doctor");
		System.out.println("Press 2 for Modify Doctor Details");
		System.out.println("Press 3 for Remove a Doctor");
		System.out.println("Press 4 for Retrive All Data");
		System.out.println("Press 0 for Exit");
		System.out.print("Enter your choice:");
	
		op = sc.nextInt();
		int res = 0;
		DoctorsDao dao = new DoctorsDao();
		
		do {
			
		switch (op) {
		case 1:
			System.out.println("Enter Doctor_ID");
			int doctor_id = sc.nextInt();
			
			System.out.println("Enter Name");
			sc.nextLine();
			String name = sc.nextLine();
			
			System.out.println("Enter Specialization");
			String specialization = sc.nextLine();
			
			System.out.println("Enter Contact_info");
			String contact_info = sc.nextLine();
			
			System.out.println("Enter Schedule");
			String schedule = sc.nextLine();
			
			Doctors dr = new Doctors(doctor_id, name, specialization, contact_info, schedule);
			System.out.println("Addding Data");
			res = dao.insertDoctor(dr);
			if (res>0) {
				System.out.println("Adding Done");
			} else {
				System.out.println("Work Failed");
			}
			break;
			
		case 2:
			System.out.println("Modifying Staff Details");
			System.out.println("Enter Staff ID to Modify");
			int id1 = sc.nextInt();
			res = dao.modifyDoctor(id1);
			if (res>0) {
				System.out.println("\nModifying Done");
			} else {
				System.out.println("Modifying Failed");
			}
			break;
			
		case 3:
			System.out.println("Removing a Staff");
			System.out.println("Enter Doctor ID to Delete");
			int id = sc.nextInt();
			res = dao.deleteDoctor(id);
			if (res>0) {
				System.out.println("Removing Done");
			} else {
				System.out.println("Removing Failed");
			}
			break;
			
		case 4:
			System.out.println("Retriving All Data");
			List<Doctors> showDoctor = dao.showDoctor();
			showDoctor.forEach((obj)->System.out.println(obj));
			System.out.println("Data Retrived ");
			break;
		
		case 0:
                System.out.println("Exiting application...");
                break;

		default:
			throw new IllegalArgumentException("Wrong Operation Choice"+ op);
		}
		
		sc.nextLine();
		System.out.println("Do You Want to Continue.. Or Press 0");
		op = sc.nextInt();
		} while (op!=0);
		System.out.println("Exited...");
		sc.close();		
	}
	

}
