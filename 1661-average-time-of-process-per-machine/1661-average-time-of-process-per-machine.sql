/* Write your PL/SQL query statement below */
--self join, TC=>O(n^2), SC=>O(n), best for small dataset
-- select a1.machine_id machine_id, 
--     round(avg(a2.timestamp-a1.timestamp),3) processing_time
-- from Activity a1
--     join Activity a2
--     on a1.machine_id=a2.machine_id 
--         and a1.process_id=a2.process_id
--         and a1.activity_type='start'
--         and a2.activity_type='end'
-- group by a1.machine_id;

-- CTE (group by), TC=>O(nlogn), SC=>O(n), best for medium data set and debugging
-- with processing as (
--     select machine_id, abs(max(timestamp)-min(timestamp)) diff
--     from Activity
--     group by machine_id, process_id
-- )

-- select machine_id, round(avg(diff), 3) processing_time
-- from processing
-- group by machine_id;

-- conditional sum, TC=>O(n), SC=>O(k), best for high scale production system
SELECT 
    machine_id, 
    ROUND(
        SUM(CASE WHEN activity_type = 'end' THEN timestamp ELSE -timestamp END) 
        / (COUNT(timestamp) / 2), 
    3) AS processing_time
FROM Activity
GROUP BY machine_id;