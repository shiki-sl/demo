/*
Navicat MySQL Data Transfer

Source Server         : shiki
Source Server Version : 50726
Source Host           : 192.168.1.197:3306
Source Database       : sl_demo

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-06-26 09:56:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for s_perms
-- ----------------------------
DROP TABLE IF EXISTS `s_perms`;
CREATE TABLE `s_perms` (
  `perms_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '权限id',
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
  `role_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '权限id',
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
  `role_id` int(20) NOT NULL COMMENT '角色id',
  `perms_id` int(20) NOT NULL COMMENT '权限id',
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
  `user_id` int(20) NOT NULL COMMENT '文章所属用户',
  `text_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '文章id',
  `title` varchar(20) DEFAULT NULL COMMENT '文章标题',
  `text` text COMMENT '文章正文',
  `create_time` bigint(13) DEFAULT NULL,
  `is_delete` bit(1) DEFAULT b'0' COMMENT '是否被删除',
  PRIMARY KEY (`text_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_text
-- ----------------------------
INSERT INTO `s_text` VALUES ('1', '1', '特', '额', '1561357173316', '');
INSERT INTO `s_text` VALUES ('1', '2', 'test标题', 'test文章', '1561357173316', '\0');
INSERT INTO `s_text` VALUES ('2', '3', '123456', '123456', '1561357173316', '\0');
INSERT INTO `s_text` VALUES ('1', '4', 'test', '萨达萨达是发生发生发生飞洒发生的服务器发士大夫撒给v现场v在这些asdasfsagsad干撒广东省搭嘎是个撒个撒个撒个的撒干啥事嘎洒上', '1561357173316', '\0');
INSERT INTO `s_text` VALUES ('3', '5', 'date', '时间', '1561357173316', '\0');
INSERT INTO `s_text` VALUES ('4', '6', 'test', '测试', '1561456711389', '\0');
INSERT INTO `s_text` VALUES ('4', '7', '文章', '-_-', '1561456711389', '\0');
INSERT INTO `s_text` VALUES ('4', '8', '测试', 'weqaareq', '1561456711389', '\0');
INSERT INTO `s_text` VALUES ('4', '9', '2', '2', '1561456711389', '\0');
INSERT INTO `s_text` VALUES ('3', '10', '312', '3123123', '1561456711389', '\0');
INSERT INTO `s_text` VALUES ('3', '11', '1223', '12', '1561456711389', '\0');

-- ----------------------------
-- Table structure for s_user
-- ----------------------------
DROP TABLE IF EXISTS `s_user`;
CREATE TABLE `s_user` (
  `user_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_user
-- ----------------------------
INSERT INTO `s_user` VALUES ('1', 'root', '1');
INSERT INTO `s_user` VALUES ('2', 'test_user', '123456');
INSERT INTO `s_user` VALUES ('3', 'user1', '1');
INSERT INTO `s_user` VALUES ('4', 'user', '3');

-- ----------------------------
-- Table structure for s_user_role
-- ----------------------------
DROP TABLE IF EXISTS `s_user_role`;
CREATE TABLE `s_user_role` (
  `user_id` int(20) NOT NULL COMMENT '用户id',
  `role_id` int(20) NOT NULL COMMENT '角色id',
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
