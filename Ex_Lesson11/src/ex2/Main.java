package ex2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static String templateUrl = "dataStudent.txt";

    public static void main(String[] args) {
        var data = readObject(templateUrl);
        List<Student> students = new ArrayList<>(data);
//        writeObject(templateUrl,students);
        showProfileAndTranscripts(students);
    }

//    private static List<Student> dataStudent() {
//        List<Student> students = new ArrayList<>();
//        students.add(new Student("Hiếu"));
//        students.add(new Student("Khoa"));
//        students.add(new Student("Huy"));
//        return students;
//    }
//
//    private static List<Transcript> dataScore1() {
//        List<Transcript> score1 = new ArrayList<>();
//        score1.add(new Transcript("Java", 10.0d));
//        score1.add(new Transcript("Html", 8.5d));
//        score1.add(new Transcript("C#", 9.5d));
//        score1.add(new Transcript("Sql", 9.0d));
//        return score1;
//    }
//
//    private static List<Transcript> dataScore2() {
//        List<Transcript> score1 = new ArrayList<>();
//        score1.add(new Transcript("Java", 9.5d));
//        score1.add(new Transcript("Html", 8.5d));
//        score1.add(new Transcript("C#", 8.5d));
//        score1.add(new Transcript("Sql", 8.5d));
//        return score1;
//    }
//
//    private static List<Transcript> dataScore3() {
//        List<Transcript> score1 = new ArrayList<>();
//        score1.add(new Transcript("Java", 9.0d));
//        score1.add(new Transcript("Html", 10.0d));
//        score1.add(new Transcript("C#", 9.5d));
//        score1.add(new Transcript("Sql", 8.5d));
//        return score1;
//    }

    private static void showProfileAndTranscripts(List<Student> students) {
        if (!students.isEmpty()) {
            for (var student :
                    students) {
                System.out.println("Name :" + student.getName());
                System.out.printf("%-12s%-12s\n", "Subject", "Score");
                show(student);
                System.out.println("============================");
            }
        }
    }

    private static void show(Student student) {
        if (student != null) {
            for (var tran : student.getTranscripts()) {
                System.out.printf("%-12s%-12.1f\n", tran.getSubject(), tran.getScore());
            }
        }
    }

    private static void writeObject(String url, List<Student> students) {
        File file = new File(url);
        try {
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (var stu :
                    students) {
                oos.writeObject(stu);
            }
            System.out.println("Success!");
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Student> readObject(String url) {
        List<Student> students = new ArrayList<>();
        File file = new File(url);
        if (!file.exists()) {
            System.out.println("File not found!");
            return students;
        }
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object object = null;
            try {
                while ((object = ois.readObject()) != null) {
                    var student = (Student) object;
                    students.add(student);
                }

            } catch (EOFException e) {
            }
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return students;
    }
}
