/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50721
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2019-04-24 11:45:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) NOT NULL COMMENT '课程id',
  `course_name` varchar(255) DEFAULT NULL COMMENT '课程名称',
  `tea_id` int(11) DEFAULT NULL COMMENT '授课教师ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COMMENT='课程信息表';

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '101', '语文', '2019001');
INSERT INTO `course` VALUES ('2', '102', '数学', '2019003');
INSERT INTO `course` VALUES ('3', '103', '历史', '2019004');
INSERT INTO `course` VALUES ('4', '104', '计算机', '2019002');
INSERT INTO `course` VALUES ('5', '105', '教育技术学', '2019004');
INSERT INTO `course` VALUES ('6', '106', '展览学', '2019002');
INSERT INTO `course` VALUES ('7', '107', 'C语言编程', '2019002');
INSERT INTO `course` VALUES ('8', '108', 'Java语言编程', '2019002');
INSERT INTO `course` VALUES ('9', '109', '高等数学', '2019003');
INSERT INTO `course` VALUES ('10', '110', '毛概', '2019004');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) DEFAULT NULL COMMENT '学生学号',
  `stu_name` varchar(50) DEFAULT NULL COMMENT '学生姓名',
  `stu_age` int(11) DEFAULT NULL COMMENT '学生年龄',
  `stu_sex` varchar(5) DEFAULT NULL COMMENT '性别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COMMENT='学生信息表';

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '1001', '张三', '14', '男');
INSERT INTO `student` VALUES ('2', '1002', '李四', '15', '女');
INSERT INTO `student` VALUES ('3', '1003', '王五', '15', '女');
INSERT INTO `student` VALUES ('4', '1004', '刘柳', '14', '女');
INSERT INTO `student` VALUES ('5', '1005', '李看书', '13', '男');
INSERT INTO `student` VALUES ('6', '1006', '于强', '14', '男');
INSERT INTO `student` VALUES ('7', '1007', '苏大强', '15', '女');
INSERT INTO `student` VALUES ('8', '1008', '苏明宇', '12', '男');
INSERT INTO `student` VALUES ('9', '1009', '苏有朋', '13', '女');
INSERT INTO `student` VALUES ('10', '1010', '王丽丽', '13', '男');
INSERT INTO `student` VALUES ('11', '1011', '王不输', '14', '女');

-- ----------------------------
-- Table structure for stu_grade
-- ----------------------------
DROP TABLE IF EXISTS `stu_grade`;
CREATE TABLE `stu_grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) DEFAULT NULL COMMENT '学号',
  `course_id` int(11) DEFAULT NULL COMMENT '课程号',
  `grade` int(11) DEFAULT NULL COMMENT '成绩',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COMMENT='学生成绩表';

-- ----------------------------
-- Records of stu_grade
-- ----------------------------
INSERT INTO `stu_grade` VALUES ('1', '1001', '101', '68');
INSERT INTO `stu_grade` VALUES ('2', '1001', '102', '89');
INSERT INTO `stu_grade` VALUES ('3', '1001', '103', '87');
INSERT INTO `stu_grade` VALUES ('4', '1002', '101', '98');
INSERT INTO `stu_grade` VALUES ('5', '1002', '102', '67');
INSERT INTO `stu_grade` VALUES ('6', '1002', '103', '87');
INSERT INTO `stu_grade` VALUES ('7', '1002', '104', '67');
INSERT INTO `stu_grade` VALUES ('8', '1003', '101', '87');
INSERT INTO `stu_grade` VALUES ('9', '1003', '105', '98');
INSERT INTO `stu_grade` VALUES ('10', '1003', '103', '57');
INSERT INTO `stu_grade` VALUES ('11', '1003', '104', '67');
INSERT INTO `stu_grade` VALUES ('12', '1004', '101', '84');
INSERT INTO `stu_grade` VALUES ('13', '1004', '105', '23');
INSERT INTO `stu_grade` VALUES ('14', '1004', '103', '45');
INSERT INTO `stu_grade` VALUES ('15', '1004', '104', '12');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tea_id` int(11) DEFAULT NULL COMMENT '教师编号',
  `tea_name` varchar(50) DEFAULT NULL COMMENT '教师姓名',
  `tea_sex` varchar(5) DEFAULT NULL COMMENT '性别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COMMENT='教师信息表';

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '2019001', '老生常', '男');
INSERT INTO `teacher` VALUES ('2', '2019002', '王树忱', '女');
INSERT INTO `teacher` VALUES ('3', '2019003', '叶平', '女');
INSERT INTO `teacher` VALUES ('4', '2019004', '刘柳二', '');
INSERT INTO `teacher` VALUES ('5', '2019005', '李乐乐', '男');
INSERT INTO `teacher` VALUES ('6', '2019006', '乔李斯', '女');
INSERT INTO `teacher` VALUES ('7', '2019007', '李琉璃', '男');
