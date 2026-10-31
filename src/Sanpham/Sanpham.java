package Sanpham;

import java.util.Scanner;

public abstract class Sanpham {
    private String maSanPham , tenSanPham , loaiSanPham , maNhaCungCap;
    private long giaNhap , giaBan ;
    private int soLuongTonKho , soSanPhamTrungBay ;
    private double thue ;
    public Sanpham()
    {
        maSanPham = tenSanPham = loaiSanPham = maNhaCungCap = "" ;
        giaNhap = giaBan = 0 ;
        soLuongTonKho = soSanPhamTrungBay = 0 ;
        thue = 0 ;
    }
    public Sanpham( String maSanPham , String tenSanPham , String loaiSanPham , long giaNhap , long giaBan , int soLuongTonKho , int soSanPhamTrungBay , String maNhaCungCap )
    {
        this.maSanPham = maSanPham ;
        this.tenSanPham = tenSanPham ;
        this.loaiSanPham = loaiSanPham ;
        this.giaNhap = giaNhap ;
        this.giaBan = giaBan ;
        this.soLuongTonKho = soLuongTonKho ;
        this.soSanPhamTrungBay = soSanPhamTrungBay ;
        this.maNhaCungCap = maNhaCungCap ;
    }

    public void setThue(double thue) {
        this.thue = thue;
    }

    public double getThue() {
        return thue;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public void setMaNhaCungCap(String maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    public void setSoLuongTonKho(int soLuongTonKho) {
        this.soLuongTonKho = soLuongTonKho;
    }

    public void setGiaNhap(long giaNhap) {
        this.giaNhap = giaNhap;
    }

    public void setGiaBan(long giaBan) {
        this.giaBan = giaBan;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public String getLoaiSanPham() {
        return loaiSanPham;
    }

    public void setLoaiSanPham(String loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }

    public String getMaNhaCungCap() {
        return maNhaCungCap;
    }

    public int getSoLuongTonKho() {
        return soLuongTonKho;
    }

    public int getSoSanPhamTrungBay() {
        return soSanPhamTrungBay;
    }

    public long getGiaBan() {
        return giaBan;
    }

    public long getGiaNhap() {
        return giaNhap;
    }

    public void setSoSanPhamTrungBay(int soSanPhamTrungBay) {
        this.soSanPhamTrungBay = soSanPhamTrungBay;
    }
    public void setSanPham(Scanner sc)
    {
        System.out.println("Nhập mã sản phẩm: ");
        maSanPham = sc.nextLine() ;
        System.out.println("Nhập tên sản phẩm: ");
        tenSanPham = sc.nextLine() ;
        System.out.println("Nhập giá bán: ");
        giaBan = sc.nextInt() ;
        System.out.println("Nhập giá nhập: ");
        giaNhap = sc.nextInt() ;
        System.out.println("Nhập số lượng nhập: ");
        soLuongTonKho = sc.nextInt() ;
        System.out.println("Nhập số lượng sản phẩm trưng bày: ");
        soSanPhamTrungBay = sc.nextInt() ;
        sc.nextLine() ;
    }

    public abstract void trangThaiBan() ;
    public abstract int tinhThue() ;
    @Override
    public String toString() {
        return "Mã sản phẩm: " + maSanPham + " | Tên sản phẩm: " + tenSanPham + " | Giá nhập: " + giaNhap + " | Giá bán: " + giaBan + " | Số sản phẩm tồn kho : " + soLuongTonKho + " | Số sản phẩm trưng bày: " + soSanPhamTrungBay + " | Nhà cung cấp : " + maNhaCungCap;
    }
    public abstract String toStringKhachHang() ;
}
