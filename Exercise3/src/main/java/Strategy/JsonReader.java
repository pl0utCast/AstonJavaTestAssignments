package Strategy;

import com.example.Student;

import java.util.ArrayList;
import java.util.List;

public class JsonReader implements ReadStrategy{
    public List<Student> readFile(){
        List<Student> studentsOut = new ArrayList<Student>();
        System.out.println("Прочитать JSON файл");
        return studentsOut;
    }
}
