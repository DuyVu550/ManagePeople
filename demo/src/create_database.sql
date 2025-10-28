create database HR_Management;
use HR_Management;
create table Users(
UserId int auto_increment primary key,
username nvarchar(50) not null,
Password varchar(50) not null,
role enum('HR', 'Employee') not null
);
-- -----------------------
create table Departments(
departmentsId int auto_increment primary key,
name nvarchar(50)
);
-- ----------------------
create table Employees(
EmployId int auto_increment primary key,
name nvarchar(50) not null,
age int not null,
address nvarchar(100) not null,
departmentsID int,
avater varchar(100),
salaryRate decimal,
Check(age >= 18),
Foreign key (departmentsID) references Departments(departmentsId)
);
-- ---------------------------
create table Attendance(
attendanceID int auto_increment primary key,
EmployId int,
attendanceDate date not null,
checkIn_time datetime not null,
CheckOut_time datetime not null,
Foreign key (EmployId) references Employees(EmployId)
);
-- -----------------------------
create table Payroll(
payRollID int auto_increment primary key,
EmployId int,
month date not null,
amount decimal not null,
payment_date date not null,
Foreign key (EmployId) references Employees(EmployId)
);
-- -------------------------------
create table LeaveRequest(
leaveRequestID int auto_increment primary key,
EmployId int,
startDate date not null,
endDate date not null,
type enum("paid", "unpaid"),
reason nvarchar(120),
status enum("pending", "approved", "rejected"),
Foreign key (EmployId) references Employees(EmployId)
);
-- create indexes
create index isd_department on Employees(departmentsId); -- departments
create index isd_name on Employees(name); -- find name employee
create index isd_attendance_date on Attendance(attendanceDate); -- find attend date
create index isd_employId on Attendance(EmployId);
create index isd_employId_payroll on PayRoll(EmployId);
create index isd_month on PayRoll(month);
create index isd_employId_leaveRequest on LeaveRequest(EmployId);
-- status
create index isd_status on LeaveRequest(status);




