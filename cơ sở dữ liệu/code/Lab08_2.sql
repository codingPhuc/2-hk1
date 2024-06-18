create table Lop 
(
  Malop varchar(10),
  Tenlop nvarchar(30)
 )
create table Sinhvien 
(
	Masv varchar(10),
	Hoten nvarchar (30),
	ns date, 
	malop varchar(10)
)
create table Monhoc
(
	Mamh varchar(10),
	Tenmh nvarchar(30)
)
create table Ketqua
(
	Masv varchar(10),
	Mamh varchar(10),
	Diem float
)
INSERT INTO Lop VALUES ('L01', 'Class01')
INSERT INTO SinhVien Values('01', N'Trần Ngọc Khoa', '07-19-2002', 'L01')
INSERT INTO SinhVien Values('02', N'Mai Hồng Ngọc', '07-19-2002', 'L01')
INSERT INTO SinhVien Values('02', N'trần Hoàng Phúc', '06-20-2003', 'L01')
INSERT INTO SinhVien Values('03', N'Nguyễn Ngọc Nga', '03-10-2003', 'L01')

INSERT INTO Ketqua Values('02', 'OOP', 6.75)
INSERT INTO Ketqua Values('01', 'DSA', 8)
INSERT INTO Ketqua Values('01', 'DSA', 1)


CREATE FUNCTION cauA (@maLop VARCHAR(10))
RETURNS TABLE
AS
	return (select (Upper(left(Hoten,1)) + substring(Hoten,2,len(Hoten)-1)) as hoten, CONVERT(VARCHAR(10), ns ,103) as NgaySinh
	From Sinhvien Where malop=@maLop)
go

select * from cauA ('L01')

CREATE FUNCTION cauB()
RETURNS TABLE
AS
	RETURN (SELECT Masv, Mamh, STR(diem, 4, 2) as Diem from Ketqua)
go

select * from cauB()

CREATE FUNCTION cauC()
RETURNS TABLE
AS
	RETURN (SELECT Hoten, ns, DATENAME(dw, ns) as Thu FROM Sinhvien)
go

SELECT * FROM cauC()

CREATE FUNCTION cauD()
RETURNS TABLE
AS
	RETURN (SELECT Masv, REVERSE(SUBSTRING(REVERSE(Hoten), CHARINDEX(' ', REVERSE(Hoten)) + 1, len(Hoten) - len(left(reverse(Hoten), CHARINDEX(' ',reverse(Hoten)))))) as Holot, 
	reverse(left(reverse(hoten),charindex(' ',reverse(hoten)))) as Ten
From Sinhvien)
Go

CREATE FUNCTION cauE(@Malop VARCHAR(10))
RETURNS VARCHAR(10)
AS
	BEGIN
	RETURN (SELECT TOP 1 Masv From Sinhvien WHERE @Malop = malop ORDER BY Masv DESC)
	END
GO

print dbo.cauE('L01')

CREATE FUNCTION cauG()
RETURNS TABLE
AS
	RETURN (SELECT Sinhvien.Masv, Sinhvien.Hoten, STR(AVG(Ketqua.Diem), 4, 1) AS DTB  
	from Sinhvien, Ketqua 
	WHERE Ketqua.MaSV = Sinhvien.Masv 
	GROUP BY Sinhvien.Masv, Sinhvien.Hoten
	HAVING AVG(Ketqua.Diem) >= 5)
GO

SELECT * FROM cauG()

CREATE PROC P_AddStudent(@hoten NVARCHAR(30), @ns Date, @maLop VARCHAR(10))
AS
	DECLARE @masv VARCHAR(10)
	set @masv = dbo.cauE(@maLop)
	DECLARE @stt INT
	if @masv IS NULL
	begin
		set @stt = 1
	end
	else
	begin
		set @stt = cast(right(@masv, 3) as INT) + 1
	end
	if @stt < 10
	begin
		set @masv = @maLop + '00' + CAST(@stt as VARCHAR(1))
	end
	else if @stt < 100
	begin
		set @masv = @maLop + '0' + CAST(@stt as VARCHAR(1))
	end
	else
	begin
		set @masv = @maLop + CAST(@stt as VARCHAR(1))
	end
	INSERT INTO Sinhvien VALUES (@masv, @hoten, @ns, @maLop)
GO

exec P_AddStudent N'Nguyễn Tài', '03/10/2003', 'L01'
SELECT * FROM Sinhvien

CREATE FUNCTION cauA2()
RETURNS TABLE
AS
	RETURN (SELECT LEFT(Hoten, CHARINDEX(' ', HoTen)) AS Ho,
	REVERSE(SUBSTRING(REVERSE(Hoten), CHARINDEX(' ', REVERSE(Hoten)) + 1, len(Hoten) - len(LEFT(Hoten, CHARINDEX(' ', HoTen))) - len(REVERSE(LEFT(REVERSE(Hoten), CHARINDEX(' ', REVERSE(Hoten))))))) AS Lot,
	REVERSE(LEFT(REVERSE(Hoten), CHARINDEX(' ', REVERSE(Hoten)))) AS Ten 
	FROM Sinhvien)
GO

SELECT * FROM cauA2()

CREATE FUNCTION cauB2()
RETURNS TABLE
AS
	RETURN (SELECT Hoten, ns, DATENAME(dw, ns) as Thu FROM Sinhvien)
GO

SELECT * FROM cauB2()

CREATE FUNCTION cauC2()
RETURNS TABLE
AS
	RETURN (SELECT Sinhvien.Masv, Sinhvien.Hoten, STR(AVG(Ketqua.Diem), 4, 1) AS DTB  
	from Sinhvien, Ketqua 
	WHERE Ketqua.MaSV = Sinhvien.Masv 
	GROUP BY Sinhvien.Masv, Sinhvien.Hoten
	HAVING AVG(Ketqua.Diem) <5)
GO

SELECT * FROM cauC2()

CREATE FUNCTION cauD2(@masv VARCHAR(10))
RETURNS VARCHAR(10)
AS
	BEGIN
	RETURN (SELECT Lop.Tenlop FROM Lop, Sinhvien WHERE Sinhvien.malop = Lop.Malop AND @masv = Sinhvien.Masv)
	END
GO

print dbo.cauD2('01')

CREATE FUNCTION cauE2(@mamh VARCHAR(10))
RETURNS FLOAT
AS
	BEGIN
	RETURN (SELECT AVG(Diem) from Ketqua Group by Mamh HAVING Ketqua.MaMH = @mamh)
	END
GO

print dbo.cauE2('OOP')


CREATE FUNCTION cauF2()