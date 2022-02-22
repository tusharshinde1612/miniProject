package com.Admin.section;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.tushar.FeeReport;

public class AccountantImplDB implements AccountantInterface {
	Scanner sc=new Scanner(System.in);
	ArrayList<AccountantPojo> arl=new ArrayList<AccountantPojo>();
	public static Connection c()
	{
		Connection c = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniProject","root","root");
			//System.out.println("connection success");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println("Connection not success");
			e.printStackTrace();
		}	
		return c;
	}
	public void addAccountant() throws Exception{
		String flag="y";
		 while(flag.equalsIgnoreCase("y")) {
		AccountantPojo a=new AccountantPojo();
		System.out.println("Enter Accountant Name:");
		String name=sc.next();
		System.out.println("Enter Accountant Password:");
		String pass=sc.next();
		System.out.println("Enter Accountant Email:");
		String email=sc.next();
		System.out.println("Enter Accountant contact:");
		String contact=sc.next();
		a.setName(name);
		a.setPassword(pass);
		a.setEmail(email);
		a.setContact(contact);
		arl.add(a);
		System.out.println("Do you want to continue[Y/N]");
	    flag=sc.next();
		 }
		try
		{
			String sql = "INSERT INTO Accountant(Name,Password,Email,Contact) values (?, ?, ?, ?)";
            PreparedStatement st = c().prepareStatement(sql);
            System.out.println("After ps");
            for(AccountantPojo a:arl) {
            st.setString(1,a.getName());
            st.setString(2,a.getPassword());
            st.setString(3,a.getEmail());
            st.setString(4,a.getContact());
            st.execute();
            System.out.println("After value setting");
           // b=true;
            }
		}
		catch(Exception k){System.out.println(k);}
	}
	
	public void viewAccountant() throws Exception{
		try
		{
		    Statement st = c().createStatement();
		    ResultSet rs = st.executeQuery("SELECT * FROM Accountant");
		    while(rs.next()) { 
//		    	Accountant accountant=new Accountant();
//				  accountant.setA_name(rs.getString(1));
//				  accountant.setA_password(rs.getString(2));
//				  accountant.setA_email(rs.getString(3));
//				  accountant.setA_contact(rs.getLong(4));
//				  accountants.add(accountant);
		    	System.out.println(rs.getString(1));
		    	//System.out.println(rs.getString(2));
		    	System.out.println(rs.getString(3));
		    	System.out.println(rs.getString(4));
		    	System.out.println("****************");
		    }    
		}
		catch(Exception e){e.printStackTrace();}
	
	}
	public void Logout() {
		try {
			FeeReport.main(new String[0]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
