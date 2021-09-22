use userdetails;

Drop TABLE IF EXISTS user;

create table user (
  id int(11) not null auto_increment,
  email varchar(256) default null,
  first_name varchar(256) default null,
  middle_name varchar(256) default null,
  last_name varchar(50) default null,
  primary key (id)
) engine=innodb auto_increment=1;

INSERT INTO userdetails.user (id, email, first_name, last_name) VALUES ('1', 'test', 'test', 'test');
