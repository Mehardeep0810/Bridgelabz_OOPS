package File_Input_Output_Streams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java FileCopy <sourceFile> <destinationFile>");
            return;
        }

        String sourceFile = args[0];
        String destFile = args[1];

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            File src = new File(sourceFile);

            if (!src.exists()) {
                System.out.println("Source file does not exist: " + sourceFile);
                return;
            }

            File dest = new File(destFile);
            if (!dest.exists()) {
                dest.createNewFile();
                System.out.println("Destination file created: " + destFile);
            }

            fis = new FileInputStream(src);
            fos = new FileOutputStream(dest);

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }

            System.out.println("File copied successfully from " + sourceFile + " to " + destFile);

        } catch (IOException e) {
            System.out.println("An error occurred during file handling: " + e.getMessage());
        } finally {
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Error closing streams: " + e.getMessage());
            }
        }
    }
}
