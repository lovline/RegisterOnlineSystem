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
	private Date checkin_time;
	private int type;
	private String name;

	public boolean check(int type, int uid) {
		// ResultSet rs =
		DB db = new DB();
		Date d = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String now = format.format(d);
		String sq = "insert into attendance set type=" + type + " ,user_id="
				+ uid+" ,checkin_time=\""+now+ "\"";
		db.insert(sq);



		db.close();
		return true;
	}
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
	public ArrayList<Check> chek(int pid) {
		DB db = new DB();
		String sql = "select * from attendance where user_id="+pid;
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

}
