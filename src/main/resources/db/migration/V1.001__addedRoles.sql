create table if not exists roles
(
    id   serial
        constraint roles_pk
            primary key,
    role varchar(10) not null
);

alter table roles
    owner to bvqltbigfbndox;

create  unique index if not exists roles_role_uindex
    on roles (role);

create table if not exists "user-roles"
(
    id       serial
        constraint "user-roles_pk"
            primary key,
    fr_user  integer not null
        constraint "user-roles_user_id_fk"
            references "user",
    fr_roles integer not null
        constraint "user-roles_roles_id_fk"
            references roles
);

alter table "user-roles"
    owner to bvqltbigfbndox;

