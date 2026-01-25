/* Write your PL/SQL query statement below */
select id
from (
    select id, recordDate, temperature,
    lag(temperature) over (order by recordDate) as prev_temp,
    lag(recordDate) over (order by recordDate) as prev_date
    from Weather
)
where temperature > prev_temp
and recordDate = prev_date+1;


/*select w1.id from Weather w1 join Weather w2 on w1.recordDate = w2.recordDate+1 where w1.temperature > w2.temperature;*/