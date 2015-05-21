package com.tusheng.oa;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/profile/")
public class ProfileServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfileServlet() {
		super();
		this.setTitle("个人主页");
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
		String uid = request.getParameter("uid");
		if (uid == null || uid.isEmpty() || Integer.parseInt(uid) == this.user.getId()){
			request.setAttribute("owner", this.user);
			request.setAttribute("isOwner", true);
		}
		else{
			UserBean owner = new UserBean();
			boolean is_succ = owner.login(Integer.parseInt(uid));
			if (!is_succ){
				String alert = URLEncoder.encode("你请求的用户不存在", "utf-8");
				response.sendRedirect(request.getContextPath() + "/profile/?alert="+alert);
				return;
			}
			request.setAttribute("owner", owner);
			request.setAttribute("isOwner", false);
		}
		request.getRequestDispatcher("/profile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			
	}
}
