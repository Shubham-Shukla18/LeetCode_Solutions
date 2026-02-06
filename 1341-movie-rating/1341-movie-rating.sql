/* Write your PL/SQL query statement below */
with tmp_t1 as (
    select * 
    from (
        select u.name, count(mr.rating) total_rating
        from Users u
        join MovieRating mr on u.user_id = mr.user_id
        group by u.name
        order by total_rating desc, u.name asc
    )
    where rownum=1
), tmp_t2 as (
    select * 
    from (
        select m.title, avg(mr.rating) avg_rating
        from Movies m
        join MovieRating mr on m.movie_id = mr.movie_id
        where to_char(mr.created_at, 'yyyy-mm') = '2020-02'
        group by m.title
        order by avg_rating desc, m.title asc
    )
    where rownum=1
)

select name as results from tmp_t1
union all
select title as results from tmp_t2;