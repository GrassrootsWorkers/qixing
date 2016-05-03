/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50523
Source Host           : localhost:3306
Source Database       : dream

Target Server Type    : MYSQL
Target Server Version : 50523
File Encoding         : 65001

Date: 2016-05-03 17:18:07
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `qx_activity`
-- ----------------------------
DROP TABLE IF EXISTS `qx_activity`;
CREATE TABLE `qx_activity` (
  `activity_id` int(20) DEFAULT NULL,
  `activity_desc` varchar(200) DEFAULT NULL,
  `begin_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `apply_end_time` datetime DEFAULT NULL,
  `road_book_id` int(20) DEFAULT NULL,
  `roles` varchar(100) DEFAULT NULL,
  `people_num` int(4) DEFAULT NULL,
  `if_mass` varchar(2) DEFAULT NULL,
  `allow_unknow` varchar(2) DEFAULT NULL,
  `apply_fee` double DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `start_x` varchar(20) DEFAULT NULL,
  `end_x` varchar(20) DEFAULT NULL,
  `start_y` varchar(20) DEFAULT NULL,
  `end_y` varchar(20) DEFAULT NULL,
  `activity_status` int(4) DEFAULT NULL COMMENT '0：活动刚创建，1：活动通过审核开始报名，2活动结束报名，3活动进行中 4 活动结束'
) ENGINE=InnoDB DEFAULT CHARSET=gb2312 COMMENT='车队中组织的活动';

-- ----------------------------
-- Records of qx_activity
-- ----------------------------

-- ----------------------------
-- Table structure for `qx_activity_apply`
-- ----------------------------
DROP TABLE IF EXISTS `qx_activity_apply`;
CREATE TABLE `qx_activity_apply` (
  `id` int(20) DEFAULT NULL,
  `activity_id` int(20) DEFAULT NULL,
  `user_id` int(20) DEFAULT NULL,
  `role_id` int(20) DEFAULT NULL COMMENT '在该活动担当什么角色',
  `apply_time` datetime DEFAULT NULL,
  `if_on_time` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of qx_activity_apply
-- ----------------------------

-- ----------------------------
-- Table structure for `qx_activity_picture`
-- ----------------------------
DROP TABLE IF EXISTS `qx_activity_picture`;
CREATE TABLE `qx_activity_picture` (
  `id` char(10) DEFAULT NULL,
  `image_big` char(10) DEFAULT NULL,
  `image_center` char(10) DEFAULT NULL,
  `imgage_small` char(10) DEFAULT NULL,
  `cativity_id` char(10) DEFAULT NULL,
  `create_time` char(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gb2312 COMMENT='保存骑行图片，活动上传图片，自行车图片';

-- ----------------------------
-- Records of qx_activity_picture
-- ----------------------------

-- ----------------------------
-- Table structure for `qx_bicycle_brand`
-- ----------------------------
DROP TABLE IF EXISTS `qx_bicycle_brand`;
CREATE TABLE `qx_bicycle_brand` (
  `brand_id` int(20) DEFAULT NULL,
  `brand_name` varchar(200) DEFAULT NULL,
  `brand_story` varchar(200) DEFAULT NULL,
  `brand_desc` varchar(200) DEFAULT NULL,
  `people_number` int(4) DEFAULT NULL,
  `status` int(2) DEFAULT NULL COMMENT '0：停用1：启用'
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of qx_bicycle_brand
-- ----------------------------

-- ----------------------------
-- Table structure for `qx_bicycle_friend`
-- ----------------------------
DROP TABLE IF EXISTS `qx_bicycle_friend`;
CREATE TABLE `qx_bicycle_friend` (
  `id` int(20) DEFAULT NULL,
  `cyc_id` int(20) DEFAULT NULL,
  `user_id` int(20) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `status` int(2) DEFAULT NULL,
  `if_admin` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of qx_bicycle_friend
-- ----------------------------

-- ----------------------------
-- Table structure for `qx_bicycle_series`
-- ----------------------------
DROP TABLE IF EXISTS `qx_bicycle_series`;
CREATE TABLE `qx_bicycle_series` (
  `serie_id` int(20) DEFAULT NULL,
  `brand_id` int(20) DEFAULT NULL,
  `input_time` datetime DEFAULT NULL,
  `status` int(2) DEFAULT NULL,
  `serie_name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of qx_bicycle_series
-- ----------------------------

-- ----------------------------
-- Table structure for `qx_bicycling_team`
-- ----------------------------
DROP TABLE IF EXISTS `qx_bicycling_team`;
CREATE TABLE `qx_bicycling_team` (
  `cyc_id` int(20) DEFAULT NULL,
  `cyc_team_logo` varchar(100) DEFAULT NULL,
  `club_name` varchar(100) DEFAULT NULL,
  `club_address` varchar(50) DEFAULT NULL,
  `club_desc` varchar(200) DEFAULT NULL,
  `create_name` varchar(50) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  `personal_php` varchar(100) DEFAULT NULL,
  `allow_unknow` varchar(20) DEFAULT NULL,
  `person_limit` int(10) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `activity_amount` int(4) DEFAULT NULL,
  `liveness` int(4) DEFAULT NULL COMMENT '1-10分 根据举办的活动计算'
) ENGINE=InnoDB DEFAULT CHARSET=gb2312 COMMENT='组件的车队车队';

-- ----------------------------
-- Records of qx_bicycling_team
-- ----------------------------

-- ----------------------------
-- Table structure for `qx_bicyele_picture`
-- ----------------------------
DROP TABLE IF EXISTS `qx_bicyele_picture`;
CREATE TABLE `qx_bicyele_picture` (
  `id` int(20) DEFAULT NULL,
  `big_pic` varchar(100) DEFAULT NULL,
  `center_pic` varchar(100) DEFAULT NULL,
  `small_pic` varchar(100) DEFAULT NULL,
  `bicycle_id` int(20) DEFAULT NULL,
  `input_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gb2312 COMMENT='保存骑行图片，活动上传图片，自行车图片';

-- ----------------------------
-- Records of qx_bicyele_picture
-- ----------------------------

-- ----------------------------
-- Table structure for `qx_essay`
-- ----------------------------
DROP TABLE IF EXISTS `qx_essay`;
CREATE TABLE `qx_essay` (
  `essays_id` int(20) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `cys_report_id` int(20) DEFAULT NULL,
  `image_url` varchar(200) DEFAULT NULL,
  `location_x` varchar(45) DEFAULT NULL,
  `location_y` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gb2312 COMMENT='骑行随笔';

-- ----------------------------
-- Records of qx_essay
-- ----------------------------

-- ----------------------------
-- Table structure for `qx_own_bicycle`
-- ----------------------------
DROP TABLE IF EXISTS `qx_own_bicycle`;
CREATE TABLE `qx_own_bicycle` (
  `bicycle_id` int(20) DEFAULT NULL,
  `user_id` int(20) DEFAULT NULL,
  `brand` int(20) DEFAULT NULL,
  `version` int(20) DEFAULT NULL,
  `bicycle_number` varchar(50) DEFAULT NULL,
  `buy_time` date DEFAULT NULL,
  `price` double DEFAULT NULL,
  `if_assembly` varchar(2) DEFAULT NULL,
  `if_public` varchar(2) DEFAULT NULL,
  `depreciation_rate` int(11) DEFAULT NULL,
  `input_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of qx_own_bicycle
-- ----------------------------

-- ----------------------------
-- Table structure for `qx_reply`
-- ----------------------------
DROP TABLE IF EXISTS `qx_reply`;
CREATE TABLE `qx_reply` (
  `id` int(20) DEFAULT NULL,
  `review_id` int(20) DEFAULT NULL,
  `user_id` int(20) DEFAULT NULL,
  `reply_content` varchar(200) DEFAULT NULL,
  `reply_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gb2312 COMMENT='评论表：骑行路线评论，自行车评论';

-- ----------------------------
-- Records of qx_reply
-- ----------------------------

-- ----------------------------
-- Table structure for `qx_report`
-- ----------------------------
DROP TABLE IF EXISTS `qx_report`;
CREATE TABLE `qx_report` (
  `cys_report_id` int(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(20) DEFAULT NULL,
  `qx_name` varchar(100) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `gps_strs` varchar(200) DEFAULT NULL,
  `difficulty_deg` int(2) DEFAULT NULL,
  `average_speed` float DEFAULT NULL,
  `highest_speed` float DEFAULT NULL,
  `lowest_speed` float DEFAULT NULL,
  `time_consume` float DEFAULT NULL COMMENT '时分秒',
  `caloric_value` float DEFAULT NULL,
  `if_team` int(2) DEFAULT NULL,
  `road_book_id` int(20) DEFAULT NULL,
  `height` double DEFAULT NULL,
  PRIMARY KEY (`cys_report_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312 COMMENT='记录轨迹，高程，和速度的。';

-- ----------------------------
-- Records of qx_report
-- ----------------------------

-- ----------------------------
-- Table structure for `qx_review`
-- ----------------------------
DROP TABLE IF EXISTS `qx_review`;
CREATE TABLE `qx_review` (
  `review_id` int(20) DEFAULT NULL,
  `user_id` int(20) DEFAULT NULL,
  `review_content` varchar(200) DEFAULT NULL,
  `review_time` datetime DEFAULT NULL,
  `reply_count` int(4) DEFAULT NULL,
  `review_type` int(4) DEFAULT NULL COMMENT '0:骑行报告评论 1：活动评论 2：自行车评论',
  `type_code` int(20) DEFAULT NULL COMMENT 'review_type =0 该值是骑行报告的编码，以此类推'
) ENGINE=InnoDB DEFAULT CHARSET=gb2312 COMMENT='活动评论的回复，骑行路线评论的回复，自行车评论的回复';

-- ----------------------------
-- Records of qx_review
-- ----------------------------

-- ----------------------------
-- Table structure for `qx_road_book`
-- ----------------------------
DROP TABLE IF EXISTS `qx_road_book`;
CREATE TABLE `qx_road_book` (
  `road_book_id` int(20) NOT NULL AUTO_INCREMENT,
  `creater` varchar(50) DEFAULT NULL,
  `activity_id` int(20) DEFAULT NULL,
  `all_distance` int(4) DEFAULT NULL,
  `estimated_time` int(40) DEFAULT NULL,
  `difficulty` int(2) DEFAULT NULL,
  `status` int(2) DEFAULT NULL,
  `begin_x` varchar(20) DEFAULT NULL,
  `end_x` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `begin_y` double DEFAULT NULL,
  `end_y` double DEFAULT NULL,
  PRIMARY KEY (`road_book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312 COMMENT='自行车路线，一些坐标点';

-- ----------------------------
-- Records of qx_road_book
-- ----------------------------

-- ----------------------------
-- Table structure for `qx_road_book_xyz`
-- ----------------------------
DROP TABLE IF EXISTS `qx_road_book_xyz`;
CREATE TABLE `qx_road_book_xyz` (
  `xyz_id` int(20) DEFAULT NULL,
  `xyz_name` varchar(50) DEFAULT NULL,
  `xyz` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `road_book_id` int(20) DEFAULT NULL,
  `localtion_x` double DEFAULT NULL,
  `localtion_y` double DEFAULT NULL,
  `localtion_z` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gb2312 COMMENT='路书坐标';

-- ----------------------------
-- Records of qx_road_book_xyz
-- ----------------------------

-- ----------------------------
-- Table structure for `qx_role`
-- ----------------------------
DROP TABLE IF EXISTS `qx_role`;
CREATE TABLE `qx_role` (
  `role_id` int(20) DEFAULT NULL,
  `role_name` varchar(100) DEFAULT NULL,
  `condtion` varchar(100) DEFAULT NULL,
  `status` int(2) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of qx_role
-- ----------------------------

-- ----------------------------
-- Table structure for `qx_user`
-- ----------------------------
DROP TABLE IF EXISTS `qx_user`;
CREATE TABLE `qx_user` (
  `user_id` int(4) NOT NULL AUTO_INCREMENT,
  `mobile` varchar(20) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `nick_name` varchar(50) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `level` int(2) DEFAULT NULL COMMENT '骑过路线的难度最高等级 --根据路线进行测评，定期更新该字段，为推荐好友做准备',
  `location` varchar(50) DEFAULT NULL,
  `height` varchar(10) DEFAULT NULL,
  `weight` varchar(10) DEFAULT NULL,
  `bicycle_age` int(11) DEFAULT NULL,
  `real_name` varchar(50) DEFAULT NULL,
  `weixin_num` varchar(50) DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL,
  `registered_time` datetime DEFAULT NULL,
  `total` int(4) DEFAULT NULL,
  `active_level` int(2) DEFAULT NULL COMMENT '根据使用次数和组件车队的次数',
  `image` varchar(100) DEFAULT NULL,
  `spread_code` varchar(6) DEFAULT NULL,
  `recommend_id` int(20) DEFAULT NULL COMMENT '介绍人',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of qx_user
-- ----------------------------
INSERT INTO qx_user VALUES ('1', '18618102693', '186****02693', '42dae262b8531b3df48cde9cc018c512', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `qx_vender`
-- ----------------------------
DROP TABLE IF EXISTS `qx_vender`;
CREATE TABLE `qx_vender` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `venderId` varchar(20) DEFAULT NULL,
  `secret` varchar(20) DEFAULT NULL,
  `appType` varchar(10) DEFAULT NULL COMMENT 'android ,ios',
  `status` int(2) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `chanageTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of qx_vender
-- ----------------------------
