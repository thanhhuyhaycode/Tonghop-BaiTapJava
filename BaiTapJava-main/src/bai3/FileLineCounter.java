package bai3;

import java.io.*;

public class FileLineCounter {
    public static void main(String[] args) {
        String sourceFile = "C:/Users/admin/LapTrinhJava/Baitapweek5/src/bai3/in.txt/"; // Đường dẫn file nguồn

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile))) {
            int lineCount = 0;
            while (reader.readLine() != null) {
                lineCount++;
            }

            System.out.println("Số dòng trong file: " + lineCount);
        } catch (IOException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}