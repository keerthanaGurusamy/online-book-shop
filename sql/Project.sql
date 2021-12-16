create table customer_details
(cus_id int Default cus_id.nextval,
name VARCHAR2(50) NOT NULL,
phoneNo NUMBER NOT NULL,
address VARCHAR2(100) NOT NULL,
email_id VARCHAR2(100)NOT NULL,
password VARCHAR2(100)NOT NULL,
CONSTRAINT cus PRIMARY KEY(cus_id),UNIQUE(email_id),UNIQUE(phoneNo));

drop table customer_register cascade constraints;
commit;
create sequence cus_id increment by 1 start with 100;
DROP SEQUENCE CUS_ID;
desc customer_register;
select * from customer_details;

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

create SEQUENCE book_id increment by 1 start with 1000;
desc books;

create table author_details
(author_id int DEFAULT author_id.nextval,
name VARCHAR2(100) NOT NULL,
book_id int NOT NULL,
CONSTRAINT author PRIMARY KEY(author_id),
CONSTRAINT book_id FOREIGN KEY(book_id) REFERENCES books(book_id));

create SEQUENCE author_id increment by 1 start with 2000;
desc author_details;

create table order_books
(order_id int DEFAULT ORDER_ID.nextval ,
book_id int,
quantity int NOT NULL,
total_cost decimal NOT NULL,
CONSTRAINT orders PRIMARY KEY(order_id),
CONSTRAINT b_id FOREIGN KEY(book_id) REFERENCES books(book_id));

create SEQUENCE order_id increment by 1 start with 300;

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
