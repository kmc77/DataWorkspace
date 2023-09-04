drop table member2 CASCADE CONSTRAINTS;
--1. index.jsp 에서 시작합니다.
--2. 관리자 계정 admin, 비번 1234를 만듭니다.
--3. 사용자 계정을 3개 만듭니다.

create table member2(
	id			varchar2(15),
	password 	varchar2(60),
	name		varchar2(15), --한글 5글자까지 가능
	age			Number(2),
	gender		varchar2(5),
	email		varchar2(30),
	PRIMARY KEY(id)

);


-- 회원 테이블 생성
CREATE TABLE member (
    id          VARCHAR2(12),
    password    VARCHAR2(10),
    name        VARCHAR2(15), -- 한글 5글자까지 가능
    age         NUMBER(2),
    gender      VARCHAR2(3),
    email       VARCHAR2(30),
    PRIMARY KEY(id)
);


-- 관리자 계정 추가
INSERT INTO member (id, password)
VALUES ('admin', '1234');

INSERT INTO member (id, password)
VALUES ('admin', '1234');

INSERT INTO member (id, password)
VALUES ('admin', '1234');