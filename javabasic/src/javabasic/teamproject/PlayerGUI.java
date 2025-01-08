package javabasic.teamproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class PlayerGUI extends JFrame {
	
	private QuizClient client;

	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;

	private static final int TOTAL_TIME_LIMIT = 50; // 총 퀴즈 제한 시간
	private static final int HINT_TIME_INTERVAL = 5; // 힌트 제공 간격
	private static final int NEXT_QUIZ_TIME = 50; // 다음 문제로 넘어가는 시간

	private Timer mainTimer; // 메인 타이머 (퀴즈 진행 타이머)
	private Timer hintTimer; // 힌트 타이머
	private Timer delayTimer; // 시작 지연 타이머

	private int totalQuizTime; // 현재 문제의 남은 시간
	private int hintIndex = 0; // 현재 제공된 힌트 인덱스
	private int currentQuizIndex = 0; // 현재 퀴즈 인덱스
	// 문제별 남은 시간을 추적
	private int[] timeUsedPerQuestion = new int[5]; // 각 문제별 소요 시간 저장

	private List<Quiz> selectedQuestions; // 퀴즈 데이터
	private ReadQuizFile rqf = new ReadQuizFile(); // JSON 파일 읽기 객체

	// GUI 컴포넌트
	private JTextArea chatOutputArea; // 채팅 출력 영역
	private JTextField timerField; // 타이머 표시 영역
	private JTextField questionField; // 남은 문제 표시
	private JTextArea rankField; // 기록 표시 영역
	private JPanel mainPanel; // 메인 패널

	public PlayerGUI(String serverHost, int serverPort) {
		this.client = new QuizClient(serverHost, serverPort);
		
		// 퀴즈 데이터를 JSON 파일에서 읽기
		selectedQuestions = rqf.readQuizFile();

		// JFrame 설정
		setTitle(":: Association Quiz ::");
		setSize(600, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		// ** 메인 패널 설정 **
		mainPanel = new JPanel();
		mainPanel.setLayout(null); // 절대 레이아웃
		mainPanel.setBounds(0, 0, 600, 550);
		mainPanel.setBackground(new Color(245, 245, 245));
		add(mainPanel);

		// ** 중앙 패널: 채팅 영역 **
		chatOutputArea = new JTextArea();
		chatOutputArea.setBounds(40, 20, 300, 400);
		chatOutputArea.setEditable(false);
		chatOutputArea.setBackground(Color.WHITE);
		chatOutputArea.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
		JScrollPane chatScrollPane = new JScrollPane(chatOutputArea);
		chatScrollPane.setBounds(40, 20, 300, 400);
		mainPanel.add(chatScrollPane);

		JTextField chatInputField = new JTextField();
		chatInputField.setBounds(40, 440, 300, 40);
		chatInputField.setFont(new Font("굴림", Font.PLAIN, 18));
		chatInputField.setHorizontalAlignment(JTextField.CENTER);
		chatInputField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
		mainPanel.add(chatInputField);

		// ** 오른쪽 패널: 타이머, 남은 문제, 기록 영역 **
		JLabel timerTitle = new JLabel("남은 시간", SwingConstants.CENTER);
		timerTitle.setBounds(370, 30, 180, 30);
		timerTitle.setFont(new Font("굴림", Font.BOLD, 16));
		mainPanel.add(timerTitle);

		timerField = new JTextField("" + TOTAL_TIME_LIMIT);
		timerField.setBounds(370, 60, 180, 60);
		timerField.setFont(new Font("굴림", Font.BOLD, 40));
		timerField.setHorizontalAlignment(JTextField.CENTER);
		timerField.setEditable(false);
		timerField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
		mainPanel.add(timerField);

		JLabel questionTitle = new JLabel("남은 문제", SwingConstants.CENTER);
		questionTitle.setBounds(370, 140, 180, 30);
		questionTitle.setFont(new Font("굴림", Font.BOLD, 16));
		mainPanel.add(questionTitle);

		questionField = new JTextField((currentQuizIndex + 1) + "/" + selectedQuestions.size());
		questionField.setBounds(370, 170, 180, 40);
		questionField.setFont(new Font("굴림", Font.BOLD, 16));
		questionField.setHorizontalAlignment(JTextField.CENTER);
		questionField.setEditable(false);
		questionField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
		mainPanel.add(questionField);

		// 기록 라벨
		JLabel rankTitle = new JLabel("최고기록", SwingConstants.CENTER);
		rankTitle.setBounds(370, 220, 180, 30);
		rankTitle.setFont(new Font("굴림", Font.BOLD, 16));
		mainPanel.add(rankTitle);

		rankField = new JTextArea();
		rankField.setBounds(370, 260, 180, 70);
		rankField.setFont(new Font("굴림", Font.BOLD, 18));
		rankField.setEditable(false);
		rankField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
		mainPanel.add(rankField);

		// ** START 버튼 **
		JButton startButton = new JButton("★START★");
		startButton.setBounds(370, 370, 180, 50);
		startButton.setFont(new Font("굴림", Font.BOLD, 18));
		startButton.setBackground(new Color(60, 179, 113));
		startButton.setForeground(Color.WHITE);
		mainPanel.add(startButton);

		// ** EXIT 버튼 **
		JButton exitButton = new JButton("★EXIT★");
		exitButton.setBounds(370, 430, 180, 50);
		exitButton.setFont(new Font("굴림", Font.BOLD, 18));
		exitButton.setBackground(new Color(220, 20, 60));
		exitButton.setForeground(Color.WHITE);
		mainPanel.add(exitButton);

		chatOutputArea.append(
				"☆연상퀴즈☆\n☆이 게임은 총 250초 5문제 입니다!☆\n☆빠르게 맞춘 시간을 기준으로 점수를 도출하며☆\n☆한 문제당 50초, 힌트는 6개로 이루어져 있습니다!☆\n☆점수 계산 방법!☆\n☆1초당 1점☆\n");

		// ** 채팅 입력 이벤트 리스너 **
		chatInputField.addActionListener(e -> {
			String message = chatInputField.getText(); // 입력된 텍스트 가져오기
			if (checkAnswer(message)) {
				chatOutputArea.append("정답입니다!\n");
				moveToNextQuiz();
			} else {
				chatOutputArea.append("정답이 아닙니다!\n");
			}
			chatInputField.setText(""); // 입력 필드 초기화
		});

		// ** START 버튼 이벤트 **
		startButton.addActionListener(e -> {
			resetGame();
			// 퀴즈 데이터를 JSON 파일에서 읽기
			selectedQuestions = rqf.readQuizFile();
			startQuizWithDelay();
		});

		// ** EXIT 버튼 이벤트 **
		exitButton.addActionListener(e -> System.exit(0));

		setVisible(true);
	}


	// 서버와의 연결 종료 메서드
	private void disconnectFromServer() {
		try {
			if (socket != null && !socket.isClosed()) {
				socket.close();
				chatOutputArea.append("서버와의 연결이 종료되었습니다.\n");
			}
		} catch (IOException ex) {
			chatOutputArea.append("연결 종료 중 오류가 발생했습니다.\n");
		}
	}

	// 퀴즈 시작 메서드 (3초 지연 후 타이머 시작)
	private void startQuizWithDelay() {
		totalQuizTime = TOTAL_TIME_LIMIT;
		hintIndex = 0;

		loadRecords();
		chatOutputArea.append("퀴즈가 곧 시작됩니다! 잠시만 기다려주세요...\n");

		delayTimer = new Timer(1000, new ActionListener() {
			int delayCount = 3; // 3초 지연

			@Override
			public void actionPerformed(ActionEvent e) {
				if (delayCount > 0) {
					chatOutputArea.append("시작까지 " + delayCount + "초 남았습니다...\n");
					delayCount--;
				} else {
					delayTimer.stop(); // 지연 타이머 종료
					chatOutputArea.append("퀴즈가 시작됩니다! 첫 번째 힌트를 확인하세요.\n");
					startQuiz();
				}
			}
		});
		delayTimer.start();
	}

	// 퀴즈 진행 메서드
	private void startQuiz() {

		// 첫 번째 힌트 즉시 제공
		provideHint();

		// 5초 간격으로 힌트를 제공하는 타이머
		hintTimer = new Timer(HINT_TIME_INTERVAL * 1000, e -> provideHint());
		hintTimer.start();

		// 메인 타이머 시작
		mainTimer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				totalQuizTime--;

				// 타이머 UI 업데이트
				timerField.setText("" + totalQuizTime);

				// 50초마다 다음 문제로 전환
				if (totalQuizTime % NEXT_QUIZ_TIME == 0) {
					moveToNextQuiz();
				}

				// 타이머 종료
				if (totalQuizTime <= 0) {
					mainTimer.stop();
					hintTimer.stop(); // 힌트 타이머도 종료
					endGame(); // 게임 종료 처리
					JOptionPane.showMessageDialog(PlayerGUI.this, "퀴즈가 종료되었습니다!");
				}
			}
		});
		mainTimer.start();
	}

	// 힌트를 제공하는 메서드
	private void provideHint() {
		Quiz currentQuiz = selectedQuestions.get(currentQuizIndex);
		if (hintIndex < currentQuiz.getHints().size()) {
			chatOutputArea.append("힌트: " + currentQuiz.getHints().get(hintIndex) + "\n");
			hintIndex++;
		}
	}

	// 정답 확인 메서드
	private boolean checkAnswer(String input) {
		Quiz currentQuiz = selectedQuestions.get(currentQuizIndex);
		return currentQuiz.getAnswer().equalsIgnoreCase(input.trim());
	}

	// 다음 문제로 이동
	private void moveToNextQuiz() {

		if (currentQuizIndex < timeUsedPerQuestion.length) {
			updateTimeTracking(); // 현재 문제가 배열 범위 내일 때만 호출
		}

		currentQuizIndex++;
		if (currentQuizIndex < selectedQuestions.size()) {
			chatOutputArea.append("\n다음 문제로 넘어갑니다!\n");
			questionField.setText((currentQuizIndex + 1) + "/" + selectedQuestions.size());
			hintIndex = 0;
			totalQuizTime = TOTAL_TIME_LIMIT;
			provideHint(); // 첫 번째 힌트 제공

			// 기존 힌트 타이머가 있으면 멈추고, 새로 시작
			if (hintTimer != null) {
				hintTimer.stop();
			}

			// 5초 간격으로 힌트를 제공하는 타이머를 다시 시작
			hintTimer = new Timer(HINT_TIME_INTERVAL * 1000, e -> provideHint());
			hintTimer.start();

		} else {
			mainTimer.stop();
			hintTimer.stop(); // 힌트 타이머도 종료
			endGame(); // 게임 종료 처리
		}

	}

	private void endGame() {

		if (currentQuizIndex < timeUsedPerQuestion.length) {
			updateTimeTracking(); // 현재 문제가 배열 범위 내일 때만 호출
		}

		// 게임 종료 메시지
		String finalScore = calculateScore();
		chatOutputArea.append("\n게임이 종료되었습니다! 총 점수: " + finalScore + "점\n");
		totalQuizTime = TOTAL_TIME_LIMIT;
		JOptionPane.showMessageDialog(this, "게임이 종료되었습니다!", "게임 종료", JOptionPane.INFORMATION_MESSAGE);

		// 사용자 ID 입력
		String name = JOptionPane.showInputDialog(this, "아이디를 입력하세요:", "아이디 입력", JOptionPane.PLAIN_MESSAGE);
		if (name == null || name.trim().isEmpty()) {
			name = "익명"; // 입력하지 않은 경우 기본값 설정
		}

		saveRecord(name, finalScore);

		// 최종 메시지 출력
		chatOutputArea.append("\n감사합니다, " + name + " 님!\n");
		// 게임 초기화
		resetGame();
	}

	private void resetGame() {
		// 초기 상태로 설정
		currentQuizIndex = 0;
		totalQuizTime = TOTAL_TIME_LIMIT;
		hintIndex = 0;

		// 문제별 소요 시간 배열 초기화
		timeUsedPerQuestion = new int[selectedQuestions.size()];

		// UI 초기화
		chatOutputArea.setText(
				"☆연상퀴즈☆\n☆이 게임은 총 250초 5문제 입니다!☆\n☆빠르게 맞춘 시간을 기준으로 점수를 도출하며☆\n☆한 문제당 50초, 힌트는 6개로 이루어져 있습니다!☆\n☆점수 계산 방법!☆\n☆1초당 1점☆\n");
		timerField.setText("" + TOTAL_TIME_LIMIT);
		questionField.setText((currentQuizIndex + 1) + "/" + selectedQuestions.size());
		rankField.setText("");
		loadRecords();

		// 타이머 초기화
		if (mainTimer != null)
			mainTimer.stop();
		if (hintTimer != null)
			hintTimer.stop();
		if (delayTimer != null)
			delayTimer.stop();
	}

	// 게임 진행 중 남은 시간을 계산하여 점수를 누적
	private String calculateScore() {
		int totalScore = 0;

		for (int i = 0; i < timeUsedPerQuestion.length; i++) {
			int remainingTime = NEXT_QUIZ_TIME - timeUsedPerQuestion[i];
			totalScore += Math.max(remainingTime, 0); // 음수 값 방지
		}

		return String.valueOf(totalScore);
	}

	// 타이머에서 시간 추적 및 저장
	private void updateTimeTracking() {
		if (currentQuizIndex < timeUsedPerQuestion.length) { // 인덱스가 유효한 경우에만 실행
			timeUsedPerQuestion[currentQuizIndex] = TOTAL_TIME_LIMIT - totalQuizTime;
		}
	}

	private void saveRecord(String name, String score) {
	    client.sendScore(name, score); // 서버로 바로 점수를 전송
	}

	private void loadRecords() {
		List<User> userList = SaveScoreFile.readScoreFile();
		rankField.setText("");
		if (userList != null) {
			for (User user : userList) {
				rankField.append(user.getName() + ": " + user.getScore() + "\n");
			}
		}
	}

	
}