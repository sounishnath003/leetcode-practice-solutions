# Write your MySQL query statement below
with fil as (
    with deptWiseMaxSal as (
        select e.departmentId, max(e.salary) as maxSal
        from employee e
        group by e.departmentId
    )
    select e.*
    from employee e
    join deptWiseMaxSal ds
    where e.departmentId=ds.departmentId and e.salary=ds.maxSal
)
select d.name as Department, ds.name as Employee, ds.salary as Salary
    from fil as ds
    join department d
on ds.departmentId=d.id;