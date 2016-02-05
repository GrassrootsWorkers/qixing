CREATE DATABASE  IF NOT EXISTS `dream` /*!40100 DEFAULT CHARACTER SET gb2312 */;
USE `dream`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: dream
-- ------------------------------------------------------
-- Server version	5.5.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `qx_bicycle_series`
--

DROP TABLE IF EXISTS `qx_bicycle_series`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qx_bicycle_series` (
  `serie_id` int(20) DEFAULT NULL,
  `brand_id` int(20) DEFAULT NULL,
  `input_time` datetime DEFAULT NULL,
  `status` int(2) DEFAULT NULL,
  `serie_name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qx_bicycle_series`
--

LOCK TABLES `qx_bicycle_series` WRITE;
/*!40000 ALTER TABLE `qx_bicycle_series` DISABLE KEYS */;
/*!40000 ALTER TABLE `qx_bicycle_series` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qx_activity`
--

DROP TABLE IF EXISTS `qx_activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qx_activity`
--

LOCK TABLES `qx_activity` WRITE;
/*!40000 ALTER TABLE `qx_activity` DISABLE KEYS */;
/*!40000 ALTER TABLE `qx_activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qx_report`
--

DROP TABLE IF EXISTS `qx_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qx_report`
--

LOCK TABLES `qx_report` WRITE;
/*!40000 ALTER TABLE `qx_report` DISABLE KEYS */;
/*!40000 ALTER TABLE `qx_report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qx_own_bicycle`
--

DROP TABLE IF EXISTS `qx_own_bicycle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qx_own_bicycle`
--

LOCK TABLES `qx_own_bicycle` WRITE;
/*!40000 ALTER TABLE `qx_own_bicycle` DISABLE KEYS */;
/*!40000 ALTER TABLE `qx_own_bicycle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qx_essay`
--

DROP TABLE IF EXISTS `qx_essay`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qx_essay` (
  `essays_id` int(20) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `cys_report_id` int(20) DEFAULT NULL,
  `image_url` varchar(200) DEFAULT NULL,
  `location_x` varchar(45) DEFAULT NULL,
  `location_y` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gb2312 COMMENT='骑行随笔';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qx_essay`
--

LOCK TABLES `qx_essay` WRITE;
/*!40000 ALTER TABLE `qx_essay` DISABLE KEYS */;
/*!40000 ALTER TABLE `qx_essay` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qx_activity_apply`
--

DROP TABLE IF EXISTS `qx_activity_apply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qx_activity_apply` (
  `id` int(20) DEFAULT NULL,
  `activity_id` int(20) DEFAULT NULL,
  `user_id` int(20) DEFAULT NULL,
  `role_id` int(20) DEFAULT NULL COMMENT '在该活动担当什么角色',
  `apply_time` datetime DEFAULT NULL,
  `if_on_time` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qx_activity_apply`
--

LOCK TABLES `qx_activity_apply` WRITE;
/*!40000 ALTER TABLE `qx_activity_apply` DISABLE KEYS */;
/*!40000 ALTER TABLE `qx_activity_apply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qx_bicycling_team`
--

DROP TABLE IF EXISTS `qx_bicycling_team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qx_bicycling_team`
--

LOCK TABLES `qx_bicycling_team` WRITE;
/*!40000 ALTER TABLE `qx_bicycling_team` DISABLE KEYS */;
/*!40000 ALTER TABLE `qx_bicycling_team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qx_role`
--

DROP TABLE IF EXISTS `qx_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qx_role` (
  `role_id` int(20) DEFAULT NULL,
  `role_name` varchar(100) DEFAULT NULL,
  `condtion` varchar(100) DEFAULT NULL,
  `status` int(2) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qx_role`
--

LOCK TABLES `qx_role` WRITE;
/*!40000 ALTER TABLE `qx_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `qx_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qx_review`
--

DROP TABLE IF EXISTS `qx_review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qx_review` (
  `review_id` int(20) DEFAULT NULL,
  `user_id` int(20) DEFAULT NULL,
  `review_content` varchar(200) DEFAULT NULL,
  `review_time` datetime DEFAULT NULL,
  `reply_count` int(4) DEFAULT NULL,
  `review_type` int(4) DEFAULT NULL COMMENT '0:骑行报告评论 1：活动评论 2：自行车评论',
  `type_code` int(20) DEFAULT NULL COMMENT 'review_type =0 该值是骑行报告的编码，以此类推'
) ENGINE=InnoDB DEFAULT CHARSET=gb2312 COMMENT='活动评论的回复，骑行路线评论的回复，自行车评论的回复';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qx_review`
--

LOCK TABLES `qx_review` WRITE;
/*!40000 ALTER TABLE `qx_review` DISABLE KEYS */;
/*!40000 ALTER TABLE `qx_review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qx_bicycle_friend`
--

DROP TABLE IF EXISTS `qx_bicycle_friend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qx_bicycle_friend` (
  `id` int(20) DEFAULT NULL,
  `cyc_id` int(20) DEFAULT NULL,
  `user_id` int(20) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `status` int(2) DEFAULT NULL,
  `if_admin` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qx_bicycle_friend`
--

LOCK TABLES `qx_bicycle_friend` WRITE;
/*!40000 ALTER TABLE `qx_bicycle_friend` DISABLE KEYS */;
/*!40000 ALTER TABLE `qx_bicycle_friend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qx_bicyele_picture`
--

DROP TABLE IF EXISTS `qx_bicyele_picture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qx_bicyele_picture` (
  `id` int(20) DEFAULT NULL,
  `big_pic` varchar(100) DEFAULT NULL,
  `center_pic` varchar(100) DEFAULT NULL,
  `small_pic` varchar(100) DEFAULT NULL,
  `bicycle_id` int(20) DEFAULT NULL,
  `input_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gb2312 COMMENT='保存骑行图片，活动上传图片，自行车图片';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qx_bicyele_picture`
--

LOCK TABLES `qx_bicyele_picture` WRITE;
/*!40000 ALTER TABLE `qx_bicyele_picture` DISABLE KEYS */;
/*!40000 ALTER TABLE `qx_bicyele_picture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qx_road_book_xyz`
--

DROP TABLE IF EXISTS `qx_road_book_xyz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qx_road_book_xyz`
--

LOCK TABLES `qx_road_book_xyz` WRITE;
/*!40000 ALTER TABLE `qx_road_book_xyz` DISABLE KEYS */;
/*!40000 ALTER TABLE `qx_road_book_xyz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qx_bicycle_brand`
--

DROP TABLE IF EXISTS `qx_bicycle_brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qx_bicycle_brand` (
  `brand_id` int(20) DEFAULT NULL,
  `brand_name` varchar(200) DEFAULT NULL,
  `brand_story` varchar(200) DEFAULT NULL,
  `brand_desc` varchar(200) DEFAULT NULL,
  `people_number` int(4) DEFAULT NULL,
  `status` int(2) DEFAULT NULL COMMENT '0：停用1：启用'
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qx_bicycle_brand`
--

LOCK TABLES `qx_bicycle_brand` WRITE;
/*!40000 ALTER TABLE `qx_bicycle_brand` DISABLE KEYS */;
/*!40000 ALTER TABLE `qx_bicycle_brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qx_user`
--

DROP TABLE IF EXISTS `qx_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qx_user` (
  `user_id` int(4) NOT NULL AUTO_INCREMENT,
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
  `mobile` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `registered_time` datetime DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL,
  `total` int(4) DEFAULT NULL,
  `active_level` int(2) DEFAULT NULL COMMENT '根据使用次数和组件车队的次数',
  `image` varchar(100) DEFAULT NULL,
  `spread_code` varchar(6) DEFAULT NULL,
  `recommend_id` int(20) DEFAULT NULL COMMENT '介绍人',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qx_user`
--

LOCK TABLES `qx_user` WRITE;
/*!40000 ALTER TABLE `qx_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `qx_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qx_activity_picture`
--

DROP TABLE IF EXISTS `qx_activity_picture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qx_activity_picture` (
  `id` char(10) DEFAULT NULL,
  `image_big` char(10) DEFAULT NULL,
  `image_center` char(10) DEFAULT NULL,
  `imgage_small` char(10) DEFAULT NULL,
  `cativity_id` char(10) DEFAULT NULL,
  `create_time` char(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gb2312 COMMENT='保存骑行图片，活动上传图片，自行车图片';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qx_activity_picture`
--

LOCK TABLES `qx_activity_picture` WRITE;
/*!40000 ALTER TABLE `qx_activity_picture` DISABLE KEYS */;
/*!40000 ALTER TABLE `qx_activity_picture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qx_road_book`
--

DROP TABLE IF EXISTS `qx_road_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qx_road_book`
--

LOCK TABLES `qx_road_book` WRITE;
/*!40000 ALTER TABLE `qx_road_book` DISABLE KEYS */;
/*!40000 ALTER TABLE `qx_road_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qx_reply`
--

DROP TABLE IF EXISTS `qx_reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qx_reply` (
  `id` int(20) DEFAULT NULL,
  `review_id` int(20) DEFAULT NULL,
  `user_id` int(20) DEFAULT NULL,
  `reply_content` varchar(200) DEFAULT NULL,
  `reply_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gb2312 COMMENT='评论表：骑行路线评论，自行车评论';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qx_reply`
--

LOCK TABLES `qx_reply` WRITE;
/*!40000 ALTER TABLE `qx_reply` DISABLE KEYS */;
/*!40000 ALTER TABLE `qx_reply` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-02-05 17:57:37
