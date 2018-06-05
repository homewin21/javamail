package com.homewin.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homewin.service.UserService;


public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		System.out.println(userName+" "+password+" "+email);
		UserService userService=new UserService();
		
		try {
			if(userService.register(userName,password,email)){
				request.setAttribute("msg", "◊¢≤·≥…π¶£¨«Îµ«¬º” œ‰º§ªÓ’À∫≈");
			}else{
				request.setAttribute("msg", "◊¢≤· ß∞‹£¨«ÎºÏ≤Èœ‡πÿ–≈œ¢");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/result.jsp").forward(request, response);
	}
	
	
}
