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
@WebServlet("/manage/user/")
public class ManagerUserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	
		// TODO Auto-generated constructor stub


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
		ArrayList<UserBean> admin = UserBean.admin();
		 request.setAttribute("admin1", admin);
		 ArrayList<UserBean> notadmin = UserBean.notAdmin();
		 request.setAttribute("admin3", notadmin);
		ArrayList<UserBean> user = UserBean.manageruser();
		 request.setAttribute("user3", user);
		 ArrayList<UserBean> reuser = UserBean.renewuser();
		 request.setAttribute("user4", reuser);
		request.getRequestDispatcher("/manageuser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
		
		String type = request.getParameter("type");
		 String[] checked = request.getParameterValues("checked");
		 if (type.equals("delete")){
			 UserBean dd=new UserBean();
				dd.deleteuser(checked);	 
		 }
		 else if (type.equals("restore")){
			 UserBean ds=new UserBean();
			ds.renewuser(checked); 
		 }
		 else if (type.equals("beadmin")){
			 UserBean ds=new UserBean();
			ds.toBeAdmin(checked); 
		 }
		 else if (type.equals("notbeadmin")){
			 UserBean ds=new UserBean();
			ds.cancelAdmin(checked); 
		 }
		 
		 else{
			 
		 }
		//System.out.println(usermana);
//		UserBean dd=new UserBean();
//		dd.deleteuser(usermana);
//		
//		int reuser = (Integer.parseInt(request.getParameter("reuserman")));
//		UserBean ds=new UserBean();
//		ds.renewuser(reuser);
		response.sendRedirect(request.getContextPath() + "/manage/user/");
			
	}

}
