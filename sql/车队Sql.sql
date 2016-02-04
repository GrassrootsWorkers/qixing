drop table if exists qx_cycling_team;

/*==============================================================*/
/* Table: "qx_ cycling_team"                                    */
/*==============================================================*/
create table qx_cycling_team
(
   cyc_id               int(20),
   cyc_team_logo        varchar(100),
   club_name            varchar(100),
   club_address         varchar(50),
   club_desc            varchar(200),
   create_name          varchar(50),
   mobile               varchar(50),
   personal_php         varchar(100),
   allow_unknow         varchar(20),
   person_limit         int(10),
   create_time          datetime,
   activity_amount      int(4),
   liveness             int(4) comment '1-10分 根据举办的活动计算'
);

alter table qx_cycling_team comment '组件的车队车队';

drop table if exists qx_activity;

/*==============================================================*/
/* Table: qx_activity                                           */
/*==============================================================*/
create table qx_activity
(
   activity_id          int(20),
   activity_desc        varchar(200),
   begin_time           datetime,
   end_time             datetime,
   apply_end_time       datetime,
   road_book_id         int(20),
   roles                varchar(100),
   people_num           int(4),
   if_mass              varchar(2),
   allow_unknow         varchar(2),
   apply_fee            double,
   create_time          datetime,
   start_x              varchar(20),
   end_x                varchar(20),
   start_y              varchar(20),
   end_y                varchar(20),
   activity_status      int(4) comment '0：活动刚创建，1：活动通过审核开始报名，2活动结束报名，3活动进行中 4 活动结束'
);

alter table qx_activity comment '车队中组织的活动';

drop table if exists qx_activity_attendee;

/*==============================================================*/
/* Table: qx_activity_attendee                                  */
/*==============================================================*/
create table qx_activity_attendee
(
   id                   int(20),
   activity_id          int(20),
   user_id              int(20),
   role_id              int(20) comment '在该活动担当什么角色',
   apply_time           datetime,
   if_on_time           varchar(2)
);

drop table if exists qx_activity_picture;

/*==============================================================*/
/* Table: qx_activity_picture                                   */
/*==============================================================*/
create table qx_activity_picture
(
   id                   char(10),
   image_big            char(10),
   image_center         char(10),
   imgage_small         char(10),
   cativity_id          char(10),
   create_time          char(10)
);

alter table qx_activity_picture comment '保存骑行图片，活动上传图片，自行车图片';
drop table if exists qx_cys_friend;

/*==============================================================*/
/* Table: qx_cys_friend                                         */
/*==============================================================*/
create table qx_cys_friend
(
   id               int(20),
   cyc_id               int(20),
   user_id              int(20),
   add_time             datetime,
   status               int(2)
);
drop table if exists qx_role;

/*==============================================================*/
/* Table: qx_role                                               */
/*==============================================================*/
create table qx_role
(
   role_id              int(20),
   role_name            varchar(100),
   condtion             varchar(100),
   status               int(2),
   add_time             datetime
);
drop table if exists qx_bicyele_picture;

/*==============================================================*/
/* Table: qx_bicyele_picture                                    */
/*==============================================================*/
create table qx_bicyele_picture
(
   id                   int(20),
   big_pic              varchar(100),
   center_pic           varchar(100),
   small_pic            varchar(100),
   bicycle_id           int(20),
   input_time           datetime
);

alter table qx_bicyele_picture comment '保存骑行图片，活动上传图片，自行车图片';

drop table if exists qx_own_bicycle;

/*==============================================================*/
/* Table: qx_own_bicycle                                        */
/*==============================================================*/
create table qx_own_bicycle
(
   bicycle_id           int(20),
   user_id              int(20),
   brand                int(20),
   version              int(20),
   bicycle_number       varchar(50),
   buy_time             date,
   price                double,
   if_assembly          varchar(2),
   if_public            varchar(2),
   depreciation_rate    int,
   input_time           datetime
);
drop table if exists qx_bicycle_brand;

/*==============================================================*/
/* Table: qx_bicycle_brand                                      */
/*==============================================================*/
create table qx_bicycle_brand
(
   brand_id             int(20),
   brand_name           varchar(200),
   brand_story          varchar(200),
   brand_desc           varchar(200),
   people_number        int(4),
   status               int(2) comment '0：停用1：启用'
);
drop table if exists qx_bicycle_series;

/*==============================================================*/
/* Table: qx_bicycle_series                                     */
/*==============================================================*/
create table qx_bicycle_series
(
   serie_id             int(20),
   brand_id             int(20),
   input_time           datetime,
   status               int(2),
   serie_name           varchar(20)
);

