package Sanpham ;

import dichvu.Nhacungcap;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Quanlysanpham {
    private ArrayList<Sanpham> danhSachSanPham;

    public Quanlysanpham() {
        danhSachSanPham = new ArrayList<>();
    }

    public ArrayList<Sanpham> getDanhSachSanPham() {
        return danhSachSanPham;
    }

    public void setDanhSachSanPham(ArrayList<Sanpham> danhSachSanPham) {
        this.danhSachSanPham = danhSachSanPham;
    }
    public void themSanPham(Scanner sc, ArrayList<Nhacungcap> danhSachNhaCungCap) {
        Sanpham sanPham;
        System.out.println("Nhập loại sản phẩm cần thêm: ");
        System.out.println("1. Thực Phẩm");
        System.out.println("2. Tiêu Dùng");
        System.out.println("3. Điện tử ");
        int luaChon = sc.nextInt();
        sc.nextLine();
        switch (luaChon) {
            case 1:
                if (danhSachNhaCungCap == null) {
                    System.out.println("Vui lòng thêm nhà cung cấp!");
                } else {
                    sanPham = new ThucPham();
                    sanPham.setSanPham(sc);
                    System.out.println("Chọn nhà cung cấp: ");
                    for (int i = 0; i < danhSachNhaCungCap.size(); i++) {
                        System.out.println((i + 1) + ". Nhà cung cấp" + danhSachNhaCungCap.get(i).getTenDoiTac() + "!");
                    }
                    System.out.println("Nhập lựa chọn: ");
                    int luaChonNhaCungCap = sc.nextInt();
                    sc.nextLine();
                    sanPham.setMaNhaCungCap(danhSachNhaCungCap.get(luaChonNhaCungCap - 1).getMaDoiTac());
                    danhSachSanPham.add(sanPham);
                    System.out.println("Thêm sản phẩm thành công!");
                    danhSachNhaCungCap.get(luaChonNhaCungCap - 1).getSanPhamCungCap().add(sanPham);
                    // hoá đơn đối tác
                }
                break;
            case 2:
                if (danhSachNhaCungCap == null) {
                    System.out.println("Vui lòng thêm nhà cung cấp!");
                } else {
                    sanPham = new Tieudung();
                    sanPham.setSanPham(sc);
                    System.out.println("Chọn nhà cung cấp: ");
                    for (int i = 0; i < danhSachNhaCungCap.size(); i++) {
                        System.out.println((i + 1) + ". Nhà cung cấp" + danhSachNhaCungCap.get(i).getTenDoiTac() + "!");
                    }
                    System.out.println("Nhập lựa chọn: ");
                    int luaChonNhaCungCap = sc.nextInt();
                    sc.nextLine();
                    sanPham.setMaNhaCungCap(danhSachNhaCungCap.get(luaChonNhaCungCap - 1).getMaDoiTac());
                    danhSachSanPham.add(sanPham);
                    System.out.println("Thêm sản phẩm thành công!");
                    danhSachNhaCungCap.get(luaChonNhaCungCap - 1).getSanPhamCungCap().add(sanPham);
                    // hoá đơn đối tác
                }
                break;
            case 3:
                if (danhSachNhaCungCap == null) {
                    System.out.println("Vui lòng thêm nhà cung cấp!");
                } else {
                    sanPham = new Dientu();
                    sanPham.setSanPham(sc);
                    System.out.println("Chọn nhà cung cấp: ");
                    for (int i = 0; i < danhSachNhaCungCap.size(); i++) {
                        System.out.println((i + 1) + ". Nhà cung cấp" + danhSachNhaCungCap.get(i).getTenDoiTac() + "!");
                    }
                    System.out.println("Nhập lựa chọn: ");
                    int luaChonNhaCungCap = sc.nextInt();
                    sc.nextLine();
                    sanPham.setMaNhaCungCap(danhSachNhaCungCap.get(luaChonNhaCungCap - 1).getMaDoiTac());
                    danhSachSanPham.add(sanPham);
                    System.out.println("Thêm sản phẩm thành công!");
                    danhSachNhaCungCap.get(luaChonNhaCungCap - 1).getSanPhamCungCap().add(sanPham);
                    // hoá đơn đối tác
                }
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
                break;
        }
    }

    public void taoDuLieuSanPham(Scanner sc, ArrayList<Nhacungcap> danhSachNhaCungCap) {
        System.out.println("Tạo dữ liệu cho danh sách sản phẩm!");
        boolean tiepTuc = true;
        while (tiepTuc) {
            themSanPham(sc, danhSachNhaCungCap);
            System.out.println("Bạn có muốn tiếp tục(1/0): ");
            int luaChon = sc.nextInt();
            sc.nextLine();
            if (luaChon == 0) {
                tiepTuc = false;
            }
        }
        System.out.println("Tạo dữ liệu thành công!");
    }

    public int timKiemSanPham(String maSanPham) {
        for (int i = 0; i < danhSachSanPham.size(); i++) {
            if (danhSachSanPham.get(i).getTenSanPham().equalsIgnoreCase(maSanPham)) {
                return i;
            }
        }
        return -1;
    }

    public void xoaSanPham(String maSanPham) {
        int viTri = timKiemSanPham(maSanPham);
        if (viTri == -1) {
            System.out.println("Mã sản phẩm không hợp lệ, sản phẩm không tồn tại!");
        } else {
            danhSachSanPham.remove(viTri);
            System.out.println("Xoá sản phẩm thành công!");
        }
    }

    public void suaThongTinSanPham(Scanner sc, String maSanPham, ArrayList<Nhacungcap> danhSachNhaCungCap) {
        System.out.println("Sửa thông tin sản phẩm!");
        int index = timKiemSanPham(maSanPham);
        DateTimeFormatter khuon = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Sanpham sanPham = danhSachSanPham.get(index);
        if (sanPham instanceof ThucPham) {
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
                    sanPham.setMaSanPham(sc.nextLine());
                    break;
                case 2:
                    System.out.println("Nhập tên mới cho sản phẩm: ");
                    sanPham.setTenSanPham(sc.nextLine());
                    break;
                case 3:
                    System.out.println("Nhập giá nhập mới cho sản phẩm: ");
                    sanPham.setGiaNhap(sc.nextInt());
                    sc.nextLine();
                    break;
                case 4:
                    System.out.println("Nhập giá bán mới cho sản phẩm: ");
                    sanPham.setGiaBan(sc.nextInt());
                    sc.nextLine();
                    break;
                case 5:
                    System.out.println("Nhập số lượng tồn kho mới cho sản phẩm: ");
                    sanPham.setSoLuongTonKho(sc.nextInt());
                    sc.nextLine();
                    break;
                case 6:
                    System.out.println("Nhập số sản phẩm trưng bày mới cho sản phẩm: ");
                    sanPham.setSoSanPhamTrungBay(sc.nextInt());
                    sc.nextLine();
                    break;
                case 7:
                    System.out.println("Nhập ngày sản xuất mới cho sản phẩm(dd/MM/yyyy): ");
                    ((ThucPham) sanPham).setNgaySanXuat(LocalDate.parse(sc.nextLine(), khuon));
                    break;
                case 8:
                    System.out.println("Nhập hạn sử dụng mới cho sản phẩm(dd/MM/yyyy): ");
                    ((ThucPham) sanPham).setHanSuDung(LocalDate.parse(sc.nextLine(), khuon));
                    break;
                case 9:
                    System.out.println("Nhập nhiệt độ bảo quản mới cho sản phẩm: ");
                    ((ThucPham) sanPham).setNhietDoBaoQuan(sc.nextInt());
                    sc.nextLine();
                    break;
                case 10:
                    System.out.println("Nhập môi trường bảo quản mới cho sản phẩm: ");
                    ((ThucPham) sanPham).setBaoQuan(sc.nextLine());
                    break;
                case 11:
                    System.out.println("Chọn nhà cung cấp: ");
                    for (int i = 0; i < danhSachNhaCungCap.size(); i++) {
                        System.out.println((i + 1) + ". Nhà cung cấp" + danhSachNhaCungCap.get(i).getTenDoiTac() + "!");
                    }
                    System.out.println("Nhập lựa chọn: ");
                    int luaChonNhaCungCap = sc.nextInt();
                    sc.nextLine();
                    sanPham.setMaNhaCungCap(danhSachNhaCungCap.get(luaChonNhaCungCap - 1).getMaDoiTac());
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
        } else if (sanPham instanceof Tieudung) {
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
                    sanPham.setMaSanPham(sc.nextLine());
                    break;
                case 2:
                    System.out.println("Nhập tên mới cho sản phẩm: ");
                    sanPham.setTenSanPham(sc.nextLine());
                    break;
                case 3:
                    System.out.println("Nhập giá nhập mới cho sản phẩm: ");
                    sanPham.setGiaNhap(sc.nextInt());
                    sc.nextLine();
                    break;
                case 4:
                    System.out.println("Nhập giá bán mới cho sản phẩm: ");
                    sanPham.setGiaBan(sc.nextInt());
                    sc.nextLine();
                    break;
                case 5:
                    System.out.println("Nhập số lượng tồn kho mới cho sản phẩm: ");
                    sanPham.setSoLuongTonKho(sc.nextInt());
                    sc.nextLine();
                    break;
                case 6:
                    System.out.println("Nhập số sản phẩm trưng bày mới cho sản phẩm: ");
                    sanPham.setSoSanPhamTrungBay(sc.nextInt());
                    sc.nextLine();
                    break;
                case 7:
                    System.out.println("Nhập thương hiệu mới cho sản phẩm: ");
                    ((Tieudung) sanPham).setThuongHieu(sc.nextLine());
                    break;
                case 8:
                    System.out.println("Nhập nơi sản xuất mới cho sản phẩm: ");
                    ((Tieudung) sanPham).setNoiSanXuat(sc.nextLine());
                    break;
                case 9:
                    System.out.println("Nhập phân loại mới cho sản phẩm: ");
                    ((Tieudung) sanPham).setPhanLoai(sc.nextLine());
                    sc.nextLine();
                    break;
                case 10:
                    System.out.println("Nhập lưu ý an toàn mới cho sản phẩm: ");
                    ((Tieudung) sanPham).setLuuYAnToan(sc.nextLine());
                    break;
                case 11:
                    System.out.println("Chọn nhà cung cấp: ");
                    for (int i = 0; i < danhSachNhaCungCap.size(); i++) {
                        System.out.println((i + 1) + ". Nhà cung cấp" + danhSachNhaCungCap.get(i).getTenDoiTac() + "!");
                    }
                    System.out.println("Nhập lựa chọn: ");
                    int luaChonNhaCungCap = sc.nextInt();
                    sc.nextLine();
                    sanPham.setMaNhaCungCap(danhSachNhaCungCap.get(luaChonNhaCungCap - 1).getMaDoiTac());
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
        } else if (sanPham instanceof Dientu) {
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
                    sanPham.setMaSanPham(sc.nextLine());
                    break;
                case 2:
                    System.out.println("Nhập tên mới cho sản phẩm: ");
                    sanPham.setTenSanPham(sc.nextLine());
                    break;
                case 3:
                    System.out.println("Nhập giá nhập mới cho sản phẩm: ");
                    sanPham.setGiaNhap(sc.nextInt());
                    sc.nextLine();
                    break;
                case 4:
                    System.out.println("Nhập giá bán mới cho sản phẩm: ");
                    sanPham.setGiaBan(sc.nextInt());
                    sc.nextLine();
                    break;
                case 5:
                    System.out.println("Nhập số lượng tồn kho mới cho sản phẩm: ");
                    sanPham.setSoLuongTonKho(sc.nextInt());
                    sc.nextLine();
                    break;
                case 6:
                    System.out.println("Nhập số sản phẩm trưng bày mới cho sản phẩm: ");
                    sanPham.setSoSanPhamTrungBay(sc.nextInt());
                    sc.nextLine();
                    break;
                case 7:
                    System.out.println("Nhập thời gian bảo hành mới cho sản phẩm(theo tháng): ");
                    ((Dientu) sanPham).setThoiGianBaoHanh(sc.nextInt());
                    sc.nextLine();
                    break;
                case 8:
                    System.out.println("Nhập số tiền bảo hành(theo tháng): ");
                    ((Dientu) sanPham).setChatLieu(sc.nextLine());
                    break;
                case 9:
                    System.out.println("Nhập chất liệu mới cho sản phẩm: ");
                    ((Dientu) sanPham).setChatLieu(sc.nextLine());
                    sc.nextLine();
                    break;
                case 10:
                    System.out.println("Chọn nhà cung cấp: ");
                    for (int i = 0; i < danhSachNhaCungCap.size(); i++) {
                        System.out.println((i + 1) + ". Nhà cung cấp" + danhSachNhaCungCap.get(i).getTenDoiTac() + "!");
                    }
                    System.out.println("Nhập lựa chọn: ");
                    int luaChonNhaCungCap = sc.nextInt();
                    sc.nextLine();
                    sanPham.setMaNhaCungCap(danhSachNhaCungCap.get(luaChonNhaCungCap - 1).getMaDoiTac());
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
        }
        System.out.println("Đã thay đổi thông tin sản phẩm!");
    }
    public void inDanhSachSanPham()
    {
        for ( Sanpham sanPham:danhSachSanPham )
            System.out.println(sanPham);
    }
    public void inDanhSachSanPhamChoKhachHang()
    {
        for (Sanpham sanPham: danhSachSanPham)
            System.out.println(sanPham.toStringKhachHang());
    }
    public Sanpham traCuuSanPham( String maSanPham)
    {
        int index = timKiemSanPham(maSanPham);
        if ( index == -1 )
        {
            return null ;
        }
        return danhSachSanPham.get(index) ;
    }
}
