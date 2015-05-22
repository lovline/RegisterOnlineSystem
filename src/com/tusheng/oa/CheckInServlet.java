package com.tusheng.oa;

import java.io.IOException;
import java.util.ArrayList;

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
		if (!this.isLogged) {
			response.sendRedirect(request.getContextPath() + "/login/");
			return;
		}
		Check chk = new Check();
		int pid = this.user.getId();
		ArrayList<Check> list = chk.chek(pid);
		request.setAttribute("custkq", list);
		ArrayList<UserBean> employees = UserBean.get_kqemployees(pid);
		request.setAttribute("cu", employees);
		request.getRequestDispatcher("/checkin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = request.getParameter("type");
		int pid = this.user.getId();
		Check chk = new Check();
		chk.check(Integer.parseInt(type), pid);
		chk.chek(pid);
		UserBean bean=new UserBean();
		bean.get_kqemployees(pid);
		
		response.sendRedirect(request.getContextPath() + "/checkin/");
		
		}
}
