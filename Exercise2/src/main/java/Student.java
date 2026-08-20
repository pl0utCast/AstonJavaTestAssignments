import java.util.List;

class Student {
    private String FIO;
    private List<Book> ownedBooks;
    public Student(String FIO, List<Book> ownedBooks) {
        this.FIO = FIO;
        this.ownedBooks = ownedBooks;
    }
}