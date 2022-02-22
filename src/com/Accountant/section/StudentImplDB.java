package com.Accountant.section;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.tushar.FeeReport;

public class StudentImplDB implements StudentInterface {
	ArrayList<StudentPojo> al = new ArrayList<StudentPojo>();
	Scanner sc=new Scanner(System.in);
	public static Connection c()
	{
		Connection c = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniProject","root","root");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	public void addStudent () throws Exception{
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
		
		try
		{
	        String sql = "INSERT INTO Student(Id,Name,Email,Course,Fee,Paid,Due,Address,Contact) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement st = c().prepareStatement(sql);
            for(StudentPojo student:al) {
            st.setInt(1, student.getId());
            st.setString(2,student.getName());
            st.setString(3,student.getEmail());
            st.setString(4,student.getCourse());
            st.setInt(5,student.getFee());
            st.setInt(6,student.getPaid());
            st.setInt(7,student.getDue());
            st.setString(8,student.getAddress());
//            st.setString(8,student.getCity());
//            st.setString(9,student.getState());
//            st.setString(10,student.getCountry());
            st.setString(9,student.getContact());
            st.executeUpdate();
		}
		}
		catch(Exception e){e.printStackTrace();}
	}
	
	public void viewStudent() throws Exception{
		try
		{
			
		    Statement st = c().createStatement();
		    ResultSet rs = st.executeQuery("SELECT * FROM student");
			  while(rs.next()) { 
				 // Student student=new Student();
				  System.out.println(rs.getInt(1));
				  System.out.println(rs.getString(2));
				  System.out.println(rs.getString(3));
				  System.out.println(rs.getString(4));
				  System.out.println(rs.getInt(5));
				  System.out.println(rs.getInt(6));
				  System.out.println(rs.getInt(7));
				  System.out.println(rs.getString(8));
				  System.out.println(rs.getString(9));
				  System.out.println("********************");
				  }	 
		}
		catch(Exception e){e.printStackTrace();}
	
	}
	public void editStudent() throws Exception{
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
		try
		{
	        String sql = "UPDATE student SET name=?,email=?,course=?,fee=?,paid=?,due=?,address=?,contact=? WHERE id=?";
            PreparedStatement pst = c().prepareStatement(sql);
            pst.setString(1,s.getName());
            pst.setString(2,s.getEmail());
            pst.setString(3,s.getCourse());
            pst.setInt(4,s.getFee());
            pst.setInt(5,s.getPaid());
            pst.setInt(6,s.getDue());
            pst.setString(7,s.getAddress());
            pst.setString(8,s.getContact());
            pst.setInt(9,s.getId());

            pst.executeUpdate();
            System.out.println("Data Updated Successfully");
		}
		catch(Exception f){f.printStackTrace();}
	}
	
	public void feeDue() throws Exception{
		try
		{
		    Statement st = c().createStatement();
		    ResultSet rs = st.executeQuery("SELECT id,name,due FROM Student");
			 while(rs.next()) { 
				 
//					 Student s=new Student();
					 System.out.println("Id:  "+rs.getInt(1));
					 System.out.println("Name: "+rs.getString(2));
					 System.out.println("Due:  "+rs.getInt(3));
					 //students.add(s);
				 
				 }
		}
		catch(Exception e){System.out.println(e);}
	}
	public void studLogout() {
		try {
			FeeReport.main(new String[0]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
