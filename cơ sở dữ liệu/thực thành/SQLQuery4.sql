select *from Department where Department.DID not in (
  select DID
  from Student
)
select *from Department where Department.DID not in (
  select DID
  from  Courses
)
select *from Courses where Courses.CID not in (
  select CID
  from  Results
)

select *from Student where Student.SID not in (
  select SID
  from  Results
)
select *from Student where Student.SID not in (
  select SID
  from   Results 
  where  Results.SID in (SELECT AVG(Results.score) over (partition by SID) 
  from Results where Results.
 
)

--1
select * from Department
select * from Student
select * from Department where did not in 
(select DISTINCT did from Student)
--3
select * from Courses
select * from Results
select * from Courses where cid not in 
(select DISTINCT cid from Results)
--5
select * from Student where sid in 
(
select sid from Results group by sid 
having avg(score) < 7)
--6
select * from Results
UPDATE Results set score = 6 where sid = 's01' and cid = 'PM'
select * from Student where sid in (
select sid from Results group by sid having avg(score) = 
(select top 1 avg(score) from Results group by sid order by avg(score) desc ))
--7 
select * from Results
select * from Courses where cid in (
select cid from Results GROUP by cid having count(*) = 
(select top 1 count(*) from Results GROUP by cid order by count(*) desc))
--8
select * from Courses where cid not in (
select cid from Results group by cid having count(*) > 1)

