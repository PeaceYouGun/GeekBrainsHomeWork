package Lesson_06.Homework_06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ConsoleClient {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static DataInputStream in;
    private static DataOutputStream out;

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 65500)) {
            System.out.println("Connected!");

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            clientSentMessage();

            while (true) {
                String inputMessage = in.readUTF();
                System.out.println("Received " + inputMessage);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void clientSentMessage() throws InterruptedException {
        Thread consoleClientThread = new Thread(() -> {
            while (true) {
                try {
                    String sentMsg = SCANNER.nextLine();
                    out.writeUTF(sentMsg);
                    Thread.sleep(200);
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            }
        });
        consoleClientThread.start();
    }
}
