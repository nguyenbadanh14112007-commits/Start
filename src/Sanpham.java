import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public abstract class Sanpham {
    private String Ma_sp , Ten_sp , Loai_sp , Ma_ncc;
    private long gia_nhap , gia_ban ;
    private int So_luong_ton_kho , So_sp_trung_bay ;
    private double Thue ;
    private final Scanner sc = new Scanner(System.in) ;
    public Sanpham()
    {
        Ma_sp = Ten_sp = Loai_sp = Ma_ncc = "" ;
        gia_nhap = gia_ban = 0 ;
        So_luong_ton_kho = So_sp_trung_bay = 0 ;
        Thue = 0 ;
    }
    public Sanpham( String ma_sp , String ten_sp , String loai_sp , long gia_nhap , long gia_ban , int so_luong_ton_kho , int so_sp_trung_bay , String Ma_ncc )
    {
        Ma_sp = ma_sp ;
        Ten_sp = ten_sp ;
        Loai_sp = loai_sp ;
        this.gia_nhap = gia_nhap ;
        this.gia_ban = gia_ban ;
        So_luong_ton_kho = so_luong_ton_kho ;
        So_sp_trung_bay = so_sp_trung_bay ;
        this.Ma_ncc = Ma_ncc ;
    }

    public void setThue(double thue) {
        Thue = thue;
    }

    public double getThue() {
        return Thue;
    }

    public void setMa_sp(String ma_sp) {
        Ma_sp = ma_sp;
    }

    public void setTen_sp(String ten_sp) {
        Ten_sp = ten_sp;
    }

    public void setMa_ncc(String ma_ncc) {
        Ma_ncc = ma_ncc;
    }

    public void setSo_luong_ton_kho(int so_luong_ton_kho) {
        So_luong_ton_kho = so_luong_ton_kho;
    }

    public void setGia_nhap(long gia_nhap) {
        this.gia_nhap = gia_nhap;
    }

    public void setGia_ban(long gia_ban) {
        this.gia_ban = gia_ban;
    }

    public String getTen_sp() {
        return Ten_sp;
    }

    public String getMa_sp() {
        return Ma_sp;
    }

    public String getLoai_sp() {
        return Loai_sp;
    }

    public void setLoai_sp(String loai_sp) {
        Loai_sp = loai_sp;
    }

    public String getMa_ncc() {
        return Ma_ncc;
    }

    public int getSo_luong_ton_kho() {
        return So_luong_ton_kho;
    }

    public int getSo_sp_trung_bay() {
        return So_sp_trung_bay;
    }

    public long getGia_ban() {
        return gia_ban;
    }

    public long getGia_nhap() {
        return gia_nhap;
    }

    public void setSo_sp_trung_bay(int so_sp_trung_bay) {
        So_sp_trung_bay = so_sp_trung_bay;
    }
    public void set_sp()
    {
        System.out.println("Nhập mã sản phẩm: ");
        Ma_sp = sc.nextLine() ;
        System.out.println("Nhập tên sản phẩm: ");
        Ten_sp = sc.nextLine() ;
        System.out.println("Nhập giá bán: ");
        gia_ban = sc.nextInt() ;
        System.out.println("Nhập giá nhập: ");
        gia_nhap = sc.nextInt() ;
        System.out.println("Nhập số lượng nhập: ");
        So_luong_ton_kho = sc.nextInt() ;
        System.out.println("Nhập số lượng sản phẩm trưng bày: ");
        So_sp_trung_bay = sc.nextInt() ;
        sc.nextLine() ;
    }

    public abstract void Trang_thai_ban() ;
    public abstract int tinh_thue() ;
    @Override
    public String toString() {
        return "Mã sản phẩm: " + Ma_sp + " | Tên sản phẩm: " + Ten_sp + " | Giá nhập: " + gia_nhap + " | Giá bán: " + gia_ban + " | Số sản phẩm tồn kho : " + So_luong_ton_kho + " | Số sản phẩm trưng bày: " + So_sp_trung_bay + " | Nhà cung cấp : " + Ma_ncc;
    }
    public abstract String toString_kh() ;
}
class ThucPham extends Sanpham
{
    private LocalDate Ngay_san_xuat , Han_su_dung ;
    private double Nhiet_do_bao_quan ;
    private String Bao_quan ;
    Scanner sc = new Scanner(System.in) ;
    public ThucPham()
    {
        super();
        Ngay_san_xuat = Han_su_dung = LocalDate.now() ;
        Nhiet_do_bao_quan = 0 ;
        Bao_quan = "" ;
    }
    public ThucPham ( String ma_sp , String ten_sp , String loai_sp , long gia_nhap , long gia_ban , int so_luong_ton_kho , int so_sp_trung_bay , String Ma_ncc ,
            LocalDate ngay_san_xuat , LocalDate han_su_dung , double nhiet_do_bao_quan , String bao_quan)
    {
        super( ma_sp, ten_sp, loai_sp, gia_nhap, gia_ban, so_luong_ton_kho, so_sp_trung_bay, Ma_ncc);
        Ngay_san_xuat = ngay_san_xuat ;
        Han_su_dung = han_su_dung ;
        Nhiet_do_bao_quan = nhiet_do_bao_quan ;
        Bao_quan = bao_quan ;
    }

