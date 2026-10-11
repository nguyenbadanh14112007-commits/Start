import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Doitac {
    private String Ma_dt , Ten_dt , So_dt , Dia_chi , Email , Ma_so_thue ;
    Scanner sc = new Scanner(System.in) ;
    public Doitac()
    {
        Ma_dt = Ten_dt = So_dt = Dia_chi = Ma_so_thue = Email = " " ;
    }
    public Doitac ( String ma_dt , String ten_dt , String so_dt , String dia_chi , String ma_so_thue , String email)
    {
        Ma_dt = ma_dt ;
        Ten_dt = ten_dt ;
        So_dt = so_dt ;
        Dia_chi = dia_chi ;
        Ma_so_thue = ma_so_thue ;
        Email = email ;
    }

    public void setSo_dt(String so_dt) {
        So_dt = so_dt;
    }

    public String getDia_chi() {
        return Dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        Dia_chi = dia_chi;
    }

    public String getSo_dt() {
        return So_dt;
    }

    public String getMa_dt() {
        return Ma_dt;
    }

    public String getMa_so_thue() {
        return Ma_so_thue;
    }

    public String getTen_dt() {
        return Ten_dt;
    }

    public void setMa_dt(String ma_dt) {
        Ma_dt = ma_dt;
    }

    public void setTen_dt(String ten_dt) {
        Ten_dt = ten_dt;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getEmail() {
        return Email;
    }

    public void setMa_so_thue(String ma_so_thue) {
        Ma_so_thue = ma_so_thue;
    }
    public void set_doitac ()
    {
        System.out.println("Nhập mã đối tác: ");
        Ma_dt = sc.nextLine() ;
        System.out.println("Nhập tên đối tác: ");
        Ten_dt = sc.nextLine() ;
        System.out.println("Nhập số điện thoại: ");
        So_dt = sc.nextLine() ;
        System.out.println("Nhập địa chỉ: ");
        Dia_chi = sc.nextLine() ;
        System.out.println("Nhập Email: ");
        Email = sc.nextLine() ;
        System.out.println("Nhập mã số thuế: ");
        Ma_so_thue = sc.nextLine() ;
    }
    @Override
    public String toString() {
        return "Mã đối tác: " + Ma_dt + " | Tên đối tác: " + Ten_dt + " | Số điện thoại: " + So_dt + " | Địa chỉ: " + Dia_chi + " | Email: " + Email + " | Mã số thuế: " + Ma_so_thue ;
    }
}
class Nhacungcap extends Doitac
{
    private String Nganh_hang_cung_cap  ;
    private long Han_muc_no_cong ;
    private ArrayList<Sanpham> sanpham_cungcap ;
    Scanner sc = new Scanner(System.in) ;
    public Nhacungcap()
    {
        Nganh_hang_cung_cap = "" ;
        Han_muc_no_cong = 0 ;
        sanpham_cungcap = new ArrayList<>() ;
    }
    public Nhacungcap ( String ma_dt , String ten_dt , String so_dt , String dia_chi , String ma_so_thue , String email , String nganh_hang_cung_cap , long han_muc_no_cong)
    {
        super(ma_dt, ten_dt, so_dt, dia_chi, ma_so_thue, email);
        Nganh_hang_cung_cap = nganh_hang_cung_cap ;
        Han_muc_no_cong = han_muc_no_cong ;
    }

    public String getNganh_hang_cung_cap() {
        return Nganh_hang_cung_cap;
    }

    public void setNganh_hang_cung_cap(String nganh_hang_cung_cap) {
        Nganh_hang_cung_cap = nganh_hang_cung_cap;
    }

    public void setHan_muc_no_cong(long han_muc_no_cong) {
        Han_muc_no_cong = han_muc_no_cong;
    }

    public long getHan_muc_no_cong() {
        return Han_muc_no_cong;
    }

    public ArrayList<Sanpham> getSanpham_cungcap() {
        return sanpham_cungcap;
    }

    public void setSanpham_cungcap(ArrayList<Sanpham> sanpham_cungcap) {
        this.sanpham_cungcap = sanpham_cungcap;
    }

    public void set_doitac()
    {
        super.set_doitac();
        System.out.println("Nhập ngành hàng cung cấp: ");
        Nganh_hang_cung_cap = sc.nextLine() ;
        System.out.println("Nhập hạn mức nợ công: ");
        Han_muc_no_cong = sc.nextInt() ;
        sc.nextLine() ;
    }
    public void Nhandon (Sanpham sp , int so_luong , LocalDate Ngay_dat_hang )
    {

    }
    public int Tim_kiem_sp ( String Ma_sp )
    {
        return -1 ;
    }
    public void In_danh_sach_sp ()
    {

    }
    public void Hien_thi_sp_tra_cuu ( String Ma_sp )
    {

    }
    public boolean ktra_han_muc_no_cong ()
    {
        return true ;
    }
    public String toString()
    {
        return super.toString() + " | Ngành hàng cung cấp: " + Nganh_hang_cung_cap + " | Hạn mức nợ công: " + Han_muc_no_cong ;
    }
}
class Donvivanchuyen extends Doitac
{
    private ArrayList<Xe> Danhsachxe ;
    public Donvivanchuyen()
    {
        Danhsachxe = new ArrayList<>() ;
    }
    public Donvivanchuyen( String ma_dt , String ten_dt , String so_dt , String dia_chi , String ma_so_thue , String email , ArrayList<Xe> danhsachxe )
    {
        super(ma_dt, ten_dt, so_dt, dia_chi, ma_so_thue, email);
        Danhsachxe = danhsachxe ;
    }

    public ArrayList<Xe> getDanhsachxe() {
        return Danhsachxe;
    }

    public void setDanhsachxe( ArrayList<Xe> danhsachxe) {
        Danhsachxe = danhsachxe;
    }
    public void Them_xe()
    {

    }
    public void Xoa_xe( String Ma_xe )
    {

    }
    public void Chinh_sua_xe ( String Ma_xe )
    {

    }
    public void Tim_xe ( String Ma_xe )
    {

    }
    public void In_bang_gia () // Danh sách xe
    {

    }
}
class Xe
{
    private String Ma_xe , Ten_xe , Loai_xe ;
    private long Gia_mot_km , Suc_chua_toi_da , Khoang_cach_di_chuyen , Gia_van_chuyen_co_ban;
    Scanner sc = new Scanner(System.in) ;
    public Xe()
    {
        Ma_xe = Ten_xe = Loai_xe = "" ;
        Gia_mot_km = Suc_chua_toi_da = Khoang_cach_di_chuyen = Gia_van_chuyen_co_ban = 0 ;
    }
    public Xe( String ma_xe , String ten_xe , String loai_xe , long gia_mot_km , long suc_chua_toi_da , long gia_van_chuyen_co_ban)
    {
        Ma_xe = ma_xe ;
        Ten_xe = ten_xe ;
        Gia_mot_km = gia_mot_km ;
        Suc_chua_toi_da = suc_chua_toi_da ;
        Gia_van_chuyen_co_ban = gia_van_chuyen_co_ban ;
    }
    public double chi_phi_van_chuyen()
    {
        return 0 ;
    }

    public void setSuc_chua_toi_da(long suc_chua_toi_da) {
        Suc_chua_toi_da = suc_chua_toi_da;
    }

    public long getSuc_chua_toi_da() {
        return Suc_chua_toi_da;
    }

    public long getGia_mot_km() {
        return Gia_mot_km;
    }

    public long getKhoang_cach_di_chuyen() {
        return Khoang_cach_di_chuyen;
    }

    public String getLoai_xe() {
        return Loai_xe;
    }

    public String getMa_xe() {
        return Ma_xe;
    }

    public String getTen_xe() {
        return Ten_xe;
    }

    public void setGia_mot_km(long gia_mot_km) {
        Gia_mot_km = gia_mot_km;
    }

    public void setLoai_xe(String loai_xe) {
        Loai_xe = loai_xe;
    }

    public void setKhoang_cach_di_chuyen(long khoang_cach_di_chuyen) {
        Khoang_cach_di_chuyen = khoang_cach_di_chuyen;
    }

    public void setMa_xe(String ma_xe) {
        Ma_xe = ma_xe;
    }

    public void setTen_xe(String ten_xe) {
        Ten_xe = ten_xe;
    }

    public long getGia_van_chuyen_co_ban() {
        return Gia_van_chuyen_co_ban;
    }

    public void setGia_van_chuyen_co_ban(long gia_van_chuyen_co_ban) {
        Gia_van_chuyen_co_ban = gia_van_chuyen_co_ban;
    }

    public void set_xe ()
    {
        System.out.println("Nhập mã số xe: ");
        Ma_xe = sc.nextLine() ;
        System.out.println("Nhập tên xe: ");
        Ten_xe = sc.nextLine() ;
        System.out.println("Nhập loại xe: ");
        Loai_xe = sc.nextLine() ;
        System.out.println("Nhập chi phí vận chuyển(Giá/km): ");
        Gia_mot_km = sc.nextInt() ;
        System.out.println("Nhập giá vận chuyển cơ bản: ");
        Gia_van_chuyen_co_ban = sc.nextInt() ;
        System.out.println("Nhập sức chứa tối đa của xe: ");
        Suc_chua_toi_da = sc.nextInt() ;
        sc.nextLine() ;
    }
    public void setKhoang_cach_di_chuyen()
    {
        System.out.println("Nhập khoảng cách di chuyển của xe: ");
        Khoang_cach_di_chuyen = sc.nextInt() ;
        sc.nextLine();
    }
    @Override
    public String toString() {
        return "Mã số xe: " + Ma_xe + " | Tên xe"  + Ten_xe + " | Loại xe: " + Loai_xe +  " | Giá/km: " + Gia_mot_km + " | Sức chở tối đa: " + Suc_chua_toi_da;
    }
}