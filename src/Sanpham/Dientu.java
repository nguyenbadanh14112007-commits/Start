package Sanpham;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Dientu extends Sanpham
{
    private int thoiGianBaoHanh ;
    private long tienBaoHanh ;
    private String chatLieu ;
    private LocalDate ngayMua ;
    public Dientu()
    {
        super();
        thoiGianBaoHanh = 0 ;
        tienBaoHanh = 0 ;
        chatLieu = "" ;
        ngayMua = LocalDate.now() ;
    }
    public Dientu( String maSanPham , String tenSanPham , String loaiSanPham , long giaNhap , long giaBan , int soLuongTonKho , int soSanPhamTrungBay , String maNhaCungCap ,
                   int thoiGianBaoHanh , long tienBaoHanh , String chatLieu , LocalDate ngayMua)
    {
        super( maSanPham, tenSanPham, loaiSanPham, giaNhap, giaBan, soLuongTonKho, soSanPhamTrungBay, maNhaCungCap);
        this.thoiGianBaoHanh = thoiGianBaoHanh ;
        this.tienBaoHanh = tienBaoHanh ;
        this.chatLieu = chatLieu ;
        this.ngayMua = ngayMua ;
    }

    public void setTienBaoHanh(long tienBaoHanh) {
        this.tienBaoHanh = tienBaoHanh;
    }

    public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }

    public int getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }

    public LocalDate getNgayMua() {
        return ngayMua;
    }

    public long getTienBaoHanh() {
        return tienBaoHanh;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public void setNgayMua(LocalDate ngayMua) {
        this.ngayMua = ngayMua;
    }

    public void setSanPham(Scanner sc)
    {
        super.setSanPham(sc);
        System.out.println("Nhập chất liệu: ");
        chatLieu = sc.nextLine() ;
        System.out.println("Nhập ngày mua(dd/MM/yyyy): ");
        String ngayMua = sc.nextLine() ;
        DateTimeFormatter khuon = DateTimeFormatter.ofPattern("dd/MM/yyyy") ;
        this.ngayMua = LocalDate.parse(ngayMua , khuon) ;
        System.out.println("Thời gian bảo hành(theo tháng): ");
        thoiGianBaoHanh = sc.nextInt() ;
        System.out.println("Số tiền bảo hành(nghìn đồng/năm): ");
        tienBaoHanh = sc.nextInt();
        sc.nextLine() ;
    }

    @Override
    public void trangThaiBan() {

    }

    @Override
    public int tinhThue() {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + " | Chất liệu: " + chatLieu + " | Tiền bảo hành: " + tienBaoHanh + " | Thời gian bảo hành: " + thoiGianBaoHanh ;
    }
    public LocalDate ngayHetHanBaoHanh()
    {

        return null;
    }
    public boolean kiemTraBaoHanh ()
    {
        return true;
    }
    public void giaHanBaoHanh()
    {
        
    }
    public String toStringKhachHang()
    {
        return "Mã sản phẩm: " + super.getMaSanPham() + " | Tên sản phẩm: " + super.getTenSanPham() + " | Giá bán: " + super.getGiaBan() + " | Số sản phẩm đang trưng bày: " + super.getSoSanPhamTrungBay() + " | Chất liệu: " + chatLieu + " | Tiền bảo hành: " + tienBaoHanh + " | Thời gian bảo hành: " + thoiGianBaoHanh ;
    }
}
