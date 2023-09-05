drop table comments CASCADE CONSTRAINTS;


create table comments(
	num			number		 primary key,
	id			varchar2(30) references member(id),
	content 	varchar2(200),
	reg_date	date,
	board_num	number references board(board_num)
				on delete cascade
);

CREATE TABLE comments (
    num         NUMBER PRIMARY KEY,
    id          VARCHAR2(30) REFERENCES member(id),
    content     VARCHAR2(200),
    reg_date    DATE,
    board_num   NUMBER REFERENCES board(board_num)
                    ON DELETE CASCADE
);

  drop sequence com_seq;
create sequence com_seq;