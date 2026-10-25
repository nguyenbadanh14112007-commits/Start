import java.time.LocalDate;
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
    private String Ten_sp ;
    private int So_luong ;
    private long Gia_ban ;
    private long Muc_giam_gia ;
    private ArrayList<Khuyenmai> khuyenmais ;
    Scanner sc = new Scanner(System.in) ;
    public CTHoaDonBan()
    {
        Ma_hd = Ma_sp = "" ;
        Gia_ban = Muc_giam_gia = 0 ;
        So_luong = 0 ;
        khuyenmais = new ArrayList<>() ;
    }
    public CTHoaDonBan(CTgiohang giohang)
    {
        Ma_sp = giohang.getMa_sp() ;
        Ten_sp = giohang.getTen_sp() ;
        Gia_ban = giohang.getGia_ban() ;
        So_luong = giohang.getSo_luong();
        Ma_hd = "" ;
        khuyenmais = new ArrayList<>() ;
    }

    public void set_hoa_don( String ma_hd )
    {
        Ma_hd = ma_hd ;
    }
    public String ap_ma_giam_gia() {
        for (Khuyenmai km : khuyenmais) {
            for ( Sanpham sp : km.getDanhsachKM() )
            {
                if ( sp.getMa_sp().equalsIgnoreCase(Ma_sp))
                {
                    if (km.getNgay_bat_dau().isBefore(LocalDate.now()) && km.getNgay_ket_thuc().isAfter(LocalDate.now())) {
                        switch (km) {
                            case KhuyenMaiPhanTram khuyenMaiPhanTram -> {
                                Muc_giam_gia = (long) (Gia_ban * So_luong * khuyenMaiPhanTram.getPhan_tram_giam_gia());
                                if (Muc_giam_gia > khuyenMaiPhanTram.getMuc_giam_toi_da()) {
                                    Muc_giam_gia = khuyenMaiPhanTram.getMuc_giam_toi_da();
                                }
                                return "Bạn đã tiết kiệm được " + Muc_giam_gia + " VNĐ";
                            }
                            case KhuyenMaiTrucTiep khuyenMaiTrucTiep -> {
                                if (Gia_ban * So_luong >= km.getMuc_chi_toi_thieu())
                                    Muc_giam_gia = khuyenMaiTrucTiep.getSo_tien_giam();
                                return "Bạn đã tiết kiệm được " + Muc_giam_gia + " VNĐ";
                            }
                            case KhuyenMaiMuaTang khuyenMaiMuaTang -> {
                                if (Gia_ban * So_luong >= km.getMuc_chi_toi_thieu()) {
                                    So_luong -= khuyenMaiMuaTang.getSo_luong_tang();
                                    return "Bạn đã nhận được " + khuyenMaiMuaTang.getSo_luong_tang() + " sản phẩm từ việc mua " + Ten_sp;
                                }
                            }
                            default -> {
                            }
                        }
                    }
                }
            }
        }
        return "" ;
    }

    public ArrayList<Khuyenmai> getKhuyenmais() {
        return khuyenmais;
    }

    public void setKhuyenmais(ArrayList<Khuyenmai> khuyenmais) {
        this.khuyenmais = khuyenmais;
    }

    public int Tinh_tien_mac_hang()
    {
        return Math.toIntExact(Gia_ban * So_luong - Muc_giam_gia);
    }
    public void setMa_hd(String ma_hd) {
        Ma_hd = ma_hd;
    }

    public String getTen_sp() {
        return Ten_sp;
    }

    public void setTen_sp(String ten_sp) {
        Ten_sp = ten_sp;
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
        return "Mã hoá đơn: " + Ma_hd + " | Mã sản phẩm: " + Ma_sp +  " | Tên sản phẩm: " + Ten_sp +" | Số lượng: " + So_luong + " | Giá bán sau khuyến mãi: " + Gia_ban + " | Mức giảm giá: " + Muc_giam_gia ;
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
class CTHoaDonNhap
{
    private String Ma_hd_nhap , Ma_sp , Ten_sp ;
    private int So_luong ;
    private long Gia_nhap ;
    public CTHoaDonNhap()
    {
        Ma_hd_nhap = Ma_sp = Ten_sp = "" ;
        So_luong = 0 ;
        Gia_nhap = 0 ;
    }
    public CTHoaDonNhap( String ma_hd , String ma_sp , String ten_sp , int so_luong , long gia_nhap)
    {
        Ma_hd_nhap = ma_hd ;
        Ma_sp = ma_sp ;
        Ten_sp = ten_sp ;
        So_luong = so_luong ;
        Gia_nhap = gia_nhap ;
    }
    public String getTen_sp() {
        return Ten_sp;
    }

    public void setTen_sp(String ten_sp) {
        Ten_sp = ten_sp;
    }

    public void setSo_luong(int so_luong) {
        So_luong = so_luong;
    }

    public int getSo_luong() {
        return So_luong;
    }

    public void setMa_sp(String ma_sp) {
        Ma_sp = ma_sp;
    }

    public String getMa_sp() {
        return Ma_sp;
    }

    public String getMa_hd_nhap() {
        return Ma_hd_nhap;
    }

    public void setMa_hd_nhap(String ma_hd_nhap) {
        Ma_hd_nhap = ma_hd_nhap;
    }

    public long getGia_nhap() {
        return Gia_nhap;
    }

    public void setGia_nhap(long gia_nhap) {
        Gia_nhap = gia_nhap;
    }

    public long ThanhTien()
    {
        return So_luong*Gia_nhap ;
    }
    public void set_HoaDonNhap( Scanner sc , String ma_hd_nhap , Quanlysanpham qlsp)
    {
        Ma_hd_nhap = ma_hd_nhap ;
        Ma_sp = Nhapdulieu.NhapChuoi(sc , "Nhập mã sản phẩm" , "SP\\d{3}" , "Mã sản phẩm không hợp lệ vui lòng nhập lại!(VD hợp lệ: SP001): ") ;
        So_luong = (int)Nhapdulieu.NhapSoNguyen(sc , "Nhập số lượng sản phẩm cần nhập!") ;
        int index = qlsp.Tim_kiem_sp(Ma_sp);
        while ( index == -1 )
        {
            System.out.println("Mã sản phẩm không tồn tại vui lòng nhập lại!");
            Ma_sp = Nhapdulieu.NhapChuoi(sc , "Nhập mã sản phẩm: " , "SP\\d{3}" , "Mã sản phẩm hơp lệ vui lòng nhập lại!" ) ;
            index =  qlsp.Tim_kiem_sp(Ma_sp);

        }
        Ten_sp = qlsp.getDanhsachSP().get(index).getTen_sp() ;
        Gia_nhap = qlsp.getDanhsachSP().get(index).getGia_nhap() ;
    }
    public void setHoaDonNhap( Scanner sc )
    {
        Ma_hd_nhap = Nhapdulieu.NhapChuoi(sc , "Nhập mã hoá đơn: " , "HDN\\d{4}" , "Mã hoá đơn không hợp lệ vui lòng nhập lại!") ;

    }
    @Override
    public String toString() {
        return "Mã hoá đơn " + Ma_hd_nhap + " | Mã sản phẩm " + Ma_sp + " | Tên sản phẩm: " + Ten_sp + " | Số lượng: " + So_luong + " | Giá nhập: " + Gia_nhap ;
    }
}
class HoaDonNhap extends Hoadon
{
    private String Ma_ncc , Ma_dtvt ;
    private ArrayList<CTHoaDonNhap> CTHoaDonNhaps ;

    public HoaDonNhap(String ma_nv) {
        super(ma_nv);
    }

    @Override
    public int Tong_tien_hoa_don() {
        return 0;
    }

    @Override
    public void In_hoa_don(ArrayList<Sanpham> sanphams) {

    }
}
class CTgiohang
{
    private String Ma_sp , Ten_sp ;
    private long Gia_ban ;
    private int So_luong ;
    public CTgiohang()
    {
        Ma_sp = Ten_sp = "" ;
        Gia_ban = 0 ;
        So_luong = 0 ;
    }
    public CTgiohang( String ma_sp , String ten_sp , long gia_ban , int so_luong )
    {
        Ma_sp = ma_sp ;
        Ten_sp = ten_sp ;
        Gia_ban = gia_ban ;
        So_luong = so_luong ;
    }

    public void setSo_luong(int so_luong) {
        So_luong = so_luong;
    }

    public String getTen_sp() {
        return Ten_sp;
    }

    public String getMa_sp() {
        return Ma_sp;
    }

    public void setMa_sp(String ma_sp) {
        Ma_sp = ma_sp;
    }

    public int getSo_luong() {
        return So_luong;
    }

    public void setTen_sp(String ten_sp) {
        Ten_sp = ten_sp;
    }

    public void setGia_ban(long gia_ban) {
        Gia_ban = gia_ban;
    }

    public long getGia_ban() {
        return Gia_ban;
    }
    public void set_CTGioHang(Scanner sc , Quanlysanpham qlsp )
    {
        Ma_sp = Nhapdulieu.NhapChuoi(sc , "Nhập mã sản phẩm: " , "SP\\d{3}" , "Mã sản phẩm hơp lệ vui lòng nhập lại!" ) ;
        So_luong = (int)Nhapdulieu.NhapSoNguyen(sc , "Nhập số lượng: ") ;
        int index = qlsp.Tim_kiem_sp(Ma_sp);
        while ( index == -1 )
        {
            System.out.println("Mã sản phẩm không tồn tại vui lòng nhập lại!");
            Ma_sp = Nhapdulieu.NhapChuoi(sc , "Nhập mã sản phẩm: " , "SP\\d{3}" , "Mã sản phẩm hơp lệ vui lòng nhập lại!" ) ;
            index =  qlsp.Tim_kiem_sp(Ma_sp);

        }
        Ten_sp = qlsp.getDanhsachSP().get(index).getTen_sp() ;
        Gia_ban = qlsp.getDanhsachSP().get(index).getGia_ban() ;
    }
    public long ThanhTien()
    {
        return So_luong*Gia_ban ;
    }

    @Override
    public String toString() {
        return "Mã sản phẩm " + Ma_sp + " | Tên sản phẩm: " + Ten_sp + " | Số lượng: " + So_luong + " | Giá bán: " + Gia_ban ;
    }
}