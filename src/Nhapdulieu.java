import java.util.Scanner;
public class Nhapdulieu {
    public static String NhapChuoi(Scanner sc , String Thongbao , String regex , String Baoloi)
    {
        while (true)
        {
            System.out.println(Thongbao);
            String value = sc.nextLine().trim() ;
            if ( value.matches(regex))
            {
                return value ;
            }
            System.out.println(Baoloi);
        }
    }
    public static String TaoMa ( String regex , int SoTiepTheo )
    {
        return String.format( regex , SoTiepTheo );
    }
    public static long NhapSoNguyen( Scanner sc , String Thongbao )
    {
        while (true)
        {
            System.out.println(Thongbao);
            String value = sc.nextLine().trim() ;
            try {
                long SoNguyen = Long.parseLong(value) ;
                if ( SoNguyen <= 0 )
                {
                    System.out.println("Vui lòng nhập số dương!");
                    continue;
                }
                return SoNguyen ;
            }
            catch ( NumberFormatException e )
            {
                System.out.println("Nhập sai định dạng vui lòng nhập lại!");
            }
        }
    }
    public static Double NhapSoThuc( Scanner sc , String Thongbao)
    {
        while (true)
        {
            System.out.println(Thongbao);
            String value = sc.nextLine().trim() ;
            try {
                double SoThuc = Double.parseDouble(value) ;
                if ( !Double.isFinite(SoThuc) || SoThuc <= 0 )
                {
                    System.out.println("Phải nhập số hữu hạn lớn hơn 0!");
                    continue;
                }
                return SoThuc ;
            }
            catch ( NumberFormatException e )
            {
                System.out.println("Nhập sai định dạng!(Ví dụ hợp lệ: 15000 hoặc 15000.5)");
            }
        }
    }
    public static int LuaChon ( Scanner sc , String Thongbao , int KhoangBatDau , int KhoangKetThuc )
    {
        while ( true )
        {
            System.out.println(Thongbao);
            String value = sc.nextLine() ;
            try {
                int SoNguyen = Integer.parseInt(value) ;
                if ( SoNguyen < KhoangBatDau || SoNguyen > KhoangKetThuc )
                {
                    System.out.println("Giá trị nhập không hợp lệ vui lòng nhập giá trị nguyên từ " + KhoangBatDau + " đến " + KhoangKetThuc);
                    continue;
                }
                return SoNguyen ;
            }
            catch ( NumberFormatException e )
            {
                System.out.println("Giá trị nhập phải là số nguyên!");
            }
        }
    }
}
