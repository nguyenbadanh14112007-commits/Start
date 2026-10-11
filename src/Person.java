import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Person {
    private String Ho_ten , So_dt , Email , Dia_chi ;
    private LocalDate Ngay_sinh ;
    Scanner sc = new Scanner(System.in) ;
    public Person()
    {
        Ho_ten = So_dt = Email = Dia_chi = "" ;
        Ngay_sinh = LocalDate.now() ;
    }
    public Person( String ho_ten , String so_dt , String dia_chi , String email )
    {
        Ho_ten = ho_ten ;
        So_dt = so_dt;
        Dia_chi = dia_chi ;
        Email = email ;
    }

    public String getEmail() {
        return Email;
    }

    public String getHo_ten() {
        return Ho_ten;
    }

    public String getSo_dt() {
        return So_dt;
    }

    public void setSo_dt(String so_dt) {
        So_dt = so_dt;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setHo_ten(String ho_ten) {
        Ho_ten = ho_ten;
    }

    public LocalDate getNgay_sinh() {
        return Ngay_sinh;
    }

    public String getDia_chi() {
        return Dia_chi;
    }

    public void setNgay_sinh(LocalDate ngay_sinh) {
        Ngay_sinh = ngay_sinh;
    }

    public void setDia_chi(String dia_chi) {
        Dia_chi = dia_chi;
    }
    public void set_person()
    {
        System.out.println("Nhập họ tên: ");
        Ho_ten = sc.nextLine() ;
        System.out.println("Nhập số điên thoại: ");
        So_dt = sc.nextLine() ;
        System.out.println("Nhập địa chỉ: ");
        Dia_chi = sc.nextLine() ;
        System.out.println("Nhâp email: ");
        Email = sc.nextLine() ;
        System.out.println("Nhập ngày sinh(dd/mm/yyyy): ");
        String ngay = sc.nextLine() ;
        DateTimeFormatter khuon = DateTimeFormatter.ofPattern("dd/MM/yyyy") ;
        Ngay_sinh = LocalDate.parse( ngay , khuon ) ;
        sc.nextLine() ;
    }
    @Override
    public String toString() {
        return "Họ tên: " + Ho_ten + " | Số điện thoại: " + So_dt + " | Địa chỉ: " + Email + " | Ngày sinh: " + Ngay_sinh ;
    }

}
class Khachhang extends Person
{
    private String Ma_kh , Hang_thanh_vien ;
    private long Tong_tien_da_mua ;
    private LocalDate Ngay_dang_ky ;
    Scanner sc = new Scanner(System.in) ;
    private ArrayList<CTHoaDonBan> Giohang ;
    private ArrayList<Hoadon> Lich_su_mua_hang ;
    public Khachhang ()
    {
        Ma_kh = Hang_thanh_vien = "" ;
        Tong_tien_da_mua = 0 ;
        Ngay_dang_ky = LocalDate.now() ;
        Giohang = new ArrayList<>() ;
        Lich_su_mua_hang = new ArrayList<>() ;
    }
    public Khachhang ( String ho_ten , String so_dt , String dia_chi , String email , String ma_kh , LocalDate ngay_dang_ky , long tong_tien_da_mua )
    {
        super( ho_ten, so_dt, dia_chi, email);
        Ma_kh = ma_kh ;
        Ngay_dang_ky = ngay_dang_ky ;
        Tong_tien_da_mua = tong_tien_da_mua;
    }

    public ArrayList<CTHoaDonBan> getGiohang() {
        return Giohang;
    }

    public ArrayList<Hoadon> getLich_su_mua_hang() {
        return Lich_su_mua_hang;
    }

    public void setLich_su_mua_hang(ArrayList<Hoadon> lich_su_mua_hang) {
        Lich_su_mua_hang = lich_su_mua_hang;
    }

    public String getHang_thanh_vien() {
        return Hang_thanh_vien;
    }

    public void setHang_thanh_vien(String hang_thanh_vien) {
        Hang_thanh_vien = hang_thanh_vien;
    }

    public long getTong_tien_da_mua() {
        return Tong_tien_da_mua;
    }

    public void setTong_tien_da_mua(long tong_tien_da_mua) {
        Tong_tien_da_mua = tong_tien_da_mua;
    }

    public void setMa_kh(String ma_kh) {
        Ma_kh = ma_kh;
    }

    public String getMa_kh() {
        return Ma_kh;
    }

    public void setNgay_dang_ky(LocalDate ngay_dang_ky) {
        Ngay_dang_ky = ngay_dang_ky;
    }

    public LocalDate getNgay_dang_ky() {
        return Ngay_dang_ky;
    }

    public void setGiohang(ArrayList<CTHoaDonBan> giohang) {
        Giohang = giohang;
    }

    @Override
    public void set_person() {
        System.out.println("Nhập mã khách hàng: ");
        Ma_kh = sc.nextLine() ;
        super.set_person();
        System.out.println("Nhập ngày đăng ký(dd/MM/yyyy): ");
        String ngay = sc.nextLine() ;
        DateTimeFormatter khuon = DateTimeFormatter.ofPattern("dd/MM/yyyy") ;
        Ngay_dang_ky = LocalDate.parse( ngay , khuon ) ;
    }
    public void thiet_lap_thu_hang()
    {
          if ( Tong_tien_da_mua <= 1000000 && Tong_tien_da_mua >= 0 ) Hang_thanh_vien = "Đồng" ;
          else if (Tong_tien_da_mua <= 5000000)  Hang_thanh_vien = "Bạc" ;
          else if ( Tong_tien_da_mua <= 10000000) Hang_thanh_vien = "Vàng" ;
          else Hang_thanh_vien = "Kim cương" ;
          System.out.println("Hạng của khách hàng đang là: " + Hang_thanh_vien );
    }
    public void Danh_sach_sp()
    {

    }
    public void mua_sam()
    {

    }
    public void Danh_sach_gio_hang()
    {

    }
    public void Thanh_toan_don_hang()
    {

    }
    public int tim_kiem_sp ( String ma_sp )
    {
        return 0 ;
    }
    public void lich_su_giao_dich() // danh sách hoá đơn khách hàng
    {

    }
    @Override
    public String toString() {
        return "Mã khách hàng: " + Ma_kh + " | " + super.toString() + " | Ngay dang ky " + Ngay_dang_ky + " | Thu hang: " + Hang_thanh_vien + " | Tổng tiền đã mua: " + Tong_tien_da_mua;
    }
}
class Nhanvien extends Person
{
    private String Ma_nv , Chuc_vu ;
    private LocalDate Ngay_vao_lam ;
    private int So_gio_lam ;
    private long Luong_theo_gio ;
    Scanner sc = new Scanner(System.in) ;
    public Nhanvien()
    {
        Ma_nv = Chuc_vu = "" ;
        Ngay_vao_lam = LocalDate.now() ;
        So_gio_lam = 0 ;
        Luong_theo_gio = 0 ;
    }
    public Nhanvien ( String ho_ten , String so_dt , String dia_chi , String email , String ma_nv , long luong_theo_gio , int so_gio_lam , LocalDate ngay_vao_lam)
    {
        super(ho_ten, so_dt, dia_chi, email);
        Ma_nv = ma_nv ;
        Luong_theo_gio = luong_theo_gio ;
        So_gio_lam = so_gio_lam ;
        Ngay_vao_lam = ngay_vao_lam ;
    }

    public void setChuc_vu(String chuc_vu) {
        Chuc_vu = chuc_vu;
    }

    public String getChuc_vu() {
        return Chuc_vu;
    }

    public void setSo_gio_lam(int so_gio_lam) {
        So_gio_lam = so_gio_lam;
    }

    public int getSo_gio_lam() {
        return So_gio_lam;
    }

    public void setLuong_theo_gio(long luong_theo_gio) {
        Luong_theo_gio = luong_theo_gio;
    }

    public void setNgay_vao_lam(LocalDate ngay_vao_lam) {
        Ngay_vao_lam = ngay_vao_lam;
    }

    public LocalDate getNgay_vao_lam() {
        return Ngay_vao_lam;
    }

    public void setMa_nv(String ma_nv) {
        Ma_nv = ma_nv;
    }

    public String getMa_nv() {
        return Ma_nv;
    }

    public long getLuong_theo_gio() {
        return Luong_theo_gio;
    }
    public int tinh_luong_theo_thang()
    {
        return 0 ;
    }
    public void set_person()
    {
        System.out.println("Nhập mã nhân viên: ");
        Ma_nv = sc.nextLine() ;
        super.set_person();
        System.out.println("Nhập ngày vào làm(dd/MM/yyyy): ");
        String ngay = sc.nextLine() ;
        DateTimeFormatter khuon = DateTimeFormatter.ofPattern("dd/MM/yyyy") ;
        Ngay_vao_lam = LocalDate.parse( ngay , khuon ) ;
        System.out.println("Nhập số giờ làm: ");
        So_gio_lam = sc.nextInt() ;
        System.out.println("Nhập mức lương theo giờ: ");
        Luong_theo_gio = sc.nextInt() ;
        sc.nextLine() ;
    }
    public String toString()
    {
        return "Ma nhân viên: " + Ma_nv + " | " + super.toString() + " | Chuc vu: " + Chuc_vu + " | Ngay vao lam: " + Ngay_vao_lam + " | Số giờ làm: " + So_gio_lam + " | Lương theo giờ: " + Luong_theo_gio  ;
    }
}
