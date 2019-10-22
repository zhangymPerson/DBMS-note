# 数据库面试相关的sql问题记录


- 表信息

	[表信息sql](table-info.md)

	[数据](database-test.sql) 

- sql 练习
```sql
-- 查询“101”课程比“102”课程成绩高的所有学生的学号；
select * from stu_grade;
select a.stu_id from (select stu_id,grade from stu_grade where course_id = 101) a , (select stu_id,grade from stu_grade where course_id = 102) b where a.stu_id = b.stu_id AND a.grade > b.grade;


-- 查询平均成绩大于60分的同学的学号和平均成绩；
select * from stu_grade;
select stu_id,AVG(grade) from stu_grade GROUP BY stu_id HAVING avg(grade) > 60;

-- 查询所有同学的学号、姓名、选课数、总成绩；
select a.stu_id, b.stu_name,COUNT(a.course_id),sum(a.grade) from stu_grade a  LEFT JOIN student b on a.stu_id = b.stu_id GROUP BY a.stu_id ; 


-- 查询姓“李”的老师的个数；
select * from teacher;
select count(DISTINCT tea_id) from teacher t where t.tea_name like "李%";

-- 查询没学过“叶平”老师课的同学的学号、姓名； not in 

SELECT
	*
FROM
	student
WHERE
	stu_id NOT IN (
		SELECT DISTINCT
			d.stu_id
		FROM
			stu_grade d
		LEFT JOIN (
			SELECT
				b.course_id
			FROM
				(
					SELECT
						t.tea_id
					FROM
						teacher t
					WHERE
						t.tea_name = "叶平"
				) a
			LEFT JOIN course b ON a.tea_id = b.tea_id
		) c ON c.course_id = d.course_id
	);


-- 查询学过“001”并且也学过编号“002”课程的同学的学号、姓名；
-- inner join 是同时符合前后条件的查询
select a.stu_id from stu_grade a INNER JOIN stu_grade b on a.stu_id = b.stu_id where a.course_id =101 and b.course_id = 102

select a.stu_id,b.stu_name from (select a.stu_id from stu_grade a INNER JOIN stu_grade b on a.stu_id = b.stu_id where a.course_id =101 and b.course_id = 102) a LEFT JOIN student b on a.stu_id = b.stu_id;




-- 查询课程编号“103”的成绩比课程编号“104”课程低的所有同学的学号、姓名；
select a.stu_id FROM (select * from stu_grade where course_id = '103' ) a left JOIN (select * from stu_grade where course_id = '104')b on a.stu_id = b.stu_id where a.grade < b.grade;



-- 查询各科成绩最高和最低的分：以如下形式显示：课程ID，最高分，最低分

select * from stu_grade;

select course_id, max(grade),min(grade) from stu_grade GROUP BY course_id;

-- 统计列印各科成绩,各分数段人数:课程ID,课程名称,[100-85],[85-70],[70-60],[ <60]


SELECT
	a.course_id,
	b.course_name,
	a.`[85-100]`,
	a.`[70-85]`,
	a.`[60-70]`,
	a.`[<60]`
FROM
	(
		SELECT
			course_id,
			sum(
				CASE
				WHEN grade BETWEEN 85
				AND 100 THEN
					1
				ELSE
					0
				END
			) AS '[85-100]',
			sum(
				CASE
				WHEN grade BETWEEN 70
				AND 85 THEN
					1
				ELSE
					0
				END
			) AS '[70-85]',
			sum(
				CASE
				WHEN grade BETWEEN 60
				AND 70 THEN
					1
				ELSE
					0
				END
			) AS '[60-70]',
			sum(
				CASE
				WHEN grade BETWEEN 0
				AND 60 THEN
					1
				ELSE
					0
				END
			) AS '[<60]'
		FROM
			stu_grade
		GROUP BY
			course_id
	) a
LEFT JOIN course b ON a.course_id = b.course_id;


-- 查询所有专业的学生的成绩排名前3的学生




```