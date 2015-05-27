package com.tusheng.oa;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/user/change/")
public class ChangeUserInfoServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeUserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException {
		super.doGet(request, response);
		request.getRequestDispatcher("/changeuser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doPost(request, response);
		DB db=new DB();
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		int pid=this.user.getId();
		UserBean bean = new UserBean();
		if(bean.login(pid)){
			String originEmail=bean.getEmail();
			HttpSession session = request.getSession();
			session.setAttribute("userid", bean.getId());
			String originName=Helper.toUTF8(bean.getRealname());
			System.out.println(name+" | "+originName);
			if(email.equals(originEmail) && name.equals(originName)){
				String info=URLEncoder.encode("与原邮箱、用户名一致，无需修改！","utf-8");
				response.sendRedirect(request.getContextPath()+"/user/change/?a"
						+ "lert="+info);
			}else{
				if(bean.updateUserMessage(email, name,pid)){
					String info = URLEncoder.encode("修改成功！", "utf-8");
					response.sendRedirect(request.getContextPath() + "/index"
							+ "/?alert="+info);
				}else{
					String info = URLEncoder.encode("该邮箱或用户名已被他人占用，请重新"
							+ "输入...", "utf-8");
					response.sendRedirect(request.getContextPath() + "/user/"
							+ "change/?alert="+info);
				}
			}
		}
	}

}
