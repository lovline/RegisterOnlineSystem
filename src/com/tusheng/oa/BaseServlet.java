package com.tusheng.oa;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    
    public void setTitle(String s){
    	this.title = s + "-" + Constant.SITE_NAME;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		setExtra(request);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		setExtra(request);
	}

}
