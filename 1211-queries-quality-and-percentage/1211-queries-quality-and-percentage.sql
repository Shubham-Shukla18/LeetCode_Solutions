/* Write your PL/SQL query statement below */
select query_name, 
    round(sum(rating/position)/count(rating), 2) quality,
    round((count(case when rating < 3 then 1 end)/count(rating))*100, 2) poor_query_percentage
from Queries
group by query_name;