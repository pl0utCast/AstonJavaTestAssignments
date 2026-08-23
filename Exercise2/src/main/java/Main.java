import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

void main() {
    List<Student> students;
    String path = "Exercise2/files/students.txt";
    students = ReadFromFileJSON(path);
    if (students != null) {
        students.stream().peek(student -> System.out.println(student))
                .map(student -> student.getOwnedBooks())
                .flatMap(books -> books.stream())
                .sorted((book1, book2) -> Integer.compare(book1.getPages(), book2.getPages()))
                .distinct()
                .filter(book -> book.getPublishDate().getYear() > 2000)
                .limit(3)
                .map(book -> book.getPublishDate().getYear())
                .findFirst()
                .ifPresentOrElse(
                        year -> System.out.println("Год найден: " + year),
                        () -> System.out.println("Книга отсутствует")
                );
    }
}

public List<Student> ReadFromFileJSON(String filePath) {
    File studFile = new File(filePath);
    if (studFile.exists()) {
        try {
            Path path = Paths.get(filePath);
            String jsonContent = Files.readString(path);
            Gson gson = new GsonBuilder().create();
            Type studentListType = new TypeToken<List<Student>>() {
            }.getType();
            List<Student> students = gson.fromJson(jsonContent, studentListType);
            return students;
        } catch (IOException e) {
            System.out.println("File error");
            return null;
        }
    } else {
        System.out.println("File is missing");
        return null;
    }
}