package com.tushar;

import java.util.Scanner;

import com.Admin.section.AccountantImpl;
import com.Admin.section.AccountantImplDB;

public class AdminLoginDB {
	String AdminUsername="admin";
	String Adminpassword="admin123";
	Scanner sc=new Scanner(System.in);
	AccountantImplDB a=new AccountantImplDB();
void adminlogin(String uname,String pass) throws Exception {
	if(this.AdminUsername.equals(uname)&&this.Adminpassword.equals(pass)) {
		System.out.println("********Admin Section********");
		System.out.println("Enter your choice:");
		System.out.println("1-->Add Accountant");
		System.out.println("2-->View Accountant");
		System.out.println("3-->Logout");
		int choice=sc.nextInt();
		switch(choice) {
		case 1:{
			
			a.addAccountant();
			System.out.println("Accountant Added Successfully!!");
			adminlogin(AdminUsername,Adminpassword);
			break;
		}
		case 2:{
			a.viewAccountant();
			adminlogin(AdminUsername,Adminpassword);
			break;
		}
		case 3:{
			a.Logout();
			AdminLogin a=new AdminLogin();
			a.adminlogin(uname, pass);
			break;
		}
		default:{
			System.out.println("Invalid Choice Entered!!");
		}
		}
	}
	else {
		System.out.println("Invalid Username or Password!!");
	}

}
}