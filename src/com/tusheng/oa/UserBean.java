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
	private static final int SUPER_ADMIN = 2;
	private int id;
	private String email;
	private String password;
	private int status;
	private boolean is_active;
	private String realname;
	private Date last_login_at;
	private Date created_at;

	private boolean admin=false;
	private boolean superAdmin=false;
	public static ArrayList<UserBean> admin(){
		DB na=new DB();
		String sql="select * from user where status=0";
		ResultSet ss=na.select(sql);
		ArrayList<UserBean> user = new ArrayList<UserBean>();
		try {
			while(ss.next()){
				UserBean user1= new UserBean();
				user1.id = ss.getInt("id");
				user1.email=ss.getString("email");
				user1.realname=ss.getString("realname");
				user1.status=ss.getInt("status");
				user.add(user1);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		na.close();
		return user;
		
	}
	public static ArrayList<UserBean> notAdmin(){
		DB na=new DB();
		String sql="select * from user where status=1";
		ResultSet ss=na.select(sql);
		ArrayList<UserBean> user = new ArrayList<UserBean>();
		try {
			while(ss.next()){
				UserBean user1= new UserBean();
				user1.id = ss.getInt("id");
				user1.email=ss.getString("email");
				user1.realname=ss.getString("realname");
				user1.status=ss.getInt("status");
				user.add(user1);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		na.close();
		return user;
		
	}
	public void toBeAdmin(String[] usermanid){
		DB db=new DB();
		String ids = "";
		for(int i=0; i<usermanid.length; i++){
			ids += usermanid[i] + ",";
		}
		ids = ids.substring(0, ids.length()-1);
		String sql="update user set status=1 where id in ("+ids+"); ";
		db.update(sql);
		db.close();
	}
	public void cancelAdmin(String[] usermanid){
		DB db=new DB();
		String ids = "";
		for(int i=0; i<usermanid.length; i++){
			ids += usermanid[i] + ",";
		}
		ids = ids.substring(0, ids.length()-1);
		String sql="update user set status=0 where id in ("+ids+"); ";
		db.update(sql);
		db.close();
	}
	public static ArrayList<UserBean> manageruser(){
		DB na=new DB();
		String sql="select * from user where is_active=1";
		ResultSet ss=na.select(sql);
		ArrayList<UserBean> user = new ArrayList<UserBean>();
		try {
			while(ss.next()){
				UserBean user1= new UserBean();
				user1.id = ss.getInt("id");
				user1.email=ss.getString("email");
				user1.realname=ss.getString("realname");
				user.add(user1);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		na.close();
		return user;
		
	}
	public void deleteuser(String[] usermanid){
		DB db=new DB();
		String ids = "";
		for(int i=0; i<usermanid.length; i++){
			ids += usermanid[i] + ",";
		}
		ids = ids.substring(0, ids.length()-1);
		String sql="update user set is_active=0 where id in ("+ids+"); ";
		db.update(sql);
		db.close();
	}
	public static ArrayList<UserBean> renewuser(){
		DB na=new DB();
		String sql="select * from user where is_active=0";
		ResultSet ss=na.select(sql);
		ArrayList<UserBean> user = new ArrayList<UserBean>();
		try {
			while(ss.next()){
				UserBean user1= new UserBean();
				user1.id = ss.getInt("id");
				user1.email=ss.getString("email");
				user1.realname=ss.getString("realname");
				user1.status=ss.getInt("status");
				user.add(user1);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		na.close();
		return user;
		
	}
	public void renewuser(String[] reusermanid){
		DB db=new DB();
		String ids = "";
		for(int i=0; i<reusermanid.length; i++){
			ids += reusermanid[i] + ",";
		}
		ids = ids.substring(0, ids.length()-1);
		String sql="update user set is_active=1 where id in ("+ids+"); ";
		db.update(sql);
		db.close();
	}
	

	public void password(String password, int id) {
		DB db = new DB();
		// String sql = "select * from user where id=\" " + id +"\"  ";

		String sql = "update user set password=\"" + password + "\""
				+ "where id =" + id;
		db.insert(sql);
		db.close();
	}

	public boolean updateUserMessage(String email,String realname,int pid){

		DB db = new DB();
		String sql = "update user set email=\"" + email + "\",realname=\"" + realname +
				"\""+"where id="+pid+";";
		String sql1="select email from user where email=\""+email+"\" and id!="+pid+";";
		String sql2="select realname from user where realname=\""+realname+"\" and id!="
				+pid+";";
		ResultSet rs1=db.select(sql1);
		ResultSet rs2=db.select(Helper.toUTF8(sql2));
		System.out.println(realname);
		try {
			if(rs1.next()||rs2.next()){
				return false;
			}else{
				db.update(Helper.toUTF8(sql));
				db.select(sql2);
				db.close();
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
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
				this.superAdmin = this.status == SUPER_ADMIN;

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
				this.superAdmin = this.status == SUPER_ADMIN;
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

	// ¿¼ÇÚ
	public static ArrayList<UserBean> get_kqemployees(int pid) {
		// TODO Auto-generated method stub
		DB db = new DB();
		ArrayList<UserBean> list = new ArrayList<UserBean>();

		String s = "select * from user where id=" + pid;
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getRealname() + "(" + this.getId() + ")";
	}
	public boolean isSuperAdmin() {
		return superAdmin;
	}
	public void setSuperAdmin(boolean superAdmin) {
		this.superAdmin = superAdmin;
	}

}
