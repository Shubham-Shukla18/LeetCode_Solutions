/* Write your PL/SQL query statement below */
select 
    round(sum(case when a.rn=2 and a.lag=1 then 1 else 0 end)/count(distinct a.player_id), 2) as fraction
from (
    select player_id, event_date,
    row_number() over (partition by player_id order by event_date) as rn,
    event_date - lag(event_date, 1) over (partition by player_id order by event_date) as lag
    from Activity) a