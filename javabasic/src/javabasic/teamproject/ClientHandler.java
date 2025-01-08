package javabasic.teamproject;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private List<User> userList;
    private BufferedReader in;
    private PrintWriter out;

    public ClientHandler(Socket clientSocket, List<User> userList) {
        this.clientSocket = clientSocket;
        this.userList = userList;

        try {
            this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(), "UTF-8"));
            this.out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream(), "UTF-8"), true);
        } catch (IOException e) {
            System.err.println("클라이언트 스트림 초기화 중 오류: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        try {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                String[] parts = inputLine.split("\\|");
                if ("SCORE".equalsIgnoreCase(parts[0])) {
                    handleScore(parts);
                } else if ("TOP3".equalsIgnoreCase(parts[0])) {
                    sendTop3Scores();
                }
            }
        } catch (IOException e) {
            System.err.println("클라이언트 통신 중 오류: " + e.getMessage());
        }
    }

    private void handleScore(String[] parts) {
        if (parts.length < 3) {
            out.println("ERROR|Invalid score data");
            return;
        }
        String playerName = parts[1];
        String newScore = parts[2];

        boolean isUpdated = updateTop3Scores(playerName, newScore);

        // 상위 3명의 데이터를 항상 전송
        sendTop3Scores();
    }

    private boolean updateTop3Scores(String playerName, String newScore) {
        User existingUser = userList.stream()
                .filter(u -> u.getName().equals(playerName))
                .findFirst()
                .orElse(null);

        if (existingUser == null) {
            userList.add(new User(playerName, newScore));
        } else if (Integer.parseInt(newScore) > existingUser.getScoreAsInt()) {
            existingUser.setScore(newScore);
        } else {
            return false;
        }

        userList.sort(new GameRule());
        if (userList.size() > 3) {
            userList = userList.subList(0, 3);
        }

        SaveScoreFile.writeScoreFile(userList);
        return true;
    }

    private void sendTop3Scores() {
        userList.sort(new GameRule());
        StringBuilder top3Builder = new StringBuilder("TOP3|");
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            top3Builder.append((i + 1)).append(":").append(user.getName())
                    .append(":").append(user.getScoreAsInt());
            if (i < userList.size() - 1) {
                top3Builder.append(",");
            }
        }
        String top3Data = top3Builder.toString();
        System.out.println("클라이언트에게 전송할 데이터: " + top3Data);
        out.println(top3Data);
        out.flush();
    }
}
