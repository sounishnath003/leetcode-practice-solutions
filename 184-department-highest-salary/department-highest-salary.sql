# Write your MySQL query statement below
WITH deptWiseMaxSal AS (
    SELECT departmentId, MAX(salary) AS maxSal
    FROM employee
    GROUP BY departmentId
)
SELECT d.name AS Department, e.name AS Employee, e.salary AS Salary
FROM employee e
JOIN deptWiseMaxSal ds ON e.departmentId = ds.departmentId
JOIN department d ON e.departmentId = d.id
WHERE e.salary = ds.maxSal;
