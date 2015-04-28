package com.tusheng.oa;

import java.io.IOException;

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
    public BaseServlet() {
        super();
        this.setTitle(Constant.HOMEPAGE);
    }
    
    private void setExtra(HttpServletRequest request) {
    	request.setAttribute("SITE_NAME", Constant.SITE_NAME);
    	request.setAttribute("title", this.title);
    }
    
    private void checkLogin(HttpServletRequest request){
    	HttpSession session = request.getSession();
    	if (session == null) return;
    	if (session.getAttribute("is_logged") == null) return;
    	boolean is_logged = (boolean) session.getAttribute("is_logged");
    	if (is_logged){
    		// ÒÑ¾­µÇÂ¼
    		if (session.getAttribute("userid") == null){
    			session.removeAttribute("is_logged");
    			return;
    		}
    		int uid = (int)session.getAttribute("userid");
    		UserBean user = new UserBean();
    		boolean is_succ = user.login(uid);
    		if (is_succ){
    			request.setAttribute("userBean", user);
    		}
    		else{
    			session.removeAttribute("is_logged");
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
		setExtra(request);
		checkLogin(request);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		setExtra(request);
	}

}
