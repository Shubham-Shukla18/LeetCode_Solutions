/* Write your PL/SQL query statement below */
with directReport as (
    select managerId
    from Employee
    group by managerId
    having count(managerId)>=5 and managerId is not null
)

select name
from Employee 
where id in (select managerId from directReport);