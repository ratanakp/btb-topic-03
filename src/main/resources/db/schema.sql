-- Start create table

create table tb_category (
  id   serial primary key,
  name varchar
);


create table tb_book (
  id        serial primary key,
  title     varchar,
  author    varchar,
  publisher varchar,
  thumbnail varchar,
  cate_id   int references tb_category (id)
);


create table tb_role (
  id   serial primary key,
  role varchar
);


create table tb_user (
  id          serial primary key,
  username    varchar,
  password    varchar,
  status      boolean default true,
  profile_img varchar
);


create table tb_user_role (
  user_id int not null
    constraint user_id_fk references tb_user (id) on delete cascade on update cascade,
  role_id int not null
    constraint role_id_fk references tb_role (id) on delete cascade on update cascade,

  primary key (user_id, role_id)


);

-- drop table tb_user_role;

-- End create table


-- alter table tb_category
--   add column created_at timestamp null default now(),
--   add column updated_at timestamp with time zone null default now();






-- Start get_book_filter_pagination Function
-- Note: this function can not use with h2 db, this is for pgsql
/*CREATE FUNCTION get_book_filter_pagination(cate_id_param integer, book_title varchar, "limit" integer, "offset" integer)
  RETURNS table(
    id        integer,
    title     varchar,
    author    varchar,
    publisher varchar,
    thumbnail varchar,
    cate_id   integer,
    cate_name varchar
  )
AS
$$
DECLARE
  --   your variable;
BEGIN
  if cate_id_param isnull
  then
    raise notice 'meme';
    return query select b.id, b.title, b.author, b.publisher, b.thumbnail, c.id, c.name
                 from tb_book b
                        inner join tb_category c on b.cate_id = c.id
                 where b.title ilike '%' || book_title || '%'
                 limit "limit"
                 offset "offset";
  else
    return query select b.id, b.title, b.author, b.publisher, b.thumbnail, c.id, c.name
                 from tb_book b
                        inner join tb_category c on b.cate_id = c.id
                 where b.cate_id = cate_id_param
                   and b.title ilike '%' || book_title || '%'
                 limit "limit"
                 offset "offset";
  end if;


END;
$$
LANGUAGE 'plpgsql';*/
-- End get_book_filter_pagination Function










