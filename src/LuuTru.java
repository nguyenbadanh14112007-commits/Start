import java.util.Scanner;

public abstract class LuuTru {
    private String maKhuVuc , tenKhuVuc , trangThai;
    private int sucChua , mucTaiHienTai ;
    public LuuTru ()
    {
        maKhuVuc = trangThai = tenKhuVuc = "" ;
        sucChua = mucTaiHienTai = 0 ;
    }
    public LuuTru( String maKhuVuc , String trangThai , int sucChua , int mucTaiHienTai )
    {
        this.maKhuVuc = maKhuVuc ;
        this.trangThai = trangThai ;
        this.sucChua = sucChua ;
        this.mucTaiHienTai = mucTaiHienTai ;
    }
    public boolean ktraDayKho ()
    {
        return true ;
    }

    public String getTenKhuVuc() {
        return tenKhuVuc;
    }

    public void setTenKhuVuc(String tenKhuVuc) {
        this.tenKhuVuc = tenKhuVuc;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public String getMaKhuVuc() {
        return maKhuVuc;
    }

    public int getSucChua() {
        return sucChua;
    }

    public int getMucTaiHienTai() {
        return mucTaiHienTai;
    }

    public void setMaKhuVuc(String maKhuVuc) {
        this.maKhuVuc = maKhuVuc;
    }

    public void setMucTaiHienTai(int mucTaiHienTai) {
        this.mucTaiHienTai = mucTaiHienTai;
    }

    public void setSucChua(int sucChua) {
        this.sucChua = sucChua;
    }
    public void setLuuTru(Scanner sc)
    {
        System.out.println("Nhập mã khu vực: ");
        maKhuVuc = sc.nextLine() ;
        System.out.println("Nhập tên khu vực: ");
        tenKhuVuc = sc.nextLine() ;
        System.out.println("Nhập trạng thái(Hoạt động/Đầy/Bảo trì): ");
        trangThai = sc.nextLine() ;
        System.out.println("Nhập sức chứa tối đa: ");
        sucChua = sc.nextInt() ;
        System.out.println("Nhập sức chứa hiện tại: ");
        mucTaiHienTai = sc.nextInt() ;
        sc.nextLine() ;
    }
    @Override
    public String toString() {
        return "Mã Khu vực: " + maKhuVuc + " | Tên khu vực: " + tenKhuVuc + " | Trạng thái: " + trangThai + " | Sức chứa tối đa : " + sucChua + " | Mức tải hiện tại: " + mucTaiHienTai ;
    }
}
class QuayTrungBay extends LuuTru
{
    private int day ; // dãy hàng trưng bày
    private String loaiHangTrungBay ;
}
