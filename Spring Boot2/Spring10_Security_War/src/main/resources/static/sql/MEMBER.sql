DROP TABLE member3 CASCADE constraints purge;
--1. index.jsp���� �����մϴ�.
--2. ������ ���� admin, ��� 1234�� ����ϴ�.
--3. ����� ������ 3�� ����ϴ�.

CREATE TABLE member3(
	id			 	VARCHAR2(12),  
	password	 	VARCHAR2(60),--��ȣȭ�� �ϸ� password��  
	name		 	VARCHAR2(15), --�ѱ� 5���ڱ��� ����
	age			 	NUMBER(2),   
	gender		 	VARCHAR2(3),
	email		 	VARCHAR2(30),
            auth                               VARCHAR2(50) not null, --ȸ���� role(����)�� �����ϴ� ������ �⺻���� 'ROLE_MEMBER'�Դϴ�. 
	PRIMARY KEY(id)
);


update member3 set auth='ROLE_ADMIN' where id='admin';
commit;