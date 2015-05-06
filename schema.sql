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
-- ���±�
create table if not exists note (id int auto_increment,
				   user_id int,
				   subject varchar(200),
				   content text,
				   is_public tinyint, /* 0: ������ 1:���� */
				   created_at datetime,
				   updated_at datetime,
				   status tinyint, /* 0: ������ 1��ɾ�� */
				   primary key(id), 
				   index(status),
				   constraint note_userid foreign key(user_id) references user(id) 
);
-- ��������
create table if not exists work (id int auto_increment,
				   assigner_id int,  /* ���������ˣ�������admin */
				   assignee_id int,  /* ���������� */
				   subject varchar(200),
				   detail text,
				   deadline datetime,
				   created_at datetime,
				   updated_at datetime,
				   finish_at datetime,
				   status tinyint, /* 0: ������ 1���Ѿ����� 2: �ܾ� 3����ɴ����� 4���ر� */
				   primary key(id), 
				   index(status),
				   constraint work_assigner_id foreign key(assigner_id) references user(id), 
				   constraint work_assignee_id foreign key(assignee_id) references user(id) 
);