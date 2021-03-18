package Lesson_06.Homework_06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static DataInputStream in;
    private static DataOutputStream out;

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(65500)) {
            System.out.println("Server started!");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            echoSentMessage();

            while (true) {
                String inputMessage = in.readUTF();
                System.out.println("Received " + inputMessage);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void echoSentMessage() throws InterruptedException {
        Thread echoServerThread = new Thread(() -> {
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
        echoServerThread.start();
    }
}
