import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Hoadon {
    private String Ma_hd , Ma_nv  ;
    private LocalDateTime Thoi_gian_in ;
    Scanner sc = new Scanner(System.in) ;
    public Hoadon ( String ma_nv )
    {
        Ma_nv = ma_nv ;
        Ma_hd =  "" ;
        Thoi_gian_in = LocalDateTime.now() ;
    }
    public Hoadon ( String ma_nv , String ma_hd , LocalDateTime thoi_gian_in )
    {
        Ma_hd = ma_hd ;
        Ma_nv = ma_nv ;
        Thoi_gian_in = thoi_gian_in ;
    }
    public void set_hoa_don()
    {
        System.out.println("Nhập mã hoá đơn: ");
        Ma_hd = sc.nextLine() ;
    }
    public String getMa_nv() {
        return Ma_nv;
    }

    public void setMa_nv(String ma_nv) {
        Ma_nv = ma_nv;
    }

    public LocalDateTime getThoi_gian_in() {
        return Thoi_gian_in;
    }

    public String getMa_hd() {
        return Ma_hd;
    }

    public void setMa_hd(String ma_hd) {
        Ma_hd = ma_hd;
    }

    public void setThoi_gian_in(LocalDateTime thoi_gian_in) {
        Thoi_gian_in = thoi_gian_in;
    }
    public abstract int Tong_tien_hoa_don() ;
    public abstract void In_hoa_don( ArrayList<Sanpham> sanphams ) ;
    @Override
    public String toString() {
        return "Mã hoá đơn: " + Ma_hd + " | Mã nhân viên: " + Ma_nv + " | Thời gian in: " + Thoi_gian_in ;
    }
}
class CTHoaDonBan
{
    private String Ma_sp , Ma_hd ;
    private int So_luong ;
    private long Gia_ban ;
    private long Muc_giam_gia ;
    private transient ArrayList<KhuyenMaiPhanTram> khuyenMaiPhanTrams ;
    private transient ArrayList<KhuyenMaiTrucTiep> khuyenMaiTrucTieps ;
    private transient ArrayList<KhuyenMaiMuaTang> khuyenMaiMuaTangs ;
    Scanner sc = new Scanner(System.in) ;
    public CTHoaDonBan()
    {
        Ma_hd = Ma_sp = "" ;
        Gia_ban = Muc_giam_gia = 0 ;
        So_luong = 0 ;
    }
    public void set_hoa_don( String ma_hd )
    {
        Ma_hd = ma_hd ;
        System.out.println("Nhập mã sản phẩm: ");
        Ma_sp = sc.nextLine() ;
        System.out.println("Nhập số lượng: ");
        So_luong = sc.nextInt() ;
        System.out.println("Nhập giá bán: ");
        Gia_ban = sc.nextInt() ;
        sc.nextLine() ;
    }
    public void ap_ma_giam_gia()
    {

    }
    public void setMa_hd(String ma_hd) {
        Ma_hd = ma_hd;
    }

    public String getMa_hd() {
        return Ma_hd;
    }

    public long getGia_ban() {
        return Gia_ban;
    }

    public String getMa_sp() {
        return Ma_sp;
    }

    public void setGia_ban(long gia_ban) {
        Gia_ban = gia_ban;
    }

    public void setMa_sp(String ma_sp) {
        Ma_sp = ma_sp;
    }

    public int getSo_luong() {
        return So_luong;
    }

    public void setSo_luong(int so_luong) {
        So_luong = so_luong;
    }

    public long getMuc_giam_gia() {
        return Muc_giam_gia;
    }

    public void setMuc_giam_gia(long muc_giam_gia) {
        Muc_giam_gia = muc_giam_gia;
    }

    @Override
    public String toString() {
        return "Mã hoá đơn: " + Ma_hd + " | Mã sản phẩm: " + Ma_sp + " | Số lượng: " + So_luong + " | Giá bán sau khuyến mãi: " + Gia_ban + " | Mức giảm giá: " + Muc_giam_gia ;
    }
}
class HoaDonBan extends  Hoadon
{
    private String Ma_kh ;
    private ArrayList<CTHoaDonBan> ctHoaDonBans ;
    private ThanhToan thanhToan ;
    Scanner sc = new Scanner(System.in) ;
    public HoaDonBan( String ma_nv )
    {
        super(ma_nv);
        ctHoaDonBans = new ArrayList<>() ;
        Ma_kh = "" ;
        thanhToan = null ;
    }
    public String getMa_kh() {
        return Ma_kh;
    }

    public void setMa_kh(String ma_kh) {
        Ma_kh = ma_kh;
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
    public void set_hoa_don()
    {
        super.set_hoa_don();
        System.out.println("Nhập mã khách hàng: ");
        Ma_kh = sc.nextLine() ;
        boolean hop_le = true ;
        while( hop_le )
        System.out.println("Chọn hình thức thanh toán:");
        System.out.println("1. Thanh toán qua ngân hàng!");
        System.out.println("2. Thanh toán bằng tiền mặc!");
        int Lua_chon = sc.nextInt() ;
        sc.nextLine() ;
        switch ( Lua_chon)
        {
            case 1:
                thanhToan = new ThanhToanNganHang() ;
                thanhToan.set_thanh_toan(Tong_tien_hoa_don());
            case 2:

        }
    }
    @Override
    public int Tong_tien_hoa_don() {
        return 0;
    }

    @Override
    public void In_hoa_don(ArrayList<Sanpham> sanphams) {

    }

    @Override
    public String toString() {
        return super.toString() + "| Mã khách hàng: " + Ma_kh + " | Thanh toán: " + thanhToan.toString() ;
    }
}