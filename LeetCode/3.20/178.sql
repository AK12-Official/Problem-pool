SELECT
    S1.score,
    (
        SELECT
            COUNT(DISTINCT S2.score)
        FROM
            Scores S2
        WHERE
            S2.score >= S1.score
    ) AS 'rank'
FROM
    Scores S1
ORDER BY
    S1.score DESC;

-- 主查询：括号外的部分
--     作用：遍历Scores表中的每个分数 并为每个分数计算排名
--     查询结果按照分数降序排列
-- 子查询：括号内的部分
--     作用：计算大于等于当前分数的不同分数的个数
--     查询结果即为当前分数的排名
SELECT
    score,
    DENSE_RANK() OVER (
        ORDER BY
            score DESC
    ) AS rank
FROM
    Scores;