create Database helmet;

SET foreign_key_checks = 0;
DROP TABLE member;
DROP TABLE helmet;
DROP TABLE rent;
DROP TABLE point;
DROP TABLE rentalshop;

update rent2 set  returndate = now()
where memberid="abc001";


select now();
select * from member;
select * from helmet;
select * from rent2;
select * from point;
select * from rentalshop;
select r.helmetid, DATE_FORMAT(r.rentdate, '%Y-%m-%d %H:%i:%S'), r.rentplaceName, r.returndate, r.returnplaceName
from rent r
where r.memberid = 'abc001';


select r.helmetid, r.rentdate, r.rentplaceName, r.returndate, r.returnplaceName
from rent r
where r.memberid = 'abc001';


CREATE TABLE helmet (
    helmetid        VARCHAR(50) NOT NULL,
    helmetsize      VARCHAR(50) NOT NULL,
    loss            int,
    helmetregister  VARCHAR(50) NOT NULL,
    disinfection    int NOT NULL,
    rentalshopid    VARCHAR(50) NOT NULL
);

ALTER TABLE helmet ADD CONSTRAINT helmet_pk PRIMARY KEY ( helmetid );

CREATE TABLE member (
    memberid     VARCHAR(50) NOT NULL,
    membername   VARCHAR(50) NOT NULL,
    memberage    VARCHAR(30) NOT NULL,
    password     VARCHAR(50) NOT NULL,
    memberphone  VARCHAR(50) NOT NULL
);

ALTER TABLE member ADD CONSTRAINT member_pk PRIMARY KEY ( memberid );

CREATE TABLE point (
    pointid    VARCHAR(50) NOT NULL,
    memberid   VARCHAR(50) NOT NULL,
    earndate   VARCHAR(50) NOT NULL,   
    earnpoint  int NOT NULL,
    useddate   VARCHAR(50),
    usedpoint  int
  
);
ALTER TABLE point ADD CONSTRAINT point_pk PRIMARY KEY ( pointid );

CREATE TABLE rent (
    rentid   int not null auto_increment primary key,
    rentdate     datetime NOT NULL  default now(),
    rentplaceId    VARCHAR(50) NOT NULL,
    rentplaceName    VARCHAR(50) NOT NULL,
    returndate   datetime,
    returnplaceId  VARCHAR(50), 
    returnplaceName  VARCHAR(50),
    memberid     VARCHAR(50) NOT NULL,
    helmetid     VARCHAR(50) NOT NULL
 
);

CREATE TABLE rentalshop (
    rentalshopid       VARCHAR(50) NOT NULL,
    rentalshopname     VARCHAR(50) NOT NULL,
    rentalshopaddress  VARCHAR(100) NOT NULL,
    latitude          float NOT NULL,
    longitude          float  NOT NULL
);

ALTER TABLE rentalshop ADD CONSTRAINT rentalshop_pk PRIMARY KEY ( rentalshopid );

ALTER TABLE helmet
    ADD CONSTRAINT helmet_rentalshop_fk FOREIGN KEY ( rentalshopid )
        REFERENCES rentalshop ( rentalshopid );

ALTER TABLE point
    ADD CONSTRAINT point_member_fk FOREIGN KEY ( memberid )
        REFERENCES member ( memberid );

ALTER TABLE rent
    ADD CONSTRAINT rent_helmet_fk FOREIGN KEY ( helmetid )
        REFERENCES helmet ( helmetid );

ALTER TABLE rent
    ADD CONSTRAINT rent_member_fk FOREIGN KEY ( memberid )
        REFERENCES member ( memberid );

ALTER TABLE rent
    ADD CONSTRAINT rent_rentalshop_fk FOREIGN KEY ( rentplaceid)
        REFERENCES rentalshop ( rentalshopid );

ALTER TABLE rent
    ADD CONSTRAINT rent_rentalshop_fk2 FOREIGN KEY ( returnplaceid )
        REFERENCES rentalshop ( rentalshopid );
        
