package javabasic.teamproject;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class QuizServer {
    private static final int SERVER_PORT = 6573;
    private final List<User> userList = new ArrayList<>();

    public void startServer() {
        List<User> loadedUsers = SaveScoreFile.readScoreFile();
        if (loadedUsers != null) {
            userList.addAll(loadedUsers);
        }

        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("서버가 시작되었습니다. 포트: " + SERVER_PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("새로운 클라이언트 연결: " + clientSocket.getInetAddress());
                new Thread(new ClientHandler(clientSocket, userList)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
}
