/* Write your PL/SQL query statement below */
select distinct e2.employee_id, e2.name, count(*) reports_count, round(avg(e1.age)) average_age
from Employees e1
join Employees e2 on e1.reports_to = e2.employee_id
group by e2.employee_id, e2.name
order by e2.employee_id;