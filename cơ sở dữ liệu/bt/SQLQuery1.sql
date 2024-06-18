create table LoaiNGK
(
	Maloai nvarchar(10) primary key , 
	Tenloai nvarchar(10) unique , 
)

create table  NGK 
(
	MaNGK nvarchar(10) primary key , 
	TenNGK nvarchar(10) unique , 
	DVT nvarchar(10) check(DVT='chai'or DVT= 'lon'or DVT='thùng'or DVT='kết' ),
	Soluong int check (Soluong>0),
	Dongia int check (Dongia >0) ,
	MaloaiNGK  nvarchar (10) foreign key  references LoaiNGK(Maloai),
	

)
create table khachhang 
(
	MsKH nvarchar(10) primary key , 
	hoten  nvarchar(10) , 
	diachi nvarchar (10) ,
	dienthoai nvarchar(10) default 'chua co'   ,
	
)
create TABLE Hoadon 
(
	Sohd nvarchar(10 ) primary key , 
	MsKH nvarchar(10) foreign key references khachhang(MsKH )  ,
	nhanvien nvarchar(10) ,
	ngaylap date  default getdate(),
	

 )
 create table CTHD 
 (
	Sohd nvarchar(10), 
	MaNGK nvarchar(10),
	 primary key  (Sohd , MaNGk) ,
	soluong int check (soluong >0 )  , 
	dongia int , 

 )
 
 alter table CTHD 
	add thanhtien int ; 
alter table CTHD 
	add  foreign key(Sohd) references Hoadon(Sohd) ;
alter table CTHD
	add   foreign key (MaNGK) references NGK(MaNGK) ;
alter table CTHD 
	add constraint dongia check(dongia >1000) ;
ALTER TABLE NGK
	DROP CONSTRAINT  ;
 drop table CTHd 
 drop table Hoadon
 drop table khachhang 
 drop table NGK 
 drop table loaiNGk 