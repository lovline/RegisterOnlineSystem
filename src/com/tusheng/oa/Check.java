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

	public boolean check(int type, int uid) {
		// ResultSet rs =
		System.out.println(type + "***" + uid);
		DB db = new DB();
		String sq = "insert into attendance set type=" + type + " ,user_id="
<<<<<<< HEAD
				+ uid;
=======
				+ uid+",id="+id;
>>>>>>> 18fa01b6b62788e793f99385473f2dae5c2cf572
		db.insert(sq);

		Date d = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String now = format.format(d);
		String s = "update attendance set checkin_time=\"" + now
				+ "\" where user_id=" + uid;
		db.update(s);

		db.close();
		return true;
	}

<<<<<<< HEAD
	public ArrayList<Check> chek(int pid) {
		DB db = new DB();
		String sql = "select * from attendance where user_id="+pid;
		ResultSet rs = db.select(sql);
		ArrayList<Check> list=new ArrayList<Check>();	
			try {
				while (rs.next()) {
					Check ck=new Check();
=======
	public ArrayList<Check> chek() {
		DB db = new DB();
		String sql = "select * from attendance";
		ResultSet rs = db.select(sql);
		ArrayList<Check> list=new ArrayList<Check>();
		Check ck=new Check();
		
			try {
				while (rs.next()) {
>>>>>>> 18fa01b6b62788e793f99385473f2dae5c2cf572
					ck.id = rs.getInt("id");
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

<<<<<<< HEAD
=======
	public void setCheckin_time(String checkin_time2) {
		// TODO Auto-generated method stub

	}
>>>>>>> 18fa01b6b62788e793f99385473f2dae5c2cf572

}
