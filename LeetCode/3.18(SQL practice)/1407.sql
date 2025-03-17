SELECT
    name,
    COALESCE(SUM(distance), 0) AS travelled_distance
FROM
    Users LEFT OUTER JOIN Rides 
ON 
    Users.id=user_id
GROUP BY 
    user_id
    ,name
    -- 在 SQL 查询中，当使用 GROUP BY 子句时，所有在 SELECT 子句中出现的非聚合列都必须包含在 GROUP BY 子句中。这是因为 SQL 需要知道如何对这些列进行分组。
    -- 在某些数据库系统中（例如 MySQL），在 GROUP BY 子句中不包含所有非聚合列的情况下，查询仍然可以执行。这是因为这些数据库系统允许使用扩展的 GROUP BY 语法，
    -- 默认情况下会选择 GROUP BY 子句中未列出的非聚合列的任意值。这种行为可能会导致不可预测的结果，因此在标准 SQL 中是不推荐的
ORDER BY 
    travelled_distance DESC