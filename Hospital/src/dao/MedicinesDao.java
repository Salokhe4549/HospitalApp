package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Medicines;
import utility.DBConnection;

public class MedicinesDao {
	
	public int insertMedicine(Medicines m) throws Exception {

		Scanner sc = new Scanner(System.in);
		Connection connection = DBConnection.getConn();
		String sql = "INSERT INTO medicines(medicine_id, name, stock_quantity, price, expirey_date) VALUES (?, ?, ?, ?, ?)";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setInt(1, m.getMedicine_id());
		statement.setString(2, m.getName());
		statement.setInt(3, m.getStock_quantity());
		statement.setDouble(4, m.getPrice());
		statement.setString(5, m.getExpirey_date());
	
		int result = statement.executeUpdate();
		
		connection.close();
		return result;	
	}
	
	
	public int updateMedicine(int id) throws Exception {
		
		Connection conn = DBConnection.getConn();
		Scanner scanner = new Scanner(System.in);
		String sql = "UPDATE medicines set stock_quantity = ? , price =?  WHERE medicine_id = ?";
		
		PreparedStatement statement = conn.prepareStatement(sql);
		System.out.println("Enter medicine_id to update");
		int medicine_id = scanner.nextInt();
		
		System.out.println("Enter new Stock");
		int stock_quantity = scanner.nextInt();
		
		System.out.println("Enter new Price");
		double price = scanner.nextDouble();
	
		
		statement.setInt(1, stock_quantity);
		statement.setInt(3, medicine_id);
		statement.setDouble(2, price);
		
		int result = statement.executeUpdate();
		
		conn.close();
		return result;
	}
	
	public int deleteMedicine(int id) throws Exception {
		Scanner sc = new Scanner(System.in);
		Connection conn = DBConnection.getConn();
		
		String sql = "delete from medicines where medicine_id = ? ";
		
		PreparedStatement statement = conn.prepareStatement(sql);
		
		statement.setInt(1, id);
		
		int result = statement.executeUpdate();
		
		conn.close();
		return result;
		
	}
	
	public List<Medicines> showMedicines() throws Exception{
		
		Scanner scanner = new Scanner(System.in);
		
		Connection conn = DBConnection.getConn();
		String sql = "SELECT * FROM medicines";
		
		PreparedStatement statement = conn.prepareStatement(sql);
		
		ResultSet rs = statement.executeQuery();
		
		List<Medicines> list = new ArrayList<Medicines>();
		
		while(rs.next())
		{
			int medicine_id = rs.getInt("medicine_id");
			String name = rs.getString("name");
			int stock_quantity = rs.getInt("stock_quantity");
			double price = rs.getDouble("price");
			String expirey_date = rs.getString("expirey_date");
			
			Medicines medicines = new Medicines(medicine_id, name, stock_quantity, price, name);
			list.add(medicines);
		}
		
		rs.close();
		statement.close();
		conn.close();
		return list;
		
	}

}
