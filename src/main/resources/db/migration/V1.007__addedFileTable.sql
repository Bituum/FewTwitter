create table if not exists file
(
    id   integer      not null
        constraint file_pk
            primary key,
    name varchar(255) not null,
    data bytea        not null,
    type varchar(32)  not null
);

alter table if exists file
    owner to bvqltbigfbndox;

create unique index if not exists file_id_uindex
    on file (id);

