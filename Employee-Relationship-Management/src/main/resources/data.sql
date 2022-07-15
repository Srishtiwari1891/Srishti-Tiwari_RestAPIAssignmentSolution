insert into users values(1,'$2a$12$TtOq5yXzikuBs1KZhzlMReNY5r5EcTiLL6sc5D2iunqrCNRmj0K5O','srishti');
insert into users values(2,'$2a$12$TtOq5yXzikuBs1KZhzlMReNY5r5EcTiLL6sc5D2iunqrCNRmj0K5O','bhumi');

insert into role(role_id,role_name) values ('1','ROLE_USER');
insert into role(role_id,role_name) values ('2','ROLE_ADMIN');

insert into user_roles(user_id,role_id) values(1,1);
insert into user_roles(user_id,role_id) values(2,2);