package File_Input_Output_Streams;

import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java BufferedFileCopy <sourceFile> <destFile>");
            return;
        }

        String source = args[0];
        String destBuffered = args[1] + "_buffered";
        String destUnbuffered = args[1] + "_unbuffered";

        long bufferedTime = copyBuffered(source, destBuffered);

        long unbufferedTime = copyUnbuffered(source, destUnbuffered);

        System.out.println("\nPerformance Comparison:");
        System.out.println("Buffered Streams   : " + (bufferedTime / 1_000_000) + " ms");
        System.out.println("Unbuffered Streams : " + (unbufferedTime / 1_000_000) + " ms");
    }

    private static long copyBuffered(String src, String dest) {
        long start = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {

            byte[] buffer = new byte[4096]; // 4 KB
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Buffered copy failed: " + e.getMessage());
        }
        return System.nanoTime() - start;
    }

    private static long copyUnbuffered(String src, String dest) {
        long start = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(src);
             FileOutputStream fos = new FileOutputStream(dest)) {

            byte[] buffer = new byte[4096]; 
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Unbuffered copy failed: " + e.getMessage());
        }
        return System.nanoTime() - start;
    }
}
