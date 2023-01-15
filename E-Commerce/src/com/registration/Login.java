package com.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.ConnectionP.ConnectionProvider;
import com.sun.org.apache.regexp.internal.recompile;

public class Login {

//Taking input from user  For Login

	public boolean getUserDetails() {
		ResultSet rs = null;
		System.out.println("Enter Details For Uset Login");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Email");
		String email = scanner.next();
		System.out.println("Enter Password");
		String pass = scanner.next();
		UserLogin ul = new UserLogin();
		ul.setEmail(email);
		ul.setPass(pass);
				
		

		// Connection establish

		Connection con = ConnectionProvider.getConnection();
		try {
			// prepared Statement

			PreparedStatement ps = con.prepareStatement("Select * from user");
			rs = ps.executeQuery();
			boolean flag = false;
			while (rs.next()) {

				// checking login input with database records

				if (rs.getString(2).equals(ul.getEmail()) && (rs.getString(3).equals(ul.getPass()))) {
				

					flag = true;

					break;

				} 
				else {
					flag = false;

				}

			}
			if (flag == true) {
				System.out.println("Login Successfully");
				return true;
			} 
			else {
				
				return false ;

			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false ;

	}

	public static void main(String[] args) {
		Login login = new Login();
		login.getUserDetails();

	}
	

}
