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
@WebServlet("/myworktow/")
public class MyworktowServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyworktowServlet() {
		super();
		this.setTitle("查看任务");
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
		Checko co = new Checko();
		ArrayList<Checko> cc = co.ckuser();
		response.setCharacterEncoding("UTF-8");
		request.setAttribute("cc", cc);
<<<<<<< HEAD
		request.getRequestDispatcher("/myworktow.jsp").forward(request,
				response);
=======
		

		request.getRequestDispatcher("/myworktow.jsp").forward(request, response);
>>>>>>> 18fa01b6b62788e793f99385473f2dae5c2cf572
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		int jid = Integer.parseInt(request.getParameter("work.number"));
		Checko co = new Checko();
		co.setmywork(jid);
		response.sendRedirect(request.getContextPath() + "/myworktow/");
	}

}
