drop table member3 CASCADE CONSTRAINTS;
--1. index.jsp ���� �����մϴ�.
--2. ������ ���� admin, ��� 1234�� ����ϴ�.
--3. ����� ������ 3�� ����ϴ�.

create table member3(
	id			varchar2(15),
	password 	varchar2(60),
	name		varchar2(15), --�ѱ� 5���ڱ��� ����
	age			Number(2),
	gender		varchar2(5),
	email		varchar2(30),
	auth 		varchar2(50) not null, --ȸ���� role(����)�� �����ϴ� ������ �⺻���� 'ROLE_MEMBER' �Դϴ�.
	PRIMARY KEY(id)

);


-- ������ ���� �߰�
INSERT INTO member3 (id, password)
VALUES ('admin', '1234');

INSERT INTO member (id, password)
VALUES ('admin', '1234');

INSERT INTO member (id, password)
VALUES ('admin', '1234');