/*
student 学生
sc 成绩
course 课程
teacher 老师

第一题
查询平均成绩大于60分的学生id和成绩
如果在返回集字段中，这些字段要么就要包含在Group By语句的后面，作为分组的依据；要么就要被包含在聚合函数中。
*/

select SID,avg(SCORE) FROM sc GROUP BY SID HAVING avg(SCORE)>60;
/*
第二题
查询同时选课程ID"a"和课程ID"b"的学生学号和姓名
intersect 取交集
写法1
*/
select s.sid,s.sname from sc a,student s where a.sid=s.sid and a.cid="A"
intersect
select s.sid,s.sname from sc a,student s where a.sid=s.sid and a.cid="B";
/*
写法2
*/
select s.sid,s.name from sc a,student s where a.sid = s.sid and a.cid in ("A","B")
group by s.sid,s.sname having count(1)>1;/*因为是同时满足 所以每组的数据必须为2* 不加having则AB任意一门都会被查出*/

/*
第三题
查询任课老师姓名为smith的课程列表及其课程选修学生数量及平均成绩
 */
 select c.cid,c.cname,count(1),avg(s.score) from sc s,course c,teacher t
 where t.tname = "smith" and t.tid = c.tid and s.cid = c.cid group by c.cid,c.cname;