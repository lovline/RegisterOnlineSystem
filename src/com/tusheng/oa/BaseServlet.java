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
 * Servlet implementation class BaseServlet
 */
@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public String title = "";
	public UserBean user = new UserBean();
	public boolean isLogged = false;
	public boolean has_alert = false;
    public BaseServlet() {
        super();
        this.setTitle(Constant.HOMEPAGE);
    }
    
    private void setExtra(HttpServletRequest request) {
    	request.setAttribute("SITE_NAME", Constant.SITE_NAME);
    	request.setAttribute("title", this.title);
    	String alert_info = request.getParameter("alert");
    	if (alert_info != null && !alert_info.isEmpty()){
    		has_alert = true;
    	}
    	else{
    		has_alert = false;
    	}
    	request.setAttribute("has_alert", has_alert);
    	request.setAttribute("alert_info", alert_info);
    }
    
    protected boolean needLogin(HttpServletRequest request, HttpServletResponse response) throws IOException{
    	if (!this.isLogged){
    		String alert = URLEncoder.encode("ÇëÏÈµÇÂ¼", "utf-8");
    		String url = request.getContextPath() + "/login/?alert=" + alert;
    		response.sendRedirect(url);
    		return false;
    	}
    	return true;
    }
    
    protected boolean needAdminLogin(HttpServletRequest request, HttpServletResponse response) throws IOException{
    	if (!this.isLogged && this.user.isAdmin()){
    		String alert = URLEncoder.encode("ÇëÏÈµÇÂ¼", "utf-8");
    		String url = request.getContextPath() + "/login/?alert=" + alert;
    		response.sendRedirect(url);
    		return false;
    	}
    	return true;
    }
    
    private void checkLogin(HttpServletRequest request){
    	HttpSession session = request.getSession();
    	if (session == null) return;
    	if (session.getAttribute("is_logged") == null) {
    		this.isLogged = false;
    		return;
    	}
    	this.isLogged = (boolean) session.getAttribute("is_logged");
    	if (isLogged){
    		// ÒÑ¾­µÇÂ¼
    		if (session.getAttribute("userid") == null){
    			session.removeAttribute("is_logged");
    			isLogged = false;
    			return;
    		}
    		int uid = (int)session.getAttribute("userid");
    		boolean is_succ = this.user.login(uid);
    		if (is_succ){
    			request.setAttribute("userBean", user);
    			this.isLogged = true;
    		}
    		else{
    			session.removeAttribute("is_logged");
    			this.isLogged = false;
    		}
    	}
    }
    public void setTitle(String s){
    	this.title = s + "-" + Constant.SITE_NAME;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		setExtra(request);
		checkLogin(request);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		setExtra(request);
		checkLogin(request);

		
	}

}
