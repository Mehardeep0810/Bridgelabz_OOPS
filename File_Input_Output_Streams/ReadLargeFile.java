package File_Input_Output_Streams;

import java.io.*;

public class ReadLargeFile {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java ReadLargeFile <filename>");
            return;
        }

        String filename = args[0];

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        }
    }
}
