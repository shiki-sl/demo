/*
Navicat MySQL Data Transfer

Source Server         : shiki
Source Server Version : 50726
Source Host           : 192.168.1.197:3306
Source Database       : sl_demo

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-06-27 18:15:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for s_perms
-- ----------------------------
DROP TABLE IF EXISTS `s_perms`;
CREATE TABLE `s_perms` (
  `perms_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `perms_name` varchar(20) DEFAULT 'none' COMMENT '权限名',
  PRIMARY KEY (`perms_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of s_perms
-- ----------------------------
INSERT INTO `s_perms` VALUES ('1', 'none');
INSERT INTO `s_perms` VALUES ('2', 'all');
INSERT INTO `s_perms` VALUES ('3', '/text/**');
INSERT INTO `s_perms` VALUES ('4', 'shiki');

-- ----------------------------
-- Table structure for s_role
-- ----------------------------
DROP TABLE IF EXISTS `s_role`;
CREATE TABLE `s_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `role_name` varchar(20) DEFAULT 'user' COMMENT '角色名',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_role
-- ----------------------------
INSERT INTO `s_role` VALUES ('1', 'root');
INSERT INTO `s_role` VALUES ('2', 'vip');
INSERT INTO `s_role` VALUES ('3', 'user');
INSERT INTO `s_role` VALUES ('4', 'test');
INSERT INTO `s_role` VALUES ('5', 'none');

-- ----------------------------
-- Table structure for s_role_perms
-- ----------------------------
DROP TABLE IF EXISTS `s_role_perms`;
CREATE TABLE `s_role_perms` (
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `perms_id` bigint(20) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`role_id`,`perms_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限对应表';

-- ----------------------------
-- Records of s_role_perms
-- ----------------------------
INSERT INTO `s_role_perms` VALUES ('1', '1');
INSERT INTO `s_role_perms` VALUES ('1', '2');
INSERT INTO `s_role_perms` VALUES ('3', '2');
INSERT INTO `s_role_perms` VALUES ('3', '4');

-- ----------------------------
-- Table structure for s_text
-- ----------------------------
DROP TABLE IF EXISTS `s_text`;
CREATE TABLE `s_text` (
  `user_id` bigint(20) NOT NULL COMMENT '文章所属用户',
  `text_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '文章id',
  `title` varchar(20) DEFAULT NULL COMMENT '文章标题',
  `text` text COMMENT '文章正文',
  `create_time` bigint(13) unsigned DEFAULT NULL COMMENT '文章发布时间',
  `update_time` bigint(13) unsigned DEFAULT NULL COMMENT '文章更新时间戳',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否被删除',
  PRIMARY KEY (`text_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_text
-- ----------------------------
INSERT INTO `s_text` VALUES ('1', '1', '特', '额', '1561357173316', '1561625147311', '1');
INSERT INTO `s_text` VALUES ('1', '2', 'test标题', 'test文章', '1561357173316', '1561624479421', '0');
INSERT INTO `s_text` VALUES ('2', '3', '123456', '123456', '1561357173316', '1561616598584', '0');
INSERT INTO `s_text` VALUES ('1', '4', 'test', '萨达萨达是发生发生发生飞洒发生的服务器发士大夫撒给v现场v在这些asdasfsagsad干撒广东省搭嘎是个撒个撒个撒个的撒干啥事嘎洒上', '1561357173316', '1561616598328', '0');
INSERT INTO `s_text` VALUES ('3', '5', 'date', '时间', '1561357173316', null, '0');
INSERT INTO `s_text` VALUES ('4', '6', 'test', '测试', '1561456711389', '1561616597248', '0');
INSERT INTO `s_text` VALUES ('4', '7', '文章', '-_-', '1561456711389', '1561616596808', '0');
INSERT INTO `s_text` VALUES ('4', '8', '测试', 'weqaareq', '1561456711389', '1561616595575', '0');
INSERT INTO `s_text` VALUES ('4', '9', '2', '2', '1561456711389', '1561625139919', '0');
INSERT INTO `s_text` VALUES ('3', '10', '312', '3123123', '1561456711389', null, '0');
INSERT INTO `s_text` VALUES ('3', '11', '1223', '12', '1561456711389', null, '0');

-- ----------------------------
-- Table structure for s_user
-- ----------------------------
DROP TABLE IF EXISTS `s_user`;
CREATE TABLE `s_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_user
-- ----------------------------
INSERT INTO `s_user` VALUES ('1', 'root', '6ede498e75d73b59a593c474a7dcf8e8');
INSERT INTO `s_user` VALUES ('2', 'test_user', '1accb8f62425a2b68cbd6df8da7ea31e');
INSERT INTO `s_user` VALUES ('3', 'user1', '219ccd6b0aea4b58797a435a63735095');
INSERT INTO `s_user` VALUES ('4', 'user', '16b552e0e08150a6a09fe2a6d13c1dc4');

-- ----------------------------
-- Table structure for s_user_role
-- ----------------------------
DROP TABLE IF EXISTS `s_user_role`;
CREATE TABLE `s_user_role` (
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户权限关联表';

-- ----------------------------
-- Records of s_user_role
-- ----------------------------
INSERT INTO `s_user_role` VALUES ('1', '1');
INSERT INTO `s_user_role` VALUES ('1', '2');
INSERT INTO `s_user_role` VALUES ('1', '3');
INSERT INTO `s_user_role` VALUES ('1', '4');
INSERT INTO `s_user_role` VALUES ('2', '4');
INSERT INTO `s_user_role` VALUES ('3', '3');
