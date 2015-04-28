-- �û�
create table if not exists user (id int auto_increment, 
				   email varchar(100),
				   password varchar(100),
				   realname varchar(200),
				   created_at datetime,
				   last_login_at datetime,
				   is_active tinyint,
				   status tinyint,  /*����Ա����ͨ�û�*/
				   primary key(id), index(email), index(is_active), index(status)
);

-- ����
create table if not exists attendance (id int auto_increment,
					   user_id int,
					   checkin_time datetime,
					   type tinyint, /*�ϰ࣬�°�*/
					   primary key(id), 
					   index(type),
					   constraint attendance_userid foreign key(user_id) references user(id)
);

-- ���
create table if not exists absence (id int auto_increment,
				   user_id int,
				   start_time datetime,
				   end_time datetime,
				   status tinyint, /*����׼����׼���ܾ�*/
				   created_at datetime,
				   primary key(id), 
				   index(status),
				   constraint leave_userid foreign key(user_id) references user(id) 
);