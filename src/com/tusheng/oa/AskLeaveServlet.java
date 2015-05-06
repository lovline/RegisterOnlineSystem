package com.tusheng.oa;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AskLeaveServlet
 */
@WebServlet("/askleave/")
public class AskLeaveServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AskLeaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
		AbsenceBean bean = new AbsenceBean();  		
	    try {
	    if (!this.isLogged){
			response.sendRedirect(request.getContextPath() + "/login/");
			return;
		}
	    ArrayList<AbsenceBean> results = bean.absenceout(this.user.getId());
	    request.setAttribute("results", results);
		request.getRequestDispatcher("/askleave.jsp").forward(request, response);
	    } catch (Exception e) {
        // TODO Auto-generated catch block
			e.printStackTrace();
	    }
}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
		HttpSession session=request.getSession();
		int uid=(int) session.getAttribute("userid");
		AbsenceBean bean = new AbsenceBean();
	    String start_time = request.getParameter("start_time");
		String end_time = request.getParameter("end_time");	
		bean.absencein(uid,start_time,end_time, 0);
	    response.sendRedirect(request.getContextPath() + "/askleave/");
	}
}
