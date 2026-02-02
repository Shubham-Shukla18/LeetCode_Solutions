/* Write your PL/SQL query statement below */
select employee_id, 
    coalesce(max(case when primary_flag='Y' then department_id end), min(department_id)) department_id
from employee
group by employee_id

-- select employee_id, department_id
-- from (
--     select employee_id, department_id, primary_flag, 
--         count(*) over (partition by employee_id) as dept_count
--     from employee
-- )
-- where primary_flag='Y'
--     or dept_count=1