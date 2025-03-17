SELECT
    name AS Customers
FROM
    customers
WHERE
    id NOT IN (
        SELECT
            customer_id
        FROM
            Orders
    )