package com.Accountant.section;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.output_Stream.MyObjectOutputStream;
import com.tushar.AccountantLogin;

public class Update {
	File f = new File("StudentInfo.txt");
	Scanner sc=new Scanner(System.in);
	StudentPojo s=null;
	public ArrayList<StudentPojo> search(int id) throws Exception {
		ArrayList<StudentPojo> al=new ArrayList<StudentPojo>();
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);
		boolean cont=true;
		while (cont) {
			try {
				Object obj=ois.readObject();
				if (obj != null) {
					al=(ArrayList<StudentPojo>)obj;
					return al;
					}
				 else {
					cont = false;
				}
			} catch (EOFException e) {
				System.out.println("\n");
				break;
			}
		}
		ois.close();
		fis.close();
		return null;
		
	}
	
	public void updateEmail() throws Exception {
		System.out.println("Enter student id whose data to be updated:");
		int id=sc.nextInt();
		ArrayList<StudentPojo> arl=new ArrayList<StudentPojo>();
		arl=search(id);
		for(StudentPojo s:arl) {
			if(s.getId()==id) {
				System.out.println("Enter new Email");
				String email=sc.next();
				s.setEmail(email);
				System.out.println("Email updated sucessfully");
			}
			FileOutputStream fos=new FileOutputStream(f);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(arl);
			oos.close();
			fos.close();
		}
	}
	public void updateCourse() throws Exception {
		System.out.println("Enter student id whose data to be updated:");
		int id=sc.nextInt();
		ArrayList<StudentPojo> arl=new ArrayList<StudentPojo>();
		arl=search(id);
		for(StudentPojo s:arl) {
			if(s.getId()==id) {
				System.out.println("Enter new Course");
				String course=sc.next();
				s.setCourse(course);
				System.out.println("course updated sucessfully");
			}
			FileOutputStream fos=new FileOutputStream(f);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(arl);
			oos.close();
			fos.close();
	}}
	public void updateFee() throws Exception {
		System.out.println("Enter student id whose data to be updated:");
		int id=sc.nextInt();
		//StudentPojo s1=new StudentPojo();
		//s1.setDue(s1.getFee()-s1.getPaid());
		ArrayList<StudentPojo> arl=new ArrayList<StudentPojo>();
		arl=search(id);
		for(StudentPojo s:arl) {
			if(s.getId()==id) {
				System.out.println("Enter amount");
				int fee=sc.nextInt();
				s.setDue(s.getFee()-(s.getPaid()+fee));
				s.setPaid(s.getPaid()+fee);
				System.out.println("fee updated sucessfully");
			}
			FileOutputStream fos=new FileOutputStream(f);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(arl);
			oos.close();
			fos.close();}
		
		
	}
	public void updateAddress() throws Exception {
		System.out.println("Enter student id whose data to be updated:");
		int id=sc.nextInt();
		ArrayList<StudentPojo> arl=new ArrayList<StudentPojo>();
		arl=search(id);
		for(StudentPojo s:arl) {
			if(s.getId()==id) {
				System.out.println("Enter new Address");
				String address=sc.next();
				s.setAddress(address);
				System.out.println("Address updated sucessfully");
			}
			FileOutputStream fos=new FileOutputStream(f);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(arl);
			oos.close();
			fos.close();
		}
	}
	public void updateContact() throws Exception {
		System.out.println("Enter student id whose data to be updated:");
		int id=sc.nextInt();
		ArrayList<StudentPojo> arl=new ArrayList<StudentPojo>();
		arl=search(id);
		for(StudentPojo s:arl) {
			if(s.getId()==id) {
				System.out.println("Enter new Contact");
				String contact=sc.next();
				s.setContact(contact);
				System.out.println("contact updated sucessfully");
			}
			FileOutputStream fos=new FileOutputStream(f);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(arl);
			oos.close();
			fos.close();
	}
}

	public void exit() throws Exception {
		// TODO Auto-generated method stub
		AccountantLogin a=new AccountantLogin();
		a.acclogin("acc","acc123");
	}
}