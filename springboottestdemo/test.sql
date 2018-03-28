/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 100110
 Source Host           : localhost
 Source Database       : test

 Target Server Type    : MySQL
 Target Server Version : 100110
 File Encoding         : utf-8

 Date: 03/28/2018 14:56:49 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `Persons`
-- ----------------------------
DROP TABLE IF EXISTS `Persons`;
CREATE TABLE `Persons` (
  `Id_P` int(11) DEFAULT NULL,
  `LastName` varchar(255) DEFAULT NULL,
  `FirstName` varchar(255) DEFAULT NULL,
  `Address` varchar(255) DEFAULT NULL,
  `City` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `album`
-- ----------------------------
DROP TABLE IF EXISTS `album`;
CREATE TABLE `album` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `path` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `album`
-- ----------------------------
BEGIN;
INSERT INTO `album` VALUES ('58', null, 'http://192.168.1.141:8080/assets/images/avatar.png'), ('59', null, 'http://192.168.1.141:8080/assets/images/avatar1.png'), ('60', null, 'http://192.168.1.141:8080/assets/images/avatar1.png'), ('61', null, 'http://192.168.1.141:8080/assets/images/avatar1.png'), ('62', null, 'http://192.168.1.141:8080/assets/images/image-2.jpg'), ('63', null, 'http://192.168.1.141:8080/assets/images/avatar1.png'), ('64', null, 'http://192.168.1.141:8080/assets/images/avatar.png'), ('65', null, 'http://192.168.1.141:8080/assets/images/image-2.jpg'), ('66', null, 'http://192.168.1.141:8080/assets/images/image-2.jpg'), ('67', null, 'http://192.168.1.141:8080/assets/images/avatar.png'), ('68', null, 'http://192.168.1.141:8080/assets/images/avatar.png');
COMMIT;

-- ----------------------------
--  Table structure for `dic`
-- ----------------------------
DROP TABLE IF EXISTS `dic`;
CREATE TABLE `dic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '字典类型',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '名称',
  `code` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `comment` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '字典说明',
  `create_time` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `dic`
-- ----------------------------
BEGIN;
INSERT INTO `dic` VALUES ('1', 'wx_type', '订阅号', '0', '微信公众号类型', '2018-03-13 14:23:21'), ('2', 'wx_type', '服务号', '1', '微信公众号类型', '2018-03-13 14:24:21'), ('3', 'login_type', '管理员', '1', '用户登录类型', '2018-03-13 14:25:21'), ('4', 'login_type', '公众号', '0', '用户登录类型', '2018-03-13 14:26:21');
COMMIT;

-- ----------------------------
--  Table structure for `public_users`
-- ----------------------------
DROP TABLE IF EXISTS `public_users`;
CREATE TABLE `public_users` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '登录名',
  `paw` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '登录密码',
  `type` int(10) DEFAULT NULL,
  `create_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `del_flg` int(1) DEFAULT NULL,
  `salt` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `public_users`
-- ----------------------------
BEGIN;
INSERT INTO `public_users` VALUES ('12', 'kk', 'kk', '1', '2018-03-16 11:52:51', '0', null), ('13', 'qq1', 'qq', '0', '2018-03-16 11:53:03', '0', null), ('14', 'qqq', 'qqq', '0', '2018-03-16 22:55:11', '0', null), ('15', 'jj', 'jj', '0', '2018-03-19 09:28:29', '0', null);
COMMIT;

-- ----------------------------
--  Table structure for `public_users_info`
-- ----------------------------
DROP TABLE IF EXISTS `public_users_info`;
CREATE TABLE `public_users_info` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `app_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'appid',
  `app_secret` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '开发者密码',
  `token` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '令牌',
  `encoding_aes_key` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '消息加解密密钥',
  `type` int(100) DEFAULT '0' COMMENT '公众号类型',
  `create_time` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '创建时间',
  `original_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '原始id',
  `public_user_id` int(10) DEFAULT NULL,
  `del_flg` int(2) DEFAULT NULL,
  `name` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `public_users_info`
-- ----------------------------
BEGIN;
INSERT INTO `public_users_info` VALUES ('28', '12', '12', '12', '12', '1', '2018-03-16 21:15:17', '12', '12', '0', '联合众生2'), ('29', '22', '2222', '2', '2', '0', '2018-03-16 21:16:34', '2', '13', '0', '联合众生'), ('32', '2', '2', '2', '2', '0', '2018-03-16 22:56:16', '2', '12', '0', '2'), ('33', '1', '1', '1', '1', '0', '2018-03-17 20:32:56', '1', '12', '0', '12'), ('34', '3', '3', '3', '3', '0', '2018-03-19 09:17:19', '3', '14', '0', '联合众生'), ('35', 'aaa', 'aaa', 'aaa', 'aaa', '0', '2018-03-19 09:24:41', 'aaa', '12', '0', 'aaa');
COMMIT;

-- ----------------------------
--  Table structure for `score`
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `mathe` double(3,1) DEFAULT NULL,
  `english` double(3,1) DEFAULT NULL,
  `chainese` double(3,1) DEFAULT NULL,
  `student_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `score`
-- ----------------------------
BEGIN;
INSERT INTO `score` VALUES ('1', '99.9', '99.0', '99.0', '1'), ('2', '89.0', '99.0', '80.0', '3'), ('3', '66.0', null, null, null), ('4', '66.0', null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `sex` varchar(2) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `student`
-- ----------------------------
BEGIN;
INSERT INTO `student` VALUES ('1', 'xxx', '23', '男'), ('2', 'zz', '25', '男');
COMMIT;

-- ----------------------------
--  Procedure structure for `AddGeometryColumn`
-- ----------------------------
DROP PROCEDURE IF EXISTS `AddGeometryColumn`;
delimiter ;;
CREATE DEFINER=`` PROCEDURE `AddGeometryColumn`(catalog varchar(64), t_schema varchar(64),
   t_name varchar(64), geometry_column varchar(64), t_srid int)
begin
  set @qwe= concat('ALTER TABLE ', t_schema, '.', t_name, ' ADD ', geometry_column,' GEOMETRY REF_SYSTEM_ID=', t_srid); PREPARE ls from @qwe; execute ls; deallocate prepare ls; end
 ;;
delimiter ;

-- ----------------------------
--  Procedure structure for `DropGeometryColumn`
-- ----------------------------
DROP PROCEDURE IF EXISTS `DropGeometryColumn`;
delimiter ;;
CREATE DEFINER=`` PROCEDURE `DropGeometryColumn`(catalog varchar(64), t_schema varchar(64),
   t_name varchar(64), geometry_column varchar(64))
begin
  set @qwe= concat('ALTER TABLE ', t_schema, '.', t_name, ' DROP ', geometry_column); PREPARE ls from @qwe; execute ls; deallocate prepare ls; end
 ;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
