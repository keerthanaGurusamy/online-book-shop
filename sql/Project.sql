create table user_details(cus_id int Default cus_id.nextval,
                         name VARCHAR2(50) NOT NULL,
                         phoneNo NUMBER NOT NULL,
                         role Varchar2(10) Default 'user',
                         address VARCHAR2(100) NOT NULL,
                         email_id VARCHAR2(30)NOT NULL,
                         password VARCHAR2(30)NOT NULL,
                         wallet int Default '100000',
                         CONSTRAINT cus PRIMARY KEY(cus_id),UNIQUE(email_id),UNIQUE(phoneNo));

insert into user_details (name,phoneNo,role,address,email_id,password) values('karthick','9345257036','admin','Mylapore,chennai,600019','karthick30@gmail.com','karthick30');
insert into user_details (name,phoneNo,role,address,email_id,password) values('keerthi','9345257096','admin','Mylapore,chennai,600019','keke05@gmail.com','keke05020');
insert into user_details (name,phoneNo,role,address,email_id,password) values('uma','9345250036','admin','Mylapore,chennai,600019','keerthi02@gmail.com','keerthi05');

update user_details SET wallet=0 where role='admin';
drop table user_details cascade constraints;
create sequence cus_id increment by 1 start with 100;
commit;

create table bookdetails(book_id int DEFAULT book_id.nextval,
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

insert into bookdetails(category,description,publisher_id,book_title,book_code,price,publish_date,condition)values('Architecture','A fascinating, thought-provoking journey into our built environment',10,'The Great Indoors','B10',200,'10-12-2021','New');




create table author_details(author_id int DEFAULT author_id.nextval,
                            name VARCHAR2(50) NOT NULL,
                            email_id VARCHAR2(30),
                            book_id int NOT NULL,
                            CONSTRAINT authors PRIMARY KEY(author_id),
                            CONSTRAINT book_id FOREIGN KEY(book_id) REFERENCES books(book_id),
                            UNIQUE(email_id));


create SEQUENCE author_id increment by 1 start with 2000;

create table cart(order_id int DEFAULT ORDER_ID.nextval,
                 cus_id int not null,
                 book_id int not null,
                 quantity int NOT NULL,
                 total_cost decimal NOT NULL,
                 CONSTRAINT orders_id PRIMARY KEY(order_id),
                 CONSTRAINT customer_id FOREIGN KEY(cus_id) REFERENCES user_details(cus_id),
                 CONSTRAINT books_id FOREIGN KEY(book_id) REFERENCES bookdetails(book_id));

create SEQUENCE order_id increment by 1 start with 300;

create table rating(id int generated always as identity(start with 1 increment by 1),
                   cus_id int  not null,
                   book_id int  not null,
                   rating number(2,1));

select * from bookdetails;
select * from cart;
select * from user_details;
select * from order_details;
select * from rating;

commit;

desc user_details;
desc bookdetails;
desc author_details;
desc cart;
desc order_details;
desc rating;




create table order_details(order_id int NOT NULL,
                          cus_id int NOT NULL,
                          book_id int NOT NULL, 
                          order_date TIMESTAMP default current_timestamp,
                          status varchar2(50) NOT NULL,
                          CONSTRAINT c_id FOREIGN KEY(cus_id) REFERENCES user_details(cus_id),
                          CONSTRAINT o_id FOREIGN KEY(order_id) REFERENCES cart(order_id));