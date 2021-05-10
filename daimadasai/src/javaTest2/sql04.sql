/*

*/


select
    e.DepartmentId as id,
    d.Name as name ,
    count(e.Id) as num,
    avg(e.salary) as avgSa
from employee e left join department d
on e.DepartmentId = d.Id
GROUP BY DepartmentId;