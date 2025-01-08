package javabasic.jdbc.board.main;

import javabasic.jdbc.board.service.BoardService;
import javabasic.jdbc.board.service.impl.BoardServiceImpl;

public class BoardMain {

	public static void main(String[] args) {
		
		BoardService boardService = new BoardServiceImpl();
		
//		System.out.println(boardService.listBoard());
		
//		System.out.println(boardService.getBoard(2));
		
//		boardService.registBoard(new Board(0, "고양이계시판", null, null));
		
//		boardService.modifyBoard(new Board(21, "냥이계시판", null, "N"));
		
		boardService.removeBoard(21);
		
	}// main
	
}// class
