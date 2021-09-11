
alter table "user_extension" rename to userextension;
alter table "userextension" rename to user_extension;

alter table user_extension rename column "secondName" to second_name;
alter table user_extension rename column "second_name" to second_name;

alter table "user_roles" rename to userroles;
alter table "userroles" rename to user_roles;

alter table posts rename column "image_path" to imagepath;
alter table posts rename column "imagepath" to image_path;

alter table posts rename column "comment_section" to commentsection;
alter table posts rename column "commentsection" to comment_section;


alter table photos rename column "photo_path" to photopath;
alter table photos rename column "photopath" to photo_path;
