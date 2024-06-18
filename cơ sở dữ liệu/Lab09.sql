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

CREATE table Hoadon_Luu
(
	Mahd varchar(10),
	Ngayban date,
	Manv varchar(10)
)

CREATE TRIGGER addNhomSach ON Nhomsach
FOR INSERT
AS
	DECLARE @mn VARCHAR(10)
	select @mn = manhom from INSERTed

	IF( SELECT COUNT(*) FROM Nhomsach WHERE Manhom = @mn) = 2
	BEGIN
	Print('Primary key coincide')
	ROLLBACK TRAN
	END

INSERT into Nhomsach VALUES ('VH', N'Van hoc')

SELECT * from Nhomsach

INSERT into Nhomsach VALUES ('VH', N'Van hoa')

CREATE TRIGGER cau1a ON Nhomsach
FOR INSERT
AS
	DECLARE @mn VARCHAR(10)
	SELECT @mn = Manhom FROM inserted

	IF(SELECT COUNT(*) FROM Nhomsach WHERE Manhom = @mn) = 2
	BEGIN
	PRINT('Primary key coincide')
	ROLLBACK TRAN
	END

	SELECT COUNT(*) FROM Nhomsach WHERE Manhom = @mn

INSERT into Nhomsach VALUES ('TH', N'TinHoc'),
('HH', N'HoaHoc')

CREATE TRIGGER cau1b ON Hoadon
FOR INSERT
AS
	DECLARE @MHD VARCHAR(10)
	SELECT @MHD = Mahd FROM INSERTED

	IF(SELECT COUNT(*) FROM Hoadon WHERE Mahd = @MHD) = 2
	BEGIN
	PRINT('Primary key coincide')
	ROLLBACK TRAN
	END
	
	ELSE
	BEGIN
	INSERT INTO Hoadon_Luu(Mahd, Ngayban, Manv) SELECT Mahd, Ngayban, Manv FROM inserted
	END


INSERT INTO Hoadon VALUES('HD01', '10/03/2022', 'NV01', NULL)
SELECT * FROM Hoadon_Luu

SELECT * FROM Hoadon

CREATE TRIGGER cau1c ON CTHD
FOR INSERT, UPDATE, DELETE
AS
	DECLARE @mhdIn VARCHAR(10)
	SELECT @mhdIn = mahd FROM inserted

	DECLARE @mhdDe VARCHAR(10)
	SELECT @mhdDe = mahd FROM deleted

	IF(SELECT COUNT(*) FROM CTHD where Mahd = @mhdIn) = 2
	BEGIN
	PRINT('Primary key coincide')
	ROLLBACK TRAN
	END

	ELSE
	BEGIN
	DELETE FROM Hoadon WHERE Mahd = @mhdDe
	UPDATE Hoadon
	SET Hoadon.TongTriGia = DMSach.Dg * CTHD.sl FROM DMSach, CTHD, Hoadon WHERE CTHD.Masach = DMSach.Masach AND CTHD.Mahd = Hoadon.Mahd
	END

SELECT * FROM Hoadon
SELECT * FROM DMSach
SELECT * FROM CTHD
INSERT INTO CTHD VALUES ('HD01', 'S01', 4, 35000)


ALTER TABLE CTHD
ADD GiaBan FLOAT

CREATE TRIGGER cau1d ON CTHD
FOR INSERT, UPDATE
AS
	IF(SELECT COUNT(*) FROM CTHD, DMSach WHERE CTHD.Masach = DMSach.Masach AND DMSach.Dg <> CTHD.Giaban) >= 1
	BEGIN
	print('Wrong input')
	ROLLBACK TRAN
	END

INSERT INTO CTHD VALUES('HD01', 'S01', 3, 35000)
	 