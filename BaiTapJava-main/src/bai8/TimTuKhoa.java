package bai8;
import java.io.*;
import java.util.concurrent.*;

public class TimTuKhoa {
    private static final String[] FILES = {
    		"C:/Users/admin/LapTrinhJava/Baitapweek5/src/bai6/in1.txt",
            "C:/Users/admin/LapTrinhJava/Baitapweek5/src/bai6/in2.txt",
            "C:/Users/admin/LapTrinhJava/Baitapweek5/src/bai6/in3.txt"};

    private static final String KEYWORD = "Trần";

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(FILES.length);

        for (String file : FILES) {
            executor.execute(new KeywordSearchTask(file, KEYWORD));
        }

        executor.shutdown();
    }
}

class KeywordSearchTask implements Runnable {
    private final String filePath;
    private final String keyword;

    public KeywordSearchTask(String filePath, String keyword) {
        this.filePath = filePath;
        this.keyword = keyword;
    }

    @Override
    public void run() {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                count += line.split(keyword, -1).length - 1;
            }
            System.out.println("File " + filePath + " có " + count + " lần xuất hiện của từ khóa '" + keyword + "'.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
