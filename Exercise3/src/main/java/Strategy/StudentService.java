package Strategy;

public class StudentService {
    private ReadStrategy readStrategy;

    public StudentService(ReadStrategy readStrategy){
        this.readStrategy = readStrategy;
    }

    public void readFile(){
        readStrategy.readFile();
    }

    public void getStudents(){
        System.out.println("Get students list");
    }

    public void updateStudent(){
        System.out.println("Update student by id");
    }
}
