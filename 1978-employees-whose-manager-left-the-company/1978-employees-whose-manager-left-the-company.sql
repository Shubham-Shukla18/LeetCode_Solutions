# Write your MySQL query statement below
/*
Approach=> set-based (not in)
TC=> O(nlogn)
SC=> O(1) with index or O(n)
Speed=> fast
object creation => minimal
memory pressure => low
Application => data integrity and orphan audit
*/

select employee_id
from Employees 
where salary < 30000
 and manager_id is not null
 and manager_id not in (select employee_id from Employees)
order by employee_id
