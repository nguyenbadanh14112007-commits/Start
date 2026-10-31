package utils;

import java.util.Scanner;
public class Nhapdulieu {
    // Số nguyên: chấp nhận dấu + hoặc -, ví dụ: 0, 123, -123.
    public static final String soNguyenRegex = "^[+-]?\\d+$";

    // Số thực: dùng dấu chấm thập phân, ví dụ: 15, 15.5, -0.5.
    public static final String soThucRegex = "^[+-]?\\d+(\\.\\d+)?$";

    // Số điện thoại: gồm 10 chữ số, bắt đầu bằng 03, 05, 07, 08 hoặc 09.
    public static final String phoneRegex = "^(03|05|07|08|09)\\d{8}$";

    // Email: định dạng abc@domain.com
    public static final String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    public static String nhapChuoi(Scanner sc , String thongBao , String regex , String baoLoi)
    {
        while (true)
        {
            System.out.println(thongBao);
            String value = sc.nextLine().trim() ;
            if ( value.matches(regex))
            {
                return value ;
            }
            System.out.println(baoLoi);
        }
    }
    public static String taoMa ( String regex , int soTiepTheo )
    {
        return String.format( regex , soTiepTheo );
    }
    public static long nhapSoNguyen( Scanner sc , String thongBao )
    {
        while (true)
        {
            System.out.println(thongBao);
            String value = sc.nextLine().trim() ;
            try {
                long soNguyen = Long.parseLong(value) ;
                if ( soNguyen <= 0 )
                {
                    System.out.println("Vui lòng nhập số dương!");
                    continue;
                }
                return soNguyen ;
            }
            catch ( NumberFormatException e )
            {
                System.out.println("Nhập sai định dạng vui lòng nhập lại!");
            }
        }
    }
    public static Double nhapSoThuc( Scanner sc , String thongBao)
    {
        while (true)
        {
            System.out.println(thongBao);
            String value = sc.nextLine().trim() ;
            try {
                double soThuc = Double.parseDouble(value) ;
                if ( !Double.isFinite(soThuc) || soThuc <= 0 )
                {
                    System.out.println("Phải nhập số hữu hạn lớn hơn 0!");
                    continue;
                }
                return soThuc ;
            }
            catch ( NumberFormatException e )
            {
                System.out.println("Nhập sai định dạng!(Ví dụ hợp lệ: 15000 hoặc 15000.5)");
            }
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
