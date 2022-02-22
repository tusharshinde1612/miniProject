package com.Accountant.section;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import com.output_Stream.*;
//import com.rafDemo.RAFDemo;
import com.tushar.FeeReport;

public class StudentImpl implements StudentInterface {

	ArrayList<StudentPojo> al = new ArrayList<StudentPojo>();
	Scanner sc = new Scanner(System.in);
	File f = new File("StudentInfo.txt");

	public void addStudent() throws Exception {
		FileOutputStream fos = new FileOutputStream(f, true);
		ObjectOutputStream oos = null;
		MyObjectOutputStream myoos = null;
		 String flag="y";
		 while(flag.equalsIgnoreCase("y")) {

		 //MyObjectOutputStream myoos=null;
		StudentPojo s =new StudentPojo();
		System.out.println("Enter id:");
		int id=sc.nextInt();
		System.out.println("EnterName:");
		String name = sc.next();
		System.out.println("Enter email:");
		String email = sc.next();
		System.out.println("Enter course:");
		String course = sc.next();
		System.out.println("Enter fee");
		int fee = sc.nextInt();
		System.out.println("Enter paidfee:");
		int paid = sc.nextInt();
		System.out.println("Enter due:");
		int due = sc.nextInt();
		System.out.println("Enter Address:");
		String address = sc.next();
		System.out.println("Enter contact:");
		String contact = sc.next();
		s.setId(id);
		s.setName(name);
		s.setEmail(email);
		s.setCourse(course);
		s.setFee(fee);
		s.setPaid(paid);
		s.setDue(due);
		s.setAddress(address);
		s.setContact(contact);
		al.add(s);
		System.out.println("Do you want to continue[Y/N]");
	    flag=sc.next();
		 }
		 if (f.length() == 0) {
				System.out.println("In oos");
	
				oos = new ObjectOutputStream(fos);
				oos.writeObject(al);
				oos.close();
			}
	
			// There is content in file to be write on
			else {
				System.out.println("In myoos");
	
				myoos = new MyObjectOutputStream(fos);
				myoos.writeObject(al);
				myoos.close();
				// Closing the FileOutputStream object
				// to release memory resources
	
			}
		fos.flush();
	    //oos.close();
		//myoos.close();
		fos.close();
		System.out.println("Data added successfully");
		System.out.println(al);
	}

	//@SuppressWarnings("unchecked")
	public void viewStudent() throws Exception {
		boolean cont = true;
		ArrayList<StudentPojo> arl = new ArrayList<StudentPojo>();;
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);
		while (cont) {
			try {
				Object obj = ois.readObject();
				System.out.println(obj instanceof ArrayList);
				//arl=(ArrayList<StudentPojo>)ois.readObject();
				if (obj instanceof ArrayList) {
					  // Get the List.
					  arl = (ArrayList<StudentPojo>) obj; 
				}
					  else {
					cont = false;
				}
			} catch (EOFException e) {
				System.out.println("\n");
				break;
			}
		}
		for (StudentPojo s : arl) {
			System.out.println("Id:"+s.getId());
			System.out.println("Name:"+s.getName());
			System.out.println("Email:"+s.getEmail());
			System.out.println("Course:"+s.getCourse());
			System.out.println("Fee"+s.getFee());
			System.out.println("Fee Paid:"+s.getPaid());
			System.out.println("Fee Due:"+s.getDue());
			System.out.println("Address:"+s.getAddress());
			System.out.println("Contact:"+s.getContact());
			System.out.println("*************************");
			//ois.close();
			//fis.close();
		}
		ois.close();
		fis.close();
	}

	public void editStudent() throws Exception {
		Update up=new Update();
		int choice=0;
		System.out.println("What you want to Update?");
		System.out.println("1-->Email");
		System.out.println("2-->Course");
		System.out.println("3-->fee");
		System.out.println("4-->Address");
		System.out.println("5-->Contact");
		System.out.println("6-->Exit");
		choice=sc.nextInt();
		switch(choice) {
		case 1:up.updateEmail();
			break;
		case 2:up.updateCourse();
			break;
		case 3:up.updateFee();
			break;
		case 4:up.updateAddress();
			break;
		case 5:up.updateContact();
			break;
		case 6:up.exit();
			break;
		default:System.out.println("Incorrect choice Entered!!");
		}
	}

 
	public void feeDue() throws Exception{
		// System.out.println("Fees Due:"+s.getDue());
		boolean cont = true;
		ArrayList<StudentPojo> arl = new ArrayList<StudentPojo>();;
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);
		while (cont) {
			try {
				Object obj = ois.readObject();
				//System.out.println(obj instanceof ArrayList);
				//arl=(ArrayList<StudentPojo>)ois.readObject();
				if (obj !=null) {
					  // Get the List.
					  arl = (ArrayList<StudentPojo>) obj; 
				}
					  else {
					cont = false;
				}
			} catch (EOFException e) {
				System.out.println("\n");
				break;
			}
		}
		System.out.println("Id "+" "+"Name "+" "+"Fee Due ");
		for (StudentPojo s : arl) {
			System.out.println(s.getId()+" "+s.getName()+" "+s.getDue());
			}
		ois.close();
		fis.close();
	}

	public void studLogout() {
		// FeeReport fe=new FeeReport();
		try {
			FeeReport.main(new String[0]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
