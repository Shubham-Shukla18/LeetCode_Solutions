/* Write your PL/SQL query statement below */
select department, employee, salary
from (
    select d.name department, e.name employee, e.salary salary,
        dense_rank() over (partition by e.departmentId order by e.salary desc) rnk
    from Employee e
    inner join department d on e.departmentId=d.id
)
where rnk <=3