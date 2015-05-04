package com.tusheng.oa;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AskLeaveServlet
 */
@WebServlet("/askleave/")
public class AskLeaveServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
    static final String DB_URL="jdbc:mysql://localhost/oa";
    //  Database credentials
    static final String USER = "root";
    static final String PASS = "java";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AskLeaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
	    try {
		HttpSession session = request.getSession();
//		int uid = (int)session.getAttribute("userid");
    	UserBean user = new UserBean();      
//    	boolean is_succ = user.login(uid);
		AbsenceBean bean = new AbsenceBean();
//		bean.setCreated_at(new Date());
//		bean.setStart_time(new Date());
//		bean.setEnd_time(new Date());
		Class.forName(JDBC_DRIVER).newInstance();
		Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		String sql = "select created_at,start_time,end_time from absence where (user_id=\"" + user.getId() + "\")";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list=new ArrayList();
		while(rs.next()){
			bean.setCreated_at(rs.getDate("created_at"));
			bean.setStart_time(rs.getDate("start_time"));
			bean.setEnd_time(rs.getDate("end_time"));}
		list.add(bean);
		request.setAttribute("list", list);
//		request.setAttribute("absenceBean", bean);
//		System.out.println(list);
		request.getRequestDispatcher("/askleave.jsp").forward(request, response);
	    } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }


//		request.getRequestDispatcher("/askleave.jsp").forward(request, response);
	
}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String start_time = request.getParameter("start_time");
		String end_time = request.getParameter("end_time");
	    response.sendRedirect(request.getContextPath() + "/profile/");
//	    response.sendRedirect("profile.jsp");
	}

}
