package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Controller;
import model.Student;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Student st=new Student();
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		
		String r=request.getParameter("rollno");
		int rollno=Integer.parseInt(r);
		st.setRollno(rollno);
		
		String stName=request.getParameter("name");
		st.setStName(stName);
		
		String sem=request.getParameter("sem");
		int semester=Integer.parseInt(sem);
		st.setSemester(semester);
		
		String fName=request.getParameter("fname");
		st.setfName(fName);
		
		String address=request.getParameter("address");
		st.setAddress(address);
		
		String emailId=request.getParameter("email");
		st.setEmailId(emailId);
		
		String password=request.getParameter("psw");
		st.setPassword(password);
		
		String gender=request.getParameter("gender");
		st.setGender(gender);
		
		String clsName=request.getParameter("class");
		st.setClsName(clsName);
		

		String m=request.getParameter("Marks");
		double marks=Double.parseDouble(m);
		st.setMarks(marks);
		
		System.out.println(st);
		boolean status=Controller.storeRegisterData(st);
		
		if(status) {
			out.print("Data successfully Entered.");
		}
		else {
			out.print("Data not Entered");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
