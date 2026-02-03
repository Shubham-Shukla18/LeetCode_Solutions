/* Write your PL/SQL query statement below */

/*
Approach=> Single scan Join
TC=> O(n)
SC=> O(1)
Speed=> faster on large datasets
object creation => minimal(one join)
memory pressure =>low
Application => Batch financial Analytics
*/
select t.category, count(a.account_id) as accounts_count
from (
    select 'Low Salary' as category from dual union all
    select 'Average Salary' as category from dual union all
    select 'High Salary' as category from dual
) t
left join Accounts a on 
    (t.category = 'Low Salary' and a.income<20000) or
    (t.category = 'Average Salary' and a.income between 20000 and 50000) or
    (t.category = 'High Salary' and a.income>50000)
group by t.category;


/*
Approach=> union all
TC=> O(n*3)
SC=> O(1)
Speed=> Moderate
object creation => Higher(three queries)
memory pressure => low
Application => Simple Reporting
*/
-- select 'Low Salary' as category, count(*) accounts_count
-- from Accounts
-- where income < 20000
-- union all
-- select 'Average Salary' as category, count(*) accounts_count
-- from Accounts
-- where income >= 20000 and income <= 50000
-- union all
-- select 'High Salary' as category, count(*) accounts_count
-- from Accounts
-- where income > 50000


