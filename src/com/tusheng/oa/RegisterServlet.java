package com.tusheng.oa;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register/")
public class RegisterServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
    static final String DB_URL="jdbc:mysql://localhost/oa";
    //  Database credentials
    static final String USER = "root";
    static final String PASS = "123";  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        this.setTitle("зЂВс");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
		request.getRequestDispatcher("/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		String realname = request.getParameter("realname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
			UserBean bb=new UserBean();
			bb.registerxx(email,realname,password);
		
		
		String url = request.getContextPath() + "/login/";
		response.sendRedirect(url);

	}
		
		
	}


