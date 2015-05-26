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
@WebServlet("/worktwo/")
public class CheckTwoServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckTwoServlet() {
		super();
		this.setTitle("查看工作");
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
		ArrayList<UserBean> employees = UserBean.get_employees();
		request.setAttribute("cc", cc);
		request.setAttribute("cu", employees);

		request.getRequestDispatcher("/worktwo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		
		String sw = request.getParameter("worknum");
		String uuid = request.getParameter("custId");
		if(uuid!=null){
			Checko co = new Checko();
			co.setwork(Integer.parseInt(sw),Integer.parseInt(uuid));
			response.sendRedirect(request.getContextPath() + "/worktwo/");	
			return;
		}else if(uuid==null){
			response.sendRedirect(request.getContextPath() + "/worktwo/");
			return;
		}
	}

}
