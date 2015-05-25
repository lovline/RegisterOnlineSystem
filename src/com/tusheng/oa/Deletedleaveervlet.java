package com.tusheng.oa;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckInServlet
 */
@WebServlet("/updateleave/")
public class Deletedleaveervlet extends BaseServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Deletedleaveervlet() {
		super();
        this.setTitle("考勤管理");
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
		if (!this.isLogged){
			response.sendRedirect(request.getContextPath() + "/login/");
			return;
		}
		Check chk = new Check();
		int pid=this.user.getId();
		ArrayList<Check> list=chk.chekin();
		request.setAttribute("custList", list);
		request.getRequestDispatcher("/updateleave.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.
		//这是在java代码中获取checkbox的值   
		String type = "";   
		String[] type1 = request.getParameterValues("checkbox1");   
		for (int i = 0; i < type1.length; i++) {   
		   type += type1[i] + ",";   
		}   
		System.out.println(type);  
		
//		int inteId = Integer.parseInt(request.getParameter("inte"));
//		System.out.println(inteId);
//		Check check=new Check();
//		check.deletcheck(inteId);
		response.sendRedirect(request.getContextPath() + "/updateleave/");
		
	}

}
