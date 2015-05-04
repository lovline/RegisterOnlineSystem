package com.tusheng.oa;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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

	CheckInf chif = new CheckImp();

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
		HttpSession session=request.getSession();
		
		int type = (Integer.parseInt(request.getParameter("type")));
		Check chk = new Check();
		chk.setType(type);	
		chif.addtype(chk);
		request.getRequestDispatcher("/checkin.jsp");

		//2.
		request.setCharacterEncoding("utf-8");
		List list = chif.getChecList();
		request.setAttribute("list", list);
		
		String chk1="2015-5-1 14:00";
		String chk2="ÕÅÈý";
		request.setAttribute("ckr1", chk1);
		request.setAttribute("ckr2", chk2);
		
//		String usercode = (String)request.getSession().getAttribute("realname");
//		System.out.println(usercode);
//		request.setAttribute("usercode", usercode);
		
		
		request.getRequestDispatcher("/checkin.jsp").forward(request, response);
	}

}
