package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Bills;
import utility.DBConnection;

public class BillsDao {
	
	
	public int insertBill(Bills  b) throws Exception {		
		Scanner sc = new Scanner(System.in);
		Connection conn = DBConnection.getConn();
		
		String sql = "INSERT INTO bills (bill_id,patient_id, amount, date, payment_status) VALUES (?, ?, ?, ?, ?)";
		
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, b.getBill_id());
		statement.setInt(2, b.getPatient_id());
		statement.setDouble(3, b.getAmount());
		statement.setString(4, b.getDate());
		statement.setString(5, b.getPayment_status());
		
		int result = statement.executeUpdate();
		
		conn.close();
		return result ;
	}
	public int modifyBill(int id) throws Exception {
		Connection conn = DBConnection.getConn();
		Scanner sc = new Scanner(System.in);
		String sql = "update bills set contact_info = ? where bill_id = ?";
		
		PreparedStatement statement = conn.prepareStatement(sql);
		System.out.println("Enter new Amount");
		String amount = sc.nextLine();
		System.out.println("Enter new Date");
		String date = sc.nextLine();
		System.out.println("Enter Updated Payment_Status");
		String payment_status = sc.nextLine();
		statement.setString(1 , amount);
		statement.setString(2 , date);
		statement.setString(3 , payment_status);
		statement.setInt(4 ,id);
		
		
		
		int result = statement.executeUpdate();
		
		conn.close();
		return result ;
	}
	public int deleteBill(int id) throws Exception {
		Connection conn = DBConnection.getConn();
//		Scanner sc = new Scanner(System.in);
		String sql = "delete from bills where bill_id = ?";
		
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, id);
		
		int result = statement.executeUpdate();
		
		conn.close();
		return result ;
	}
	
	public List<Bills> showBill() throws Exception {
	    // Establish connection
	    Connection conn = DBConnection.getConn();

	    // SQL query to select all staff records
	    String sql = "SELECT * FROM bills";

	    // Prepare statement
	    PreparedStatement statement = conn.prepareStatement(sql);

	    // Execute the query and retrieve results
	    ResultSet resultSet = statement.executeQuery();

	    List<Bills> bList = new ArrayList<Bills>();
	    // Process the result set
	    while (resultSet.next()) {
	        // Retrieve data from the result set (e.g., assuming the staff table has columns: id, name)
	        int bill_id = resultSet.getInt("bill_id");
	        int patient_id = resultSet.getInt("patient_id");
	        double amount = resultSet.getDouble("amount");
	        String date = resultSet.getString("date");
	        String payment_status = resultSet.getString("payment_status");
//	        (int bill_id, int patient_id, double amount, String date, String payment_status)
	        Bills bills = new Bills(bill_id, patient_id, amount, date, payment_status);
	        bList.add(bills);
	        // Print or store the staff information
	        //System.out.println("Staff_id: " + bill_id + ", Name: " + name + ", Role: "+ role + ",  contact_info: "+contact_info);
	    }

	    // Close the connection and result set
	    resultSet.close();
	    statement.close();
	    conn.close();
		return bList;
	}
}
