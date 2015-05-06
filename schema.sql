-- 用户
create table if not exists user (id int auto_increment, 
				   email varchar(100),
				   password varchar(100),
				   realname varchar(200),
				   created_at datetime,
				   last_login_at datetime,
				   is_active tinyint,
				   status tinyint,  /*管理员，普通用户*/
				   primary key(id), index(email), index(is_active), index(status)
);

-- 考勤
create table if not exists attendance (id int auto_increment,
					   user_id int,
					   checkin_time datetime,
					   type tinyint, /*上班，下班*/
					   primary key(id), 
					   index(type),
					   constraint attendance_userid foreign key(user_id) references user(id)
);

-- 请假
create table if not exists absence (id int auto_increment,
				   user_id int,
				   start_time datetime,
				   end_time datetime,
				   status tinyint, /*待批准，批准，拒绝*/
				   created_at datetime,
				   primary key(id), 
				   index(status),
				   constraint leave_userid foreign key(user_id) references user(id) 
);
-- 记事本
create table if not exists note (id int auto_increment,
				   user_id int,
				   subject varchar(200),
				   content text,
				   is_public tinyint, /* 0: 不公开 1:公开 */
				   created_at datetime,
				   updated_at datetime,
				   status tinyint, /* 0: 正常， 1：删除 */
				   primary key(id), 
				   index(status),
				   constraint note_userid foreign key(user_id) references user(id) 
);
-- 工作安排
create table if not exists work (id int auto_increment,
				   assigner_id int,  /* 工作分配人，必须是admin */
				   assignee_id int,  /* 工作接受人 */
				   subject varchar(200),
				   detail text,
				   deadline datetime,
				   created_at datetime,
				   updated_at datetime,
				   finish_at datetime,
				   status tinyint, /* 0: 正常， 1：已经接受 2: 拒绝 3：完成待验收 4：关闭 */
				   primary key(id), 
				   index(status),
				   constraint work_assigner_id foreign key(assigner_id) references user(id), 
				   constraint work_assignee_id foreign key(assignee_id) references user(id) 
);