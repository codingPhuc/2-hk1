CREATE table Nhomsach
(
  Manhom varchar(10),
  Tennhom nvarchar(30)
  )
  CREATE table Nhanvien
  (
   Manv varchar(10),
   Ho nvarchar(30),
    Ten nvarchar(30),
    Phai nvarchar(10),
    Ngaysinh date,
    Diachi nvarchar(30)
    )
CREATE table DMSach
(
  Masach varchar(10),
  Tensach nvarchar(30),
  Tacgia nvarchar(30),
  Manhom varchar(10),
  Dg INT,
  sl int 
  )
CREATE table Hoadon
(
  Mahd varchar(10),
  Ngayban date,
  Manv varchar(10)
)
CREATE table CTHD
(
  Mahd varchar(10),
  Masach varchar(10),
  sl int 
)


CREATE TRIGGER count_nhomsach 
ON nhomsach
FOR INSERT  
AS  
	

BEGIN  
  DECLARE @Msg int = (select count(*)from nhomsach)  
  print('Có '+ CAST(@Msg AS VARCHAR(5)) +' mẫu tin được chèn')
END  
drop  TRIGGER count_nhomsach
INSERT into Nhomsach VALUES ('VH', N'Van hoc')

CREATE TRIGGER count_nhomsach 
ON nhomsach
FOR INSERT  
AS  
	

BEGIN  
  DECLARE @Msg int = (select count(*)from nhomsach)  
  print('Có '+ CAST(@Msg AS VARCHAR(5)) +'N mẫu tin được chèn')
END 
-- cau 2 
CREATE table Hoadon_luu
(
  Mahd varchar(10),
  Ngayban date,
  Manv varchar(10)
)
CREATE TRIGGER hoadon_inhoadon
ON hoadon
FOR INSERT  
AS  

BEGIN  
    Declare @Mahd varchar(10)  
	Declare @Ngayban date
	Declare @Manv varchar(10)  
	SELECT @Mahd = Mahd from inserted
	SELECT @Ngayban = Ngayban from inserted
	SELECT @Manv = Manv from inserted
	INSERT INTO  Hoadon_luu 
	VALUES (@Mahd,@Ngayban, @Manv) 
END 
INSERT into hoadon VALUES ('VH', getdate() ,'04' )
select * from  Hoadon_luu
--5

drop table hoadon 
CREATE table Hoadon
(
  Mahd varchar(10),
  Ngayban date,
  Manv varchar(10),
  ngaytaohd date  
)

CREATE TRIGGER hoadon_inhoadon
ON hoadon
FOR INSERT  
AS
Declare @Ngayban date
Declare @ngaytaohd date
SELECT @Ngayban = Ngayban from inserted
SELECT @ngaytaohd = ngaytaohd from inserted
IF(@Ngayban  > @ngaytaohd)
BEGIN
	raiserror('hoa don ghi sai',16,1)
	ROLLBACK TRAN     
END
INSERT into hoadon VALUES ('VH', getdate() ,'04' ,getdate())
