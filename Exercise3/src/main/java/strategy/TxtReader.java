package strategy;

import com.example.Student;

import java.util.ArrayList;
import java.util.List;

public class TxtReader implements ReadStrategy {
    public List<Student> readFile() {
        List<Student> studentsOut = new ArrayList<Student>();
        System.out.println("Read txt file");
        return studentsOut;
    }
}
