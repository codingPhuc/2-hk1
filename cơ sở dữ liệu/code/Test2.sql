CREATE TABLE San(
	MaSan VARCHAR(10),
	TenSan NVARCHAR(30),
	SoTienGio INT,
)

CREATE TABLE KhachHang(
	SDT VARCHAR(10),
	HoTen NVARCHAR(30),
)

CREATE TABLE DichVu(
	MaDichVu VARCHAR(10),
	TenDichVu NVARCHAR(30),
	SoLuong INT,
	DonGia INT,
)

CREATE TABLE PhieuDatSan(
	MaDatSan VARCHAR(10),
	SDT VARCHAR(10),
	NgayDat DATE,
	NgayThiDau DATE,
	GioBatDau INT,
	GioKetThuc INT,
	MaSan VARCHAR(10),
)

CREATE TABLE HoaDon(
	SoHoaDon VARCHAR(10),
	NgayLap Date,
	MaDatSan VARCHAR(10),
)

CREATE TABLE CTHD(
	SoHoaDon VARCHAR(10),
	MaDichVu VARCHAR(10),
	SoLuong INT,
	DonGia INT,
)

INSERT INTO HoaDon VALUES('HD01', '2022-09-11', 'PDS01')
INSERT INTO CTHD VALUES('HD01', 'DV01', 3, 20000)
INSERT INTO CTHD VALUES('HD01', 'DV02', 4, 50000)
SELECT * FROM CTHD

CREATE FUNCTION Cau3a(@SoHoaDon VARCHAR(10))
RETURNS INT
AS
	BEGIN
	RETURN (SELECT SUM(SoLuong * DonGia) FROM CTHD WHERE SoHoaDon = @SoHoaDon)
	END
GO

print(dbo.Cau3a('HD01'))

CREATE FUNCTION Cau3b()
RETURNS VARCHAR(12)
AS
	BEGIN
	DECLARE @currentDate VARCHAR(8)
	set @currentDate = FORMAT (getdate(), 'ddMMyyyy')
	DECLARE @stt VARCHAR(4)
	DECLARE @soHD VARCHAR(10)
	DECLARE @res VARCHAR(12)
	set @soHD = (SELECT Top 1 SoHoaDon FROM HoaDon WHERE LEFT(SoHoaDon,8) = @currentDate ORDER BY SoHoaDon DESC)
	if(@soHD is null)
		begin
		set @stt = 1
		end
	else
		begin
		set @stt = CAST(RIGHT(@soHD, 4) AS INT) + 1
		end
	if @stt < 10
		begin
			set @res = CAST(@currentDate AS VARCHAR(8)) + '000' + CAST(@stt AS VARCHAR(1))
		end
	else if @stt < 100
		begin
			set @res = CAST(@currentDate AS VARCHAR(8)) + '00' + CAST(@stt AS VARCHAR(2))
		end
	else if @stt < 1000
		begin
			set @res = CAST(@currentDate AS VARCHAR(8)) + '0' + CAST(@stt AS VARCHAR(3))
		end
	else
		begin
			set @res = CAST(@currentDate AS VARCHAR(8)) + CAST(@stt AS VARCHAR(4))
		end
	return @res
	END
GO

print(dbo.Cau3b())

CREATE PROC P_AddSan @maSan VARCHAR(10), @ten NVARCHAR(30), @soTien INT
AS
	if(@soTien <= 0)
	begin
		print('Tien san phai lon hon 0')
	end
	else
		INSERT INTO San VALUES (@maSan, @ten, @soTien)
GO

EXEC P_AddSan 'S01', N'SVD Quận 8', 11000
SELECT * FROM San

CREATE PROC P_UpdateSDT @soDTCu VARCHAR(10), @soDTMoi VARCHAR(10)
AS
	if exists(select * from KhachHang where SDT = @soDTMoi)
	Begin
	print('SDT Moi da ton tai')
	end
	else
	BEGIN
		if exists(Select * from KhachHang WHERE SDT = @soDTCu)
		BEGIN
			Update KhachHang
			SET SDT = @soDTMoi
			WHERE SDT = @soDTCu
		END
		ELSE
		BEGIN
			print('SDT Cu khong ton tai')
		END

		if exists(Select * from PhieuDatSan where SDT = @soDTCu)
		BEGIN
			Update PhieuDatSan
			SET SDT = @soDTMoi
			WHERE SDT = @soDTCu
		END
	END
GO

INSERT INTO KhachHang VALUES ('0375830891', N'Nguyễn Phương Tài')
INSERT INTO PhieuDatSan VALUES('PDS01','0865413542', GETDATE(), GETDATE(), 8, 9, 'S01')
EXEC P_UpdateSDT '0865413542', '0375830891'
SELECT * FROM KhachHang
SELECT * FROM PhieuDatSan

CREATE TRIGGER Cau5a
ON PhieuDatSan
FOR INSERT
AS
	DECLARE @ngayDat DATE, @ngayThiDau DATE
	SELECT @ngayDat = NgayDat, @ngayThiDau = NgayThiDau from inserted
	if(@ngayDat > @ngayThiDau)
	begin
		print('Ngay thi dau phai lon hon ngay dat san')
		ROLLBACK TRAN
	end
GO

INSERT INTO PhieuDatSan VALUES('PDS02','0375830891', '2022-08-17', '2022-08-17', 8, 9, 'S01')

CREATE TRIGGER Cau5b
ON CTHD
FOR INSERT, UPDATE
AS
	DECLARE @MaDV VARCHAR(10), @sl INT
	SELECT @MaDV = MaDichVu, @sl = SoLuong from inserted
	
	if not exists(SELECT * FROM DichVu WHERE MaDichVu = @MaDV AND @sl <= SoLuong)
	begin
		print('So luong ban phai <= So Luong hien co')
		rollback tran
	end
GO

SELECT * FROM DichVu
INSERT INTO DichVu VALUES ('DV01',N'Khăn tắm', 5, 12000)
INSERT INTO DichVu VALUES ('DV02',N'Bóng đá', 4, 30000)

SELECT * FROM HoaDon
SELECT * FROM CTHD
UPDATE CTHD
set SoLuong = 5
WHERE MaDichVu = 'DV01'
INSERT INTO CTHD VALUES('HD01', 'DV02', 5, 30000)