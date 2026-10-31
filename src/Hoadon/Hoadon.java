package Hoadon ;
import dichvu.Khuyenmai ;
import Sanpham.Sanpham;
import utils.Nhapdulieu;
import Sanpham.Quanlysanpham ;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import Thanhtoan.ThanhToan ;
import java.time.LocalDate ;
public abstract class Hoadon {
    private String maHoaDon , maNhanVien  ;
    private LocalDateTime thoiGianIn ;
    public Hoadon ( String maNhanVien )
    {
        this.maNhanVien = maNhanVien ;
        maHoaDon =  "" ;
        thoiGianIn = LocalDateTime.now() ;
    }
    public Hoadon ( String maNhanVien , String maHoaDon , LocalDateTime thoiGianIn )
    {
        this.maHoaDon = maHoaDon ;
        this.maNhanVien = maNhanVien ;
        this.thoiGianIn = thoiGianIn ;
    }
    public void setHoaDon(Scanner sc)
    {
        System.out.println("Nhập mã hoá đơn: ");
        maHoaDon = sc.nextLine() ;
    }
    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public LocalDateTime getThoiGianIn() {
        return thoiGianIn;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public void setThoiGianIn(LocalDateTime thoiGianIn) {
        this.thoiGianIn = thoiGianIn;
    }
    public abstract int tongTienHoaDon() ;
    public abstract void inHoaDon( ArrayList<Sanpham> danhSachSanPham ) ;
    @Override
    public String toString() {
        return "Mã hoá đơn: " + maHoaDon + " | Mã nhân viên: " + maNhanVien + " | Thời gian in: " + thoiGianIn ;
    }
}
class CTHoaDonBan
{
    private String maSanPham , maHoaDon ;
    private String tenSanPham ;
    private int soLuong ;
    private long giaBan ;
    private long mucGiamGia ;
    private ArrayList<Khuyenmai> danhSachKhuyenMai ;
    public CTHoaDonBan()
    {
        maHoaDon = maSanPham = "" ;
        giaBan = mucGiamGia = 0 ;
        soLuong = 0 ;
        danhSachKhuyenMai = new ArrayList<>() ;
    }
    public CTHoaDonBan(CTgiohang gioHang)
    {
        maSanPham = gioHang.getMaSanPham() ;
        tenSanPham = gioHang.getTenSanPham() ;
        giaBan = gioHang.getGiaBan() ;
        soLuong = gioHang.getSoLuong();
        maHoaDon = "" ;
        danhSachKhuyenMai = new ArrayList<>() ;
    }

    public void setHoaDon( String maHoaDon )
    {
        this.maHoaDon = maHoaDon ;
    }
    public String apMaGiamGia() {

        return "" ;
    }

    public ArrayList<Khuyenmai> getKhuyenmais() {
        return danhSachKhuyenMai;
    }

    public void setKhuyenmais(ArrayList<Khuyenmai> danhSachKhuyenMai) {
        this.danhSachKhuyenMai = danhSachKhuyenMai;
    }

