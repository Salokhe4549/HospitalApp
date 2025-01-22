package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Appointments;
import utility.DBConnection;

public class AppointmentsDao {

	public int addAppointments(Appointments d) throws Exception {		
		Scanner sc = new Scanner(System.in);
		Connection conn = DBConnection.getConn();
		
		String sql = "INSERT INTO appointments(appointment_id,patient_id, doctor_id, date, time, status) VALUES(?, ?, ?, ?, ?, ?)";
		
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, d.getAppointment_id());
		statement.setInt(2, d.getPatient_id());
		statement.setInt(3, d.getDoctor_id());
		statement.setString(4, d.getDate());
		statement.setString(5, d.getTime());
		statement.setString(6, d.getStatus());
		
		int result = statement.executeUpdate();
		
		conn.close();
		return result ;
	}
	
	public int modifyAppointments(int id) throws Exception {
		Connection conn = DBConnection.getConn();
		Scanner sc = new Scanner(System.in);
		String sql = "update appointments set doctor_id = ? , date = ? , time = ? , status = ?  where appointment_id = ?";
		
		PreparedStatement statement = conn.prepareStatement(sql);
		System.out.println("Enter Doctor_id to modify");
		int doctor_id = sc.nextInt();
		
		System.out.println("Enter new date(YYYY-MM-DD)");
		sc.nextInt();
		String date = sc.nextLine();
		
		System.out.println("Enter New time(HH:MM:SS)");
		String time = sc.nextLine();
		
		System.out.println("Enter New status");
		String status = sc.nextLine();
		
		statement.setInt(1 , doctor_id);
		statement.setString(2 , date);
		statement.setString(3 , time);
		statement.setString(4 ,status);
		statement.setInt(5 ,id);
		
		
		
		int result = statement.executeUpdate();
		

		conn.close();
		return result ;
	}
	public int deleteAppointment(int id) throws Exception {
		Connection conn = DBConnection.getConn();

		String sql = "delete from appointments where appointment_id = ?";
		
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, id);
		
		int result = statement.executeUpdate();
		
		conn.close();
		return result ;
	}
	
	public List<Appointments> showAppointments() throws Exception {
	    // Establish connection
	    Connection conn = DBConnection.getConn();

	    // SQL query to select all staff records
	    String sql = "SELECT * FROM appointments";

	    // Prepare statement
	    PreparedStatement statement = conn.prepareStatement(sql);

	    // Execute the query and retrieve results
	    ResultSet resultSet = statement.executeQuery();

	    List<Appointments> aList = new ArrayList<Appointments>();
	    // Process the result set
	    while (resultSet.next()) {
	        // Retrieve data from the result set (e.g., assuming the staff table has columns: id, name)
	        int appointment_id = resultSet.getInt("appointment_id");
	        int patient_id = resultSet.getInt("patient_id");
	        int doctor_id = resultSet.getInt("doctor_id");
	        String date = resultSet.getString("date");
	        String time = resultSet.getString("time");
	        String status = resultSet.getString("status");

	        Appointments appointments = new Appointments(appointment_id, patient_id, doctor_id, date, time, status);
	        aList.add(appointments);
	        // Print or store the staff information
	        // System.out.println("Appointment_id: " + appointment_id + ", Patient_id: " + patient_id + ", Doctor_id: "+ doctor_id + ",  Date: "+date+ ", Time: "+time+ ", Status: "+status);
	    }

	    // Close the connection and result set
	    resultSet.close();
	    statement.close();
	    conn.close();
		return aList;
		
	}

	
}
