/*
Navicat MySQL Data Transfer

Source Server         : ai
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : turing

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2021-01-16 04:01:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'book id',
  `book_name` varchar(255) NOT NULL COMMENT '书名',
  `category` varchar(255) DEFAULT NULL COMMENT '类别',
  `path` varchar(255) DEFAULT NULL COMMENT '存储路径',
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
