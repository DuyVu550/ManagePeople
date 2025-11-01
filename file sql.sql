-- -------------------- Choose all employee
-- select * 
-- from attendance a, departments b, employees c
-- where a.employ_id = c.employ_id and c.departments_id = b.departments_id;
-- ------------------ choose department which has the most employees
-- with temp_table as
-- (
--   select a.name, count(a.departments_id) as number_employee
--   from departments a, employees b
--   where a.departments_id = b.departments_id
--   group by a.name
-- )
-- select * 
-- from temp_table
-- where number_employee =
-- (
-- select max(number_employee)
-- from temp_table
-- )
-- ------------------------------- choose highest salary, lowest salary
--  select c.name, max(amount) as highest_salary, min(amount) as lowest_salary
--  from pay_roll a, employees b, departments c
--  where a.employ_id = b.employ_id and c.departments_id = b.departments_id
--  group by name
-- --------------------------------- choose employee who has the lowest days in company
-- select *
-- from attendance a, employees b
-- where a.employ_id = b.employ_id and 
-- a.attendance_date = (
--   select min(attendance_date)
--   from attendance
-- )
-- ------------------------------------------ sort the day-off from highest to lowest
-- select b.name, timestampdiff(year, attendance_date, curdate()) * 12 as day_off
-- from attendance a, employees b
-- where a.employ_id = b.employ_id
-- order by day_off desc















