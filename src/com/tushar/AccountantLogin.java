package com.tushar;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.Accountant.section.StudentImpl;
import com.Accountant.section.StudentImplDB;
import com.Admin.section.AccountantPojo;

public class AccountantLogin {
//	String AccUsername="acc";
//	String Accpassword="acc123";
	Scanner sc=new Scanner(System.in);
	File f=new File("accountantInfo.txt");
	StudentImpl s=new StudentImpl();
	public boolean validate(String uname,String pass) throws Exception {
		boolean cont = true;
		ArrayList<AccountantPojo> arl1 = new ArrayList<AccountantPojo>();;
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);
		while (cont) {
			try {
				Object obj = ois.readObject();
				if (obj instanceof ArrayList) {
					  arl1 = (ArrayList<AccountantPojo>) obj; 
				}
					  else {
					cont = false;
				}
			} catch (EOFException e) {
				System.out.println("\n");
				break;
			}
		}
		for(AccountantPojo a:arl1) {
			if(a.getName().equals(uname)&&a.getPassword().equals(pass)) {
				//System.out.println("Inside validate true");
				ois.close();
				fis.close();
				return true;
			}
		}
		ois.close();
		fis.close();
		return false;
		
	}
	public void acclogin(String uname,String pass) throws Exception {
		boolean flag=validate(uname,pass);
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
