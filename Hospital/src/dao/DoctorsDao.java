package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Doctors;
import model.Staffs;
import utility.DBConnection;

public class DoctorsDao {
	
		
		public int insertDoctor(Doctors d) throws Exception {		
			Scanner sc = new Scanner(System.in);
			Connection conn = DBConnection.getConn();
			
			String sql = "INSERT INTO doctors(doctor_id, name, specialization, contact_info , schedule) VALUES(?, ?, ?, ? ,?)";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, d.getDoctor_id());
			statement.setString(2, d.getName());
			statement.setString(3, d.getSpecialization());
			statement.setString(4, d.getContact_info());
			statement.setString(5, d.getSchedule());
			
			int result = statement.executeUpdate();
			

			conn.close();
			return result ;
		}
		
		public int modifyDoctor(int id) throws Exception {
			Connection conn = DBConnection.getConn();
			Scanner sc = new Scanner(System.in);
			String sql = "update doctors set name = ? , specialization = ? , contact_info = ? , schedule = ?  where doctor_id = ?";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			System.out.println("Enter new Name");
			String name = sc.nextLine();
			
			System.out.println("Enter new specialization");
			String specialization = sc.nextLine();
			
			System.out.println("Enter New Contact_Info");
			String contact_info = sc.nextLine();
			
			System.out.println("Enter New Schedule");
			String schedule = sc.nextLine();
			
			statement.setString(1 , name);
			statement.setString(2 , specialization);
			statement.setString(3 , contact_info);
			statement.setString(4 ,schedule);
			statement.setInt(5 ,id);
			
			
			
			int result = statement.executeUpdate();
			

			conn.close();
			return result ;
		}
		public int deleteDoctor(int id) throws Exception {
			Connection conn = DBConnection.getConn();

			String sql = "delete from doctors where doctor_id = ?";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			
			int result = statement.executeUpdate();
			
			conn.close();
			return result ;
		}
		
		public List<Doctors> showDoctor() throws Exception {
		    // Establish connection
		    Connection conn = DBConnection.getConn();

		    // SQL query to select all staff records
		    String sql = "SELECT * FROM doctors";

		    // Prepare statement
		    PreparedStatement statement = conn.prepareStatement(sql);

		    // Execute the query and retrieve results
		    ResultSet resultSet = statement.executeQuery();
		    List<Doctors> dList = new ArrayList<Doctors>();
		    // Process the result set
		    while (resultSet.next()) {
		        // Retrieve data from the result set (e.g., assuming the staff table has columns: id, name)
		        int doctor_id = resultSet.getInt("doctor_id");
		        String name = resultSet.getString("name");
		        String specialization = resultSet.getString("specialization");
		        String contact_info = resultSet.getString("contact_info");
		        String schedule = resultSet.getString("schedule");

		        Doctors doctors = new Doctors(doctor_id, name, specialization, contact_info, schedule);
		        dList.add(doctors);
		        // Print or store the staff information
		        // System.out.println("Doctor_id: " + doctor_id + ", Name: " + name + ", Specialization: "+ specialization + ",  Contact_info: "+contact_info+ ", Schedule: "+schedule);
		    }
		    // Close the connection and result set
		    resultSet.close();
		    statement.close();
		    conn.close();
			return dList;
		}
		
}

