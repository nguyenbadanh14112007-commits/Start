import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Khuyenmai {
    private String Ma_km , Loai_km ;
    private LocalDate Ngay_bat_dau , Ngay_ket_thuc ;
    private long Muc_chi_toi_thieu ;
    Scanner sc = new Scanner(System.in) ;
    private ArrayList<Sanpham> DanhsachKM ;
    public Khuyenmai()
    {
        Ma_km = Loai_km = "" ;
        Ngay_bat_dau = Ngay_ket_thuc = LocalDate.now() ;
        Muc_chi_toi_thieu = 0 ;
        DanhsachKM = new ArrayList<>() ;
    }
    public Khuyenmai ( String ma_km , String loai_km , LocalDate ngay_bat_dau , LocalDate ngay_ket_thuc , long muc_chi_toi_thieu , ArrayList<Sanpham> danhsachKM)
    {
        Ma_km = ma_km ;
        Loai_km = loai_km ;
        Ngay_bat_dau = ngay_bat_dau ;
        Ngay_ket_thuc= ngay_ket_thuc ;
        DanhsachKM = danhsachKM ;
    }
    public void set_KM ()
    {
        System.out.println("Nhập mã khuyến mãi: ");
        Ma_km = sc.nextLine() ;
        System.out.println("Nhập ngày bắt đầu(dd/MM/yyyy): ");
        String ngay_bd = sc.nextLine() ;
        System.out.println("Nhập ngày kết thúc(dd/MM/yyyy): ");
        String ngay_kt = sc.nextLine() ;
        DateTimeFormatter khuon = DateTimeFormatter.ofPattern("dd/MM/yyyy") ;
        Ngay_bat_dau = LocalDate.parse( ngay_bd , khuon ) ;
        Ngay_ket_thuc = LocalDate.parse( ngay_kt , khuon ) ;
        System.out.println("Mức chi tiêu tối thiểu để sử dụng khuyến mãi: ");
        Muc_chi_toi_thieu = sc.nextInt() ;
        sc.nextLine() ;
    }
    public void In_danh_sach_sp_KM()
    {

    }
    public void Them_sp()
    {

    }
    public void Xoa_sp( String Ma_sp )
    {

    }
    public int Tim_kiem_sp ( String Ma_sp )
    {
        return -1 ;
    }
    public LocalDate getNgay_bat_dau() {
        return Ngay_bat_dau;
    }

    public ArrayList<Sanpham> getDanhsachKM() {
        return DanhsachKM;
    }

    public void setDanhsachKM(ArrayList<Sanpham> danhsachKM) {
        DanhsachKM = danhsachKM;
    }

    public LocalDate getNgay_ket_thuc() {
        return Ngay_ket_thuc;
    }

    public long getMuc_chi_toi_thieu() {
        return Muc_chi_toi_thieu;
    }

    public String getLoai_km() {
        return Loai_km;
    }

    public String getMa_km() {
        return Ma_km;
    }

    public void setLoai_km(String loai_km) {
        Loai_km = loai_km;
    }

    public void setNgay_bat_dau(LocalDate ngay_bat_dau) {
        Ngay_bat_dau = ngay_bat_dau;
    }

    public void setMuc_chi_toi_thieu(long muc_chi_toi_thieu) {
        Muc_chi_toi_thieu = muc_chi_toi_thieu;
    }

    public void setNgay_ket_thuc(LocalDate ngay_ket_thuc) {
        Ngay_ket_thuc = ngay_ket_thuc;
    }

    public void setMa_km(String ma_km) {
        Ma_km = ma_km;
    }
    public abstract int tra_cuu_gia_san_pham_sau_KM ( String Ma_sp ) ;
    @Override
    public String toString() {
        return "Mã khuyến mãi: " + Ma_km + " | Loại khuyến mãi: " + Loai_km + " | Ngày bắt đầu: " + Ngay_bat_dau + " | Ngày kết thúc: " + Ngay_ket_thuc +  " | Mức chi tiêu tối thiểu: " + Muc_chi_toi_thieu ;
    }
}
class KhuyenMaiPhanTram extends Khuyenmai
{
    private double Phan_tram_giam_gia ;
    private long Muc_giam_toi_da ;
    Scanner sc = new Scanner(System.in) ;
    public KhuyenMaiPhanTram()
    {
        Phan_tram_giam_gia = 0 ;
        Muc_giam_toi_da = 0 ;
        super.setLoai_km("Giảm theo phần trăm");
    }
    public KhuyenMaiPhanTram( String ma_km , String loai_km , LocalDate ngay_bat_dau , LocalDate ngay_ket_thuc , long muc_chi_toi_thieu , ArrayList<Sanpham> danhsachKM , double phan_tram_giam_gia , long muc_giam_toi_da )
    {
        super(ma_km, loai_km, ngay_bat_dau, ngay_ket_thuc, muc_chi_toi_thieu, danhsachKM);
        Phan_tram_giam_gia = phan_tram_giam_gia ;
        Muc_giam_toi_da = muc_giam_toi_da ;
    }

    public void setPhan_tram_giam_gia(double phan_tram_giam_gia) {
        Phan_tram_giam_gia = phan_tram_giam_gia;
    }

