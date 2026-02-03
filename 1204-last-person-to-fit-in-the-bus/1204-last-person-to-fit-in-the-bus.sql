/* Write your PL/SQL query statement below */

/*
Approach=> using keep 
TC=> O(n)
SC=> O(1)
Speed=> fastest
object creation => none
memory pressure => low
Application => reporting/dashboards
*/
select max(person_name) keep (dense_rank last order by cumulative_sum) person_name
from (
    select person_name,
        sum(weight) over(order by turn asc) cumulative_sum
    from 
    Queue
) 
where cumulative_sum<=1000