Use flightdetails;
Drop TABLE IF EXISTS flight;

CREATE TABLE flight (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  arrival_city varchar(255) DEFAULT NULL,
  date_of_departure datetime DEFAULT NULL,
  departure_city varchar(255) DEFAULT NULL,
  estimated_departure_time datetime DEFAULT NULL,
  flight_number varchar(255) DEFAULT NULL,
  operating_airlines varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
);

insert into flight(id,flight_number,operating_airlines,departure_city,arrival_city,date_of_departure,estimated_departure_time) values(1,'aa1','american airlines','aus',
                          'nyc','2018-02-05','2018-02-05 03:14:07');

insert into flight (id,flight_number,operating_airlines,departure_city,arrival_city,date_of_departure,estimated_departure_time)  values (2,'aa2','american airlines','aus',
                          'nyc','2018-02-05','2018-02-05 05:14:07');

insert into flight (id,flight_number,operating_airlines,departure_city,arrival_city,date_of_departure,estimated_departure_time)  values(3,'aa3','american airlines','aus',
                          'nyc','2018-02-05','2018-02-05 06:14:07');

insert into flight(id,flight_number,operating_airlines,departure_city,arrival_city,date_of_departure,estimated_departure_time)   values(4,'sw1','south west','aus',
                          'nyc', '2018-02-05','2018-02-05 07:14:07');

insert into flight(id,flight_number,operating_airlines,departure_city,arrival_city,date_of_departure,estimated_departure_time)  values(5,'ua1','united airlines','nyc',
                          'dal','2018-02-05','2018-02-05 10:14:07');

insert into flight(id,flight_number,operating_airlines,departure_city,arrival_city,date_of_departure,estimated_departure_time)   values(6,'ua1','united airlines','nyc',
                          'dal', '2018-02-05','2018-02-05 10:14:07');

insert into flight (id,flight_number,operating_airlines,departure_city,arrival_city,date_of_departure,estimated_departure_time)  values(7,'sw1','south west','aus',
                          'nyc', '2018-02-06','2018-02-06 07:14:07');

insert into flight (id,flight_number,operating_airlines,departure_city,arrival_city,date_of_departure,estimated_departure_time)  values(8,'sw2','south west','aus',
                          'nyc', '2018-02-06','2018-02-06 08:14:07');

insert into flight (id,flight_number,operating_airlines,departure_city,arrival_city,date_of_departure,estimated_departure_time)  values(9,'sw3','south west','nyc',
                          'dal', '2018-02-06','2018-02-06 10:14:07');

insert into flight (id,flight_number,operating_airlines,departure_city,arrival_city,date_of_departure,estimated_departure_time)  values(10,'ua1','united airlines','nyc',
                          'dal', '2018-02-06','2018-02-06 10:14:07');