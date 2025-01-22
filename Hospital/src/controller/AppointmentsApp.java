package controller;

import java.util.List;
import java.util.Scanner;

import dao.AppointmentsDao;
import model.Appointments;


public class AppointmentsApp {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int op;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Press 1 for Add a Appointment");
		System.out.println("Press 2 for Modify Appointment Details");
		System.out.println("Press 3 for Remove a Appointment");
		System.out.println("Press 4 for Retrive All Appointments");
		System.out.println("Press 0 for Exit");
		System.out.print("Enter your choice:");
	
		op = sc.nextInt();
		int res = 0;
		AppointmentsDao dao = new AppointmentsDao();
		
		do {
			
		switch (op) {
		case 1:
			System.out.println("Enter Appointment_ID");
			int appointment_id = sc.nextInt();
			
			System.out.println("Enter Patient_id");
			int patient_id = sc.nextInt();
			
			System.out.println("Enter Doctor_id");
			int doctor_id = sc.nextInt();
			
			System.out.println("Enter Date(YYYY-MM-DD)");
			sc.nextLine();
			String date = sc.nextLine();
			
			System.out.println("Enter Time(HH:MM:SS)");
			String time = sc.nextLine();

			System.out.println("Enter Status");
			String status = sc.nextLine();
			
			Appointments ap = new Appointments(appointment_id, patient_id, doctor_id, date, time, status);
			
			System.out.println("Addding Appointments Details");
			res = dao.addAppointments(ap);
			
			if (res>0) {
				System.out.println("Adding Done");
			} else {
				System.out.println("Work Failed");
			}
			break;
			
		case 2:
			System.out.println("Modifying Appointments Details");
			System.out.println("Enter Appointment ID to Modify");
			int id1 = sc.nextInt();
			res = dao.modifyAppointments(id1);
			if (res>0) {
				System.out.println("\nModifying Done");
			} else {
				System.out.println("Modifying Failed");
			}
			break;
			
		case 3:
			System.out.println("Removing Appointment Details");
			System.out.println("Enter Appointment ID to Delete");
			int id = sc.nextInt();
			res = dao.deleteAppointment(id);
			if (res>0) {
				System.out.println("Removing Done");
			} else {
				System.out.println("Removing Failed");
			}
			break;
			
		case 4:
			System.out.println("Retriving All Data");
			List<Appointments> showAppointments = dao.showAppointments();
			showAppointments.forEach((obj)->System.out.println(obj));
			System.out.println("Data Retrived ");
			break;
		
		case 0:
                System.out.println("Exiting application...");
                return;

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
