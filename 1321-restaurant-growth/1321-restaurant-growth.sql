/* Write your PL/SQL query statement below */

SELECT TO_CHAR(visited_on, 'YYYY-MM-DD') AS visited_on,
       amount,
       average_amount
FROM (
    SELECT visited_on,
           -- Calculate 7-day total revenue
           SUM(day_sum) OVER (ORDER BY visited_on 
               ROWS BETWEEN 6 PRECEDING AND CURRENT ROW) AS amount,
           -- Calculate average using multiplication (faster than division in some ALUs)
           ROUND(SUM(day_sum) OVER (ORDER BY visited_on 
               ROWS BETWEEN 6 PRECEDING AND CURRENT ROW) * 0.142857, 2) AS average_amount,
           -- Filter using a single window pointer
           COUNT(*) OVER (ORDER BY visited_on 
               ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW) as row_num
    FROM (
        SELECT visited_on, SUM(amount) as day_sum
        FROM Customer
        GROUP BY visited_on
    )
)
WHERE row_num >= 7
ORDER BY visited_on;