CREATE TABLE NSX(
	MaNSX VARCHAR(10),
	TenNSX NVARCHAR(30),
)

CREATE TABLE XeMay(
	MaXe VARCHAR(10),
	TenXe NVARCHAR(30),
	MaNSX VARCHAR(10),
	SoLuong INT,
	DONGIA INT,
)

CREATE TABLE KhachHang(
	SDT VARCHAR(10),
	HoTen NVARCHAR(30),
	DIACHI NVARCHAR(30),
)

CREATE TABLE HoaDon(
	SoHD VARCHAR(10),
	NgayLap DATE,
	MaKhachHang VARCHAR(10),
)

CREATE TABLE CTHD(
	SoHD VARCHAR(10),
	MaXe VARCHAR(10),
	Soluong INT,
	DonGia INT,
)

SELECT KHACHHANG.* FROM KHACHHANG, HOADON
WHERE KHACHHANG.DIACHI = 'TPHCM' AND MONTH(HOADON.NGAYLAP) BETWEEN 7 AND 9

SELECT * FROM XeMay WHERE MaXe IN(
SELECT MaXe FROM CTHD
WHERE SoHD IN (
	SELECT SoHD FROM HoaDon WHERE MAKHACHHANG IN(
	SELECT SDT FROM KHACHHANG WHERE DIACHI = 'TPHCM')
) AND MaXe IN (
	SELECT MaXe FROM XeMay WHERE MaNSX IN(
	SELECT MaNSX FROM NSX WHERE TenNSX = 'Yamaha')
))

SELECT * FROM XeMay WHERE MaXe IN(
SELECT MaXe FROM CTHD GROUP BY MaXe HAVING SUM(SoLuong)=(
SELECT TOP 1 SUM(SoLuong) FROM CTHD WHERE SoHD IN (
SELECT SoHD FROM HoaDon WHERE YEAR(NgayLap) = 2020
) GROUP BY MaXe ORDER BY SUM(Soluong) DESC))

SELECT * FROM XeMay Where MaXe NOT IN(
SELECT MaXe FROM CTHD WHERE SoHD IN(
SELECT SoHD FROM HoaDon WHERE YEAR(NgayLap) = 2020))

SELECT * FROM NSX WHERE MaNSX IN(
SELECT XeMay.MaNSX FROM XeMay, CTHD WHERE CTHD.MaXe = XeMay.MaXe GROUP BY XeMay.MaNSX HAVING SUM(CTHD.Soluong) = (
SELECT TOP 1 SUM(CTHD.SOLUONG) FROM CTHD, XeMay 
WHERE CTHD.MaXe = XeMay.MaXe
GROUP BY XeMay.MaNSX
ORDER BY SUM(CTHD.SOLUONG) DESC))


SELECT MONTH(HoaDon.NgayLap) AS Thang, SUM(CTHD.Soluong) AS TongBan FROM CTHD, HoaDon WHERE CTHD.SoHD IN(
SELECT SoHD FROM HoaDon WHERE YEAR(NgayLap) = 2020) AND CTHD.SoHD = HoaDon.SoHD GROUP BY MONTH(HoaDon.NgayLap) ORDER BY MONTH(HoaDon.NgayLap) ASC

CREATE FUNCTION cau2a(@ngayLap DATE)
RETURNS VARCHAR(12)
AS
	BEGIN
		DECLARE @maNgay VARCHAR(8)
		DECLARE @stt VARCHAR(4)
		DECLARE @soHD VARCHAR(10)
		DECLARE @res VARCHAR(12)
		set @maNgay = FORMAT(@ngayLap, 'ddMMyyyy')
		SET @soHD = (SELECT TOP 1 SoHD FROM HoaDon WHERE LEFT(SoHD, 8) = @maNgay ORDER BY SoHD DESC)
		IF @soHD is null
			begin
			set @stt = 1
			end
		else
			begin
			set @stt = CAST(RIGHT(@soHD, 4) AS INT) + 1
			End
		IF(@stt < 10)
			begin
			set @res = @maNgay + '000' + CAST(@stt as VARCHAR(1))
			END
		ELSE IF (@stt < 100)
			begin
			set @res = @maNgay + '00' + CAST(@stt as VARCHAR(2))
			END
		ELSE IF (@stt < 1000)
			begin
			set @res = @maNgay + '0' + CAST(@stt as VARCHAR(3))
			ENd
		ELSE 
			begin
			set @res = @maNgay + CAST(@stt as VARCHAR(4))
			ENd
		RETURN @res
	END
GO

SELECT dbo.cau2a('03/20/2022')

