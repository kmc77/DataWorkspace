create table persistent_logins(
 username varchar(64) not null,
 series varchar(64) primary key, --���, �������� ���� ������ ���� ��
 token varchar(64) not null, --�������� ������ �ִ� ��Ű�� ���� ������ ������
 last_used timestamp not null-- ���� �ֽ� �ڵ� �α��� �ð�
 );
 
 select * from persistent_logins;