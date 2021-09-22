use reservation;

DROP TABLE IF EXISTS passenger;

create table passenger (
  id int(11) not null auto_increment,
  first_name varchar(256) default null,
  last_name varchar(256) default null,
  middle_name varchar(256) default null,
  email varchar(50) default null,
  phone varchar(10) default null,
  primary key (id)
) engine=innodb auto_increment=1;

DROP TABLE IF EXISTS reservation;

create table reservation (
  id int(11) not null auto_increment,
  checked_in tinyint(1) default null,
  number_of_bags int(11) default null,
  passenger_id int(11) default null,
  flight_id int(11) default null,
  created timestamp null default current_timestamp,
  primary key (id),
  key passenger_id (passenger_id),
  constraint reservation_ibfk_1 foreign key (passenger_id) references passenger (id) on delete cascade
) engine=innodb auto_increment=1;