drop table member2 CASCADE CONSTRAINTS;
--1. index.jsp ���� �����մϴ�.
--2. ������ ���� admin, ��� 1234�� ����ϴ�.
--3. ����� ������ 3�� ����ϴ�.

create table member2(
	id			varchar2(15),
	password 	varchar2(60),
	name		varchar2(15), --�ѱ� 5���ڱ��� ����
	age			Number(2),
	gender		varchar2(5),
	email		varchar2(30),
	PRIMARY KEY(id)

);


-- ȸ�� ���̺� ����
CREATE TABLE member (
    id          VARCHAR2(12),
    password    VARCHAR2(10),
    name        VARCHAR2(15), -- �ѱ� 5���ڱ��� ����
    age         NUMBER(2),
    gender      VARCHAR2(3),
    email       VARCHAR2(30),
    PRIMARY KEY(id)
);


-- ������ ���� �߰�
INSERT INTO member (id, password)
VALUES ('admin', '1234');

INSERT INTO member (id, password)
VALUES ('admin', '1234');

INSERT INTO member (id, password)
VALUES ('admin', '1234');