package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Patients;
import utility.DBConnection;

public class PatientsDao {
	public int insertPatient(Patients m) throws Exception {

		Scanner sc = new Scanner(System.in);
		Connection connection = DBConnection.getConn();
		String sql = "INSERT INTO patients (patient_id, name, age, gender, contact_info, medical_history) VALUES (? ,?, ?, ?, ?, ?)";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setInt(1, m.getPatient_id());
		statement.setString(2, m.getName());
		statement.setInt(3, m.getAge());
		statement.setString(4, m.getGender());
		statement.setString(5, m.getContact_info());
		statement.setString(6, m.getMedical_history());
	
		int result = statement.executeUpdate();
		
		connection.close();
		return result;	
	}
	
	
	public int updatePatient(int id) throws Exception {
		
		Connection conn = DBConnection.getConn();
		Scanner scanner = new Scanner(System.in);
		String sql = "UPDATE Patients set stock_quantity = ? , price =?  WHERE Patient_id = ?";
		
		PreparedStatement statement = conn.prepareStatement(sql);
		System.out.println("Enter Patient_id to update");
		int Patient_id = scanner.nextInt();
		
		System.out.println("Enter new Stock");
		int stock_quantity = scanner.nextInt();
		
		System.out.println("Enter new Price");
		double price = scanner.nextDouble();
	
		
		statement.setInt(1, stock_quantity);
		statement.setInt(3, Patient_id);
		statement.setDouble(2, price);
		
		int result = statement.executeUpdate();
		
		conn.close();
		return result;
	}
	
	public int deletePatient(int id) throws Exception {
		Scanner sc = new Scanner(System.in);
		Connection conn = DBConnection.getConn();
		
		String sql = "delete from Patients where Patient_id = ? ";
		
		PreparedStatement statement = conn.prepareStatement(sql);
		
		statement.setInt(1, id);
		
		int result = statement.executeUpdate();
		
		conn.close();
		return result;
		
	}
	
	public List<Patients> showPatients() throws Exception{
		
		Scanner scanner = new Scanner(System.in);
		
		Connection conn = DBConnection.getConn();
		String sql = "SELECT * FROM Patients";
		
		PreparedStatement statement = conn.prepareStatement(sql);
		
		ResultSet rs = statement.executeQuery();
		
		List<Patients> list = new ArrayList<Patients>();
		
		while(rs.next())
		{
			int Patient_id = rs.getInt("Patient_id");
			String name = rs.getString("name");
			int stock_quantity = rs.getInt("stock_quantity");
			double price = rs.getDouble("price");
			String expirey_date = rs.getString("expirey_date");
			
//			Patients Patients = new Patients(Patient_id, name, stock_quantity, price, name);
//			list.add(Patients);
		}
		
		rs.close();
		statement.close();
		conn.close();
		return list;
		
	}
}