insert into member values('admin', 'admin', '23','12345','010-5555-6428');
insert into member values('abc001', '김은혜', '23','12345','010-5555-6428');
insert into member values('abc002', '남수환 ', '31', '78955' ,'010-1250-7890');
insert into member values('abc003', '노현규', '40','56789','010-1260-7895');
insert into member values('abc004', '김채원', '22','78451','010-1270-7900');
insert into member values('abc005', '박형민', '46','15468','010-1280-7905');
insert into member values('abc006', '최성우', '54','65557','010-4848-9595');
insert into member values('abc007', '황해도', '64','648714','010-2743-3472');
insert into member values('abc008', '차현석', '28','79441','010-3473-2348');
insert into member values('abc009', '이기성', '26','sdxbf2355','010-2437-2845');
insert into member values('abc010', '장영우', '21','asdsbs3','010-3535-7457');
insert into member values('abc011', '김온유', '12','asfddd','010-2437-2845');
insert into member values('abc012', '김미희', '23','ssggsq2','010-4838-2434');
insert into member values('abc013', '최현영', '30','dfdgfs','010-2562-2343');
insert into member values('abc014', '정종원', '41','qwwffd','010-2727-3434');
insert into member values('abc015', '정지윤', '12','rita22','010-2563-2356');
insert into member values('abc016', '주익정', '23','susiihd','010-2341-2342');
insert into member values('abc017', '신근아', '36','ssdgy','010-1634-1323');
insert into member values('abc018', '김영주', '38','aonnrb','010-1673-1563');
insert into member values('abc019', '이상준', '57','nfgsa','010-7652-6828');
insert into member values('abc020', '김성은', '20','dsfdh','010-3578-6452');

insert into rentalshop values('1204','거여역 3번출구','서울특별시 송파구 오금로 지하 499','37.4933429999999','127.14473');
insert into rentalshop values('1207','마천CU우방점 앞','서울특별시 송파구 성내천로 233','37.499756','127.152504');
insert into rentalshop values('1212','송파역 2번 출구앞','서울특별시 송파구 송파대로 지하 354','37.499413','127.112868999999');
insert into rentalshop values('2625','가락1동 주민센터','서울특별시 송파구 가락1동 양재대로 925','37.495876','127.108505');
insert into rentalshop values('1249','아주중학교건너편','서울특별시 송파구 도곡로 446','37.505463','127.077347');
insert into rentalshop values('1206','9호선종합운동장역 9번출구','서울특별시 송파구 올림픽로 지하 23','37.51128','127.078239');
insert into rentalshop values('1217','송파파인타운 7단지','서울특별시 송파구 충민로4길 19','37.479305','127.129799');
insert into rentalshop values('2603','송파 글마루 도서관','서울특별시 송파구 문정동 충민로 120','37.480801','127.130340999999');
insert into rentalshop values('1291','서울체육고등학교 앞','서울특별시 송파구 방이동 강동대로 232','37.521938','127.131865999999');
insert into rentalshop values('2622','올림픽공원역 3번출구','서울특별시 송파구 방이동 89-28','37.516258','127.130592');
insert into rentalshop values('1213','백토공원 앞','서울특별시 송파구 양재대로72길 47-8','37.5076599999999','127.132736');
insert into rentalshop values('1214','오금역 7번 출구 인근','서울특별시 송파구 오금로 지하 321','37.502594','127.127647');
insert into rentalshop values('2649','오금공원사거리2','서울특별시 송파구 마천로103','37.505444','127.132332');
insert into rentalshop values('2654','올림픽선수촌아파트 136동 앞','서울특별시 송파구 양재대로 1218','37.509975','127.133698');
insert into rentalshop values('1221','삼전사거리 포스코더샵','서울특별시 송파구 백제고분로 188','37.5042','127.087532');
insert into rentalshop values('1232','롯데마트 주차장 옆','서울특별시 송파구 석촌호수로12길 3-19','37.512089','127.096190999999');
insert into rentalshop values('2601','석촌호수 서호사거리','서울특별시 송파구 삼학사로 136','37.5067479999999','127.098831');
insert into rentalshop values('2635','잠실새내역 1번출구','서울특별시 송파구 올림픽로 지하 140','37.511295','127.086739');
insert into rentalshop values('1241','문정 법조단지5','서울특별시 송파구 새말로 62','37.481239','127.119796999999');
insert into rentalshop values('2628','문정역 1번출구','서울특별시 송파구 문정동 55-13','37.486698','127.122443999999');
insert into rentalshop values('0','정보없음','정보없음',0,0);

