create table tbl_book(
   num int not null auto_increment,   -- 자동증가컬럼(1,2,3.....)
   title varchar(50) not null,
   author varchar(30) not null,
   company varchar(50) not null,
   isbn varchar(30) not null,   
   count int default 0 not null,
   primary key(num)
);


select*from tbl_book;
