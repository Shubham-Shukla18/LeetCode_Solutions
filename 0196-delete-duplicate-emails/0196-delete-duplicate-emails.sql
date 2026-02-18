/* Write your PL/SQL query statement below */
-- delete from Person
-- where id in (
--     select id
--     from (
--         select id,
--             row_number() over(partition by email order by id) rn
--         from Person
--     ) 
--     where rn>1
-- )

delete from Person p where p.email in (select email from person p1 where p.id > p1.id)