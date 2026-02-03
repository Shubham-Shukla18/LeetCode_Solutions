/* Write your PL/SQL query statement below */
/*
Approach=> Optimized lag1, lag2
TC=> O(nlogn)
SC=> O(n)
Speed=> fast
object creation => minimal
memory pressure => low
Application => Sensor data Spikes
*/ 
select distinct num ConsecutiveNums
from (
    select id, num,
        lag(num, 1, null) over (order by id) prev1, 
        lag(num, 2, null) over (order by id) prev2
    from Logs
)
where num = prev1 and prev1 = prev2;