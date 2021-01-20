/*
Navicat MySQL Data Transfer

Source Server         : ai
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : turing

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2021-01-16 04:01:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
