package File_Input_Output_Streams;

import java.io.*;

public class ImageByteArrayDemo {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java ImageByteArrayDemo <sourceImage> <destImage>");
            return;
        }

        String sourceFile = args[0];
        String destFile = args[1];

        try {
        
            FileInputStream fis = new FileInputStream(sourceFile);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            fis.close();

            byte[] imageBytes = baos.toByteArray();
            System.out.println("Image converted to byte array. Size: " + imageBytes.length + " bytes");

            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            FileOutputStream fos = new FileOutputStream(destFile);

            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            fos.close();
            bais.close();

            System.out.println("Image written back to: " + destFile);

            if (filesAreEqual(sourceFile, destFile)) {
                System.out.println("Verification successful ✅ — Files are identical.");
            } else {
                System.out.println("Verification failed ❌ — Files differ.");
            }

        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        }
    }
    private static boolean filesAreEqual(String file1, String file2) throws IOException {
        FileInputStream f1 = new FileInputStream(file1);
        FileInputStream f2 = new FileInputStream(file2);

        int b1, b2;
        do {
            b1 = f1.read();
            b2 = f2.read();
            if (b1 != b2) {
                f1.close();
                f2.close();
                return false;
            }
        } while (b1 != -1 && b2 != -1);

        f1.close();
        f2.close();
        return true;
    }
}

