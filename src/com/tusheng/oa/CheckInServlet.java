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
@WebServlet("/checkin/")
public class CheckInServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckInServlet() {
		super();
        this.setTitle("¿¼ÇÚ");
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
		ArrayList<Check> list=chk.chek(pid);
		request.setAttribute("custList", list);
		request.getRequestDispatcher("/checkin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.
		
		
		int type = (Integer.parseInt(request.getParameter("type")));
		HttpSession session=request.getSession();
		int uid=(int)session.getAttribute("userid");
		int pid=this.user.getId();
		Check chk = new Check();
		chk.check(type, uid);
		chk.chek(pid);
		response.sendRedirect(request.getContextPath() + "/checkin/");
		
	}

}
