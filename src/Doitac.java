import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Doitac {
    private String Ma_dt , Ten_dt , So_dt , Dia_chi , Email , Ma_so_thue , Loai_dt;
    public Doitac()
    {
        Ma_dt = Ten_dt = So_dt = Dia_chi = Ma_so_thue = Email = Loai_dt = " " ;
    }
    public Doitac ( String ma_dt , String ten_dt , String so_dt , String dia_chi , String ma_so_thue , String email , String loai_dt)
    {
        Ma_dt = ma_dt ;
        Ten_dt = ten_dt ;
        So_dt = so_dt ;
        Dia_chi = dia_chi ;
        Ma_so_thue = ma_so_thue ;
        Email = email ;
        Loai_dt = loai_dt ;
    }

    public String getLoai_dt() {
        return Loai_dt;
    }

    public void setLoai_dt(String loai_dt) {
        Loai_dt = loai_dt;
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
    public void set_doitac ( Scanner sc)
    {
        Ma_dt = Nhapdulieu.NhapChuoi(sc , "Nhập mã đối tác: " , "DT\\d{3}" , "Mã đối tác nhập sai định dạng vui lòng nhập lại(VD:DT00X)!") ;
        System.out.println("Nhập tên đối tác: ");
        Ten_dt = sc.nextLine() ;
        So_dt = Nhapdulieu.NhapChuoi(sc , "Nhập số điện thoại: " , "0[1-9]{9}" , "Nhập sai định dạng số điện thoại vui lòng nhập lại(VD:0123456789)!") ;
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
    public Nhacungcap()
    {
        Nganh_hang_cung_cap = "" ;
        Han_muc_no_cong = 0 ;
        super.setLoai_dt("Nhà cung cấp");
        sanpham_cungcap = new ArrayList<>() ;
    }
    public Nhacungcap ( String ma_dt , String ten_dt , String so_dt , String dia_chi , String ma_so_thue , String email , String loai_dt , String nganh_hang_cung_cap , long han_muc_no_cong )
    {
        super(ma_dt, ten_dt, so_dt, dia_chi, ma_so_thue, email , loai_dt);
        Nganh_hang_cung_cap = nganh_hang_cung_cap ;
        Han_muc_no_cong = han_muc_no_cong ;
        sanpham_cungcap = new ArrayList<>() ;
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

    public void set_doitac( Scanner sc)
    {
        super.set_doitac( sc );
        System.out.println("Nhập ngành hàng cung cấp: ");
        Nganh_hang_cung_cap = sc.nextLine() ;
        Han_muc_no_cong = Nhapdulieu.NhapSoNguyen(sc , "Nhập hạn mức nợ công!") ;
    }
    public void Nhandon (Sanpham sp , int so_luong , LocalDate Ngay_dat_hang )
    {

    }
    public int Tim_kiem_sp ( String Ma_sp )
    {
        for (int i = 0 ; i < sanpham_cungcap.size() ; i++ )
        {
            if ( sanpham_cungcap.get(i).getMa_sp().equalsIgnoreCase(Ma_sp)) return i ;
        }
        return -1;
    }
    public void In_danh_sach_sp ()
    {
         System.out.println("Danh sách sản phẩm do nhà cung cấp " + super.getTen_dt() + " cung cấp!");
         for( Sanpham sp:sanpham_cungcap )
             System.out.println(sp);
    }
    public void Hien_thi_sp_tra_cuu ( String Ma_sp )
    {
        int index = Tim_kiem_sp(Ma_sp) ;
        if ( index == -1 )
        {
            System.out.println("Mã sản phẩm không tồn tại!");
            return;
        }
        System.out.println("Sản phẩm cần tra cứu là: ");
        System.out.println(sanpham_cungcap.get(index));
    }
    public boolean ktra_han_muc_no_cong ()
    {
        return Han_muc_no_cong <= 100000000;
    }
    public String toString()
    {
        return super.toString() + " | Ngành hàng cung cấp: " + Nganh_hang_cung_cap + " | Hạn mức nợ công: " + Han_muc_no_cong ;
    }
}
class Donvivanchuyen extends Doitac
{
    private ArrayList<Xe> Danhsachxe ;
    public Donvivanchuyen( )
    {
        Danhsachxe = new ArrayList<>() ;
        super.setLoai_dt("Đơn vị vận chuyển");
    }
    public Donvivanchuyen( String ma_dt , String ten_dt , String so_dt , String dia_chi , String ma_so_thue , String email , String loai_dt , ArrayList<Xe> danhsachxe  )
    {
        super(ma_dt, ten_dt, so_dt, dia_chi, ma_so_thue, email , loai_dt);
        Danhsachxe = danhsachxe ;
    }

    public ArrayList<Xe> getDanhsachxe() {
        return Danhsachxe;
    }

    public void setDanhsachxe( ArrayList<Xe> danhsachxe) {
        Danhsachxe = danhsachxe;
    }
    public void tao_danh_sach_xe( Scanner sc) {
        long So_luong_xe = Nhapdulieu.NhapSoNguyen(sc , "Nhập số lượng xe: ") ;
        for (int i = 0; i < So_luong_xe; i++) {
            System.out.println("Nhập thông tin cho xe " + (i + 1) + " ! ");
            Xe new_xe = new Xe();
            new_xe.set_xe(sc );
            KiemTraTrung( sc , new_xe );
            Danhsachxe.add(new_xe);
            System.out.println("Thêm xe thành công!");
        }
    }
    public void Them_xe( Scanner sc)
    {
        System.out.println("Nhập thông tin cho xe! ");
        Xe new_xe = new Xe() ;
        new_xe.set_xe(sc);
        KiemTraTrung( sc , new_xe);
        Danhsachxe.add(new_xe) ;
        System.out.println("Thêm xe thành công!");
    }
    public void Xoa_xe( String Ma_xe )
    {
        int index = Tra_cuu_xe(Ma_xe) ;
        if ( index == -1 )
        {
            System.out.println("Mã xe không tồn tại!");
            return;
        }
        Danhsachxe.remove(index) ;
        System.out.println("Xoá phương tiện thành công!");
    }
    public void Chinh_sua_xe (  Scanner sc , String Ma_xe )
    {
        int index = Tra_cuu_xe(Ma_xe) ;
        if ( index == -1 )
        {
            System.out.println("Mã xe khôg tồn tại!");
            return;
        }
        boolean countinue = true ;
        while (countinue)
        {
            System.out.println("Nhập thông số cần sửa: ");
            System.out.println("1.Mã xe!");
            System.out.println("2.Tên xe!");
            System.out.println("3.Loại xe!");
            System.out.println("4.Giá trên 1 km!");
            System.out.println("5.Sức chứa tối đa!");
            System.out.println("6.Giá vận chuyển cơ bản!");
            int Lua_chon = Nhapdulieu.LuaChon(sc , "Nhập lựa chọn: " , 1 , 6) ;
            switch ( Lua_chon )
            {
                case 1:
                    String Ma_xe_moi = Nhapdulieu.NhapChuoi(sc , "Nhập mã số xe: " , "XE\\d{3}" , "Mã xe không đúng định dạng vui lòng nhập lại(VD: XE001)!") ;
                    while ( Tra_cuu_xe(Ma_xe_moi) != -1 )
                    {
                        System.out.println("Mã xe đã tồn tại vui lòng nhập lại!");
                        Ma_xe_moi = Nhapdulieu.NhapChuoi(sc , "Nhập mã số xe: " , "XE\\d{3}" , "Mã xe không đúng định dạng vui lòng nhập lại(VD: XE001)!") ;
                    }
                    Danhsachxe.get(index).setMa_xe(Ma_xe_moi);
                    break;
                case 2:
                    System.out.println("Nhập tên xe mới: ");
                    Danhsachxe.get(index).setTen_xe(sc.nextLine());
                    break;
                case 3:
                    System.out.println("Nhập loại xe mới: ");
                    Danhsachxe.get(index).setLoai_xe(sc.nextLine());
                    break;
                case 4:
                    Danhsachxe.get(index).setGia_mot_km(Nhapdulieu.NhapSoNguyen(sc , "Nhập giá trên 1km: "));
                    break;
                case 5:
                    Danhsachxe.get(index).setSuc_chua_toi_da(Nhapdulieu.NhapSoNguyen(sc , "Nhập sức chứa tối đa mới: "));
                    break;
                case 6:
                    Danhsachxe.get(index).setGia_van_chuyen_co_ban(Nhapdulieu.NhapSoNguyen(sc , "Nhập chi phí vận chuyển cơ bản mới: "));
                    break;
                default:
                    System.out.println("Lựa chọn nhập không hợp lệ!");
                    break;
            }
            System.out.println("Bạn có muốn tiếp tục chỉnh sửa phương tiện không(1/0): ");
            int Luachon = Nhapdulieu.LuaChon(sc , "Bạn có muốn tiếp tục chỉnh sửa phương tiện không(1/0):" , 0 , 1) ;
            if ( Luachon == 0 )
            {
                countinue = false ;
            }
        }
        System.out.println("Sửa thông tin cho phương tiện thành công!");
    }
    public int Tra_cuu_xe ( String Ma_xe )
    {
        for ( int i = 0 ; i < Danhsachxe.size() ; i++ )
            if( Danhsachxe.get(i).getMa_xe().equals(Ma_xe)) return i ;
        return -1 ;
    }
    public void Tim_xe ( String Ma_xe )
    {
        int index = Tra_cuu_xe(Ma_xe) ;
        if ( index == -1 )
        {
            System.out.println("Mã xe không tồn tại!");
            return;
        }
        System.out.println("Phương tiện cần tìm: ");
        System.out.println(Danhsachxe.get(index));
    }
    public void In_bang_gia () // Danh sách xe
    {
         System.out.println("Danh sách bảng giá của từng xe: ");
         for (Xe xe:Danhsachxe)
         {
             System.out.println(xe);
         }
    }
    public void KiemTraTrung( Scanner sc , Xe xe )
    {
        while( Tra_cuu_xe(xe.getMa_xe()) != -1 )
        {
            System.out.println("Mã xe đã tồn tại vui lòng nhập mã mới!");
            xe.setMa_xe(Nhapdulieu.NhapChuoi(sc , "Nhập mã xe: " , "XE\\d{3}" , "Mã xe không đúng định dạng vui lòng nhập lại!(VD hợp lệ: XE001"));
        }
    }
}
class Xe
{
    private String Ma_xe , Ten_xe , Loai_xe ;
    private long Gia_mot_km , Suc_chua_toi_da , Gia_van_chuyen_co_ban;
    public Xe()
    {
        Ma_xe = Ten_xe = Loai_xe = "" ;
        Gia_mot_km = Suc_chua_toi_da = Gia_van_chuyen_co_ban = 0 ;
    }
    public Xe( String ma_xe , String ten_xe , String loai_xe , long gia_mot_km , long suc_chua_toi_da , long gia_van_chuyen_co_ban)
    {
        Ma_xe = ma_xe ;
        Ten_xe = ten_xe ;
        Loai_xe = loai_xe ;
        Gia_mot_km = gia_mot_km ;
        Suc_chua_toi_da = suc_chua_toi_da ;
        Gia_van_chuyen_co_ban = gia_van_chuyen_co_ban ;
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

    public void set_xe ( Scanner sc)
    {
        Ma_xe = Nhapdulieu.NhapChuoi(sc , "Nhập mã số xe: " , "XE\\d{3}" , "Mã xe không đúng định dạng vui lòng nhập lại(VD: XE001)!");
        System.out.println("Nhập tên xe: ");
        Ten_xe = sc.nextLine() ;
        System.out.println("Nhập loại xe: ");
        Loai_xe = sc.nextLine() ;
        Gia_mot_km = Nhapdulieu.NhapSoNguyen(sc , "Nhập chi phí vận chuyển(Giá/km): ") ;
        Gia_van_chuyen_co_ban = Nhapdulieu.NhapSoNguyen(sc , "Nhập giá vận chuyển cơ bản: ") ;
        Suc_chua_toi_da = Nhapdulieu.NhapSoNguyen(sc , "Nhập sức chứa tối đa của xe: ") ;
    }
    @Override
    public String toString() {
        return "Mã số xe: " + Ma_xe + " | Tên xe"  + Ten_xe + " | Loại xe: " + Loai_xe +  " | Giá/km: " + Gia_mot_km + " | Sức chở tối đa: " + Suc_chua_toi_da;
    }
}