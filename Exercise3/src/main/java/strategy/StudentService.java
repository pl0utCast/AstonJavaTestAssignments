package strategy;

public class StudentService {
    private ReadStrategy readStrategy;

    public StudentService(ReadStrategy readStrategy) {
        this.readStrategy = readStrategy;
    }

    public void readFile() {
        readStrategy.readFile();
    }
}
