package com.Admin.section;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.Accountant.section.StudentPojo;
import com.output_Stream.MyObjectOutputStream;
import com.tushar.*;
public class AccountantImpl implements AccountantInterface {
	Scanner sc=new Scanner(System.in);
	ArrayList<AccountantPojo> arl=new ArrayList<AccountantPojo>();
	File f=new File("accountantInfo.txt");
	FileOutputStream fos=null;
	ArrayList<AccountantPojo> al=new ArrayList<AccountantPojo>();
//	FileInputStream fis=null;
//	ObjectInputStream ois=null;
	

	public void addAccountant() throws Exception {
	
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
	
	if (f.length() == 0) {
		System.out.println("In oos");
		fos=new FileOutputStream(f,true);
		ObjectOutputStream oos=null;
		oos = new ObjectOutputStream(fos);
		oos.writeObject(arl);
		System.out.println(arl);
		oos.close();
	}

	// There is content in file to be write on
	else {
		System.out.println("In myoos");
		MyObjectOutputStream myoos=null;
		fos=new FileOutputStream(f,true);
		myoos = new MyObjectOutputStream(fos);
		myoos.writeObject(arl);
		myoos.close();
		// Closing the FileOutputStream object
		// to release memory resources

	}

		//System.out.println("object written success");
		//System.out.println("Accountant added successfully");
	}
	
	public void viewAccountant() throws Exception{
		
		boolean cont = true;
		ArrayList<AccountantPojo> arl1 = new ArrayList<AccountantPojo>();;
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);
		while (cont) {
			try {
				Object obj = ois.readObject();
				//System.out.println(obj instanceof ArrayList);
				//arl=(ArrayList<StudentPojo>)ois.readObject();
				if (obj instanceof ArrayList) {
					  // Get the List.
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
		for (AccountantPojo a : arl1) {
			//System.out.println("Id:"+s.getId());
			System.out.println("Name:"+a.getName());
			System.out.println("Email:"+a.getEmail());
			System.out.println("Course:"+a.getPassword());
//			System.out.println("Fee"+s.getFee());
//			System.out.println("Fee Paid:"+s.getPaid());
//			System.out.println("Fee Due:"+s.getDue());
//			System.out.println("Address:"+s.getAddress());
			System.out.println("Contact:"+a.getContact());
			System.out.println("*************************");
			//ois.close();
			//fis.close();
		}
		ois.close();
		fis.close();
	}
	public void Logout() {
//		FeeReport fr=new FeeReport();
		try {
			FeeReport.main(new String[0]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
