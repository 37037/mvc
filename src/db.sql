CREATE DATABASE emp DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
create table t_emp(
empno int auto_increment primary key,
ename varchar(20),
job varchar(10),
mgr int,
hiredate date,
sal double,
comm double,
deptno int
);
insert into t_emp(ename,job,mgr,hiredate,sal,comm,deptno) values
('SMITH','CLERK',3,'1980-5-12',800,NULL,20);
insert into t_emp(ename,job,mgr,hiredate,sal,comm,deptno) values
('ALLEN','SALESMAN',3,'1981-6-3',1600,300,30);
insert into t_emp(ename,job,mgr,hiredate,sal,comm,deptno) values
('WARD','SALESMAN',4,'1990-3-15',1250,500,30);
insert into t_emp(ename,job,mgr,hiredate,sal,comm,deptno) values
('JONES','MANAGER',5,'1985-4-8',2975,NULL,20);
insert into t_emp(ename,job,mgr,hiredate,sal,comm,deptno) values
('MARTIN','SALESMAN',7,'1986-3-8',1250,1400,30);
insert into t_emp(ename,job,mgr,hiredate,sal,comm,deptno) values
('BLAKE','MANAGER',9,'1989-6-1',2850,NULL,30);
insert into t_emp(ename,job,mgr,hiredate,sal,comm,deptno) values
('CLARK','MANAGER',9,'1995-10-1',2450,NULL,10);
insert into t_emp(ename,job,mgr,hiredate,sal,comm,deptno) values
('SCOTT','ANALYST',9,'1993-5-1',3000,NULL,20);
insert into t_emp(ename,job,mgr,hiredate,sal,comm,deptno) values
('KING','PRESIDENT',NULL,'1988-8-8',5000,NULL,10);
insert into t_emp(ename,job,mgr,hiredate,sal,comm,deptno) values
('TURNER','SALESMAN',5,'1983-2-1',1500,0,30);
insert into t_emp(ename,job,mgr,hiredate,sal,comm,deptno) values
('ADAMS','CLERK',5,'1992-7-3',1100,NULL,20);
insert into t_emp(ename,job,mgr,hiredate,sal,comm,deptno) values
('JAMES','CLERK',1,'1996-9-10',950,NULL,30);
insert into t_emp(ename,job,mgr,hiredate,sal,comm,deptno) values
('FORD','ANALYST',1,'1993-1-1',3000,NULL,20);
insert into t_emp(ename,job,mgr,hiredate,sal,comm,deptno) values
('MILLER','CLERK',3,'1983-10-9',1300,NULL,10);

