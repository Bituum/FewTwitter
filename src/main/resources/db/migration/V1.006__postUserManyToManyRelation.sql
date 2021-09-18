create table if not exists user_posts
(
    id      serial
        constraint user_posts_pk
            primary key,
    user_fk int not null,
    post_fk int not null
);
alter table "user"
    drop constraint if exists user_posts_id_fk;

alter table "user"
    drop column if exists posts;

ALTER TABLE user_posts
    DROP CONSTRAINT IF EXISTS user_posts_user_id_fk;

alter table user_posts
    add constraint user_posts_user_id_fk
        foreign key (user_fk) references "user";

ALTER TABLE user_posts
    DROP CONSTRAINT IF EXISTS user_posts_posts_id_fk;

alter table user_posts
    add constraint user_posts_posts_id_fk
        foreign key (post_fk) references posts;