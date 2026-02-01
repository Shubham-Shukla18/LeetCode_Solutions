/* Write your PL/SQL query statement below */
select distinct class
from Courses
group by class
having count(*) > 4;