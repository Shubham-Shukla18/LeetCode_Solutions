/* Write your PL/SQL query statement below */
/*
Approach=> set join
TC=> O(nlogn)
SC=> O(n+p)(p=unique product)
Speed=> slightly slower (require join)
object creation => Higher(twp subqueries +join)
memory pressure => low(sort only filter row)
Application => clean analytic/reporting
*/
-- select product_id, coalesce(price, 10) price
-- from (
--     select distinct product_id, 
--         first_value(new_price) over(partition by product_id order by change_date desc) price
--     from Products
--     where change_date <= '2019-08-16'
-- ) t1
-- right join (select distinct product_id from Products) t2 using (product_id)



/*
Approach=> Sorting trick
TC=> O(nlogn)
SC=> O(n)
Speed=> faster(single pass)
object creation => minimal(one inline view)
memory pressure => Moderate (sorts all rows)
Application => complex ranking logic
*/
select product_id, case when change_date<='2019-08-16' then new_price else 10 end price
from (
    select product_id, new_price, change_date,
        row_number() over(partition by product_id order by case when change_date<='2019-08-16' then 1 else 2 end,        change_date desc) rn
    from Products
) 
where rn=1;