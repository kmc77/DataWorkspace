drop table comments3 CASCADE constraints purge;

CREATE TABLE comments3(
	num		 				NUMBER PRIMARY KEY,
	id	 					VARCHAR2(30) REFERENCES member3(id),  
	content	 				VARCHAR2(200),  
	reg_date 				DATE,
	board_num  				NUMBER REFERENCES BOARD3(BOARD_NUM) ON DELETE CASCADE 
);

drop sequence com_seq3;
create sequence com_seq;