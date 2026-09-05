package strategy;

import com.example.Student;

import java.util.List;

public interface ReadStrategy {
    public List<Student> readFile();
}
