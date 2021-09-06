alter table "user"
    alter column login
        type varchar(255) using login::varchar(255);
