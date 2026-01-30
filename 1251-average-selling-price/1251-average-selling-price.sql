/* Write your PL/SQL query statement below */
select p.product_id, nvl(round(sum(us.units*p.price)/sum(us.units),2), 0) average_price
from Prices p
left join UnitsSold us on p.product_id=us.product_id
where us.product_id is null or us.purchase_date between p.start_date and p.end_date
group by p.product_id
