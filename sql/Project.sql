create sequence cus_id increment by 1 start with 1;

create table customer_register(cus_id int Default cus_id.nextval,
name VARCHAR2(50) NOT NULL,
phoneNo NUMBER NOT NULL,
address VARCHAR2(100) NOT NULL,
email_id VARCHAR2(100)NOT NULL,
password VARCHAR2(100)NOT NULL,
CONSTRAINT cus PRIMARY KEY(cus_id),UNIQUE(email_id),UNIQUE(;

DROP SEQUENCE CUS_ID;

create table customer_details(id int PRIMARY KEY,cus_id int NOT NULL,FOREIGN KEY(cus_id) REFERENCES customer_register(cus_id),ph_no NUMBER NOT NULL,
city VARCHAR2(100) NOT NULL,area VARCHAR2(100) NOT NULL,pincode VARCHAR2(100) NOT NULL);

create table books(book_id int PRIMARY KEY,category VARCHAR2(100),publisher_id int,book_title VARCHAR2(100),book_code VARCHAR2(100),
price int,publish_date date,type VARCHAR2(100),condition VARCHAR2(100));

create table author_details(author_id int PRIMARY KEY,name VARCHAR2(100) NOT NULL,book_id int NOT NULL,FOREIGN KEY(book_id) REFERENCES books(book_id));

create table order_books(order_id int PRIMARY KEY,book_id int NOT NULL,FOREIGN KEY(book_id) REFERENCES books(book_id),quantity int NOT NULL,total_cost int NOT NULL);

create table orders(order_id int PRIMARY KEY,cus_id int NOT NULL,FOREIGN KEY(cus_id) REFERENCES customer_register(cus_id),
order_date TIMESTAMP default current_timestamp,status varchar2(50));


select * from customer_register;

desc customer_register;
desc customer_details;
desc books;
desc author_details;
desc order_books;
desc orders;

drop table customer_register;
drop table customer_details;
drop table books;
drop table author_details;
drop table order_books;
drop table orders;
