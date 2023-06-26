-- 실행 방법
-- 1. 한 문장 실행의 경우는 커서를 문장위에 놓고 마우스 우클릭 -> Execute Current Text(Alt + s)
drop table goodsinfo purge;

-- 2. 여러 문장 실행의 경우
--	  영역 설정 후 마우스 우클릭 -> Execute Selected Text (Alt + X)
--								또는
-- 								Execute Selected Text As One Statement(Alt + C)
create table goodsinfo(
	code varchar2(5) primary key,
	name varchar2(30) not null,
	price number(8) not null,
	maker varchar2(20)
	);
	
insert into goodsinfo 
 VALUES(10001, '디지털 TV', 350000, 'LG');
 
 insert into goodsinfo 
 VALUES(10002, 'DVD 플레이어', 250000, 'LG');
 
 insert into goodsinfo 
 VALUES(10003, '디지털 카메라', 210000, '삼성');
	
 insert into goodsinfo 
 VALUES(10004, '전자사전', 180000, '아이리버');
 
 insert into goodsinfo 
 VALUES(10005, '벽걸이 에어컨', 400000, '삼성');
 
 
 select * from goodsinfo;
 
 select * from dept;
 
 drop table hakjum cascade constraints;
 
-- 1. hakjum 테이블 생성합니다.	
create table hakjum(
	LOWSCORE     NUMBER(3),
	HISCORE      NUMBER(5,2),
	GRADE        VARCHAR2(3) primary key  -- 기본키
	);
	
	
insert into hakjum 
 VALUES(0, 59.99, 'F');
 
 insert into hakjum 
 VALUES(60, 64.99, 'D0');
 
 insert into hakjum 
 VALUES(65, 69.99, 'D+');
 
 insert into hakjum 
 VALUES(70, 74.99, 'C0');
 
 insert into hakjum 
 VALUES(75, 79.99, 'C+');
 
 insert into hakjum 
 VALUES(80, 84.99, 'B0');
 
 insert into hakjum 
 VALUES(85, 89.99, 'B+');
 
 insert into hakjum 
 VALUES(90, 94.99, 'A0');
 
 insert into hakjum 
 VALUES(95, 100, 'A+');
 
 delect from HAKJUM;
 select * from hakjum; --데이터 확인합니다.
 
 --2. student 테이블 생성합니다.
 drop table student purge;
 create table student(
	no number primary key, -- 기본키
	name varchar2(21) not null,
	kor number(3) check(kor between 0 and 100) not null, -- 0~100 사이의 값, not null
	math number(3) check(math between 0 and 100) not null, -- 0~100 사이의 값, not null
	eng number(3) check(eng between 0 and 100) not null,  -- 0~100 사이의 값, not null
	tot number(3),
	avg number(5,2),
	grade varchar2(3) references hakjum(grade)
	);

 select * from student --데이터 확인합니다.
 delete from student;

--3. 시퀀스 생성합니다.
drop sequence student_seq;

create sequence student_seq;

-- 4. 더미 데이터를 이용한 insert 쿼리문 작성해 봅시다.
--- 1) 평균이 100점인 경우 grade를 구해 봅시다.
select GRADE
from HAKJUM
where 100 between lowscore and hiscore;


--- 2) 위에서 사용한 쿼리문을 insert 문에 사용합니다.
insert into STUDENT
values(1, '홍길동', 100,100,100,300,100,
		(select grade from HAKJUM where 100 between lowscore and hiscore)
		);
		
insert into STUDENT
values(시퀀스, ? , ?,?,?,?,?,
		(select grade from HAKJUM where ? between lowscore and hiscore)
		);
 
select * from student;		
 
	