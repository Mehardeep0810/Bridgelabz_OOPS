package File_Input_Output_Streams;

import java.io.*;

class WriterThread extends Thread {
    private PipedOutputStream pos;

    public WriterThread(PipedOutputStream pos) {
        this.pos = pos;
    }

    @Override
    public void run() {
        try {
            String[] messages = {
                "Hello from Writer!",
                "This is inter-thread communication.",
                "Using Piped Streams in Java.",
                "End of messages."
            };

            for (String msg : messages) {
                pos.write(msg.getBytes());
                pos.write('\n'); 
                pos.flush();
                Thread.sleep(500); 
            }
            pos.close();
        } catch (IOException | InterruptedException e) {
            System.out.println("WriterThread error: " + e.getMessage());
        }
    }
}

class ReaderThread extends Thread {
    private PipedInputStream pis;

    public ReaderThread(PipedInputStream pis) {
        this.pis = pis;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(pis))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Reader received: " + line);
            }
        } catch (IOException e) {
            System.out.println("ReaderThread error: " + e.getMessage());
        }
    }
}

public class PipedStreamDemo {
    public static void main(String[] args) {
        try {
       
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            WriterThread writer = new WriterThread(pos);
            ReaderThread reader = new ReaderThread(pis);

            writer.start();
            reader.start();

            writer.join();
            reader.join();

        } catch (IOException | InterruptedException e) {
            System.out.println("Main error: " + e.getMessage());
        }
    }
}
