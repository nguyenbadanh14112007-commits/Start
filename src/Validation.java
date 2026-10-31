package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Scanner;

public class Validation {

    //  Họ tên: Chấp nhận chữ cái (kể cả tiếng Việt), khoảng trắng, dấu nháy đơn, dấu gạch ngang
    public static final String hoTenRegex = "^[\\p{L}\\s'-]+$";

    // Số điện thoại: Bắt đầu bằng 03, 05, 07, 08, 09 và theo sau là 8 chữ số
    public static final String phoneRegex = "^(03|05|07|08|09)\\d{8}$";

    // Email: Định dạng chuẩn abc@domain.com
    public static final String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    public static final String maNVRegex = "^NV\\d{3}$";
    public static final String maKHRegex = "^KH\\d{3,5}$";

    // 1. Hàm nhập số nguyên (chống sập bằng try-catch)
    public static int inputInt(Scanner sc, String message) {
        while (true) {
            try {
                System.out.print(message);
                int value = sc.nextInt();
                sc.nextLine(); // Xóa bộ đệm sau khi nhập số
                if ( value <= 0 )
                {
                    System.out.println("Số nhập không phải là số âm vui lòng nhập lại!");
                    continue;
                }
                return value;
            } catch (Exception e) {
                System.out.println("[!] Lỗi: Bạn phải nhập số nguyên. Vui lòng thử lại!");
                sc.nextLine(); // RẤT QUAN TRỌNG: Xóa chữ "abc" vừa nhập để không bị lặp vô hạn
            }
        }
    }

    public static long inputLong(Scanner sc, String message) {
        while (true) {
            try {
                System.out.print(message);
                long value = sc.nextLong();
                sc.nextLine();
                if ( value <= 0 )
                {
                    System.out.println("Số nhập không phải là số âm vui lòng nhập lại!");
                    continue;
                }
                return value;
            } catch (Exception e) {
                System.out.println("[!] Lỗi: Bạn phải nhập số nguyên. Vui lòng thử lại!");
                sc.nextLine();
            }
        }
    }

    // 2. Hàm nhập số thực (double) - Dùng cho Đơn giá, Tổng tiền
    public static double inputDouble(Scanner sc, String message) {
        while (true) {
            try {
                System.out.print(message);
                double value = sc.nextDouble();
                sc.nextLine();
                if ( value <= 0 )
                {
                    System.out.println("Số nhập không phải là số âm vui lòng nhập lại!");
                    continue;
                }
                return value;
            } catch (Exception e) {
                System.out.println("[!] Lỗi: Bạn phải nhập số thực (VD: 10.5). Vui lòng thử lại!");
                sc.nextLine();
            }
        }
    }

    public static float inputFloat(Scanner sc, String message) {
        while (true) {
            try {
                System.out.print(message);
                float value = sc.nextFloat();
                sc.nextLine();
                if ( value <= 0 )
                {
                    System.out.println("Số nhập không phải là số âm vui lòng nhập lại!");
                    continue;
                }
                return value;
            } catch (Exception e) {
                System.out.println("[!] Lỗi: Bạn phải nhập số thực (VD: 10.5). Vui lòng thử lại!");
                sc.nextLine();
            }
        }
    }

    // 3. Hàm nhập chuỗi có kiểm tra Regex (Dùng cho Mã HĐ, SĐT, Tên)
    public static String inputStringRegex(Scanner sc, String message, String regex, String errorMessage) {
        while (true) {
            System.out.print(message);
            String value = sc.nextLine().trim();
            if (value.matches(regex)) {
                return value; // Đúng định dạng thì trả về
            }
            System.out.println("[!] " + errorMessage);
        }
    }
    public static String taoMa ( String regex , int soTiepTheo )
    {
        return String.format( regex , soTiepTheo );
    }
    public static LocalDate inputLocalDateRegex ( Scanner sc , String message )
    {
        DateTimeFormatter khuon = DateTimeFormatter.ofPattern("dd/MM/yyyy").withResolverStyle(ResolverStyle.STRICT);
        while(true)
        {
            System.out.println(message);
            String date = sc.nextLine() ;
            if ( !date.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/[0-9]{4}$"))
            {
                System.out.println("Bạn nhập sai định dạng yêu cầu vui lòng nhập lại!");
                continue;
            }
            try {
                return LocalDate.parse(date , khuon ) ;
            } catch (Exception e) {
                System.out.println("Ngày nhập không tồn tại!");
            }
        }
    }
    public static boolean inputCoKhong(Scanner sc, String message) {
        while (true) {
            System.out.print(message + " (Có/Không): ");
            String value = sc.nextLine().trim();

            if (value.equalsIgnoreCase("có") || value.equalsIgnoreCase("co")) {
                return true;
            }

            if (value.equalsIgnoreCase("không") || value.equalsIgnoreCase("khong")) {
                return false;
            }

            System.out.println("Vui lòng nhập Có hoặc Không!");
        }
    }
    public static int luaChon ( Scanner sc , String thongBao , int khoangBatDau , int khoangKetThuc )
    {
        while ( true )
        {
            System.out.println(thongBao);
            String value = sc.nextLine() ;
            try {
                int soNguyen = Integer.parseInt(value) ;
                if ( soNguyen < khoangBatDau || soNguyen > khoangKetThuc )
                {
                    System.out.println("Giá trị nhập không hợp lệ vui lòng nhập giá trị nguyên từ " + khoangBatDau + " đến " + khoangKetThuc);
                    continue;
                }
                return soNguyen ;
            }
            catch ( NumberFormatException e )
            {
                System.out.println("Giá trị nhập phải là số nguyên!");
            }
        }
    }
}
