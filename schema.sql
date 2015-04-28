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