package com.tusheng.oa;

import java.sql.Date;

public class Check {

	private int id;
	private int user_id;
	private Date checkin_time;
	private int type;
	private String texxt;
	
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
	public String getTexxt() {
		return texxt;
	}
	public void setTexxt(String texxt) {
		this.texxt = texxt;
	}
	public Check() {
		super();
	}
	public void setCheckin_time(String checkin_time2) {
		// TODO Auto-generated method stub
		
	}
	
}
