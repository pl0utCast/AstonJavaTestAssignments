import java.util.List;

class Student {
    private String fio;
    private List<Book> ownedBooks;

    public Student(String fio, List<Book> ownedBooks) {
        this.fio = fio;
        this.ownedBooks = ownedBooks;
    }

    public List<Book> getOwnedBooks() {
        return this.ownedBooks;
    }

    @Override
    public String toString() {
        return "Student{name='" + fio + "', books=" + ownedBooks + "}\n";
    }
}