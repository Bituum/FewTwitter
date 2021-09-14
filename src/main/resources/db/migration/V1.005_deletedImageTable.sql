alter table "user"
    drop constraint if exists user_posts_id_fk;

alter table "user"
    drop if exists photos;

alter table "user"
    add if not exists photos varchar(255);

drop table if exists photos;



