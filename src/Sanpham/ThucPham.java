package Sanpham;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ThucPham extends Sanpham
{
    private LocalDate ngaySanXuat , hanSuDung ;
    private double nhietDoBaoQuan ;
    private String baoQuan ;
    public ThucPham()
    {
        super();
        ngaySanXuat = hanSuDung = LocalDate.now() ;
        nhietDoBaoQuan = 0 ;
        baoQuan = "" ;
    }
    public ThucPham ( String maSanPham , String tenSanPham , String loaiSanPham , long giaNhap , long giaBan , int soLuongTonKho , int soSanPhamTrungBay , String maNhaCungCap ,
            LocalDate ngaySanXuat , LocalDate hanSuDung , double nhietDoBaoQuan , String baoQuan)
    {
        super( maSanPham, tenSanPham, loaiSanPham, giaNhap, giaBan, soLuongTonKho, soSanPhamTrungBay, maNhaCungCap);
        this.ngaySanXuat = ngaySanXuat ;
        this.hanSuDung = hanSuDung ;
        this.nhietDoBaoQuan = nhietDoBaoQuan ;
        this.baoQuan = baoQuan ;
    }

    public double getNhietDoBaoQuan() {
        return nhietDoBaoQuan;
    }

    public LocalDate getHanSuDung() {
        return hanSuDung;
    }

    public LocalDate getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setHanSuDung(LocalDate hanSuDung) {
        this.hanSuDung = hanSuDung;
    }

    public void setNhietDoBaoQuan(double nhietDoBaoQuan) {
        this.nhietDoBaoQuan = nhietDoBaoQuan;
    }

    public String getBaoQuan() {
        return baoQuan;
    }

    public void setBaoQuan(String baoQuan) {
        this.baoQuan = baoQuan;
    }

    public void setNgaySanXuat(LocalDate ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }

    @Override
    public void setSanPham(Scanner sc)
    {
        super.setSanPham(sc);
        System.out.println("Nhập ngày sản xuất(dd/MM/yyyy): ");
        String ngaySanXuat = sc.nextLine() ;
        System.out.println("Nhập hạn sử dụng(dd/MM/yyyy): ");
        String hanSuDung = sc.nextLine() ;
        System.out.println("Nhập môi trường bảo quản: ");
        baoQuan = sc.nextLine() ;
        System.out.println("Nhập nhiệt độ bảo quản: ");
        nhietDoBaoQuan = sc.nextInt();
        sc.nextLine();
        DateTimeFormatter khuon = DateTimeFormatter.ofPattern("dd/MM/yyyy") ;
        this.ngaySanXuat = LocalDate.parse( ngaySanXuat , khuon) ;
        this.hanSuDung = LocalDate.parse(hanSuDung , khuon) ;
    }
    public int ktraNgayHetHan() {
        return 0 ;
    }//
    public boolean kiemTraSanPhamHong()
    {
        return true ;
    }//

    @Override
    public void trangThaiBan()
    {

    }

    @Override
    public int tinhThue() { //thuế VAT, thuế hàng hoá nếu có nhập lại,.... cộng lại thiết lập giá trị cho biến thuế

        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + " | Ngày sản xuất: " + ngaySanXuat + " | Hạn sử dụng: " + hanSuDung + " | Môi trường bảo quản: " + baoQuan + " | Nhiệt độ bảo quản : " + nhietDoBaoQuan;
    }
    public String toStringKhachHang()
    {
        return "Mã sản phẩm: " + super.getMaSanPham() + " | Tên sản phẩm: " + super.getTenSanPham() + " | Giá bán: " + super.getGiaBan() + " | Số sản phẩm đang trưng bày: " + super.getSoSanPhamTrungBay() + " | Ngày sản xuất: " + ngaySanXuat + " | Hạn sử dụng: " + hanSuDung + " | Môi trường bảo quản: " + baoQuan + " | Nhiệt độ bảo quản : " + nhietDoBaoQuan;
    }
}
