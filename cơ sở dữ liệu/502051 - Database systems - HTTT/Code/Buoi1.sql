create database qltt1
--Tạo bảng
create table sinhvien
(
	masv varchar(10) primary key,
	ten nvarchar(50),
	que nvarchar(50),
	ns date,
	hl float
)
create table detai
(
	msdt varchar(10) primary key,
	tdt nvarchar(50),
	cn nvarchar(50),
	kp int
)
--drop table detai
create table sv_dt
(
	masv varchar(10),
	msdt varchar(10),
	ntt nvarchar(50),
	km int,
	kq float
	primary key (masv, msdt),
	foreign key (masv) references sinhvien(masv),
	foreign key (msdt) references detai(msdt)
)
alter table detai add tinchi int
alter table detai drop column tinchi
---------------------------------------
insert into sinhvien values 
('01', N'Lý Đức', N'Lâm Đồng', '2000-2-2', 8.0)

update sinhvien set ten = N'Lý Đức',
que = N'Lâm Đồng'
where masv = '01'

delete from sinhvien
where masv = '01'

