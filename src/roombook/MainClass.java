package roombook;

import java.util.Scanner; // Import Scanner for user input

public class MainClass {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // สร้าง Scanner เพื่อรับข้อมูลจากผู้ใช้

        // สร้างอินสแตนซ์ของคลาส Library
        Library library = new Library(); 

        // สร้างอินสแตนซ์ของหนังสือแต่ละประเภท
        Library.GeneralBook generalBook = library.new GeneralBook("หนังสือทั่วไป");
        Library.ReservedBook reservedBook = library.new ReservedBook("หนังสือสำรอง");
        Library.ImportantBook importantBook = library.new ImportantBook("หนังสือสำคัญ");

        // รับข้อมูลประเภทผู้ใช้งานจากผู้ใช้
        System.out.print("กรุณาใส่ประเภทผู้ใช้งาน (student/staff): ");
        String userType = scanner.nextLine();

        // เลือกประเภทหนังสือที่ต้องการยืม
        System.out.println("กรุณาเลือกประเภทหนังสือที่ต้องการยืม:");
        System.out.println("1. หนังสือทั่วไป");
        System.out.println("2. หนังสือสำรอง");
        System.out.println("3. หนังสือสำคัญ");
        System.out.print("ใส่หมายเลขหนังสือที่ต้องการ: ");
        int bookChoice = scanner.nextInt();

        // ดำเนินการตามประเภทหนังสือที่ผู้ใช้เลือก
        switch (bookChoice) {
            case 1:
                generalBook.borrowBook(userType);
                generalBook.borrow(userType, 7); // ใช้ overloading
                break;
            case 2:
                reservedBook.borrowBook(userType);
                if (userType.equals("staff")) {
                    reservedBook.borrow(userType, 3); // ใช้ overloading เฉพาะบุคลากร
                }
                break;
            case 3:
                importantBook.borrowBook(userType);
                break;
            default:
                System.out.println("เลือกประเภทหนังสือไม่ถูกต้อง");
                break;
        }

        scanner.close(); // ปิด Scanner
    }
}
