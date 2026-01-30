/* Write your PL/SQL query statement below */

with FirstOrders AS (
    select customer_id,
        order_date,
        customer_pref_delivery_date,
        -- Rank orders for each customer by date
        row_number() over (partition by customer_id order by order_date asc) as rn
    from Delivery
)

select round((count(case when order_date=customer_pref_delivery_date then 1 end)/count(*)*100), 2) immediate_percentage
from FirstOrders
where rn = 1;