import java.util.Scanner;

public abstract class LuuTru {
    private String Ma_khu_vuc , Ten_khu_vuc , Trang_thai;
    private int Suc_chua , Muc_tai_hien_tai ;
    Scanner sc = new Scanner(System.in) ;
    public LuuTru ()
    {
        Ma_khu_vuc = Trang_thai = Ten_khu_vuc = "" ;
        Suc_chua = Muc_tai_hien_tai = 0 ;
    }
    public LuuTru( String ma_khu_vuc , String trang_thai , int suc_chua , int muc_tai_hien_tai )
    {
        Ma_khu_vuc = ma_khu_vuc ;
        Trang_thai = trang_thai ;
        Suc_chua = suc_chua ;
        Muc_tai_hien_tai = muc_tai_hien_tai ;
    }
    public boolean Ktra_day_kho ()
    {
        return true ;
    }

    public String getTen_khu_vuc() {
        return Ten_khu_vuc;
    }

    public void setTen_khu_vuc(String ten_khu_vuc) {
        Ten_khu_vuc = ten_khu_vuc;
    }

    public void setTrang_thai(String trang_thai) {
        Trang_thai = trang_thai;
    }

    public String getTrang_thai() {
        return Trang_thai;
    }

    public String getMa_khu_vuc() {
        return Ma_khu_vuc;
    }

    public int getSuc_chua() {
        return Suc_chua;
    }

    public int getMuc_tai_hien_tai() {
        return Muc_tai_hien_tai;
    }

    public void setMa_khu_vuc(String ma_khu_vuc) {
        Ma_khu_vuc = ma_khu_vuc;
    }

    public void setMuc_tai_hien_tai(int muc_tai_hien_tai) {
        Muc_tai_hien_tai = muc_tai_hien_tai;
    }

    public void setSuc_chua(int suc_chua) {
        Suc_chua = suc_chua;
    }
    public void set_luu_tru()
    {
        System.out.println("Nhập mã khu vực: ");
        Ma_khu_vuc = sc.nextLine() ;
        System.out.println("Nhập tên khu vực: ");
        Ten_khu_vuc = sc.nextLine() ;
        System.out.println("Nhập trạng thái(Hoạt động/Đầy/Bảo trì): ");
        Trang_thai = sc.nextLine() ;
        System.out.println("Nhập sức chứa tối đa: ");
        Suc_chua = sc.nextInt() ;
        System.out.println("Nhập sức chứa hiện tại: ");
        Muc_tai_hien_tai = sc.nextInt() ;
        sc.nextLine() ;
    }
    @Override
    public String toString() {
        return "Mã Khu vực: " + Ma_khu_vuc + " | Tên khu vực: " + Ten_khu_vuc + " | Trạng thái: " + Trang_thai + " | Sức chứa tối đa : " + Suc_chua + " | Mức tải hiện tại: " + Muc_tai_hien_tai ;
    }
}
class QuayTrungBay extends LuuTru
{
    private int Day ; // dãy hàng trưng bày
    private String Loai_hang_trung_bay ;
    Scanner sc = new Scanner(System.in) ;
}
