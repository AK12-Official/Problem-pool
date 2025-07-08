CREATE VIEW
    temp AS
SELECT
    MAX(salary) AS salary,
    departmentId
FROM
    Employee
GROUP BY
    departmentId;

SELECT
    Department.name AS Department,
    Employee.name AS Employee,
    Employee.salary AS Salary
FROM
    Employee
    INNER JOIN Department ON Department.id = Employee.departmentId
    INNER JOIN temp ON Employee.salary = temp.salary
    AND Employee.departmentId = temp.departmentId;

-- 下面是最后交到力扣的写法 因为傻逼力扣似乎不支持视图
-- SELECT
--     Department.name AS Department,
--     Employee.name AS Employee,
--     Employee.salary AS Salary
-- FROM
--     Employee
--     INNER JOIN Department ON Department.id = Employee.departmentId
--     INNER JOIN (
--         SELECT
--             MAX(salary) AS salary,
--             departmentId
--         FROM
--             Employee
--         GROUP BY
--             departmentId
--     ) AS temp ON Employee.salary = temp.salary
--     AND Employee.departmentId = temp.departmentId;