package com.tushar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.Accountant.section.StudentImplDB;

public class AccountantLoginDB {
	
	Scanner sc=new Scanner(System.in);
	public boolean validate(String uname,String pass) throws Exception{
		String sql="select name,password from Accountant";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniProject","root","root");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()) {
	if(rs.getString(1).equals(uname)&&rs.getString(2).equals(pass)) {
		return true;
	}}
		return false;
		
	}
	public void acclogin(String uname,String pass) throws Exception {
		boolean flag=validate(uname,pass);
		StudentImplDB s=new StudentImplDB();
		if(flag) {
			System.out.println("********Accountant Section********");
			System.out.println("1-->Add Student");
			System.out.println("2-->View Student");
			System.out.println("3-->Edit Student");
			System.out.println("4-->Fee Due");
			System.out.println("5-->LogOut");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:{
				s.addStudent();
				System.out.println("Student Added Successfully");
				acclogin(uname, pass);
				break;
			}
			case 2:{
				s.viewStudent();
				acclogin(uname, pass);
				break;
			}
			case 3:{
				s.editStudent();
				acclogin(uname, pass);
				break;
			}
			case 4:{
				s.feeDue();
				acclogin(uname, pass);
				break;
			}
			case 5:{
				s.studLogout();
				break;
			}
			default:{
				System.out.println("Invalid choice Entered!!");
			}
			}
		}
		else {
			System.out.println("Invalid Username or Password!!");
			FeeReport.main(new String[0]);
		}
	}

}
