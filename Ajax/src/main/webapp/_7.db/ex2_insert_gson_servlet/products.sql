drop table products purge;
create table products(
 id		number(11) primary key,
 name 	varchar2(50),
 price 	number,
 maker 	varchar2(30)
);

INSERT INTO products (id, name, price, maker)
VALUES (1, '노트북', 1000, '삼성');


 
 

/*
alter table products
add primary key(id);
*/
select * from products;