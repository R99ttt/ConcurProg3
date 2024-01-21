//Yarin Ackerman  //Rami Abu Rabia 
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TextFileClient {
    public static void main(String[] args) {
        try {
            // Get file name from user
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter file name: ");
            String fileName = scanner.nextLine();

            // Connect to the server
            Socket socket = new Socket("localhost", 1234);
            System.out.println("Connected to server.");

            // Get input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            // Send the file to the server
            File file = new File(fileName);
            if (file.exists()) {
                BufferedReader fileIn = new BufferedReader(new FileReader(file));
                String line;
                while ((line = fileIn.readLine()) != null) {
                    out.write(line + "\n");
                }
                out.flush();
                fileIn.close();
            } else {
                System.out.println("File not found.");
                return;
            }

            // Get the results from the server
            System.out.println(in.readLine());
            System.out.println(in.readLine());
            // Close the streams and socket
            in.close();
            out.close();
            socket.close();
            System.out.println("Disconnected from server.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
