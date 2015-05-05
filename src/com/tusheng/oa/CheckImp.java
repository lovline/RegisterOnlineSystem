package com.tusheng.oa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CheckImp implements CheckInf{

	@Override
	public void addtype(Check chk) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oa", "root", "java");
				ps = conn.prepareStatement("insert into attendance (type) values(?)");
				ps.setInt(1,chk.getType());
				ps.executeUpdate();
				conn.close();
				ps.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public UserBean seleid(int id){
		// TODO Auto-generated method stub
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserBean ub=new UserBean();
			
				try {
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oa", "root", "java");
					ps = conn.prepareStatement("select * from absence where custId=?");
					ps.setInt(1, id);
					rs = ps.executeQuery();
					while(rs.next()){
						ub.setId(rs.getInt("id"));
						ub.setRealname(rs.getString("realname"));				
					}
					conn.close();
					ps.close();
					rs.close();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return ub;
				
	
	}

	public List getChecList() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Check chk=new Check();
		ArrayList list=new ArrayList();
			try {
				Class.forName("com.mysql.jdbc.Driver");
			    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oa", "root", "java");
				ps = conn.prepareStatement("select * from attendance ");
				
				rs = ps.executeQuery();
				while(rs.next()){
					chk.setId(rs.getInt("user_id"));
					chk.setCheckin_time(rs.getDate("checkin_time"));
					chk.setType(rs.getInt("type"));	
					list.add(chk);
				}
				conn.close();
				ps.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;	
	}
	
	}

	
	

