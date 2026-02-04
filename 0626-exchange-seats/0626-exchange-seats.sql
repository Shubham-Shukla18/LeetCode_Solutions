/* Write your PL/SQL query statement below */

/*
Approach=> Arithmetic (MAX/MOD)
TC=> O(nlogn) (Sort+scalar subquery)
SC=> O(n)(Sort Buffer only)
Speed=> fastest
object creation => minimal
memory pressure => low
Application => Bulk key reassignment
*/
-- select 
--     case 
--         when mod(id, 2)!=0 and id=(select Max(id) from Seat) then id
--         when mod(id, 2)!=0 then id+1
--         else id-1
--     end id,
--     student
-- from Seat
-- order by id;

select 
case when   mod(id,2)=1 and lead(id) over (order by id asc) is not null then lead(id) over (order by id asc) 
    when mod(id,2)=0 then lag(id) over (order by id asc) 
    else id end as id, student
    
from Seat 
order by id asc