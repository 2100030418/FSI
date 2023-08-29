package com.klef.ep.servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.klef.ep.models.Faculty;
import com.klef.ep.services.FacultyService;

/**
 * Servlet implementation class Inser
 */
@WebServlet("/insertfaculty")
@MultipartConfig
public class InsertFacultyServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
			String fname = request.getParameter("name");			
			String gender = request.getParameter("gender");
			String dob = request.getParameter("dob");
			String dept = request.getParameter("department");
			String mail = request.getParameter("email");
			String sala = request.getParameter("salary");
			double sal=Double.parseDouble(sala);
			String contact = request.getParameter("contactno");
			
			Part file = request.getPart("image");
			
			System.out.println(file);
			
			InitialContext context = new InitialContext();
			FacultyService facultyService = (FacultyService) context.lookup("java:global/SFISYSTEM/FacultyServiceImpl!com.klef.ep.services.FacultyService");
			
			
	        InputStream inputStream = file.getInputStream();
	        Blob blob = new javax.sql.rowset.serial.SerialBlob(getBytesFromInputStream(inputStream));
	        
	        Faculty std = new Faculty();
	        
	        std.setFname(fname);	       
	        std.setGender(gender);
	        std.setDob(dob);
	        std.setDepartmnt(dept);
	        std.setPassword(dob);
	        std.setEmail(mail);
	        std.setSalary(sal);
	        std.setContactno(contact);
	        std.setImagedata(blob);
	        
	       facultyService.addFaculty(std);
	       response.sendRedirect("adminindex.jsp");
			
		}catch(Exception e)
		{
			out.print(e);
		}
	}
	private byte[] getBytesFromInputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[1024];
        while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }
        buffer.flush();
        return buffer.toByteArray();
    }
}
