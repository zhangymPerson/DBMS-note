# 测试sql的数据库创建
# 创建数据库 编码为utf8mb4;
create database IF NOT EXISTS test default character set utf8mb4 collate utf8mb4_unicode_ci;
-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) NOT NULL COMMENT '课程id',
  `course_name` varchar(255) DEFAULT NULL COMMENT '课程名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='课程信息表';

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '101', '语文');
INSERT INTO `course` VALUES ('2', '102', '数学');
INSERT INTO `course` VALUES ('3', '103', '历史');
INSERT INTO `course` VALUES ('4', '104', '计算机');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) DEFAULT NULL COMMENT '学生学号',
  `stu_name` varchar(50) DEFAULT NULL COMMENT '学生姓名',
  `stu_sex` varchar(5) DEFAULT NULL COMMENT '性别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='学生信息表';

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '1001', '张三', '男');
INSERT INTO `student` VALUES ('2', '1002', '李四', '女');
INSERT INTO `student` VALUES ('3', '1003', '王五', '女');
INSERT INTO `student` VALUES ('4', '1004', '刘柳', null);

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
INSERT INTO `stu_grade` VALUES ('9', '1003', '102', '98');
INSERT INTO `stu_grade` VALUES ('10', '1003', '103', '57');
INSERT INTO `stu_grade` VALUES ('11', '1003', '104', '67');
INSERT INTO `stu_grade` VALUES ('12', '1004', '101', '84');
INSERT INTO `stu_grade` VALUES ('13', '1004', '102', '23');
INSERT INTO `stu_grade` VALUES ('14', '1004', '103', '45');
INSERT INTO `stu_grade` VALUES ('15', '1004', '104', '100');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='教师信息表';

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '2019001', '老生常', '男');
INSERT INTO `teacher` VALUES ('2', '2019002', '王树忱', '女');
INSERT INTO `teacher` VALUES ('3', '2019003', '六三三', '女');
INSERT INTO `teacher` VALUES ('4', '2019004', '刘柳二', '');
