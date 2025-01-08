package javabasic.jdbc.board.dao.impl;

import java.util.List;

import javabasic.jdbc.board.dao.BoardDao;
import javabasic.jdbc.board.model.Board;

public class BoardFileDaoImpl implements BoardDao {
	
	public BoardFileDaoImpl() {
	}

	@Override
	public List<Board> listBoard() {
			return null;
	}

	@Override
	public Board getBoard(int bid) {
				return null;
	}

	@Override
	public int registBoard(Board board) {
			return 0;
	}

	@Override
	public int modifyBoard(Board board) {
			return 0;
	}

	@Override
	public int removeBoard(int bid) {
			return 0;
	}

}
