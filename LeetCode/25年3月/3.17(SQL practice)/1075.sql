SELECT 
    project_id,ROUND(SUM(experience_years)/COUNT(employee_id),2) as average_years
FROM 
    Project NATURAL JOIN Employee
GROUP BY 
    project_id
