
SELECT NAME,BALANCE
FROM(
    SELECT 
        name AS NAME,SUM(amount) AS BALANCE
    FROM
        Users NATURAL JOIN Transactions 
    GROUP BY
        account,name
)AS temp
WHERE
    BALANCE >10000
