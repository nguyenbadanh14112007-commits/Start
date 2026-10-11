import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Quanlysanpham {
    private ArrayList<Sanpham> DanhsachSP;
    Scanner sc = new Scanner(System.in);

    public Quanlysanpham() {
        DanhsachSP = new ArrayList<>();
    }

    public ArrayList<Sanpham> getDanhsachSP() {
        return DanhsachSP;
    }

    public void setDanhsachSP(ArrayList<Sanpham> danhsachSP) {
        DanhsachSP = danhsachSP;
    }

    public void Them_sp(ArrayList<Nhacungcap> nhacungcaps) {
        Sanpham sanpham;
        System.out.println("Nhập loại sản phẩm cần thêm: ");
        System.out.println("1. Thực Phẩm");
        System.out.println("2. Tiêu Dùng");
        System.out.println("3. Điện tử ");
        int Luachon = sc.nextInt();
        sc.nextLine();
        switch (Luachon) {
            case 1:
                if (nhacungcaps == null) {
                    System.out.println("Vui lòng thêm nhà cung cấp!");
                } else {
                    sanpham = new ThucPham();
                    sanpham.set_sp();
                    System.out.println("Chọn nhà cung cấp: ");
                    for (int i = 0; i < nhacungcaps.size(); i++) {
                        System.out.println((i + 1) + ". Nhà cung cấp" + nhacungcaps.get(i).getTen_dt() + "!");
                    }
                    System.out.println("Nhập lựa chọn: ");
                    int Luachon_ncc = sc.nextInt();
                    sc.nextLine();
                    sanpham.setMa_ncc(nhacungcaps.get(Luachon_ncc - 1).getMa_dt());
                    DanhsachSP.add(sanpham);
                    System.out.println("Thêm sản phẩm thành công!");
                    nhacungcaps.get(Luachon_ncc - 1).getSanpham_cungcap().add(sanpham);
                    // hoá đơn đối tác
                }
                break;
            case 2:
                if (nhacungcaps == null) {
                    System.out.println("Vui lòng thêm nhà cung cấp!");
                } else {
                    sanpham = new Tieudung();
                    sanpham.set_sp();
                    System.out.println("Chọn nhà cung cấp: ");
                    for (int i = 0; i < nhacungcaps.size(); i++) {
                        System.out.println((i + 1) + ". Nhà cung cấp" + nhacungcaps.get(i).getTen_dt() + "!");
                    }
                    System.out.println("Nhập lựa chọn: ");
                    int Luachon_ncc = sc.nextInt();
                    sc.nextLine();
                    sanpham.setMa_ncc(nhacungcaps.get(Luachon_ncc - 1).getMa_dt());
                    DanhsachSP.add(sanpham);
                    System.out.println("Thêm sản phẩm thành công!");
                    nhacungcaps.get(Luachon_ncc - 1).getSanpham_cungcap().add(sanpham);
                    // hoá đơn đối tác
                }
                break;
            case 3:
                if (nhacungcaps == null) {
                    System.out.println("Vui lòng thêm nhà cung cấp!");
                } else {
                    sanpham = new Dientu();
                    sanpham.set_sp();
                    System.out.println("Chọn nhà cung cấp: ");
                    for (int i = 0; i < nhacungcaps.size(); i++) {
                        System.out.println((i + 1) + ". Nhà cung cấp" + nhacungcaps.get(i).getTen_dt() + "!");
                    }
                    System.out.println("Nhập lựa chọn: ");
                    int Luachon_ncc = sc.nextInt();
                    sc.nextLine();
                    sanpham.setMa_ncc(nhacungcaps.get(Luachon_ncc - 1).getMa_dt());
                    DanhsachSP.add(sanpham);
                    System.out.println("Thêm sản phẩm thành công!");
                    nhacungcaps.get(Luachon_ncc - 1).getSanpham_cungcap().add(sanpham);
                    // hoá đơn đối tác
                }
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
                break;
        }
    }

    public void Tao_du_lieu_sp(ArrayList<Nhacungcap> nhacungcaps) {
        System.out.println("Tạo dữ liệu cho danh sách sản phẩm!");
        boolean countinue = true;
        while (countinue) {
            Them_sp(nhacungcaps);
            System.out.println("Bạn có muốn tiếp tục(1/0): ");
            int Luachon = sc.nextInt();
            sc.nextLine();
            if (Luachon == 0) {
                countinue = false;
            }
        }
        System.out.println("Tạo dữ liệu thành công!");
    }

    public int Tim_kiem_sp(String ma_sp) {
        for (int i = 0; i < DanhsachSP.size(); i++) {
            if (DanhsachSP.get(i).getTen_sp().equalsIgnoreCase(ma_sp)) {
                return i;
            }
        }
        return -1;
    }

    public void Xoa_sp(String ma_sp) {
        int vi_tri = Tim_kiem_sp(ma_sp);
        if (vi_tri == -1) {
            System.out.println("Mã sản phẩm không hợp lệ, sản phẩm không tồn tại!");
        } else {
            DanhsachSP.remove(vi_tri);
            System.out.println("Xoá sản phẩm thành công!");
        }
    }

    public void Sua_tt_sp(String ma_sp, ArrayList<Nhacungcap> nhacungcaps) {
        System.out.println("Sửa thông tin sản phẩm!");
        int index = Tim_kiem_sp(ma_sp);
        DateTimeFormatter khuon = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Sanpham sanpham = DanhsachSP.get(index);
        if (sanpham instanceof ThucPham) {
            System.out.println("Chọn thuộc tính cần sửa: ");
            System.out.println("1.Mã sản phẩm!");
            System.out.println("2.Tên sản phẩm!");
            System.out.println("3.Giá nhập!");
            System.out.println("4.Giá bán!");
            System.out.println("5.Số sản phẩm tồn kho!");
            System.out.println("6.Số sản phẩm trưng bày!");
            System.out.println("7.Ngày sản xuất!");
            System.out.println("8.Hạn sử dung!");
            System.out.println("9.Nhiệt độ bảo quản!");
            System.out.println("10.Bảo quản!");
            System.out.println("11.Nhà cung cấp!");
            int luachon = sc.nextInt();
            sc.nextLine();
            switch (luachon) {
                case 1:
                    System.out.println("Nhập mã sản phẩm mới: ");
                    sanpham.setMa_sp(sc.nextLine());
                    break;
                case 2:
                    System.out.println("Nhập tên mới cho sản phẩm: ");
                    sanpham.setTen_sp(sc.nextLine());
                    break;
                case 3:
                    System.out.println("Nhập giá nhập mới cho sản phẩm: ");
                    sanpham.setGia_nhap(sc.nextInt());
                    sc.nextLine();
                    break;
                case 4:
                    System.out.println("Nhập giá bán mới cho sản phẩm: ");
                    sanpham.setGia_ban(sc.nextInt());
                    sc.nextLine();
                    break;
                case 5:
                    System.out.println("Nhập số lượng tồn kho mới cho sản phẩm: ");
                    sanpham.setSo_luong_ton_kho(sc.nextInt());
                    sc.nextLine();
                    break;
                case 6:
                    System.out.println("Nhập số sản phẩm trưng bày mới cho sản phẩm: ");
                    sanpham.setSo_sp_trung_bay(sc.nextInt());
                    sc.nextLine();
                    break;
                case 7:
                    System.out.println("Nhập ngày sản xuất mới cho sản phẩm(dd/MM/yyyy): ");
                    ((ThucPham) sanpham).setNgay_san_xuat(LocalDate.parse(sc.nextLine(), khuon));
                    break;
                case 8:
                    System.out.println("Nhập hạn sử dụng mới cho sản phẩm(dd/MM/yyyy): ");
                    ((ThucPham) sanpham).setHan_su_dung(LocalDate.parse(sc.nextLine(), khuon));
                    break;
                case 9:
                    System.out.println("Nhập nhiệt độ bảo quản mới cho sản phẩm: ");
                    ((ThucPham) sanpham).setNhiet_do_bao_quan(sc.nextInt());
                    sc.nextLine();
                    break;
                case 10:
                    System.out.println("Nhập môi trường bảo quản mới cho sản phẩm: ");
                    ((ThucPham) sanpham).setBao_quan(sc.nextLine());
                    break;
                case 11:
                    System.out.println("Chọn nhà cung cấp: ");
                    for (int i = 0; i < nhacungcaps.size(); i++) {
                        System.out.println((i + 1) + ". Nhà cung cấp" + nhacungcaps.get(i).getTen_dt() + "!");
                    }
                    System.out.println("Nhập lựa chọn: ");
                    int Luachon_ncc = sc.nextInt();
                    sc.nextLine();
                    sanpham.setMa_ncc(nhacungcaps.get(Luachon_ncc - 1).getMa_dt());
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
        } else if (sanpham instanceof Tieudung) {
            System.out.println("Chọn thuộc tính cần sửa: ");
            System.out.println("1.Mã sản phẩm!");
            System.out.println("2.Tên sản phẩm!");
            System.out.println("3.Giá nhập!");
            System.out.println("4.Giá bán!");
            System.out.println("5.Số sản phẩm tồn kho!");
            System.out.println("6.Số sản phẩm trưng bày!");
            System.out.println("7.Thương hiệu sản phẩm!");
            System.out.println("8.Nơi sản xuất!");
            System.out.println("9.Phân loại!");
            System.out.println("10.Lưu ý an toàn!");
            System.out.println("11.Nhà cung cấp!");
            int luachon = sc.nextInt();
            sc.nextLine();
            switch (luachon) {
                case 1:
                    System.out.println("Nhập mã sản phẩm mới: ");
                    sanpham.setMa_sp(sc.nextLine());
                    break;
                case 2:
                    System.out.println("Nhập tên mới cho sản phẩm: ");
                    sanpham.setTen_sp(sc.nextLine());
                    break;
                case 3:
                    System.out.println("Nhập giá nhập mới cho sản phẩm: ");
                    sanpham.setGia_nhap(sc.nextInt());
                    sc.nextLine();
                    break;
                case 4:
                    System.out.println("Nhập giá bán mới cho sản phẩm: ");
                    sanpham.setGia_ban(sc.nextInt());
                    sc.nextLine();
                    break;
                case 5:
                    System.out.println("Nhập số lượng tồn kho mới cho sản phẩm: ");
                    sanpham.setSo_luong_ton_kho(sc.nextInt());
                    sc.nextLine();
                    break;
                case 6:
                    System.out.println("Nhập số sản phẩm trưng bày mới cho sản phẩm: ");
                    sanpham.setSo_sp_trung_bay(sc.nextInt());
                    sc.nextLine();
                    break;
                case 7:
                    System.out.println("Nhập thương hiệu mới cho sản phẩm: ");
                    ((Tieudung) sanpham).setThuong_hieu(sc.nextLine());
                    break;
                case 8:
                    System.out.println("Nhập nơi sản xuất mới cho sản phẩm: ");
                    ((Tieudung) sanpham).setNoi_sx(sc.nextLine());
                    break;
                case 9:
                    System.out.println("Nhập phân loại mới cho sản phẩm: ");
                    ((Tieudung) sanpham).setPhan_loai(sc.nextLine());
                    sc.nextLine();
                    break;
                case 10:
                    System.out.println("Nhập lưu ý an toàn mới cho sản phẩm: ");
                    ((Tieudung) sanpham).setLuu_y_an_toan(sc.nextLine());
                    break;
                case 11:
                    System.out.println("Chọn nhà cung cấp: ");
                    for (int i = 0; i < nhacungcaps.size(); i++) {
                        System.out.println((i + 1) + ". Nhà cung cấp" + nhacungcaps.get(i).getTen_dt() + "!");
                    }
                    System.out.println("Nhập lựa chọn: ");
                    int Luachon_ncc = sc.nextInt();
                    sc.nextLine();
                    sanpham.setMa_ncc(nhacungcaps.get(Luachon_ncc - 1).getMa_dt());
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
        } else if (sanpham instanceof Dientu) {
            System.out.println("Chọn thuộc tính cần sửa: ");
            System.out.println("1.Mã sản phẩm!");
            System.out.println("2.Tên sản phẩm!");
            System.out.println("3.Giá nhập!");
            System.out.println("4.Giá bán!");
            System.out.println("5.Số sản phẩm tồn kho!");
            System.out.println("6.Số sản phẩm trưng bày!");
            System.out.println("7.Thời gian bảo hành!");
            System.out.println("8.Tiền bảo hành!");
            System.out.println("9.Chất liệu!");
            System.out.println("10.Nhà cung cấp!");
            int luachon = sc.nextInt();
            sc.nextLine();
            switch (luachon) {
                case 1:
                    System.out.println("Nhập mã sản phẩm mới: ");
                    sanpham.setMa_sp(sc.nextLine());
                    break;
                case 2:
                    System.out.println("Nhập tên mới cho sản phẩm: ");
                    sanpham.setTen_sp(sc.nextLine());
                    break;
                case 3:
                    System.out.println("Nhập giá nhập mới cho sản phẩm: ");
                    sanpham.setGia_nhap(sc.nextInt());
                    sc.nextLine();
                    break;
                case 4:
                    System.out.println("Nhập giá bán mới cho sản phẩm: ");
                    sanpham.setGia_ban(sc.nextInt());
                    sc.nextLine();
                    break;
                case 5:
                    System.out.println("Nhập số lượng tồn kho mới cho sản phẩm: ");
                    sanpham.setSo_luong_ton_kho(sc.nextInt());
                    sc.nextLine();
                    break;
                case 6:
                    System.out.println("Nhập số sản phẩm trưng bày mới cho sản phẩm: ");
                    sanpham.setSo_sp_trung_bay(sc.nextInt());
                    sc.nextLine();
                    break;
                case 7:
                    System.out.println("Nhập thời gian bảo hành mới cho sản phẩm(theo tháng): ");
                    ((Dientu) sanpham).setThoi_gian_bao_hanh(sc.nextInt());
                    sc.nextLine();
                    break;
                case 8:
                    System.out.println("Nhập số tiền bảo hành(theo tháng): ");
                    ((Dientu) sanpham).setChat_lieu(sc.nextLine());
                    break;
                case 9:
                    System.out.println("Nhập chất liệu mới cho sản phẩm: ");
                    ((Dientu) sanpham).setChat_lieu(sc.nextLine());
                    sc.nextLine();
                    break;
                case 10:
                    System.out.println("Chọn nhà cung cấp: ");
                    for (int i = 0; i < nhacungcaps.size(); i++) {
                        System.out.println((i + 1) + ". Nhà cung cấp" + nhacungcaps.get(i).getTen_dt() + "!");
                    }
                    System.out.println("Nhập lựa chọn: ");
                    int Luachon_ncc = sc.nextInt();
                    sc.nextLine();
                    sanpham.setMa_ncc(nhacungcaps.get(Luachon_ncc - 1).getMa_dt());
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
        }
        System.out.println("Đã thay đổi thông tin sản phẩm!");
    }
    public void in_danh_sach_sp()
    {
        for ( Sanpham sp:DanhsachSP )
            System.out.println(sp);
    }
    public void in_danh_sach_sp_cho_kh()
    {
        for (Sanpham sp: DanhsachSP)
            System.out.println(sp.toString_kh());
    }
}