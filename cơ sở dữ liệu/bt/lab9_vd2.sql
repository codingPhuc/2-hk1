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
-- khi them vao nhom sach thi figure nay tu dong duoc goi 
CREATE TRIGGER Tr_A on NHomsach 

for insert --khi them vao nhom sach thi trigger nay tu dong dc goi 

as 

	DECLARE @mn varchar(10)

    select @mn = manhom from INSERTed --la bang tu dong dc phat sinh khi them du lieu 

    --no chi chua 1 dong, so cot tuong ung voi so cot dang them 

    --check primary key 

    if (select count(*) from Nhomsach where manhom = @mn) = 2 

    BEgin 

    	print ('Khoa chinh bi trung')

        rollback tran --duoi ra khoi lop

    end



INSERT into Nhomsach VALUES ('VH', N'Van hoc')

SELECT * from Nhomsach

INSERT into Nhomsach VALUES ('VH', N'Van hoa')

DROP TRIGGER Tr_AddNhomsach;  
CREATE TRIGGER Tr_AddNhomsach on NHomsach 
for insert --khi them vao nhom sach thi trigger nay tu dong dc goi 

as 

	DECLARE @mn varchar(10)

    select @mn = manhom from INSERTed --la bang tu dong dc phat sinh khi them du lieu 

    --no chi chua 1 dong, so cot tuong ung voi so cot dang them 

    --check primary key 

    if (select count(*) from Nhomsach where manhom = @mn) = 2 

    BEgin 

    	print ('Khoa chinh bi trung')

        rollback tran --duoi ra khoi lop

    end

    select count(*) from Nhomsach

