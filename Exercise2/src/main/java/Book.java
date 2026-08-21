import java.time.LocalDate;
import java.util.Objects;

class Book {
    private String title;
    private int pgNum;
    private String publishDate;

    public int getPages() {
        return this.pgNum;
    }


    public LocalDate getPublishDate() {
        return LocalDate.parse(publishDate);
    }

    @Override
    public String toString() {
        return "\n" + title + " (" + pgNum + " стр., " + publishDate + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return pgNum == book.pgNum &&
                Objects.equals(title, book.title) &&
                Objects.equals(publishDate, book.publishDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, pgNum, publishDate);
    }
}