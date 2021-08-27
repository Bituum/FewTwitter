create sequence user_id_seq1
    as integer;

alter sequence user_id_seq1 owner to bvqltbigfbndox;

create table photos
(
    id          serial
        constraint photos_pk
            primary key,
    "photoPath" varchar(255) default 'https://hajiri.co/uploads/no_image.jpg'::character varying
);

alter table photos
    owner to bvqltbigfbndox;

create table "user"
(
    id       integer default nextval('user_id_seq1'::regclass) not null
        constraint user_pk
            primary key,
    login    varchar(255)                                      not null,
    password varchar(50)                                       not null,
    photos   integer
        constraint user_photos_id_fk
            references photos
);

alter table "user"
    owner to bvqltbigfbndox;

alter sequence user_id_seq1 owned by "user".id;

create table posts
(
    id               serial
        constraint posts_pk
            primary key,
    "commentSection" varchar(777),
    "ImagePath"      varchar(66),
    author           integer not null
        constraint posts_user_id_fk
            references "user"
);

alter table posts
    owner to bvqltbigfbndox;

create table "userExtension"
(
    id           integer      not null
        constraint userextension_pk
            primary key
        constraint userextension_user_id_fk
            references "user",
    name         varchar(255) not null,
    "secondName" varchar(255) not null,
    patronymic   varchar(255) not null,
    hobby        varchar(255) not null,
    friends      integer
);

alter table "userExtension"
    owner to bvqltbigfbndox;

