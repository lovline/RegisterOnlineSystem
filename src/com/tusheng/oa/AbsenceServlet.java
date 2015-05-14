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
 * Servlet implementation class AbsenceServlet
 */
@WebServlet("/manage/absence/")
public class AbsenceServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AbsenceServlet() {
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
//	    if (!this.isLogged){
//			response.sendRedirect(request.getContextPath() + "/login/");
//			return;
//		}
	    ArrayList<AbsenceBean> result = bean.mgabsenceout();
	    request.setAttribute("results", result);
		request.getRequestDispatcher("/absence.jsp").forward(request, response);
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
		super.doPost(request,response);
		int id = Integer.parseInt(request.getParameter("aid"));
		int z = Integer.parseInt(request.getParameter("z"));
		AbsenceBean bean = new AbsenceBean();
		bean.mgabsencein(id,z);
	    response.sendRedirect(request.getContextPath() + "/manage/absence/");
	}

}
