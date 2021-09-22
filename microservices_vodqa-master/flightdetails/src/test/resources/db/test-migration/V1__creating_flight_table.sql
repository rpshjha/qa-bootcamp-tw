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

