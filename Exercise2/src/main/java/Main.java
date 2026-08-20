

void main() {
    List<Student> students;
    students = ReadFromFileRaw();
    //Один стрим
}

public List<Student> ReadFromFileRaw() {
    String filePathStr = "Exercise2/files/students.txt";
    File studFile = new File(filePathStr);
    if (studFile.exists()) {
        try {
            Path path = Paths.get(filePathStr);
            String jsonContent = Files.readString(path);


        } catch (IOException e) {
            System.out.println("File error");
        }
        return null;
    } else {
        return null;
    }
}

public List<Student> ReadFromFileJSON(){
    return null;
}