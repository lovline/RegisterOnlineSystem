package com.tusheng.oa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Check {

	private int id;
	private int user_id;
	private UserBean userid = new UserBean();
	private Date checkin_time;
	private int type;
	private String name;
	private Date times;

	public boolean check(int type, int pid) {
		// ResultSet rs =
		
		DB db = new DB();
		Date d = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = format.format(d);
		String sq = "insert into attendance set type=" + type + " ,user_id="
				+ pid+" ,checkin_time=\""+now+ "\"";
		db.insert(sq);



		db.close();
		return true;
	}
	//删除
	public boolean deletcheck(int kqpe) {
		// ResultSet rs =
		DB db = new DB();
		String sq = "delete from attendance where id="+kqpe;
		db.update(sq);
		db.close();
		return true;
	}
	//管理查询
	public String nameselec(int u) {
		DB db = new DB();
		String realname = null;
		try {
			String s = "select realname from user where id=" + u;
			ResultSet rs = db.select(s);
			while (rs.next()) {
				realname = rs.getString("realname");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.close();
		return realname;
	}
	public ArrayList<Integer> assid() {
		DB db = new DB();
		ArrayList<Integer> relist = new ArrayList<Integer>();
		String s = "select user_id from attendance";
		ResultSet rs = db.select(s);
		try {
			while (rs.next()) {
				Check bean = new Check();
				bean.user_id = rs.getInt("user_id");
				relist.add(bean.user_id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.close();
		return relist;
	}

	public ArrayList<Check> chek(int pid) {
		System.out.println(pid);
		DB db = new DB();
		String sql = "select * from attendance where user_id="+pid;
		ResultSet rs = db.select(sql);
		ArrayList<Check> list2=new ArrayList<Check>();
		Check cbean=new Check();
		ArrayList<Integer> userid = cbean.assid();	
		int i=0;
			try {
				while (rs.next()) {
					Check ck=new Check();
					ck.id = rs.getInt("id");
					ck.name = ck.nameselec(userid.get(i++));
					ck.checkin_time=rs.getTimestamp("checkin_time");
					ck.type=rs.getInt("type");
					ck.userid.login(ck.user_id);
					list2.add(ck);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			db.close();
			return list2;
	
	}
	
	public ArrayList<Check> chekin() {
		DB db = new DB();
		String sql = "select * from attendance ";
		ResultSet rs = db.select(sql);

		ArrayList<Check> list=new ArrayList<Check>();
		Check cbean=new Check();
		ArrayList<Integer> userid = cbean.assid();	
		int i=0;
			try {
				while (rs.next()) {
					Check ck=new Check();
					ck.id = rs.getInt("id");
					ck.name = ck.nameselec(userid.get(i++));
					ck.checkin_time=rs.getTimestamp("checkin_time");
					ck.type=rs.getInt("type");
					list.add(ck);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			db.close();
			return list;
	
	}

	//查签到时间 type=1; 下班
	public ArrayList<Check> qdchek() {
		DB db = new DB();
		String sql ="SELECT * FROM attendance WHERE  TYPE=1 AND DATE_FORMAT(checkin_time,'%H')<16";
		ResultSet rs = db.select(sql);
		ArrayList<Check> list=new ArrayList<Check>();
		Check cbean=new Check();
		ArrayList<Integer> userid = cbean.assid();	
		int i=0;
			try {
				while (rs.next()) {
					Check ck=new Check();
					ck.id = rs.getInt("id");
					ck.name =ck.nameselec(userid.get(i++));
					ck.checkin_time=rs.getTimestamp("checkin_time");
					ck.type=rs.getInt("type");
					ck.times=rs.getTime("checkin_time");
					list.add(ck);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			db.close();
			return list;
	
	}
	// type=2； 上班
	public ArrayList<Check> qbchek() {
		DB db = new DB();
		String sql ="SELECT * FROM attendance WHERE  TYPE=2 AND DATE_FORMAT(checkin_time,'%H：%i')>'09:00'";
		ResultSet rs = db.select(sql);
		ArrayList<Check> list=new ArrayList<Check>();
		Check cbean=new Check();
		ArrayList<Integer> userid = cbean.assid();	
		int i=0;
			try {
				while (rs.next()) {
					Check ck=new Check();
					ck.id = rs.getInt("id");
					ck.name = ck.nameselec(userid.get(i++));
					ck.checkin_time=rs.getTimestamp("checkin_time");
					ck.type=rs.getInt("type");
					list.add(ck);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			db.close();
			return list;
	
	}
	
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

	public Date getCheckin_time() {
		return checkin_time;
	}

	public void setCheckin_time(Date checkin_time) {
		this.checkin_time = checkin_time;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Check() {
		super();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getTimes() {
		return times;
	}
	public void setTimes(Date times) {
		this.times = times;
	}
	public UserBean getUserid() {
		return userid;
	}
	public void setUserid(UserBean userid) {
		this.userid = userid;
	}

}
