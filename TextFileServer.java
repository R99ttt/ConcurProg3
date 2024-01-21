//Yarin Ackerman   //Rami Abu Rabia
import java.io.*;
import java.net.*;
import java.util.*;

public class TextFileServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("At port 1234");
            while (true) {
                System.out.println("client connected");
                // Wait for client to connect
                Socket clientSocket = serverSocket.accept();

                // Get input and output streams
                InputStream inputStream = clientSocket.getInputStream();
                OutputStream outputStream = clientSocket.getOutputStream();

                // Read file from client
                byte[] fileBuffer = new byte[1024];
                int bytesRead = inputStream.read(fileBuffer);
                FileOutputStream fos = new FileOutputStream("received.txt");
                fos.write(fileBuffer, 0, bytesRead);
                fos.close();

                // Get number of words and longest word in file
                File file = new File("received.txt");
                Scanner scanner = new Scanner(file);
                int wordCount = 0;
                String longestWord = "";
                while (scanner.hasNext()) {
                    String word = scanner.next();
                    wordCount++;
                    if (word.length() > longestWord.length()) {
                        longestWord = word;
                    }
                }
                
                System.out.println(wordCount);
                // Send word count and longest word to client
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                dataOutputStream.writeUTF("Number of words");
                dataOutputStream.writeBytes(Integer.toString(wordCount));
                dataOutputStream.writeUTF("longest word length");
                dataOutputStream.writeBytes(Integer.toString(longestWord.length()));
                dataOutputStream.writeUTF("Words with maximum length:");
                dataOutputStream.writeUTF(longestWord);

                clientSocket.close();
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
