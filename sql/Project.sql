create table users
(cus_id int Default cus_id.nextval,
name VARCHAR2(50) NOT NULL,
phoneNo NUMBER NOT NULL,
role Varchar2(10) Default 'user',
address VARCHAR2(100) NOT NULL,
email_id VARCHAR2(30)NOT NULL,
password VARCHAR2(30)NOT NULL,
CONSTRAINT cus PRIMARY KEY(cus_id),UNIQUE(email_id),UNIQUE(phoneNo));

insert into users (name,phoneNo,role,address,email_id,password) values('keerthi','9345257036','admin','Mylapore,chennai,600019','keke052000@gmail.com','keke0502');
insert into users (name,phoneNo,role,address,email_id,password) values('keerthiga','9345257096','admin','Mylapore,chennai,600019','keke05@gmail.com','keke05020');
insert into users (name,phoneNo,role,address,email_id,password) values('keerthaan','9345250036','admin','Mylapore,chennai,600019','keerthi02@gmail.com','keerthi05');

drop table users cascade constraints;
commit;
create sequence cus_id increment by 1 start with 100;
DROP SEQUENCE CUS_ID;
desc users;
select * from users;
commit;

create table books
(book_id int DEFAULT book_id.nextval,
category VARCHAR2(100) NOT NULL,
description VARCHAR(100),
publisher_id int NOT NULL,
book_title VARCHAR2(100) NOT NULL,
book_code VARCHAR2(100) NOT NULL,
price int NOT NULL,
publish_date date NOT NULL,
condition VARCHAR2(100) NOT NULL,
CONSTRAINT BOOK PRIMARY KEY(book_id));

insert into books (category,description,publisher_id,book_title,book_code,price,publish_date,condition)values('Architecture','A fascinating, thought-provoking journey into our built environment',10,'The Great Indoors','B10',200,'10-12-2021','New');
delete from books where book_id=1000;
create SEQUENCE book_id increment by 1 start with 1000;
desc books;
select * from books;

create table author_details
(author_id int DEFAULT author_id.nextval,
name VARCHAR2(50) NOT NULL,
email_id VARCHAR2(30),
book_id int NOT NULL,
CONSTRAINT authors PRIMARY KEY(author_id),
CONSTRAINT book_id FOREIGN KEY(book_id) REFERENCES books(book_id),
UNIQUE(email_id));

drop table author_details cascade constraints;
create SEQUENCE author_id increment by 1 start with 2000;
desc author_details;

create table cart
(order_id int DEFAULT ORDER_ID.nextval ,
book_id int,
quantity int NOT NULL,
total_cost decimal NOT NULL,
CONSTRAINT orders_id PRIMARY KEY(order_id),
CONSTRAINT books_id FOREIGN KEY(book_id) REFERENCES books(book_id));

create SEQUENCE order_id increment by 1 start with 300;
drop SEQUENCE order_id;
drop table ordered_books cascade constraints;

create table orders
(order_id int,
cus_id int,
order_date TIMESTAMP default current_timestamp,
status varchar2(50) NOT NULL,
CONSTRAINT c_id FOREIGN KEY(cus_id) REFERENCES customer_register(cus_id),
CONSTRAINT o_id FOREIGN KEY(order_id) REFERENCES order_books(order_id));



desc customer_register;
desc books;
desc author_details;
desc order_books;
desc orders;

drop table customer_register;
drop table books;
drop table author_details;
drop table order_books;
drop table orders;
