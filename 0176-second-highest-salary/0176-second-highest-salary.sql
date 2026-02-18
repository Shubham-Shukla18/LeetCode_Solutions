/* Write your PL/SQL query statement below */
select max(salary) SecondHighestSalary
from (
    select salary,
        dense_rank() over (order by salary desc) as rnk
    from Employee
)
where rnk=2