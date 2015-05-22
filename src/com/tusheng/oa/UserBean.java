package com.tusheng.oa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class UserBean {
	private static final int NORMAL = 0;
	private static final int ADMIN = 1;
	private int id;
	private String email;
	private String password;
	private int status;
	private boolean is_active;
	private String realname;
	private Date last_login_at;
	private Date created_at;
	private boolean admin = false;

	public void password(String password, int id) {
		DB db = new DB();
		// String sql = "select * from user where id=\" " + id +"\"  ";

		String sql = "update user set password=\"" + password + "\""
				+ "where id =" + id;
		db.insert(sql);
		db.close();

	}
	public void updatemessage(String email,String realname,int pid){
		DB db = new DB();
		
		String sql = "update user set email=\"" + email + "\",realname=\"" + realname +
				"\""+"where id="+pid+";";
		db.update(sql);
		db.close();
	}
	

	public void registerxx(String email, String realname, String password) {
		DB db = new DB();

		String sql = "insert into user set email=\"" + email + "\",realname=\""
				+ realname + "\", password=\"" + password
				+ "\",is_active=true,status=0, created_at=\""
				+ Helper.formatDate(new Date()) + "\"";
		;
		db.insert(sql);
		db.close();
	}

	public boolean login() {
		DB db = new DB();
		String sql = "select * from user where email=\"" + email
				+ "\" and password=\"" + password + "\"";
		ResultSet rs = db.select(sql);
		try {
			if (rs.next()) {
				this.id = rs.getInt("id");
				this.is_active = rs.getInt("is_active") == 1;

				if (!this.is_active) {
					return false;
				}

				this.status = rs.getInt("status");
				this.email = rs.getString("email");
				this.password = rs.getString("password");
				this.realname = rs.getString("realname");
				this.created_at = rs.getDate("created_at");
				this.last_login_at = rs.getDate("last_login_at");
				this.admin = this.status == ADMIN;

				Date d = new Date();
				String now = Helper.formatDate(d);
				String s = "update user set last_login_at=\"" + now
						+ "\" where id=" + this.id;
				db.update(s);
				this.last_login_at = d;

				db.close();
				return true;
			}
			db.close();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			db.close();
			return false;
		}
	}

	public boolean login(int id) {
		DB db = new DB();
		String sql = "select * from user where id=" + id;
		ResultSet rs = db.select(sql);
		try {
			if (rs.next()) {
				this.id = rs.getInt("id");
				this.is_active = rs.getInt("is_active") == 1;
				if (!this.is_active) {
					return false;
				}
				this.status = rs.getInt("status");
				this.realname = rs.getString("realname");
				this.password = rs.getString("password");
				this.email = rs.getString("email");
				this.id = rs.getInt("id");
				this.created_at = rs.getDate("created_at");
				Timestamp stamp = rs.getTimestamp("last_login_at");
				if (stamp != null) {
					this.last_login_at = new Date(stamp.getTime());
				}
				this.admin = this.status == ADMIN;
				db.close();
				return true;
			}
			db.close();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			db.close();
			return false;
		}
	}

	// 2-2

	// setter and getter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public Date getLast_login_at() {
		return last_login_at;
	}

	public void setLast_login_at(Date last_login_at) {
		this.last_login_at = last_login_at;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public static ArrayList<UserBean> get_employees() {
		// TODO Auto-generated method stub
		DB db = new DB();
		ArrayList<UserBean> list = new ArrayList<UserBean>();

		String s = "select * from user";
		ResultSet rs = db.select(s);
		try {
			while (rs.next()) {
				UserBean bean = new UserBean();
				bean.id = rs.getInt("id");
				bean.realname = rs.getString("realname");
				list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.close();
		return list;
	}

	//¿¼ÇÚ
	public static ArrayList<UserBean> get_kqemployees(int pid) {
		// TODO Auto-generated method stub
		DB db = new DB();
		ArrayList<UserBean> list = new ArrayList<UserBean>();
		
		String s = "select * from user where id="+pid;
		ResultSet rs = db.select(s);
		try {
			while (rs.next()) {
				UserBean bean=new UserBean();
				bean.id = rs.getInt("id");
				bean.realname = rs.getString("realname");
				list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.close();
		return list;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getRealname() + "(" + this.getId() + ")";
	}

}
