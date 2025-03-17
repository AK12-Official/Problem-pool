SELECT
    query_name,
    ROUND(AVG(rating/position),2) AS quality,
    -- ROUND((COUNT(rating<3)/COUNT(*))*100,2) AS poor_query_percentage         //错误的写法
    ROUND((SUM(CASE WHEN rating < 3 THEN 1 ELSE 0 END)/COUNT(*))*100,2) AS poor_query_percentage
FROM 
    Queries
GROUP BY
    query_name