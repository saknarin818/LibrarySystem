package roombook;

public class Library { 

    // คลาสแม่: Book (หนังสือ)
    abstract class Book {
        String title;

        public Book(String title) {
            this.title = title;
        }

        // เมธอด overloading (มีชื่อเดียวกันแต่พารามิเตอร์ต่างกัน)
        public void borrow(String userType) {
            System.out.println("กำลังยืมหนังสือในฐานะ " + userType);
        }

        public void borrow(String userType, int days) {
            System.out.println("กำลังยืมหนังสือในฐานะ " + userType + " เป็นเวลา " + days + " วัน");
        }

        // เมธอดที่จะถูก override ในคลาสย่อย
        public abstract void borrowBook(String userType);
    }

    // คลาสหนังสือทั่วไป (GeneralBook)
    class GeneralBook extends Book {

        public GeneralBook(String title) {
            super(title);
        }

        @Override
        public void borrowBook(String userType) {
            System.out.println(userType + " สามารถยืมหนังสือทั่วไปได้เป็นเวลา 7 วัน");
        }
    }

    // คลาสหนังสือสำรอง (ReservedBook)
    class ReservedBook extends Book {

        public ReservedBook(String title) {
            super(title);
        }
        

        @Override
        public void borrowBook(String userType) {
            if (userType.equals("staff")) {
                System.out.println("บุคลากรสามารถยืมหนังสือสำรองได้เป็นเวลา 3 วัน");
            } else {
                System.out.println("นักศึกษาไม่สามารถยืมหนังสือสำรองได้");
            }
        }
    }

    // คลาสหนังสือสำคัญ (ImportantBook)
    class ImportantBook extends Book {

        public ImportantBook(String title) {
            super(title);
        }

        @Override
        public void borrowBook(String userType) {
            System.out.println("ทั้งนักศึกษาและบุคลากรไม่สามารถยืมหนังสือสำคัญได้ สามารถอ่านได้เฉพาะในห้องสมุดเท่านั้น");
        }
    }
}
