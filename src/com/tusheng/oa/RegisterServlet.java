package com.tusheng.oa;

import java.io.IOException;
import java.net.URLEncoder;
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
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        this.setTitle("途晟科技在线注册");
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
		super.doPost(request, response);
		//response.setCharacterEncoding("UTF-8");
		String realname = request.getParameter("realname");
		//realname = Helper.toUTF8(realname);
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		UserBean userBean=new UserBean();
		boolean flag = userBean.registerxx(email, realname, password);
		if(flag){
			String info = URLEncoder.encode("Register success , Please Login", "utf-8");
			String url = request.getContextPath() + "/login/?alert=" + info;
			response.sendRedirect(url);
			return ;
		}
		else{
			String info = URLEncoder.encode("Email has been registered , Please register again", "utf-8");
			String url = request.getContextPath() + "/register/?alert=" + info;
			response.sendRedirect(url);
			return ;
		}

	}
		
		
	}


