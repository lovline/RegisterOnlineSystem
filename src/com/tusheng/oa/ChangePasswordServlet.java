package com.tusheng.oa;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/password/change/")
public class ChangePasswordServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangePasswordServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		request.getRequestDispatcher("/changepassword.jsp").forward(request,
				response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		if (!this.isLogged) {
			String info = URLEncoder.encode("必须登录才能执行", "utf-8");
			String url = request.getContextPath() + "/login/?alert=" + info;
			response.sendRedirect(url);
			return;
		}
		// request.getRequestDispatcher("/changepassword.jsp").forward(request,
		// response);
		String password = request.getParameter("pwd");
		String password1 = request.getParameter("pwd1");
		String password2 = request.getParameter("pwd2");
		int id = this.user.getId();
		UserBean bean = new UserBean();
		String password3 = this.user.getPassword();
		request.setAttribute("userBean", bean);

		if (password.equals(password3)) {
			if (password1.equals(password2)) {

				bean.password(password1, id);
				HttpSession session = request.getSession();
				session.setAttribute("is_logged", true);
				session.setAttribute("userid", bean.getId());
				String info = URLEncoder.encode("修改密码成功，请重新登陆", "utf-8");
				String url = request.getContextPath() + "/login/?alert=" + info;
				response.sendRedirect(url);

			}

		} else {

			String info = URLEncoder.encode("当前用户名密码错误", "utf-8");
			response.sendRedirect(request.getContextPath()
					+ "/password/change/?alert=" + info);
		}
	}

}