    public double getPhan_tram_giam_gia() {
        return Phan_tram_giam_gia;
    }

    public long getMuc_giam_toi_da() {
        return Muc_giam_toi_da;
    }

    public void setMuc_giam_toi_da(long muc_giam_toi_da) {
        Muc_giam_toi_da = muc_giam_toi_da;
    }

    public void set_KM()
    {
        super.set_KM();
        System.out.println("Nhập phần trăm giảm giá cho sản phẩm: ");
        Phan_tram_giam_gia = sc.nextDouble() ;
        if ( Phan_tram_giam_gia > 1 ) Phan_tram_giam_gia *= 0.01 ;
        System.out.println("Nhập số tiền được giảm tối đa: ");
        Muc_giam_toi_da = sc.nextInt() ;
        sc.nextLine() ;
    }
    public String toString()
    {
        return super.toString()  + " | Phần trăm giảm giá: " + Phan_tram_giam_gia + " | Mức giảm tối đa: " + Muc_giam_toi_da ;
    }
    public int tra_cuu_gia_san_pham_sau_KM (String Ma_sp )
    {
        return -1 ;
    }
}
class KhuyenMaiTrucTiep extends Khuyenmai
{
    private long So_tien_giam ;
    public KhuyenMaiTrucTiep()
    {
        So_tien_giam = 0 ;
        super.setLoai_km("Giảm giá trực tiếp");
    }
    public KhuyenMaiTrucTiep( String ma_km , String loai_km , LocalDate ngay_bat_dau , LocalDate ngay_ket_thuc , long muc_chi_toi_thieu , ArrayList<Sanpham> danhsachKM , long so_tien_giam)
    {
        super(ma_km, loai_km, ngay_bat_dau, ngay_ket_thuc, muc_chi_toi_thieu, danhsachKM);
        So_tien_giam = so_tien_giam ;
    }

    public long getSo_tien_giam() {
        return So_tien_giam;
    }

    public void setSo_tien_giam(long so_tien_giam) {
        So_tien_giam = so_tien_giam;
    }
    public void set_KM()
    {
        super.set_KM();
        System.out.println("Nhập số tiền giảm giá trực tiếp: ");
        So_tien_giam = sc.nextInt() ;
        while ( So_tien_giam > super.getMuc_chi_toi_thieu() )
        {
            System.out.println("Số tiền giảm giá không thể lớn hơn mức tiêu tối thiểu, vui lòng nhập lại: ");
            System.out.println("Nhập số tiền giảm giá trực tiếp: ");
            So_tien_giam = sc.nextInt() ;
        }
        sc.nextLine() ;
    }
    public String toString()
    {
        return super.toString() + " | Số tiền giảm giá trực tiếp: " + So_tien_giam ;
    }
    public int tra_cuu_gia_san_pham_sau_KM (String Ma_sp )
    {
        return -1 ;
    }
}
class KhuyenMaiMuaTang extends Khuyenmai
{
    private int So_luong_mua_toi_thieu  , So_luong_tang;
    Scanner sc = new Scanner(System.in) ;
    public KhuyenMaiMuaTang()
    {
        So_luong_mua_toi_thieu = So_luong_tang = 0;
    }
    public KhuyenMaiMuaTang( String ma_km , String loai_km , LocalDate ngay_bat_dau , LocalDate ngay_ket_thuc , long muc_chi_toi_thieu , ArrayList<Sanpham> danhsachKM , int so_luong_mua_toi_thieu , int so_luong_tang)
    {
        super(ma_km, loai_km, ngay_bat_dau, ngay_ket_thuc, muc_chi_toi_thieu, danhsachKM);
        So_luong_mua_toi_thieu = so_luong_mua_toi_thieu ;
        So_luong_tang = so_luong_tang ;
    }

    public void setSo_luong_mua_toi_thieu(int so_luong_mua_toi_thieu) {
        So_luong_mua_toi_thieu = so_luong_mua_toi_thieu;
    }

    public void setSo_luong_tang(int so_luong_tang) {
        So_luong_tang = so_luong_tang;
    }

    public int getSo_luong_mua_toi_thieu() {
        return So_luong_mua_toi_thieu;
    }

    public int getSo_luong_tang() {
        return So_luong_tang;
    }
    public void set_KM()
    {
        super.set_KM();
        System.out.println("Nhập số lượng sản phẩm mua tối thiểu để nhận khuyến mãi: ");
        So_luong_mua_toi_thieu = sc.nextInt() ;
        System.out.println("Nhập số lượng sản phẩm tặng: ");
        So_luong_tang = sc.nextInt() ;
        super.setLoai_km("Mua " + So_luong_mua_toi_thieu + " tặng " + So_luong_tang );
        sc.nextLine() ;
    }
    public int tra_cuu_gia_san_pham_sau_KM (String Ma_sp  ) // trả về giá ban đầu
    {
        return -1 ;
    }
    public int tra_cuu_gia_san_pham_sau_KM ( String Ma_sp , int so_luong_mua ) // VD: mua 1 tặng 1 thì số lượng mua 2 trả về số tiền 1 thôi
    {
        if ( so_luong_mua == 1 ) return tra_cuu_gia_san_pham_sau_KM(Ma_sp) ;
        return -1;
    }
}