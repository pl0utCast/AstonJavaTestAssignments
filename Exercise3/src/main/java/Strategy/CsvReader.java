package Strategy;

import com.example.Student;

import java.util.List;
import java.util.ArrayList;

public class CsvReader implements ReadStrategy {
    public List<Student> readFile() {
        List<Student> studentsOut = new ArrayList<Student>();
        System.out.println("Read Csv file");
        return studentsOut;
    }
}
