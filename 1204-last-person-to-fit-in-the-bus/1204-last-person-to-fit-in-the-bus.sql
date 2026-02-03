/* Write your PL/SQL query statement below */
select max(person_name) keep (dense_rank last order by cumulative_sum) person_name
from (
    select person_name,
        sum(weight) over(order by turn asc) cumulative_sum
    from 
    Queue
) 
where cumulative_sum<=1000

