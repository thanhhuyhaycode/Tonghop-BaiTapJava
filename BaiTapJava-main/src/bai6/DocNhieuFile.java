package bai6;
import java.io.*;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DocNhieuFile {
    private static final Object lock = new Object();

    public static void main(String[] args) {
        List<String> inputFiles = List.of(
        		"C:/Users/admin/LapTrinhJava/Baitapweek5/src/bai6/in1.txt",
                "C:/Users/admin/LapTrinhJava/Baitapweek5/src/bai6/in2.txt/",
                "C:/Users/admin/LapTrinhJava/Baitapweek5/src/bai6/in3.txt/"
        );
        String outputFile = "C:/Users/admin/LapTrinhJava/Baitapweek5/src/bai6/out.txt";

        ExecutorService executor = Executors.newFixedThreadPool(1);

        for (String file : inputFiles) {
            executor.execute(new FileReaderTask(file, outputFile));
        }

        executor.shutdown();
    }

    static class FileReaderTask implements Runnable {
        private final String inputFile;
        private final String outputFile;

        public FileReaderTask(String inputFile, String outputFile) {
            this.inputFile = inputFile;
            this.outputFile = outputFile;
        }

        @Override
        public void run() {
            try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
                String line;
                StringBuilder content = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    content.append(line).append("\n");
                }

                synchronized (lock) {
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, true))) {
                        bw.write(content.toString());
                        bw.flush();
                    }
                }
                System.out.println("Hoàn thành: " + inputFile);
            } catch (IOException e) {
                System.err.println("Lỗi khi xử lý file " + inputFile + ": " + e.getMessage());
            }
        }
    }
}