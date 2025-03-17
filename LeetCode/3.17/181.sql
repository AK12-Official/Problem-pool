SELECT X.name AS Employee
FROM Employee AS X INNER JOIN Employee AS Y
on X.managerID=Y.id
WHERE X.salary>Y.salary