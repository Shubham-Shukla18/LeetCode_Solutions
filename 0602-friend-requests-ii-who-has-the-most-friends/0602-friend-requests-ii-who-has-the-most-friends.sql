/* Write your PL/SQL query statement below */
select id, num
from (
    select id, count(*) num, max(count(*)) over() max_count
    from (
        select requester_id as id from RequestAccepted
        union all
        select accepter_id from RequestAccepted
    )
    group by id
)
where num=max_count