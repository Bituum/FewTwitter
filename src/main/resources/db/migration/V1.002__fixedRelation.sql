alter table posts drop if exists posts_user_id_fk;

alter table posts drop if exists author;

alter table if exists "user"
    add if not exists posts int;


alter table  "user"
    drop constraint if exists user_posts_id_fk;

alter table  "user"
    add constraint user_posts_id_fk
        foreign key (posts) references posts;