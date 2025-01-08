package javabasic.teamproject;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class QuizClient {
    private Socket clientSocket;
    private BufferedReader in;
    private PrintWriter out;

    public QuizClient(String serverHost, int serverPort) {
        try {
            this.clientSocket = new Socket(serverHost, serverPort);
            this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            this.out = new PrintWriter(clientSocket.getOutputStream(), true);
            System.out.println("서버에 연결되었습니다: " + serverHost + ":" + serverPort);
        } catch (IOException e) {
            System.err.println("서버 연결 실패: " + e.getMessage());
        }
    }

    public void sendScore(String playerName, String score) {
        out.println("SCORE|" + playerName + "|" + score);
        try {
            String response = in.readLine(); // 서버에서 한 줄 응답을 기다림
            if (response.startsWith("TOP3|")) {
                String[] top3Entries = response.substring(5).split(",");
                System.out.println("=== 상위 3명 ===");

                // 상위 3명 데이터를 List<User>로 변환
                List<User> top3List = new ArrayList<>();
                for (String entry : top3Entries) {
                    String[] details = entry.split(":");
                    System.out.println(details[0] + "위: " + details[1] + " (점수: " + details[2] + ")");

                    User user = new User(details[1], details[2]); // User 객체 생성
                    top3List.add(user);
                }

                // JSON 파일 저장
                SaveScoreFile.writeScoreFile(top3List);
            } else {
                System.err.println("예상하지 못한 응답: " + response);
            }
        } catch (IOException e) {
            System.err.println("서버 응답 처리 중 오류: " + e.getMessage());
        }
    }

    public void close() {
        try {
            if (in != null) in.close();
            if (out != null) out.close();
            if (clientSocket != null) clientSocket.close();
            System.out.println("클라이언트 연결이 종료되었습니다.");
        } catch (IOException e) {
            System.err.println("클라이언트 종료 중 오류: " + e.getMessage());
        }
    }
}
