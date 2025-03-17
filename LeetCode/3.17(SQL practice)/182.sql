SELECT DISTINCT
    X.email AS Email 
FROM
    Person AS X INNER JOIN Person AS Y
ON 
    X.id<>Y.id 
WHERE 
    X.email=Y.email
    