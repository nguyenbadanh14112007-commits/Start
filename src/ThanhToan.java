import java.time.LocalDateTime;
import java.util.Scanner;

public abstract class ThanhToan {
    private String Ma_gd  , Trang_thai ;
    private LocalDateTime Ngay_thanh_toan ;
    private long So_tien ;
    Scanner sc = new Scanner(System.in) ;
    public ThanhToan()
    {
        Ma_gd = "" ;
        Ngay_thanh_toan = LocalDateTime.now() ;
        So_tien = 0 ;
        Trang_thai = "Đang xử lý" ;
    }
    public ThanhToan(String ma_gd , LocalDateTime ngay_thanh_toan , long so_tien , String trang_thai)
    {
        Ma_gd = ma_gd ;
        Ngay_thanh_toan = ngay_thanh_toan ;
        So_tien = so_tien ;
        Trang_thai = trang_thai ;
    }
    public String getMa_gd() {
        return Ma_gd;
    }

    public void setMa_gd(String ma_gd) {
        Ma_gd = ma_gd;
    }

    public LocalDateTime getNgay_thanh_toan() {
        return Ngay_thanh_toan;
    }

    public void setNgay_thanh_toan(LocalDateTime ngay_thanh_toan) {
        Ngay_thanh_toan = ngay_thanh_toan;
    }

    public long getSo_tien() {
        return So_tien;
    }

    public void setSo_tien(long so_tien) {
        So_tien = so_tien;
    }

    public String getTrang_thai() {
        return Trang_thai;
    }

    public void setTrang_thai(String trang_thai) {
        Trang_thai = trang_thai;
    }

    public void set_thanh_toan(int so_tien )
    {
        So_tien = so_tien ;
        System.out.println("Nhập mã giao dịch: ");
        Ma_gd = sc.nextLine() ;
    }
    public abstract void Thanh_toan() ;
    @Override
    public String toString() {
        return "Mã giao dịch: " + Ma_gd + " | Số tiền cần thanh toán: " + So_tien + " | Ngày giao dịch: " + Ngay_thanh_toan ;
    }
}
class ThanhToanNganHang extends ThanhToan
{
    private String Ma_gd_ngan_hang , Ten_ngan_hang , Ten_nguoi_chuyen , So_tk_chuyen ;
    Scanner sc = new Scanner(System.in) ;
    public ThanhToanNganHang()
    {
        Ma_gd_ngan_hang = Ten_ngan_hang = Ten_nguoi_chuyen = So_tk_chuyen = "" ;
    }
    public ThanhToanNganHang( String ma_gd_ngan_hang , String ten_ngan_hang , String ma_gd , LocalDateTime ngay_thanh_toan , long so_tien , String trang_thai )
    {
        super(ma_gd, ngay_thanh_toan, so_tien, trang_thai);
        Ma_gd_ngan_hang = ma_gd_ngan_hang ;
        Ten_ngan_hang = ten_ngan_hang ;
    }

    public String getMa_gd_ngan_hang() {
        return Ma_gd_ngan_hang;
    }

    public String getTen_ngan_hang() {
        return Ten_ngan_hang;
    }

    public void setMa_gd_ngan_hang(String ma_gd_ngan_hang) {
        Ma_gd_ngan_hang = ma_gd_ngan_hang;
    }

    public void setTen_ngan_hang(String ten_ngan_hang) {
        Ten_ngan_hang = ten_ngan_hang;
    }
    public void set_thanh_toan( int so_tien )
    {
        super.set_thanh_toan(so_tien);
        System.out.println("Nhập tên ngân hàng: ");
        Ten_ngan_hang = sc.nextLine() ;
        System.out.println("Nhập tên người chuyển: ");
        Ten_nguoi_chuyen = sc.nextLine() ;
        System.out.println("Nhập số tài khoản chuyển: ");
        So_tk_chuyen = sc.nextLine() ;
        Thanh_toan() ;
    }
    public void Thanh_toan()
    {
        System.out.println("Đang chờ giao dịch từ ngân hàng " + Ten_ngan_hang );
        System.out.println("Xác nhận giao dịch(1/0): ");
        int Xac_nhan = sc.nextInt() ;
        if ( Xac_nhan == 1 )
        {
            System.out.println("Đã nhận được " + super.getSo_tien() + " Từ tài khoản " + Ten_nguoi_chuyen + " có số tài khoản là " + So_tk_chuyen );
            System.out.println("Giao dịch thành công!");
            super.setTrang_thai("Thành công!");
        }
        else
        {
            System.out.println("Giao dịch không thành công vui lòng chuyển khoản lại hoặc dùng tiền mặc!");
            super.setTrang_thai("Thất bại!");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " | Mã giao dịch ngân hàng: " + Ma_gd_ngan_hang + " | Tên ngân hàng thanh toán: " + Ten_ngan_hang + " | Tên tài khoản chuyển: " + Ten_nguoi_chuyen + " | Số tài khoản: " + So_tk_chuyen  ;
    }
}
class ThanhToanTienMat extends ThanhToan
{
    private long Tien_khach_dua , Tien_thoi ;
    private String Ma_nhan_vien_thu ;
    public ThanhToanTienMat()
    {
        Tien_khach_dua = Tien_thoi = 0 ;
        Ma_nhan_vien_thu = "" ;
    }
    public ThanhToanTienMat ( long tien_khach_dua , long tien_thoi , String ma_nhan_vien_thu , String ma_gd , LocalDateTime ngay_thanh_toan , long so_tien , String trang_thai )
    {
        Tien_khach_dua = tien_khach_dua ;
        Tien_thoi = tien_thoi ;
        Ma_nhan_vien_thu = ma_nhan_vien_thu ;
        super(ma_gd, ngay_thanh_toan, so_tien, trang_thai);
    }

    public void setTien_thoi(long tien_thoi) {
        Tien_thoi = tien_thoi;
    }

    public void setMa_nhan_vien_thu(String ma_nhan_vien_thu) {
        Ma_nhan_vien_thu = ma_nhan_vien_thu;
    }

    public long getTien_khach_dua() {
        return Tien_khach_dua;
    }

    public String getMa_nhan_vien_thu() {
        return Ma_nhan_vien_thu;
    }

    public void setTien_khach_dua(long tien_khach_dua) {
        Tien_khach_dua = tien_khach_dua;
    }

    public long getTien_thoi() {
        return Tien_thoi;
    }
    public void set_thanh_toan(int so_tien , String ma_nhan_vien_thu ) {
        super.set_thanh_toan(so_tien);
        Ma_nhan_vien_thu = ma_nhan_vien_thu ;
        System.out.println("Tiền khách đưa: ");
        Tien_khach_dua = sc.nextInt() ;
        while (Tien_khach_dua < 0 )
        {
            System.out.println("Tiền khách đưa không thể bé hơn 0 vui lòng nhập lại! ");
            System.out.println("Tiền khách đưa: ");
            Tien_khach_dua = sc.nextInt() ;
        }
        System.out.println("Tiền thối lại: ");
        Tien_thoi = sc.nextInt() ;
        while (Tien_thoi < 0 )
        {
            System.out.println("Tiền thối không thể bé hơn 0 vui lòng nhập lại! ");
            System.out.println("Tiền thối: ");
            Tien_khach_dua = sc.nextInt() ;
        }
        sc.nextLine() ;
    }

    public void Thanh_toan()
    {

    }
    @Override
    public String toString() {
        return super.toString() + " | Số tiền khách đưa: " + Tien_khach_dua + " | Số tiền thối lại: " + Tien_thoi + " | Mã nhân viên thu: " + Ma_nhan_vien_thu ;
    }
}