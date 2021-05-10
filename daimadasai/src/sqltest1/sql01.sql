
/*
查询取出成绩不及格（60分及以上为及格）的学生和不及格的科目。
 */
select student,course,score from student_score where score<60;
/*
查询取出每个学生三科成绩的平均分，并从低到高排序
 */
select student,avg(score) as avg_score from student_score
group by student order by avg_score asc;
/*
老师发现小红的数学成绩不是92，应该是90，请用一个语句修改表中内容。(
 */
update student_score set score = 90 where student = "小红" and course = "数学";

insert into student_score values ("5","乐乐","语文","79");
/*
请用一个查询取出每科成绩中的最高分
 */
select * from student where score in
(select max(score) as score from student group by course);
/*
2
*/

/*
找出员工人数大于或等于4的部门和该部门人数
 */
select d.Name,e.count from department as d,
(select DepartmentId,count(*) as count from employee
GROUP BY DepartmentId HAVING count(1)>=4) as e where d.Id =e.DepartmentId ;

select d.`Name` as Department,count(*) as Cnt from department as d
LEFT JOIN employee as e on e.DepartmentId = d.Id GROUP BY e.DepartmentId HAVING count(*)>=4;

/*
找出每个部门年龄最大的员工
 */
select t1.Name as Department,t3.Name as employee,t2.Age as Age
from
department as t1
inner join
(select DepartmentId,max(Age) as Age from employee GROUP BY DepartmentId) as t2
on t2.DepartmentId = t1.Id
inner join
employee as t3
on t2.DepartmentId = t3.DepartmentId
where
t3.Age = t2.Age;

/*
请编写删除SQL语句，批量删除除了序号不同, 其他都相同的客户信息
 */
delete Customer_info
where id not in  /* 通过group by 找到所有相同属性数据的分组 */
(select min( id) from Customer_info group by Cust_id, Cust_Nm, Age, Gender);

/*
请用一段SQL取出每个账户的平均交易金额，并按照平均交易金额从高到低排序
 */
SELECT acct,avg(tx_amt) FROM cu group by acct ORDER BY avg(tx_amt) desc;
/*
请用一段SQL查询出2019年02月 05日之后（包含2019-02-05日）的交易金额最大的交易，包含账号、机构、交易金额、交易日期
 */
 SELECT acct,org,tx_amt,tx_dt FROM cu where tx_dt >='2019-02-05' ORDER BY tx_amt desc;
limit 1;