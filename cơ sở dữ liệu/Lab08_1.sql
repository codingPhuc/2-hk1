create table Khoa
(
	Makhoa varchar(10),
	Tenkhoa nvarchar(30)
)
Create table Sinhvien 
(
	Masv varchar(10),
	HoSV nvarchar(30),
	TenSV nvarchar(30),
	Ngaysinh date,
	Phai nvarchar(10),
	Makhoa varchar(10)
)
Create table Monhoc
(
	Mamh varchar(10),
	TenMH nvarchar(30),
	Sotiet INT
)
  
Create table Ketqua
(
	MaSV varchar(10),
	MaMH varchar(10),
	Lanthi int,
	Diem float
)

---Viết thủ tục nhập sinh viên mới có kiểm tra ràng buộc khóa chính, ràng
---buộc khóa ngoại với bảng Khoa và ràng buộc tuổi của sinh viên lớn hơn
---hoặc bằng 18 và nhỏ hơn 40.
CREATE PROC P_AddStudent @masv varchar(10), @hosv nvarchar(30), @tensv nvarchar(30), @ns date, @phai nvarchar(10), @mk varchar(10) 
as 
	if (select count(*) from Sinhvien where masv = @masv) = 1 

		print ('Khoa chinh bi trung')

	else if (select count(*) from Khoa where makhoa = @mk) = 0 

		print ('Khoa ngoai khong ton tai')

	else if (year(getdate()) - year(@ns) not BETWEEN 18 and 40 )

		print ('Tuoi ko hop le')

	else 

		INSERT into Sinhvien values (@masv, @hosv, @tensv, @ns, @phai, @mk)

INSERT into khoa VALUES ('IT', N'Khoa Công nghệ thông tin')

INSERT into khoa VALUES ('ET', N'Khoa Công nghệ điện tử')

EXEC P_AddStudent '01', N'Nguyễn Văn', N'Tèo', '2000/02/12', N'Nam', 'IT'

select * from Sinhvien

---Viết thủ tục nhập kết quả của sinh viên có kiểm tra ràng buộc khóa ngoại
---giữa bảng Ketqua và bảng Sinhvien và bảng Monhoc.

CREATE PROC P_AddResult @masv varchar(10), @mamh varchar(10), @lanthi INT, @diem FLOAT
AS
	IF(SELECT COUNT(*) FROM Sinhvien WHERE Masv = @masv) = 0
		print('Sinh vien khong ton tai')
	ELSE IF(SELECT COUNT(*) FROM Monhoc WHERE Mamh = @mamh) = 0
		print('Mon hoc khong ton tai')
	ELSE
		INSERT INTO Ketqua VALUES(@masv, @mamh, @lanthi, @diem)

INSERT INTO Monhoc VALUES ('OOP', N'Lập trình hướng đối tượng', 15)
EXEC P_AddResult '01', 'OOP', 1, 9

SELECT * FROM Ketqua

---Viết thủ tục cho biết số lượng sinh viên của khoa có mã nhập vào từ bàn phím.

CREATE PROC P_ShowStudentCount @makhoa VARCHAR(10)
as 
	IF(SELECT COUNT(*) FROM Khoa WHERE Makhoa = @makhoa) = 0
		print('Khoa khong ton tai')
	ELSE
		SELECT COUNT(*) FROM Sinhvien WHERE Makhoa = @makhoa

EXEC P_ShowStudentCount 'IT'


---Viết hàm xem danh sách sinh viên của khoa có mã được nhập vào từ bàn phím
CREATE PROC P_ShowStudent @makhoa VARCHAR(10)
as 
	IF(SELECT COUNT(*) FROM Khoa WHERE Makhoa = @makhoa) = 0
		print('Khoa khong ton tai')
	ELSE
		SELECT * FROM Sinhvien WHERE Makhoa = @makhoa

EXEC P_ShowStudent 'IT'

---Viết hàm thống kê số lượng sinh viên của mỗi khoa
CREATE PROC P_FacultyStatistic
as
	SELECT Khoa.Tenkhoa, Count(*) 
	FROM Sinhvien
	JOIN Khoa ON Sinhvien.Makhoa = Khoa.Makhoa
	GROUP BY Khoa.Tenkhoa, SinhVien.Makhoa

EXEC P_FacultyStatistic

--Viết hàm xem kết quả học tập của sinh viên có mã được nhập từ bàn phím.
CREATE PROC P_StudentResult @masv VARCHAR(10)
AS
	IF(SELECT COUNT(*) FROM Sinhvien WHERE Masv = @masv) = 0
		print('Sinh vien khong ton tai')
	ELSE
		SELECT Ketqua.MaSV, Monhoc.TenMH, Ketqua.Diem
		FROM Ketqua
		JOIN Monhoc ON Monhoc.Mamh = Ketqua.MaMH
		WHERE Ketqua.MaSV = @masv

EXEC P_StudentResult '01'

--Viết hàm đếm số lượng sinh viên của khoa có mã khoa được nhập vào từ bàn phím

CREATE PROC P_CountFaculty @makhoa VARCHAR(10)
as
	IF(SELECT COUNT(*) FROM Khoa WHERE Makhoa = @makhoa) = 0
		print('Khoa khong ton tai')
	ELSE
		SELECT Khoa.Tenkhoa, Count(*) 
		FROM Sinhvien
		JOIN Khoa ON Sinhvien.Makhoa = Khoa.Makhoa
		WHERE Khoa.Makhoa = @makhoa
		GROUP BY Khoa.Tenkhoa, SinhVien.Makhoa

EXEC P_CountFaculty 'IT'