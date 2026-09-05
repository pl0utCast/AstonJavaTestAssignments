import com.example.Student;

void main() {
    List<Student> students;
    StudentService ss = new StudentService();
    students = ss.readFromFileJSON();
    ss.JavaStreamTryOut(students);
}