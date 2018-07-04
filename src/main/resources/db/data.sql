insert into tb_category (name) values (''comics''), (''romance''), (''fantasy''), (''comedy'');


insert into tb_book (title, author, publisher, thumbnail, cate_id)
values (''title'', ''author'', ''publisher'', ''thumbnail'', 1);

-- select *
-- from tb_book b inner join tb_category tc on b.cate_id = tc.id;

-- select *
-- from tb_book;

-- truncate table tb_book restart identity;

-- delete from tb_book
-- where id = 4;


-- select *
-- from tb_category;



-- select currval(''tb_book_id_seq'') as curr_id;


-- select *
-- from tb_category;


-- select *
-- from tb_category c inner join tb_book tb on c.id = tb.cate_id;


insert into tb_role (role) values (''ADMIN''), (''DBA''), (''USER'');

-- select *
-- from tb_role;


insert into tb_user (username, password, profile_img) values
  (''ehan'', ''ehan'', ''ehan.png''),
  (''piseth'', ''piseth'', ''piseth.png''),
  (''thearoth'', ''thearoth'', ''thearoth.png'');


insert into tb_user_role (user_id, role_id) values (1, 1), (1, 3), (2, 2), (2, 3), (3, 1), (3, 2), (3, 3);

-- select *
-- from tb_user_role;


-- select *
-- from tb_role tr inner join tb_user_role tur on tr.id = tur.role_id where tur.user_id=3;


update tb_user
set password = ''$2a$10$at95C9TNg8R6rKI8f2CRaO4RTypjDGNbnFog9e5R4cGDzn5HYs0sm''
where id = 1;


update tb_user
set status = false
where id = 1;
