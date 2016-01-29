use dream;
create table qx_user
(
   id                   int(4),
   nick_name            varchar(50),
   sex                  varchar(2),
   level                int(2) comment '骑过路线的难度最高等级 --根据路线进行测评，定期更新该字段，为推荐好友做准备',
   location             varchar(50),
   height               varchar(10),
   weight               varchar(10),
   bicycle_age          int,
   real_name            varchar(50),
   weixin_num           varchar(50),
   role                 varchar(20),
   mobile               varchar(20),
   password             varchar(20),
   registered_time      datetime,
   last_login_time      datetime,
   total                int(4),
   active_level         int(2) comment '根据使用次数和组件车队的次数',
   image                varchar(100),
   spread_code          varchar(6),
   recommend_id         int(20) comment '介绍人'
);