insert into helmet values('S-001','S',1,'2020-08-25',1,'1207');
insert into helmet values('S-002','S',0,'2019-12-22',0,'1212');
insert into helmet values('S-003','S',0,'2020-02-15',1,'2625');
insert into helmet values('S-004','S',1,'2020-09-17',0,'1249');
insert into helmet values('S-005','S',1,'2020-02-03',0,'1206');
insert into helmet values('S-006','S',0,'2019-07-23',1,'1217');
insert into helmet values('M-007','M',0,'2020-11-09',0,'2603');
insert into helmet values('M-008','M',0,'2021-04-03',0,'1291');
insert into helmet values('M-009','M',0,'2020-05-18',1,'2622');
insert into helmet values('M-010','M',0,'2020-07-18',0,'1213');
insert into helmet values('M-011','M',0,'2020-10-03',0,'1214');
insert into helmet values('M-012','M',0,'2020-10-08',0,'2649');
insert into helmet values('M-013','M',0,'2020-08-28',0,'2654');
insert into helmet values('M-014','M',0,'2020-07-01',0,'1221');
insert into helmet values('L-015','L',0,'2020-07-02',0,'1232');
insert into helmet values('L-016','L',1,'2020-07-05',0,'2601');
insert into helmet values('L-017','L',0,'2020-08-14',0,'2635');
insert into helmet values('L-018','L',0,'2020-04-06',1,'1241');
insert into helmet values('L-019','L',0,'2020-04-22',1,'2628');
insert into helmet values('L-020','L',0,'2020-06-22',0,'1204');

insert into rent(rentdate,rentplaceId,rentplaceName,memberid,helmetid)
values('2021-06-01 07:22:14', '1204', '거여역 3번출구','abc001','M-010');
insert into rent(rentdate,rentplaceId,rentplaceName,memberid,helmetid)
values('2021-06-01 15:52:43', '1207', '마천CU우방점 앞','abc002', 'S-004');
insert into rent(rentdate,rentplaceId,rentplaceName,memberid,helmetid)
values('2021-06-02 10:39:40', '1212', '송파역 2번 출구앞','abc001', 'M-014');
insert into rent(rentdate,rentplaceId,rentplaceName,memberid,helmetid)
values('2021-06-02 07:30:31', '2625', '가락1동 주민센터','abc004', 'L-018');
insert into rent(rentdate,rentplaceId,rentplaceName,memberid,helmetid)
values('2021-06-03 09:19:30', '1249', '아주중학교건너편','abc001', 'M-013');
insert into rent(rentdate,rentplaceId,rentplaceName,memberid,helmetid)
values('2021-06-03 15:29:21', '1206', '9호선종합운동장역 9번출구','abc005', 'M-010');
insert into rent(rentdate,rentplaceId,rentplaceName,memberid,helmetid)
values('2021-06-04 07:12:20', '1217', '송파파인타운 7단지','abc002', 'S-003');
insert into rent(rentdate,rentplaceId,rentplaceName,memberid,helmetid)
values('2021-06-04 23:04:39', '1204', '거여역 3번출구','abc008', 'S-002');
insert into rent(rentdate,rentplaceId,rentplaceName,memberid,helmetid)
values('2021-06-06 10:59:49', '1212', '송파역 2번 출구앞','abc001', 'M-012');
insert into rent(rentdate,rentplaceId,rentplaceName,memberid,helmetid)
values('2021-06-07 13:45:15', '1249', '아주중학교건너편','abc001', 'M-012');
insert into rent(rentdate,rentplaceId,rentplaceName,memberid,helmetid)
values('2021-06-08 11:23:50', '2603', '송파 글마루 도서관','abc011', 'M-010');

insert into point values('POINT001','abc001','2021-06-01',700,'',0);
insert into point values('POINT002','abc019','2021-06-01',700,'',0);
insert into point values('POINT003','abc001','2021-06-02',1000,'',0);
insert into point values('POINT004','abc001','2021-06-03',1500,'',0);
insert into point values('POINT005','abc001','2021-06-06',500,'',0);
insert into point values('POINT006','abc012','2021-06-08',100,'',0);
insert into point values('POINT007','abc008','2021-06-09',500,'',0);
insert into point values('POINT008','abc001','2021-06-16',600,'',0);
insert into point values('POINT009','abc001','2021-06-21',700,'',0);
insert into point values('POINT010','abc001','0',0,'2021-06-30',5000);


select * from rent;

UPDATE rent SET returndate = GETDATE() and returnplaceId='1204' WHERE returndate is null and memberid='abc011';
 

 
 