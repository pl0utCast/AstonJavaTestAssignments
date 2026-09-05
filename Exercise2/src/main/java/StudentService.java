import com.example.Student;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class StudentService {

    public List<Student> readFromFileJSON() {
        InputStream res = getClass().getResourceAsStream("students.txt");
        if (res != null) {
            try {
                String jsonContent = new String(res.readAllBytes(), StandardCharsets.UTF_8);
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

    public void JavaStreamTryOut(List<Student> students){
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
}
