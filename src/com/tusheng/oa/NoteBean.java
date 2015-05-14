package com.tusheng.oa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


public class NoteBean {
	private int id;
	private int user_id ;
	private String   subject ;
	private  String content ;
	private  boolean is_public ; /* 0: 不公开 1:公开 */
	private  Date created_at ;
	private  Date updated_at ;
	private  boolean status;  /* 0: 正常， 1：删除 */
	public static ArrayList<NoteBean> getnotes(int user_id){
		DB note1=new DB();
		String sql="select * from note where user_id=\""+user_id+"\"";
		ResultSet ss=note1.select(sql);
		ArrayList<NoteBean> notes = new ArrayList<NoteBean>();
		try {
			while(ss.next()){
				NoteBean note = new NoteBean();
				note.id = ss.getInt("id");
				note.user_id = ss.getInt("user_id");
				note.subject = ss.getString("subject");
				note.content = ss.getString("content");
				note.is_public = ss.getInt("is_public") == 1;
				note.created_at = ss.getDate("created_at");
				note.updated_at = ss.getDate("updated_at");
				note.status = ss.getInt("status") == 0;
				notes.add(note);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		note1.close();
		return notes;
	}
	public static ArrayList<NoteBean> getallnotes(boolean is_public){
		DB note1=new DB();
		int public1=0;
		if (is_public)
			{public1 = 1;}
		String sql="select * from note where is_public=\""+public1+"\"";
		ResultSet ss=note1.select(sql);
		ArrayList<NoteBean> notess = new ArrayList<NoteBean>();
		try {
			while(ss.next()){
				NoteBean note = new NoteBean();
				note.id = ss.getInt("id");
				note.user_id = ss.getInt("user_id");
				note.subject = ss.getString("subject");
				note.content = ss.getString("content");
				note.is_public = ss.getInt("is_public") == 1;
				note.created_at = ss.getDate("created_at");
				note.updated_at = ss.getDate("updated_at");
				note.status = ss.getInt("status") == 0;
				notess.add(note);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		note1.close();
		return notess;
	}
	public void detailnote(int id ){
		DB note2 =new DB();
		String sql="select * from note where id=\""+id+"\"";
		ResultSet ss=note2.select(sql);
		try {
			if(ss.next()){
//				NoteBean note = new NoteBean();
				this.id=ss.getInt("id");
				this.subject = ss.getString("subject");
				this.content = ss.getString("content");
				this.is_public = ss.getInt("is_public") == 1;
				this.created_at = ss.getDate("created_at");
				this.updated_at = ss.getDate("updated_at");
				this.status = ss.getInt("status") == 0;
			}
		}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			note2.close();
			
	}
	public void updatenote(int id,String subject1,String content1,boolean is_public1 ){
		DB note =new DB();
		int public1=0;
		if (is_public1)
			{public1 = 1;}
		String sql="update note set subject=\"" + subject1 + "\",content=\"" 
			+ content1 + "\",is_public=\"" + public1 + "\"where id=\""+id+"\"";
	    note.update(sql);
	    note.close();
	}
	public void creatnote(int user_id,String subject1,String content1,boolean is_public1 ){
		DB note =new DB();
		int public1=0;
		if (is_public1)
			{public1 = 1;}
		String sql="insert into note set subject=\"" + subject1 + "\",user_id=\"" + user_id + "\",content=\"" 
			+ content1 + "\",is_public=\"" + public1 + "\"";
	    note.insert(sql);
	    note.close();
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isIs_public() {
		return is_public;
	}
	public void setIs_public(boolean is_public) {
		this.is_public = is_public;
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
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	    
	  
	 


}
