package controller;

import java.util.List;

import dao.PatientsDao;
import model.Doctors;
import model.Patients;

public class PatientApp {

	public static void main(String[] args) throws Exception {
		
		Patients patients = new Patients(1, "An", 23, "A", "a", "a");
		PatientsDao dao = new PatientsDao(); 
		System.out.println("Retriving All Data");
		int res = dao.insertPatient(patients);
		if (res > 0) {
			System.out.println("Data Retrived ");
		} else {
			
			System.out.println("Failed ");

		}
//		break; 
	}
	
}
