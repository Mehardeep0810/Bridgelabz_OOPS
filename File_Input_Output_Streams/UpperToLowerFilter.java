package File_Input_Output_Streams;

import java.io.*;

public class UpperToLowerFilter {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java UpperToLowerFilter <sourceFile> <destFile>");
            return;
        }

        String sourceFile = args[0];
        String destFile = args[1];

        try (
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(sourceFile), "UTF-8")
            );
            BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(destFile), "UTF-8")
            )
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                
                writer.write(line.toLowerCase());
                writer.newLine();
            }
            System.out.println("File converted successfully: " + destFile);
        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        }
    }
}
