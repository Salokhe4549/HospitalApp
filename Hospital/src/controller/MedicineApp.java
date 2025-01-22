package controller;

import java.util.List;
import java.util.Scanner;

import dao.MedicinesDao;
import model.Medicines;

public class MedicineApp {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		int op;
		Scanner sc = new Scanner(System.in);
		int res = 0;
		MedicinesDao dao = new MedicinesDao();
		
		while (true) 
		{
		
		System.out.println("Press 1 for Insert Medicine Details");
		System.out.println("Press 2 for Modify Medicine Details");
		System.out.println("Press 3 for Remove a Medicine");
		System.out.println("Press 4 for Retrive All Medicine");
		System.out.println("Press 0 for Exit");
		System.out.print("Enter your choice:");
		op = sc.nextInt();
		
		
		switch (op) {
		case 1:
			System.out.println("Enter medicine_id");
			int medicine_id = sc.nextInt();
			
			System.out.println("Enter Medicine name");
			sc.nextLine();
			String name = sc.nextLine();
			
			System.out.println("Enter Medicine stock_quantity");
			int stock_quantity = sc.nextInt();
			
			System.out.println("Enter Medicine price");
			double price = sc.nextDouble();
			
			System.out.println("Enter Medicine expiry_date");
			sc.nextLine();
			String expiry_date = sc.nextLine();
			Medicines medicines = new Medicines(medicine_id, name, stock_quantity, price, expiry_date);
			System.out.println("Adding Medicine Data");
			 res = dao.insertMedicine(medicines); 
			 if (res>0) {
				System.out.println("Adding Done");
			} else {
				System.out.println("Adding Failed");
			}
			
			 System.out.println("Added Medicine Data");
			break;
			
		case 2:
			System.out.println("Enter Medicine Id to Modify");
			int id = sc.nextInt();
			res = dao.updateMedicine(id);
			if (res>0) {
				System.out.println("Modifying Done");
			} else {
				System.out.println("Modifying Failed");
			}
			 System.out.println("Modified Medicine Data");	
			break;
			
		case 3:
			System.out.println("Enter Medicine Id to Delete");
			int id1 = sc.nextInt();
			res = dao.deleteMedicine(id1);
			if (res>0) {
				System.out.println("Deleting Done");
			} else {
				System.out.println("Deleting Failed");
			}
			 System.out.println("Deleted Medicine Data");
			break;
		case 4:
			System.out.println("Retriving Data");
			List<Medicines> showMedicines = dao.showMedicines();
			showMedicines.forEach((obj)->System.out.println(obj));
			System.out.println("Retriving Data Done");
			break;
		case 0:
			return;

		default:
			throw new IllegalArgumentException("Wrong Operation Choice"+ op);
			
		}
		
		}
		

	}

}
