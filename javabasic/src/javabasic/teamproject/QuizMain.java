package javabasic.teamproject;

import javax.swing.SwingUtilities;

// 실행을 위한 메인클래스(플레이)
public class QuizMain {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new PlayerGUI("192.168.8.6", 6573));
	}// main
	
}// class