CREATE FUNCTION cau2b(@soHD VARCHAR(10))
RETURNS INT
AS
	BEGIN
		RETURN (SELECT SUM(SoLuong * Dongia) FROM CTHD WHERE SoHD = @soHD)
	END
GO

SELECT dbo.cau2b('HD01')

CREATE FUNCTION cau2c(@nam INT)
RETURNS TABLE
AS
	return (SELECT XeMay.MaNSX, SUM(CTHD.Soluong) AS TongBan
	FROM CTHD, XeMay 
	WHERE XeMay.MaXe = CTHD.MaXe AND CTHD.SoHD IN 
	(SELECT SoHD FROM HoaDon WHERE YEAR(NgayLap) = @nam) 
	GROUP BY XeMay.MaNSX
	)
	
GO

SELECT * FROM cau2c(2016)

CREATE PROC P_AddXeMay @maXe VARCHAR(10), @tenXe NVARCHAR(30), @maNSX VARCHAR(10), @sl int, @dongia int
AS 
	if EXISTS (SELECT * FROM XeMay WHERE MaXe = @maXe)
		begin
		print('Ma Xe da ton tai')
		end
	else if not Exists(SELECT * FROM NSX WHERE MaNSX = @maNSX)
		begin
		print('NSX khong ton tai')
		end
	ELSE IF @dongia <= 0 or @sl <= 0
		begin
		print('Don gia phai > 0')
		end
	ELSE
		INSERT INTO XeMay VALUES (@maXe, @tenXe, @maNSX, @sl, @dongia)
GO

INSERT INTO NSX VALUES ('YMH', 'YAMAHA')
select * from NSX
select * from XeMay
DELETE FROM XeMay WHERE MaXe = 'X01'

exec P_AddXeMay 'X01', 'Xe 01', 'YMH', 5, 60

CREATE PROC P_DeleteXeMay @maXe VARCHAR(10)
AS
	IF EXISTS (SELECT * FROM CTHD WHERE MaXe = @maXe)
		begin
		print('Xe van con trong CTHD')
		end
	ELSE 
		DELETE FROM XeMay WHERE MaXe = @maXe
GO

EXEC P_DeleteXeMay 'X01'

CREATE PROC P_HoaDonAnalysis
AS
	SELECT SoHD, SUM (SoLuong * Dongia) AS TongTien From CTHD GROUP BY SoHD
GO

INSERT INTO CTHD VALUES ('HD01', 'X01', 2, 50)
INSERT INTO CTHD VALUES ('HD01', 'X01', 3, 60)
INSERT INTO CTHD VALUES ('HD02', 'X01', 4, 30)

exec P_HoaDonAnalysis

CREATE TRIGGER cau4a
ON HoaDon
FOR INSERT
AS
	DECLARE @soHD VARCHAR(10)
	DECLARE @maKH VARCHAR(10)
	SELECT @soHD = SoHD, @maKH = MaKhachHang FROM inserted
	if not exists (SELECT * FROM KhachHang WHERE SDT = @maKH)
		begin
		print('Khach hang khong ton tai')
		rollback tran
		end
	if (SELECT count(*) FROM HoaDon WHERE SoHD = @soHD) = 2
		begin
		print('Hoa don da ton tai')
		rollback tran
		end
GO

INSERT INTO KhachHang VALUES ('0375830891', 'Tai', 'TPHCM')
INSERT INTO HoaDon VALUES ('HD02', GETDATE(), '0375830891')
select * from HoaDon

CREATE TRIGGER cau4b
ON CTHD
FOR INSERT
AS
	DECLARE @soHD VARCHAR(10)
	DECLARE @maXe VARCHAR(10)
	DECLARE @sl INT
	DECLARE @dongia INT
	SELECT @soHD = SoHD, @maXe = MaXe, @sl = Soluong, @dongia = DonGia from inserted

	if not exists(SELECT * FROM XeMay WHERE MaXe = @maXe)
		begin
		print('Xe khong ton tai')
		rollback tran
		end
	if not exists(SELECT * FROM HoaDon WHERE SoHD = @soHD)
		begin
		print('HD khong ton tai')
		rollback tran
		end
	if not exists (SELECT * FROM XeMay WHERE MaXe = @maXe and @dongia = DONGIA and @sl <= SoLuong)
		begin
		print('Don gia hoac so luong khong thoa dieu kien')
		rollback tran
		end
GO

SELECT * FROM XeMay
SELECT * FROM CTHD

INSERT INTO CTHD VALUES ('HD01', 'X01',5, 60)
