package com.tusheng.oa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.w3c.dom.Text;

public class Checko {
	private UserBean user;
	private int id;
	private int assigner_id;/* 工作分配人，必须是admin */
	private int assignee_id;/* 工作接受人 */
	private UserBean assigner = new UserBean();
	private UserBean assignee = new UserBean();

	private String subject;
	private String detail;
	private Date deadline;
	private Date created_at;
	private Date updated_at;
	private Date finish_at;
	private int status; /* 0: 正常， 1：已经接受 2: 拒绝 3：完成待验收 4：关闭 */
	private String name;
	private int wid;

	public boolean check(String detail,int gl) {

		DB db = new DB();
		Date d = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String now = format.format(d);
		String sq = "insert into work set detail=\"" + detail + "\",status=0"
				+ ",deadline=\"" + now + "\",assigner_id=" + gl;
		db.insert(sq);
		db.close();
		return true;
	}


	public boolean setwork(int sw, int uuid) {
		DB db = new DB();
		Date d = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String now = format.format(d);
		String sq = "update work set assignee_id=" + uuid + ",created_at=\""
				+ now + "\" where id=" + sw;
		db.update(sq);

		return true;
	}

	// 完成工作
	public boolean setmywork(int jid) {
		DB db = new DB();
		Date d = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String now = format.format(d);
		String sq = "update work set status=3" + ",updated_at=\"" + now
				+ "\" where id=" + jid;
		db.update(sq);

		return true;
	}

	// 关闭
	public boolean gbmywork(int gid) {
		DB db = new DB();
		Date d = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String now = format.format(d);
		String sq = "update work set status=4" + ",finish_at=\"" + now
				+ "\" where id=" + gid;
		db.update(sq);
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

	// 查看所有工作
	public ArrayList<Checko> ckuser() {
		DB db = new DB();
		String sql = "select * from work";
		ResultSet rs = db.select(sql);
		ArrayList<Checko> checks = new ArrayList<Checko>();
		Checko cbean = new Checko();
		ArrayList<Integer> userid = cbean.assid();
		int i = 0;
		try {
			while (rs.next()) {
				Checko co = new Checko();
				co.id = rs.getInt("id");
				co.detail = rs.getString("detail");
				co.deadline = rs.getTimestamp("deadline");
				co.created_at = rs.getTimestamp("created_at");
				co.updated_at = rs.getTimestamp("updated_at");
				co.finish_at = rs.getTimestamp("finish_at");
				co.status = rs.getInt("status");
				co.assignee_id = rs.getInt("assignee_id");
				co.assignee.login(co.assignee_id);
				checks.add(co);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		db.close();
		return checks;
	}

	// 普通用户查寻
	public ArrayList<Checko> pkuser(int pid) {
		DB db = new DB();
		String sql = "select * from work where assignee_id=" + pid;
		ResultSet rs = db.select(sql);
		ArrayList<Checko> checks = new ArrayList<Checko>();
		try {
			while (rs.next()) {
				Checko co = new Checko();
				co.id = rs.getInt("id");
				co.detail = rs.getString("detail");
				co.deadline = rs.getTimestamp("deadline");
				co.status = rs.getInt("status");
				checks.add(co);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		db.close();
		return checks;
	}

	//
	public ArrayList<Checko> wkuser(int uid) {
		DB db = new DB();
		String sql = "select * from work";
		ResultSet rs = db.select(sql);
		ArrayList<Checko> checks = new ArrayList<Checko>();
		Checko cbean = new Checko();
		ArrayList<Integer> userid = cbean.assid();
		int i = 0;
		try {
			while (rs.next()) {
				Checko co = new Checko();
				co.id = rs.getInt("id");
				co.name = co.nameselec(userid.get(i++));
				co.detail = rs.getString("detail");
				co.deadline = rs.getTimestamp("deadline");
				co.status = rs.getInt("status");
				co.assignee_id = rs.getInt("assignee_id");
				checks.add(co);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		db.close();
		return checks;
	}

	// 查寻用户Id
	public ArrayList<Integer> assid() {
		DB db = new DB();
		ArrayList<Integer> relist = new ArrayList<Integer>();
		String s = "select assignee_id from work";
		ResultSet rs = db.select(s);
		try {
			while (rs.next()) {
				Checko bean = new Checko();
				bean.assignee_id = rs.getInt("assignee_id");
				relist.add(bean.assignee_id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.close();
		return relist;
	}

	// 修改任务状态
	public boolean stcheck(int st, int cid) {
		DB db = new DB();
		Date d = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String now = format.format(d);
		String st2 = "update work set status=" + st + " where id=" + cid;
		db.update(st2);

		db.close();
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAssigner_id() {
		return assigner_id;
	}

	public void setAssigner_id(int assigner_id) {
		this.assigner_id = assigner_id;
	}

	public int getAssignee_id() {
		return assignee_id;
	}

	public void setAssignee_id(int assignee_id) {
		this.assignee_id = assignee_id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public Date getFinish_at() {
		return finish_at;
	}

	public void setFinish_at(Date finish_at) {
		this.finish_at = finish_at;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWid() {
		return wid;
	}

	public void setWid(int wid) {
		this.wid = wid;
	}

	public UserBean getAssigner() {
		return assigner;
	}

	public void setAssigner(UserBean assigner) {
		this.assigner = assigner;
	}

	public UserBean getAssignee() {
		return assignee;
	}

	public void setAssignee(UserBean assignee) {
		this.assignee = assignee;
	}

}