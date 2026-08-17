import java.awt.print.Book;

void main() {
    List<Student> students;
    //students = ReadFromFile();
    //Один стрим
}

public List<Student> ReadFromFile(){
    String path ="Exercise2/files/students.txt";
    File studFile = new File(path);
    if (studFile.exists()){
        try{
            String content = Files.readString(Path.of(path));
            System.out.println(content);
        }
        catch(IOException e){
            System.out.println("File error");
        }
        return null;
    }
    else{
        return null;
    }
}

protected class Student{
    private String FIO;
    private List<Book> ownedBooks;
    public Student(String FIO, List<Book> ownedBooks) {
        this.FIO = FIO;
        this.ownedBooks = ownedBooks;
    }
}

protected class Book{
    private String title;
    private int pgNum;
    private LocalDate publishDate;
}