    public double getNhiet_do_bao_quan() {
        return Nhiet_do_bao_quan;
    }

    public LocalDate getHan_su_dung() {
        return Han_su_dung;
    }

    public LocalDate getNgay_san_xuat() {
        return Ngay_san_xuat;
    }

    public void setHan_su_dung(LocalDate han_su_dung) {
        Han_su_dung = han_su_dung;
    }

    public void setNhiet_do_bao_quan(double nhiet_do_bao_quan) {
        Nhiet_do_bao_quan = nhiet_do_bao_quan;
    }

    public String getBao_quan() {
        return Bao_quan;
    }

    public void setBao_quan(String bao_quan) {
        Bao_quan = bao_quan;
    }

    public void setNgay_san_xuat(LocalDate ngay_san_xuat) {
        Ngay_san_xuat = ngay_san_xuat;
    }

    @Override
    public void set_sp()
    {
        super.set_sp();
        System.out.println("Nhập ngày sản xuất(dd/MM/yyyy): ");
        String ngay_san_xuat = sc.nextLine() ;
        System.out.println("Nhập hạn sử dụng(dd/MM/yyyy): ");
        String han_su_dung = sc.nextLine() ;
        System.out.println("Nhập môi trường bảo quản: ");
        Bao_quan = sc.nextLine() ;
        System.out.println("Nhập nhiệt độ bảo quản: ");
        Nhiet_do_bao_quan = sc.nextInt();
        sc.nextLine();
        DateTimeFormatter khuon = DateTimeFormatter.ofPattern("dd/MM/yyyy") ;
        Ngay_san_xuat = LocalDate.parse( ngay_san_xuat , khuon) ;
        Han_su_dung = LocalDate.parse(han_su_dung , khuon) ;
    }
    public int Ktra_ngay_het_han() {
        return 0 ;
    }//
    public boolean ktra_sp_hong()
    {
        return true ;
    }//

    @Override
    public void Trang_thai_ban()
    {

    }

    @Override
    public int tinh_thue() { //thuế VAT, thuế hàng hoá nếu có nhập lại,.... cộng lại thiết lập giá trị cho biến thuế

        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + " | Ngày sản xuất: " + Ngay_san_xuat + " | Hạn sử dụng: " + Han_su_dung + " | Môi trường bảo quản: " + Bao_quan + " | Nhiệt độ bảo quản : " + Nhiet_do_bao_quan;
    }
    public String toString_kh()
    {
        return "Mã sản phẩm: " + super.getMa_sp() + " | Tên sản phẩm: " + super.getTen_sp() + " | Giá bán: " + super.getGia_ban() + " | Số sản phẩm đang trưng bày: " + super.getSo_sp_trung_bay() + " | Ngày sản xuất: " + Ngay_san_xuat + " | Hạn sử dụng: " + Han_su_dung + " | Môi trường bảo quản: " + Bao_quan + " | Nhiệt độ bảo quản : " + Nhiet_do_bao_quan;
    }
}
class Tieudung extends Sanpham
{
    private String Thuong_hieu , Noi_sx , Phan_loai , Luu_y_an_toan ;
    Scanner sc = new Scanner(System.in) ;
    public Tieudung()
    {
        super();
        Thuong_hieu = Noi_sx = Phan_loai = Luu_y_an_toan = "" ;
    }
    public Tieudung( String ma_sp , String ten_sp , String loai_sp , long gia_nhap , long gia_ban , int so_luong_ton_kho , int so_sp_trung_bay , String Ma_ncc ,
                      String thuong_hieu , String noi_sx , String phan_loai , String luu_y_an_toan)
    {
        super( ma_sp, ten_sp, loai_sp, gia_nhap, gia_ban, so_luong_ton_kho, so_sp_trung_bay, Ma_ncc);
        Thuong_hieu = thuong_hieu ;
        Noi_sx = noi_sx ;
        Phan_loai = phan_loai ;
        Luu_y_an_toan = luu_y_an_toan ;
    }

    public String getNoi_sx() {
        return Noi_sx;
    }

    public void setNoi_sx(String noi_sx) {
        Noi_sx = noi_sx;
    }

    public String getThuong_hieu() {
        return Thuong_hieu;
    }

    public String getLuu_y_an_toan() {
        return Luu_y_an_toan;
    }

    public void setLuu_y_an_toan(String luu_y_an_toan) {
        Luu_y_an_toan = luu_y_an_toan;
    }

    public String getPhan_loai() {
        return Phan_loai;
    }

    public void setThuong_hieu(String thuong_hieu) {
        Thuong_hieu = thuong_hieu;
    }

    public void setPhan_loai(String phan_loai) {
        Phan_loai = phan_loai;
    }

