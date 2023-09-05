drop table member3 CASCADE CONSTRAINTS;
--1. index.jsp 에서 시작합니다.
--2. 관리자 계정 admin, 비번 1234를 만듭니다.
--3. 사용자 계정을 3개 만듭니다.

create table member3(
	id			varchar2(15),
	password 	varchar2(60),
	name		varchar2(15), --한글 5글자까지 가능
	age			Number(2),
	gender		varchar2(5),
	email		varchar2(30),
	auth 		varchar2(50) not null, --회원의 role(권한)을 저장하는 곳으로 기본값은 'ROLE_MEMBER' 입니다.
	PRIMARY KEY(id)

);


-- 관리자 계정 추가
INSERT INTO member (id, password)
VALUES ('admin', '1234');

INSERT INTO member (id, password)
VALUES ('admin', '1234');

INSERT INTO member (id, password)
VALUES ('admin', '1234');