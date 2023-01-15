package com.products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ConnectionP.ConnectionProvider;


public class CartImpl implements Cart {
	

	@Override
	public void buyProducts(List<Productdetails> al) {
		 Connection con = ConnectionProvider.getConnection();
		
		for (int i = 0; i < al.size(); i++) {
			Productdetails productdetails = new Productdetails();
			productdetails = al.get(i);
		
		//	int id = productdetails.getProductid();
			String name = productdetails.getName();
			String desc = productdetails.getDescription();
			double price = productdetails.getPrice();
		//	int quantity =productdetails.getQuantity();
			
		
			
			  try {
				PreparedStatement ps = con.prepareStatement("Insert into cart (pdesc,price,pname)values(?,?,?)");
				
				ps.setString(1, desc);
				ps.setDouble(2, price);
				ps.setString(3, name);
				
				int record =ps.executeUpdate();
				if (record>0) {
					
					System.out.println("Successfully Updated Into Cart "+record);
					break;
				
				}
			
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	
		
	}
	
	
		
	}