    public void set_sp()
    {
        super.set_sp();
        System.out.println("Nhập thương hiệu của sản phẩm: ");
        Thuong_hieu = sc.nextLine() ;
        System.out.println("Nhập nơi sản xuất: ");
        Noi_sx = sc.nextLine() ;
        System.out.println("Phân loại: ");
        Phan_loai = sc.nextLine() ;
        System.out.println("Lưu ý an toàn: ");
        Luu_y_an_toan = sc.nextLine() ;
    }

    @Override
    public void Trang_thai_ban() {
    }//

    @Override
    public int tinh_thue() {
        return 0;
    }//

    @Override
    public String toString() {
        return super.toString() + " | Phân loại: " + Phan_loai + " | Nơi sản xuất: " + Noi_sx + " | Phân loại: " + Phan_loai + " | Lưu ý an toàn: " + Luu_y_an_toan;
    }
    public String toString_kh()
    {
        return "Mã sản phẩm: " + super.getMa_sp() + " | Tên sản phẩm: " + super.getTen_sp() + " | Giá bán: " + super.getGia_ban() + " | Số sản phẩm đang trưng bày: " + super.getSo_sp_trung_bay() + " | Phân loại: " + Phan_loai + " | Nơi sản xuất: " + Noi_sx + " | Phân loại: " + Phan_loai + " | Lưu ý an toàn: " + Luu_y_an_toan;
    }
}
class Dientu extends Sanpham
{
    private int Thoi_gian_bao_hanh ;
    private long Tien_bao_hanh ;
    private String Chat_lieu ;
    private LocalDate Ngay_mua ;
    Scanner sc = new Scanner(System.in) ;
    public Dientu()
    {
        super();
        Thoi_gian_bao_hanh = 0 ;
        Tien_bao_hanh = 0 ;
        Chat_lieu = "" ;
        Ngay_mua = LocalDate.now() ;
    }
    public Dientu( String ma_sp , String ten_sp , String loai_sp , long gia_nhap , long gia_ban , int so_luong_ton_kho , int so_sp_trung_bay , String Ma_ncc ,
                   int thoi_gian_bao_hanh , long tien_bao_hanh , String chat_lieu , LocalDate ngay_mua)
    {
        super( ma_sp, ten_sp, loai_sp, gia_nhap, gia_ban, so_luong_ton_kho, so_sp_trung_bay, Ma_ncc);
        Thoi_gian_bao_hanh = thoi_gian_bao_hanh ;
        Tien_bao_hanh = tien_bao_hanh ;
        Chat_lieu = chat_lieu ;
        Ngay_mua = ngay_mua ;
    }

    public void setTien_bao_hanh(long tien_bao_hanh) {
        Tien_bao_hanh = tien_bao_hanh;
    }

    public void setThoi_gian_bao_hanh(int thoi_gian_bao_hanh) {
        Thoi_gian_bao_hanh = thoi_gian_bao_hanh;
    }

    public int getThoi_gian_bao_hanh() {
        return Thoi_gian_bao_hanh;
    }

    public LocalDate getNgay_mua() {
        return Ngay_mua;
    }

    public long getTien_bao_hanh() {
        return Tien_bao_hanh;
    }

    public String getChat_lieu() {
        return Chat_lieu;
    }

    public void setChat_lieu(String chat_lieu) {
        Chat_lieu = chat_lieu;
    }

    public void setNgay_mua(LocalDate ngay_mua) {
        Ngay_mua = ngay_mua;
    }

    public void set_sp()
    {
        super.set_sp();
        System.out.println("Nhập chất liệu: ");
        Chat_lieu = sc.nextLine() ;
        System.out.println("Nhập ngày mua(dd/MM/yyyy): ");
        String ngay_mua = sc.nextLine() ;
        DateTimeFormatter khuon = DateTimeFormatter.ofPattern("dd/MM/yyyy") ;
        Ngay_mua = LocalDate.parse(ngay_mua , khuon) ;
        System.out.println("Thời gian bảo hành(theo tháng): ");
        Thoi_gian_bao_hanh = sc.nextInt() ;
        System.out.println("Số tiền bảo hành(nghìn đồng/năm): ");
        Tien_bao_hanh = sc.nextInt();
        sc.nextLine() ;
    }

    @Override
    public void Trang_thai_ban() {

    }

    @Override
    public int tinh_thue() {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + " | Chất liệu: " + Chat_lieu + " | Tiền bảo hành: " + Tien_bao_hanh + " | Thời gian bảo hành: " + Thoi_gian_bao_hanh ;
    }
    public LocalDate ngay_het_han_bao_hanh()
    {

        return null;
    }
    public boolean ktra_bao_hanh ()
    {
        return true;
    }
    public void gia_han_bao_hanh()
    {
        
    }
    public String toString_kh()
    {
        return "Mã sản phẩm: " + super.getMa_sp() + " | Tên sản phẩm: " + super.getTen_sp() + " | Giá bán: " + super.getGia_ban() + " | Số sản phẩm đang trưng bày: " + super.getSo_sp_trung_bay() + " | Chất liệu: " + Chat_lieu + " | Tiền bảo hành: " + Tien_bao_hanh + " | Thời gian bảo hành: " + Thoi_gian_bao_hanh ;
    }
}