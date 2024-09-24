package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBconnect;
import com.dao.UserDaoimpl;
import com.entity.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String name=req.getParameter("fname");
			String email=req.getParameter("email");
			String phno=req.getParameter("phno");			
			String password=req.getParameter("password");
			String check=req.getParameter("check");
			
			//System.out.println(name+" "+email+" "+phno+" "+password+" "+check+"");
			
			User us = new User();
			us.setName(name);
			us.setEmail(email);
			us.setPhno(phno);
			us.setPassword(password);
			
			HttpSession session = req.getSession();
			
			if(check!=null)
			{
			 UserDaoimpl dao = new UserDaoimpl(DBconnect.getCon());
			Boolean f= dao.userRegister(us);
			 if(f)
			 {
				// System.out.println("user register success..");
				 
				 session.setAttribute("succMsg","Registration Succssfully..");
				 resp.sendRedirect("register.jsp");
			 }else
			 {
				 //System.out.println("Something wrong on server");
				 session.setAttribute("failedMsg","Something wrong on server..");
				 resp.sendRedirect("register.jsp");
			 }
			 
			}else
			{
				//System.out.println("please check Agree & terms Condition");
				session.setAttribute("failedMsg","please check Agree & terms Condition..");
				 resp.sendRedirect("register.jsp");
			}
			 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
