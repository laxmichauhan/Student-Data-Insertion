package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import db.Dconnect.Connect;
import model.Student;

public class Controller {
	private static Connection con;
	private static Statement st;
	private static PreparedStatement ps;
	private static ResultSet rs;

	public static boolean storeRegisterData(Student st) {
		boolean status=false;
		
		try {
			con=Connect.dbcon();
			String sql="insert into student (rollno,stName,fName,clsName,semester,emailId,password,gender,address,marks)values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setLong(1, st.getRollno());
			ps.setString(2, st.getStName());
			ps.setString(3, st.getfName());
			ps.setString(4, st.getClsName());
			ps.setLong(5, st.getSemester());
			ps.setString(6, st.getEmailId());
			ps.setString(7, st.getPassword());
			ps.setString(8, st.getGender());
			ps.setString(9, st.getAddress());
			ps.setDouble(10, st.getMarks());
			
			int i=ps.executeUpdate();
			if(i>0)
			{
				status=true;	
		} }
		catch (Exception e) {
			System.out.println("Exception in insertion "+e);
			
		}
		
		return status;
	
	}
}
