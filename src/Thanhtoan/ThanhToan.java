package Thanhtoan ;
import utils.Nhapdulieu;
import java.time.LocalDateTime;
import java.util.Scanner;
public abstract class ThanhToan {
    private String maGiaoDich , trangThai ;
    private LocalDateTime ngayThanhToan ;
    private long soTien;
    private String maNhanVien ;
    public ThanhToan()
    {
        maGiaoDich = maNhanVien = "" ;
        ngayThanhToan = LocalDateTime.now() ;
        soTien = 0 ;
        trangThai = "Đang xử lý" ;
    }
    public ThanhToan( String maNhanVien , String maGiaoDich , LocalDateTime ngayThanhToan , long soTien , String trangThai)
    {
        this.maNhanVien = maNhanVien;
        this.maGiaoDich = maGiaoDich;
        this.ngayThanhToan = ngayThanhToan;
        this.soTien = soTien;
        this.trangThai = trangThai;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public String getMaGiaoDich() {
        return maGiaoDich;
    }

    public void setMaGiaoDich(String maGiaoDich) {
        this.maGiaoDich = maGiaoDich;
    }

    public LocalDateTime getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(LocalDateTime ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public long getSoTien() {
        return soTien;
    }

    public void setSoTien(long soTien) {
        this.soTien = soTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public void setThanhToan(  Scanner sc , long soTien , String maNhanVien )
    {
        this.soTien = soTien;
        this.maNhanVien = maNhanVien ;
        maGiaoDich = utils.Validation.inputStringRegex(sc , "Nhập mã giao dịch: " , "GD\\d{3}" , "Mã giao dịch sai định dạng vui lòng nhập lại(VD:GD001)!");
    }
    public abstract void thanhToanGiaoDich(  Scanner sc ) ;
    @Override
    public String toString() {
        return "Mã giao dịch: " + maGiaoDich + " | Số tiền cần thanh toán: " + soTien + " | Ngày giao dịch: " + ngayThanhToan + " | Mã nhân viên: " + maNhanVien;
    }
}
class ThanhToanNganHang extends ThanhToan
{
    private String maGiaoDichNganHang , tenNganHang , tenNguoiChuyen , soTaiKhoanChuyen ;
    public ThanhToanNganHang()
    {
        maGiaoDichNganHang = tenNganHang = tenNguoiChuyen = soTaiKhoanChuyen = "" ;
    }
    public ThanhToanNganHang( String maNhanVien , String maGiaoDichNganHang , String tenNganHang , String maGiaoDich , LocalDateTime ngayThanhToan , long soTien , String trangThai , String tenNguoiChuyen , String soTaiKhoanChuyen )
    {
        super(maNhanVien , maGiaoDich, ngayThanhToan, soTien, trangThai);
        this.maGiaoDichNganHang = maGiaoDichNganHang;
        this.tenNganHang = tenNganHang;
        this.tenNguoiChuyen = tenNguoiChuyen;
        this.soTaiKhoanChuyen = soTaiKhoanChuyen;
    }

    public String getMaGiaoDichNganHang() {
        return maGiaoDichNganHang;
    }

    public String getTenNganHang() {
        return tenNganHang;
    }

    public void setMaGiaoDichNganHang(String maGiaoDichNganHang) {
        this.maGiaoDichNganHang = maGiaoDichNganHang;
    }

    public void setTenNganHang(String tenNganHang) {
        this.tenNganHang = tenNganHang;
    }
    public void setThanhToan(  Scanner sc , long soTien , String maNhanVien )
    {
        super.setThanhToan(sc , soTien , maNhanVien);
        System.out.println("Nhập tên ngân hàng: ");
        tenNganHang = sc.nextLine() ;
        System.out.println("Nhập tên người chuyển: ");
        tenNguoiChuyen = sc.nextLine() ;
        System.out.println("Nhập số tài khoản chuyển: ");
        soTaiKhoanChuyen = sc.nextLine() ;
        System.out.println("Nhập mã giao dịch ngân hàng: ");
        maGiaoDichNganHang = sc.nextLine() ;
        thanhToanGiaoDich(sc); ;
    }
    public void thanhToanGiaoDich(  Scanner sc )
    {
        System.out.println("Đang chờ giao dịch từ ngân hàng " + tenNganHang );
        int xacNhan = Nhapdulieu.luaChon( sc , "Xác nhận giao dịch(1/0): " , 0 , 1 ) ;
        if ( xacNhan == 1 )
        {
            System.out.println("Đã nhận được " + super.getSoTien() + " Từ tài khoản " + tenNguoiChuyen + " có số tài khoản là " + soTaiKhoanChuyen );
            System.out.println("Giao dịch thành công!");
            super.setTrangThai("Thành công!");
        }
        else
        {
            System.out.println("Giao dịch không thành công vui lòng chuyển khoản lại hoặc dùng tiền mặc!");
            super.setTrangThai("Thất bại!");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " | Mã giao dịch ngân hàng: " + maGiaoDichNganHang + " | Tên ngân hàng thanh toán: " + tenNganHang + " | Tên tài khoản chuyển: " + tenNguoiChuyen + " | Số tài khoản: " + soTaiKhoanChuyen  ;
    }
}
class ThanhToanTienMat extends ThanhToan
{
    private long tienKhachDua , tienThoi ;
    public ThanhToanTienMat()
    {
        tienKhachDua = tienThoi = 0 ;
    }
    public ThanhToanTienMat ( String maNhanVien , long tienKhachDua , long tienThoi , String maNhanVienThu , String maGiaoDich , LocalDateTime ngayThanhToan , long soTien , String trangThai )
    {
        super(maNhanVien , maGiaoDich, ngayThanhToan, soTien, trangThai);
        this.tienKhachDua = tienKhachDua;
        this.tienThoi = tienThoi;
    }

    public void setTienThoi(long tienThoi) {
        this.tienThoi = tienThoi;
    }


    public long getTienKhachDua() {
        return tienKhachDua;
    }


    public void setTienKhachDua(long tienKhachDua) {
        this.tienKhachDua = tienKhachDua;
    }

    public long getTienThoi() {
        return tienThoi;
    }
    public void setThanhToan(  Scanner sc , long soTien , String maNhanVienThu ) {
        super.setThanhToan( sc , soTien , maNhanVienThu);
        tienKhachDua = Nhapdulieu.nhapSoNguyen(sc , "Tiền khách đưa: ") ;
        thanhToanGiaoDich(sc );
    }

    @Override

    public void thanhToanGiaoDich(  Scanner sc)
    {
        tienThoi = tienKhachDua - super.getSoTien() ;
        if (tienThoi < 0 )
        {
            System.out.println("Khách hàng đưa không đủ tiền!");
            super.setTrangThai("Thất bại!");
            tienThoi = 0 ;
        }
        else {
            System.out.println("Giao dịch thành công! Tiền thối: " + tienThoi);
            super.setTrangThai("Thành công!");
        }
    }
    @Override
    public String toString() {
        return super.toString() + " | Số tiền khách đưa: " + tienKhachDua + " | Số tiền thối lại: " + tienThoi ;
    }
}