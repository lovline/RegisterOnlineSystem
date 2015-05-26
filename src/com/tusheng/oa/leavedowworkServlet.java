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
@WebServlet("/leavedowwork/")
public class leavedowworkServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public leavedowworkServlet() {
		super();
		this.setTitle("¿¼ÇÚ¹ÜÀí");
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
		if (!this.isLogged) {
			response.sendRedirect(request.getContextPath() + "/login/");
			return;
		}
		Check chk = new Check();
		ArrayList<Check> list = chk.qbchek();
		request.setAttribute("custList", list);
		request.getRequestDispatcher("/leavedowwork.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1.
		String kqId = request.getParameter("kqId");
		if(kqId.equals("1")){
			response.sendRedirect(request.getContextPath() + "/leaveupwork/");
		}else if(kqId.equals("2")){
			response.sendRedirect(request.getContextPath() + "/leavedowwork/");
		}else if(kqId.equals("3")){
			response.sendRedirect(request.getContextPath() + "/leave/");
		}else if(kqId.equals("")){
		response.sendRedirect(request.getContextPath() + "/leavedowwork/");
		}
	}

}
