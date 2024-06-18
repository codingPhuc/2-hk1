create database qltv
--Cau1
create table sach
(
	ms varchar(10) primary key,
	ts nvarchar(50),
	nxb nvarchar(50),
	tg nvarchar(50),
	sl int
)
create table docgia
(
	madg varchar(10) primary key,
	tendg nvarchar(50),
	ngaydk date,
	dienthoai varchar(11)
)
create table muonsach
(
	madg varchar(10),
	ms varchar(10),
	nm date,
	nt date
	primary key (madg, ms),
	foreign key (madg) references docgia(madg),
	foreign key (ms) references sach(ms)
)
--Drop table muonsach
--Cau 2
alter table sach add constraint ckSL 
check (sl between 0 and 10)
--cau 3
alter table muonsach add constraint ckNMNT
check (nm <= nt)
--Cau 4
alter table docgia add constraint dfDT
default N'Không có' for dienthoai
--Câu 5
insert into sach values('S01', N'Lập trình C', 
N'Kim Đồng', N'Trần Thanh Phước', 5)
insert into sach values('S02', N'Hệ CSDL', 
N'Thánh Gióng', N'Nguyễn Văn Tèo', 6)
insert into sach values('S03', N'Lập trình web', 
N'Minh Khia', N'Vũ ĐÌnh Hồng', 10)
--Câu 6
insert into docgia values ('dg01', N'Lê Quang Lộc',
'2018-2-2', '234234345')
insert into docgia values ('dg02', N'Lê Duy Linh',
'2017-2-2', '234234345')
insert into docgia values ('dg03', N'Đỗ Trâm Anh',
'2019-1-1', '234234345')
--Câu 7
insert into muonsach values('dg01', 's01', 
'2018-10-10', '2018-10-10')
insert into muonsach values('dg02', 's03', 
'2018-10-20', '2018-10-30')
insert into muonsach values('dg01', 's03', 
'2018-10-15', '2018-11-10')
--Câu 8
update sach set sl = sl + 4
where ms = 'S01'







