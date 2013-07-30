create table User(
id int NOT NULL AUTO_INCREMENT,
username VARCHAR(256) NOT NULL,
password VARCHAR(512) NOT NULL,
primary key(id)
);


create table Account(
id int NOT NULL AUTO_INCREMENT,
userId int NOT NULL,
schoolId int NOT NULL,
email VARCHAR(256),
profileImage VARCHAR(256),
primary key(id),
FOREIGN KEY FK_USER (userId) REFERENCES User(id)
);

create table School(
id int NOT NULL AUTO_INCREMENT,
name VARCHAR(256),
mascot VARCHAR(256),
state VARCHAR(256),
primary key(id)
);

create table Building(
id int NOT NULL AUTO_INCREMENT,
schoolId int NOT NULL,
roomNumber int,
primary key(id) 
);

create table StudyGroupEvent(
id int NOT NULL AUTO_INCREMENT,
accountId int NOT NULL,
schoolId int NOT NULL,
buildingId int NOT NULL,
postTime Date,
startTime Date,
endTime Date,
roomId int,
primary key(id),
unique key EVENT_KEY(id, accountId, buildingId)
);


