package com.tushar;

import java.util.*;

public class FeeReport {
	public static boolean check=false;
	String uname;
	String pass;
//	String Accuname;
//	String Accpass;
	public void option() throws Exception {
		int choice=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("1--->operation on File");
		System.out.println("2--->operation on database");
		choice=sc.nextInt();
		if(choice==1) {
			AdminLogin a = new AdminLogin();
			a.adminlogin(uname, pass);
		}else if(choice==2){
			AdminLoginDB ad=new AdminLoginDB();
			ad.adminlogin(uname,pass);
		}else {
			System.out.println("Invalid choice!!");
		}
		
	}
	public void option(String accName,String accPass) throws Exception {
		int choice=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("1--->operation on File");
		System.out.println("2--->operation on database");
		choice=sc.nextInt();
		if(choice==1) {
			AccountantLogin a = new AccountantLogin();
			a.acclogin(accName, accPass);
		}else if(choice==2){
			AccountantLoginDB ad=new AccountantLoginDB();
			ad.acclogin(accName, accPass);
		}else {
			System.out.println("Invalid choice!!");
		}
		
	}
	public static void main(String[] args) throws Exception {
		FeeReport fe=new FeeReport();
		Scanner sc = new Scanner(System.in);
		System.out.println("**********Welcome**********");
		// System.out.println("Enter your choice:");
		System.out.println("1-->Admin");
		System.out.println("2-->Accountant");
		int choice = sc.nextInt();
		if (choice == 1) {
			System.out.println("Enter username:");
			fe.uname = sc.next();
			System.out.println("Enter password:");
			 fe.pass = sc.next();
			 fe.option();
//			AdminLogin a = new AdminLogin();
//			a.adminlogin(uname, pass);

		} else if (choice == 2) {
			System.out.println("Enter username:");
			String Accuname = sc.next();
			System.out.println("Enter password:");
			String Accpass = sc.next();
//			AccountantLogin acc = new AccountantLogin();
//			acc.acclogin(Accuname, Accpass);
			fe.option(Accuname, Accpass);
		} else {
			System.out.println("Wrong Choice Entered choose between(1&2)");
		}
	}

}
