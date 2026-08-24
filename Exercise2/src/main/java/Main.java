import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

void main() {
    List<Student> students;
    StudentService ss = new StudentService();
    students = ss.readFromFileJSON();
    ss.JavaStreamTryOut(students);
}