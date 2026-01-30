/* Write your PL/SQL query statement below */
select contest_id, round((count(user_id)/(select count(user_id) from users))*100, 2) percentage
from Register
group by contest_id
order by percentage desc, contest_id asc