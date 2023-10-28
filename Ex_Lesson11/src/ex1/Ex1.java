package ex1;

import java.io.*;

public class Ex1 {
    public static void main(String[] args) {
        copyFileByteStream();
        copyFileCharacterStream();
    }

    private static void copyFileByteStream() {
        File file = new File("Test1.txt");
        try {
            file.createNewFile();
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream("Test1(copy).txt");
            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
            fos.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyFileCharacterStream() {
        File file = new File("char1.txt");
        try {
            file.createNewFile();
            FileReader fs = new FileReader(file);
            FileWriter fw = new FileWriter("char1(copy).txt");
            int data;
            while ((data = fs.read()) != -1) {
                fw.write(data);
            }
            fw.close();
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
