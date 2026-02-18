/* Write your PL/SQL query statement below */
with same_tiv_2015 as (
    select tiv_2015, count(tiv_2015)
    from Insurance
    group by tiv_2015
    having count(tiv_2015) > 1
),
unique_coordinates as (
    select lat || ',' || lon coords, count(lat || ',' || lon)
    from Insurance
    group by lat || ',' || lon
    having count(lat || ',' || lon)=1
)

select round(sum(tiv_2016), 2) tiv_2016
from Insurance i
inner join same_tiv_2015 st
    on i.tiv_2015=st.tiv_2015
inner join unique_coordinates uc
    on (i.lat || ',' || i.lon)=uc.coords
