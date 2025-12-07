package File_Input_Output_Streams;

import java.io.*;
import java.util.*;

public class WordCountTop5 {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java WordCountTop5 <filename>");
            return;
        }

        String filename = args[0];
        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                
                String[] words = line.toLowerCase().split("\\W+"); 
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        }

        
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordCount.entrySet());
        sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        
        System.out.println("Top 5 most frequent words:");
        for (int i = 0; i < Math.min(5, sortedList.size()); i++) {
            Map.Entry<String, Integer> entry = sortedList.get(i);
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

