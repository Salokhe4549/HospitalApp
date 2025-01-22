package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

import model.Staffs;
import utility.DBConnection;

public class StaffsDao {
	
		
		public int insertStaff(Staffs s) throws Exception {		
			Scanner sc = new Scanner(System.in);
			Connection conn = DBConnection.getConn();
			
			String sql = "INSERT INTO staffs(staff_id, name, role, contact_info) VALUES(?, ?, ?, ?)";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, s.getStaff_id());
			statement.setString(2, s.getName());
			statement.setString(3, s.getRole());
			statement.setString(4, s.getContact_info());
			
			int result = statement.executeUpdate();
			
			conn.close();
			return result ;
		}
		public int modifyStaff(int id) throws Exception {
			Connection conn = DBConnection.getConn();
			Scanner sc = new Scanner(System.in);
			String sql = "update staffs set name = ? , role = ? , contact_info = ? where staff_id = ?";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			System.out.println("Enter new Name");
			String name = sc.nextLine();
			System.out.println("Enter new Role");
			String role = sc.nextLine();
			System.out.println("Enter New Contact_Info");
			String contact_info = sc.nextLine();
			statement.setString(1 , name);
			statement.setString(2 , role);
			statement.setString(3 , contact_info);
			statement.setInt(4 ,id);
			
			
			
			int result = statement.executeUpdate();
			
			conn.close();
			return result ;
		}
		public int deleteStaff(int id) throws Exception {
			Connection conn = DBConnection.getConn();
//			Scanner sc = new Scanner(System.in);
			String sql = "delete from staffs where staff_id = ?";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			
			int result = statement.executeUpdate();
			
			conn.close();
			return result ;
		}
		
		public List<Staffs> showStaff() throws Exception {
		    // Establish connection
		    Connection conn = DBConnection.getConn();

		    // SQL query to select all staff records
		    String sql = "SELECT * FROM staffs";

		    // Prepare statement
		    PreparedStatement statement = conn.prepareStatement(sql);

		    // Execute the query and retrieve results
		    ResultSet resultSet = statement.executeQuery();

		    List<Staffs> treeSet = new ArrayList<Staffs>();  

		    // Process the result set
		    while (resultSet.next()) {
		        // Retrieve data from the result set (e.g., assuming the staff table has columns: id, name)
		        int staff_id = resultSet.getInt("staff_id");
		        String name = resultSet.getString("name");
		        String role = resultSet.getString("role");
		        String contact_info = resultSet.getString("contact_info");
		        
		        Staffs staffs = new Staffs(staff_id, name, role, contact_info);
		        treeSet.add(staffs);
		        // Print or store the staff information
//		        System.out.println("Staff_id: " + staff_id + ", Name: " + name + ", Role: "+ role + ",  contact_info: "+contact_info);
		    }

		    // Close the connection and result set
		    resultSet.close();
		    statement.close();
		    conn.close();
			return treeSet;
		}
}

