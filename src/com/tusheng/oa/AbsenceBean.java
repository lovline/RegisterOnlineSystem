package com.tusheng.oa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AbsenceBean {
	private int id;
	private int user_id;
	private Date start_time;
	private Date end_time;
	private int status;
    private Date created_at ;
   
    public boolean absencein(int uid,String start_time,String end_time, int status) {
		DB db = new DB();
		Date d = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String now = format.format(d);
		String s = "insert into absence set user_id =\"" + uid + "\", start_time= \"" + start_time + "\",end_time=\"" + end_time +"\",status=\"" +status + "\",created_at =\"" + now + "\"";
		db.insert(s);
		db.close();
		return true;
	}
    public ArrayList<AbsenceBean> absenceout(int uid) {
		DB db = new DB();		
//		UserBean user = new UserBean(); 	
		ArrayList<AbsenceBean> result = new ArrayList<AbsenceBean>();
		try {
			String s = "select created_at,start_time,end_time,status from absence where user_id=" + uid;
			ResultSet rs = db.select(s);
			while(rs.next()){
				AbsenceBean bean = new AbsenceBean();
				bean.created_at = rs.getDate("created_at");
				bean.start_time = rs.getDate("start_time");
				bean.end_time = rs.getDate("end_time");
				bean.status = rs.getInt("status");
				result.add(bean);
			}
			db.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			db.close();
			return result;
		}
    }
    
//  setter and getter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	
	
}

