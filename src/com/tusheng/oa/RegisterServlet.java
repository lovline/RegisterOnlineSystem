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
    static final String PASS = "java";  
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
		String realname = request.getParameter("realname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		try {
			Class.forName(JDBC_DRIVER).newInstance();
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			String sql = "insert into user set email=\"" + email + "\",realname=\"" + realname + 
					"\", password=\""+password + "\"";
			Statement stmt = conn.createStatement();
			stmt.execute(sql);
		} catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String url = request.getContextPath() + "/login/";
		response.sendRedirect(url);
	}
		
		
	}


