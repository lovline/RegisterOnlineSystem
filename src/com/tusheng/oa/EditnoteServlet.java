package com.tusheng.oa;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EditnoteServlet
 */
@WebServlet("/note/edit/")
public class EditnoteServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditnoteServlet() {
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
		
	//	request.getRequestDispatcher("/BaseServlet.java").forward(request, response);
	//	HttpSession session = request.getSession();
	//	session.getAttribute("userid");
		String id=request.getParameter("id");
		if (id == null){
			
		}
		int ia=Integer.parseInt(id);
		NoteBean as=new NoteBean();
	     as.detailnote(ia);
	     request.setAttribute("note",as);
	     request.getRequestDispatcher("/Editnote.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//super.doPost(request, response);
		request.setCharacterEncoding("UTF-8");
		String nid = request.getParameter("id");
		
		String subject1=request.getParameter("subject");
		String content1=request.getParameter("content");
		String is_public2=request.getParameter("is_public");
		if (nid == null || subject1 == null || content1 == null){
			// 
		}
		
		boolean is_public1=is_public2.equals("on");
		int id=Integer.parseInt(nid);
		
		//System.out.println( is_public2);
		//System.out.println( subject1);
		//System.out.println( is_public1);
		NoteBean ff=new NoteBean();
		ff.updatenote(id, subject1, content1,is_public1);
		String url = request.getContextPath() + "/mynote/";
		response.sendRedirect(url);
		
		
		
	}

}
