# table-info

- 表信息
```sql
# 测试sql的数据库创建
# 创建数据库 编码为utf8mb4;
create database IF NOT EXISTS test default character set utf8mb4 collate utf8mb4_unicode_ci;

######################## v1.0 版本###############################
#学生信息表
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) DEFAULT NULL COMMENT '学生学号',
  `stu_name` varchar(50) DEFAULT NULL COMMENT '学生姓名',
  `stu_sex` varchar(5) DEFAULT NULL COMMENT '性别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='学生信息表';

#教师信息表
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tea_id` int(11) DEFAULT NULL COMMENT '教师编号',
  `tea_name` varchar(50) DEFAULT NULL COMMENT '教师姓名',
  `tea_sex` varchar(5) DEFAULT NULL COMMENT '性别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='教师信息表';

# 学生成绩表
CREATE TABLE `stu_grade` (
  `id` int(11) NOT NULL,
  `stu_id` int(11) DEFAULT NULL COMMENT '学号',
  `course_id` int(11) DEFAULT NULL COMMENT '课程号',
  `grade` int(11) DEFAULT NULL COMMENT '成绩',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学生成绩表';

# 课程信息表
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) NOT NULL COMMENT '课程id',
  `course_name` varchar(255) DEFAULT NULL COMMENT '课程名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='课程信息表';


```