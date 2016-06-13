DROP TABLE IF EXISTS user_t;

create table role_t (
id int(1) primary key,
role varchar(20) not null
) default charset=utf-8;

insert into role_t values(1,"ROLE_ADMIN");
insert into role_t values(2,"ROLE_USER");

CREATE TABLE user_t (
id int(11) NOT NULL AUTO_INCREMENT,
user_name varchar(40) NOT NULL,
password varchar(255) NOT NULL,
role_id int(1) NOT NULL,
PRIMARY KEY(id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user_t` */
Insert into user_t values (1,'test','test',1);
