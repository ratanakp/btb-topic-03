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