    public int tinhTienMacHang()
    {
        return Math.toIntExact(giaBan * soLuong - mucGiamGia);
    }
    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public long getGiaBan() {
        return giaBan;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setGiaBan(long giaBan) {
        this.giaBan = giaBan;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public long getMucGiamGia() {
        return mucGiamGia;
    }

    public void setMucGiamGia(long mucGiamGia) {
        this.mucGiamGia = mucGiamGia;
    }

    @Override
    public String toString() {
        return "Mã hoá đơn: " + maHoaDon + " | Mã sản phẩm: " + maSanPham +  " | Tên sản phẩm: " + tenSanPham +" | Số lượng: " + soLuong + " | Giá bán sau khuyến mãi: " + giaBan + " | Mức giảm giá: " + mucGiamGia ;
    }
}
class HoaDonBan extends  Hoadon
{
    private String maKhachHang ;
    private ArrayList<CTHoaDonBan> ctHoaDonBans ;
    private ThanhToan thanhToan ;
    public HoaDonBan( String maNhanVien )
    {
        super(maNhanVien);
        ctHoaDonBans = new ArrayList<>() ;
        maKhachHang = "" ;
        thanhToan = null ;
    }
    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public ArrayList<CTHoaDonBan> getCtHoaDonBans() {
        return ctHoaDonBans;
    }

    public void setCtHoaDonBans(ArrayList<CTHoaDonBan> ctHoaDonBans) {
        this.ctHoaDonBans = ctHoaDonBans;
    }

    public ThanhToan getThanhToan() {
        return thanhToan;
    }

    public void setThanhToan(ThanhToan thanhToan) {
        this.thanhToan = thanhToan;
    }
    public void setHoaDon(Scanner sc)
    {
        super.setHoaDon(sc);

    }
    @Override
    public int tongTienHoaDon() {
        return 0;
    }

    @Override
    public void inHoaDon(ArrayList<Sanpham> danhSachSanPham) {

    }

    @Override
    public String toString() {
        return super.toString() + "| Mã khách hàng: " + maKhachHang + " | Thanh toán: " + thanhToan.toString() ;
    }
}
class CTHoaDonNhap
{
    private String maHoaDonNhap , maSanPham , tenSanPham ;
    private int soLuong ;
    private long giaNhap ;
    public CTHoaDonNhap()
    {
        maHoaDonNhap = maSanPham = tenSanPham = "" ;
        soLuong = 0 ;
        giaNhap = 0 ;
    }
    public CTHoaDonNhap( String maHoaDon , String maSanPham , String tenSanPham , int soLuong , long giaNhap)
    {
        maHoaDonNhap = maHoaDon ;
        this.maSanPham = maSanPham ;
        this.tenSanPham = tenSanPham ;
        this.soLuong = soLuong ;
        this.giaNhap = giaNhap ;
    }
    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public String getMaHoaDonNhap() {
        return maHoaDonNhap;
    }

    public void setMaHoaDonNhap(String maHoaDonNhap) {
        this.maHoaDonNhap = maHoaDonNhap;
    }

    public long getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(long giaNhap) {
        this.giaNhap = giaNhap;
    }

    public long thanhTien()
    {
        return soLuong*giaNhap ;
    }
    public void setHoaDonNhap( Scanner sc , String maHoaDonNhap , Quanlysanpham quanLySanPham)
    {
        this.maHoaDonNhap = maHoaDonNhap ;
        maSanPham = Nhapdulieu.nhapChuoi(sc , "Nhập mã sản phẩm" , "SP\\d{3}" , "Mã sản phẩm không hợp lệ vui lòng nhập lại!(VD hợp lệ: SP001): ") ;
        soLuong = (int)Nhapdulieu.nhapSoNguyen(sc , "Nhập số lượng sản phẩm cần nhập!") ;
        int index = quanLySanPham.timKiemSanPham(maSanPham);
        while ( index == -1 )
        {
            System.out.println("Mã sản phẩm không tồn tại vui lòng nhập lại!");
            maSanPham = Nhapdulieu.nhapChuoi(sc , "Nhập mã sản phẩm: " , "SP\\d{3}" , "Mã sản phẩm hơp lệ vui lòng nhập lại!" ) ;
            index =  quanLySanPham.timKiemSanPham(maSanPham);

        }
        tenSanPham = quanLySanPham.getDanhSachSanPham().get(index).getTenSanPham() ;
        giaNhap = quanLySanPham.getDanhSachSanPham().get(index).getGiaNhap() ;
    }
    public void setHoaDonNhap( Scanner sc )
    {
        maHoaDonNhap = Nhapdulieu.nhapChuoi(sc , "Nhập mã hoá đơn: " , "HDN\\d{4}" , "Mã hoá đơn không hợp lệ vui lòng nhập lại!") ;

    }
    @Override
    public String toString() {
        return "Mã hoá đơn " + maHoaDonNhap + " | Mã sản phẩm " + maSanPham + " | Tên sản phẩm: " + tenSanPham + " | Số lượng: " + soLuong + " | Giá nhập: " + giaNhap ;
    }
}
class HoaDonNhap extends Hoadon
{
    private String maNhaCungCap , maDonViVanChuyen ;
    private ArrayList<CTHoaDonNhap> cTHoaDonNhaps ;

    public HoaDonNhap(String maNhanVien) {
        super(maNhanVien);
    }

    @Override
    public int tongTienHoaDon() {
        return 0;
    }

    @Override
    public void inHoaDon(ArrayList<Sanpham> danhSachSanPham) {

    }
}
class CTgiohang
{
    private String maSanPham , tenSanPham ;
    private long giaBan ;
    private int soLuong ;
    public CTgiohang()
    {
        maSanPham = tenSanPham = "" ;
        giaBan = 0 ;
        soLuong = 0 ;
    }
    public CTgiohang( String maSanPham , String tenSanPham , long giaBan , int soLuong )
    {
        this.maSanPham = maSanPham ;
        this.tenSanPham = tenSanPham ;
        this.giaBan = giaBan ;
        this.soLuong = soLuong ;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public void setGiaBan(long giaBan) {
        this.giaBan = giaBan;
    }

    public long getGiaBan() {
        return giaBan;
    }
    public void setCTGioHang(Scanner sc , Quanlysanpham quanLySanPham )
    {
        maSanPham = Nhapdulieu.nhapChuoi(sc , "Nhập mã sản phẩm: " , "SP\\d{3}" , "Mã sản phẩm hơp lệ vui lòng nhập lại!" ) ;
        soLuong = (int)Nhapdulieu.nhapSoNguyen(sc , "Nhập số lượng: ") ;
        int index = quanLySanPham.timKiemSanPham(maSanPham);
        while ( index == -1 )
        {
            System.out.println("Mã sản phẩm không tồn tại vui lòng nhập lại!");
            maSanPham = Nhapdulieu.nhapChuoi(sc , "Nhập mã sản phẩm: " , "SP\\d{3}" , "Mã sản phẩm hơp lệ vui lòng nhập lại!" ) ;
            index =  quanLySanPham.timKiemSanPham(maSanPham);

        }
        tenSanPham = quanLySanPham.getDanhSachSanPham().get(index).getTenSanPham() ;
        giaBan = quanLySanPham.getDanhSachSanPham().get(index).getGiaBan() ;
    }
    public long thanhTien()
    {
        return soLuong*giaBan ;
    }

    @Override
    public String toString() {
        return "Mã sản phẩm " + maSanPham + " | Tên sản phẩm: " + tenSanPham + " | Số lượng: " + soLuong + " | Giá bán: " + giaBan ;
    }
}
abstract class HoaDon {
    protected String maHoaDon;
    protected LocalDate ngayLap;
    protected String tenDoiTac;
    private static int demHoaDon = 0; // Sửa: Thêm = 0
    protected ArrayList<CTHoaDon> danhSachChiTiet;

    public HoaDon() {
        this.maHoaDon = "";
        this.ngayLap = LocalDate.now();
        this.tenDoiTac = "";
        this.danhSachChiTiet = new ArrayList<>();
        demHoaDon++;
    }

    public HoaDon(String maHoaDon, String tenDoiTac) {
        this.maHoaDon = maHoaDon;
        this.ngayLap = LocalDate.now();
        this.tenDoiTac = tenDoiTac;
        this.danhSachChiTiet = new ArrayList<>();
        demHoaDon++;
    }

    // SỬA: Tự động gộp số lượng nếu thêm trùng mã sản phẩm
    public void themChiTiet(CTHoaDon ct){
        for (CTHoaDon existing : this.danhSachChiTiet) {
            if (existing.getMaSanPham().equalsIgnoreCase(ct.getMaSanPham())) {
                existing.setSoLuong(existing.getSoLuong() + ct.getSoLuong());
                return;
            }
        }
        this.danhSachChiTiet.add(ct);
    }

    public boolean xoaChiTietMSP(String maSanPham){
        for( int i = 0 ; i<this.danhSachChiTiet.size();i++){
            if (danhSachChiTiet.get(i).getMaSanPham().equals(maSanPham)) {
                danhSachChiTiet.remove(i);
                return true;
            }
        }
        return false;
    }

    public static int getDemHoaDon(){ return demHoaDon; }

    public abstract double tinhTongTien();
    public abstract void hienThiHoaDon();

    public String getMaHoaDon() { return maHoaDon; }
    public void setMaHoaDon(String maHoaDon) { this.maHoaDon = maHoaDon; }
    public LocalDate getNgayLap() { return ngayLap; }
    public void setNgayLap(LocalDate ngayLap) { this.ngayLap = ngayLap; }
    public String getTenDoiTac() { return tenDoiTac; }
    public void setTenDoiTac(String tenDoiTac) { this.tenDoiTac = tenDoiTac; }
    public ArrayList<CTHoaDon> getDanhSachChiTiet() { return danhSachChiTiet; }
    public void setDanhSachChiTiet(ArrayList<CTHoaDon> danhSachChiTiet) { this.danhSachChiTiet = danhSachChiTiet; }
}
