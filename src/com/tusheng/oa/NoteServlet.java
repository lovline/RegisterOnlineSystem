package com.tusheng.oa;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NoteServlet
 */
@WebServlet("/note/create/")
public class NoteServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
		if (!this.isLogged){
			response.sendRedirect(request.getContextPath() + "/login/");
			return;
		}
		request.getRequestDispatcher("/Creatnote.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String subject1=request.getParameter("subject");
		subject1 = Helper.toUTF8(subject1);
		String content1=request.getParameter("content");
		content1 = Helper.toUTF8(content1);
		String is_public2=request.getParameter("is_public");
		boolean is_public1=is_public2 != null && is_public2.equals("on");
		NoteBean ff=new NoteBean();
		ff.creatnote(this.user.getId(), subject1, content1, is_public1);
		String url = request.getContextPath() + "/mynote/";
		response.sendRedirect(url);
	}

}
