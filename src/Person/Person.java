package Person ;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Person {
    private String hoTen , soDoiTac , email , diaChi ;
    private LocalDate ngaySinh ;
    public Person()
    {
        hoTen = soDoiTac = email = diaChi = "" ;
        ngaySinh = LocalDate.now() ;
    }
    public Person( String hoTen , String soDoiTac , String diaChi , String email )
    {
        this.hoTen = hoTen ;
        this.soDoiTac = soDoiTac;
        this.diaChi = diaChi ;
        this.email = email ;
    }

    public String getEmail() {
        return email;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getSoDoiTac() {
        return soDoiTac;
    }

    public void setSoDoiTac(String soDoiTac) {
        this.soDoiTac = soDoiTac;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public void setPerson(Scanner sc)
    {
        System.out.println("Nhập họ tên: ");
        hoTen = sc.nextLine() ;
        System.out.println("Nhập số điên thoại: ");
        soDoiTac = sc.nextLine() ;
        System.out.println("Nhập địa chỉ: ");
        diaChi = sc.nextLine() ;
        System.out.println("Nhâp email: ");
        email = sc.nextLine() ;
        System.out.println("Nhập ngày sinh(dd/mm/yyyy): ");
        String ngay = sc.nextLine() ;
        DateTimeFormatter khuon = DateTimeFormatter.ofPattern("dd/MM/yyyy") ;
        ngaySinh = LocalDate.parse( ngay , khuon ) ;
        sc.nextLine() ;
    }
    @Override
    public String toString() {
        return "Họ tên: " + hoTen + " | Số điện thoại: " + soDoiTac + " | Địa chỉ: " + email + " | Ngày sinh: " + ngaySinh ;
    }

}
class Khachhang extends Person
{
    private String maKhachHang , hangThanhVien ;
    private long tongTienDaMua ;
    private LocalDate ngayDangKy ;
    private ArrayList<CTHoaDonBan> giohang ;
    private ArrayList<Hoadon> lichSuMuaHang ;
    public Khachhang ()
    {
        maKhachHang = hangThanhVien = "" ;
        tongTienDaMua = 0 ;
        ngayDangKy = LocalDate.now() ;
        giohang = new ArrayList<>() ;
        lichSuMuaHang = new ArrayList<>() ;
    }
    public Khachhang ( String hoTen , String soDoiTac , String diaChi , String email , String maKhachHang , LocalDate ngayDangKy , long tongTienDaMua )
    {
        super( hoTen, soDoiTac, diaChi, email);
        this.maKhachHang = maKhachHang ;
        this.ngayDangKy = ngayDangKy ;
        this.tongTienDaMua = tongTienDaMua;
    }

    public ArrayList<CTHoaDonBan> getGiohang() {
        return giohang;
    }

    public ArrayList<Hoadon> getLichSuMuaHang() {
        return lichSuMuaHang;
    }

    public void setLichSuMuaHang(ArrayList<Hoadon> lichSuMuaHang) {
        this.lichSuMuaHang = lichSuMuaHang;
    }

    public String getHangThanhVien() {
        return hangThanhVien;
    }

    public void setHangThanhVien(String hangThanhVien) {
        this.hangThanhVien = hangThanhVien;
    }

    public long getTongTienDaMua() {
        return tongTienDaMua;
    }

    public void setTongTienDaMua(long tongTienDaMua) {
        this.tongTienDaMua = tongTienDaMua;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setNgayDangKy(LocalDate ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    public LocalDate getNgayDangKy() {
        return ngayDangKy;
    }

    public void setGiohang(ArrayList<CTHoaDonBan> gioHang) {
        giohang = gioHang;
    }

    @Override
    public void setPerson(Scanner sc) {
        System.out.println("Nhập mã khách hàng: ");
        maKhachHang = sc.nextLine() ;
        super.setPerson(sc);
        System.out.println("Nhập ngày đăng ký(dd/MM/yyyy): ");
        String ngay = sc.nextLine() ;
        DateTimeFormatter khuon = DateTimeFormatter.ofPattern("dd/MM/yyyy") ;
        ngayDangKy = LocalDate.parse( ngay , khuon ) ;
    }
    public void thietLapThuHang()
    {
          if ( tongTienDaMua <= 1000000 && tongTienDaMua >= 0 ) hangThanhVien = "Đồng" ;
          else if (tongTienDaMua <= 5000000)  hangThanhVien = "Bạc" ;
          else if ( tongTienDaMua <= 10000000) hangThanhVien = "Vàng" ;
          else hangThanhVien = "Kim cương" ;
          System.out.println("Hạng của khách hàng đang là: " + hangThanhVien );
    }
    public void danhSachSanPham()
    {

    }
    public void muaSam()
    {

    }
    public void danhSachGioHang()
    {

    }
    public void thanhToanDonHang()
    {

    }
    public int timKiemSanPham ( String maSanPham )
    {
        return 0 ;
    }
    public void lichSuGiaoDich() // danh sách hoá đơn khách hàng
    {

    }
    @Override
    public String toString() {
        return "Mã khách hàng: " + maKhachHang + " | " + super.toString() + " | Ngay dang ky " + ngayDangKy + " | Thu hang: " + hangThanhVien + " | Tổng tiền đã mua: " + tongTienDaMua;
    }
}
class Nhanvien extends Person
{
    private String maNhanVien , chucVu ;
    private LocalDate ngayVaoLam ;
    private int soGioLam ;
    private long luongTheoGio ;
    public Nhanvien()
    {
        maNhanVien = chucVu = "" ;
        ngayVaoLam = LocalDate.now() ;
        soGioLam = 0 ;
        luongTheoGio = 0 ;
    }
    public Nhanvien ( String hoTen , String soDoiTac , String diaChi , String email , String maNhanVien , long luongTheoGio , int soGioLam , LocalDate ngayVaoLam)
    {
        super(hoTen, soDoiTac, diaChi, email);
        this.maNhanVien = maNhanVien ;
        this.luongTheoGio = luongTheoGio ;
        this.soGioLam = soGioLam ;
        this.ngayVaoLam = ngayVaoLam ;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setSoGioLam(int soGioLam) {
        this.soGioLam = soGioLam;
    }

    public int getSoGioLam() {
        return soGioLam;
    }

    public void setLuongTheoGio(long luongTheoGio) {
        this.luongTheoGio = luongTheoGio;
    }

    public void setNgayVaoLam(LocalDate ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public LocalDate getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public long getLuongTheoGio() {
        return luongTheoGio;
    }
    public int tinhLuongTheoThang()
    {
        return 0 ;
    }
    public void setPerson(Scanner sc)
    {
        System.out.println("Nhập mã nhân viên: ");
        maNhanVien = sc.nextLine() ;
        super.setPerson(sc);
        System.out.println("Nhập ngày vào làm(dd/MM/yyyy): ");
        String ngay = sc.nextLine() ;
        DateTimeFormatter khuon = DateTimeFormatter.ofPattern("dd/MM/yyyy") ;
        ngayVaoLam = LocalDate.parse( ngay , khuon ) ;
        System.out.println("Nhập số giờ làm: ");
        soGioLam = sc.nextInt() ;
        System.out.println("Nhập mức lương theo giờ: ");
        luongTheoGio = sc.nextInt() ;
        sc.nextLine() ;
    }
    public String toString()
    {
        return "Ma nhân viên: " + maNhanVien + " | " + super.toString() + " | Chuc vu: " + chucVu + " | Ngay vao lam: " + ngayVaoLam + " | Số giờ làm: " + soGioLam + " | Lương theo giờ: " + luongTheoGio  ;
    }
}
