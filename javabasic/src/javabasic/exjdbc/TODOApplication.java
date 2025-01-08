package javabasic.exjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TODOApplication {

	static Connection conn = ConnectionUtil.getConnection();
	static List<TODO> todoList = new ArrayList<TODO>();

	public static void main(String[] args) {

	}// main

	static void startTODO() {
		System.out.println("-----------------------------------");
		System.out.println("메뉴 (1.목록 2.등록 3.삭제 4.완료처리 5.종료)");
		System.out.println("-----------------------------------");
	}

	static void showTODO() throws SQLException {
		String selectSQL = " select tdno, tddate, tdwriter, tdcontent, decode(tdyn, 'Y', '완료', 'N', '미완료') 'dctdyn' from todo ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		pstmt = conn.prepareStatement(selectSQL);
		rs = pstmt.executeQuery();
		if (rs != null) {
			while (rs.next()) {
				todoList.add(new TODO(
						rs.getInt("tdno"),
						rs.getTimestamp("tddate"),
						rs.getString("tdwriter"),
						rs.getString("tdcontent"),
						rs.getString("dctdyn")
						)
					);
			}
		}
	}
//	System.out.println("번호:" + rs.getInt(1) + ", 등록일시:"+rs.getTimestamp(2)
//	+", 작성자:"+rs.getString(3)+", 내용:"+rs.getString(4)+", 완료 여부:"+rs.getString(5));

	static void insertTODO(TODO todo) throws SQLException {
		String insertSQL = " intsert into todo values(todo_seq.nextval, sysdate, ?, ?, ?) ";
		PreparedStatement pstmt = conn.prepareStatement(insertSQL);
		pstmt.setString(1, todo.getTdwriter());
		pstmt.setString(2, todo.getTdcontent());
		pstmt.setString(3, todo.getTdyn());
		pstmt.executeUpdate();
	}

	static void deleteTODO(String tdno) throws SQLException {
		String deleteSQL = " delete todo where tdno = ? ";
		PreparedStatement pstmt = conn.prepareStatement(deleteSQL);
		pstmt.setString(1, tdno);
		pstmt.executeUpdate();
	}

	static void compTODO(String tdno) throws SQLException{
		String updateSQL = " update todo set tdyn = 'Y' where tdno = ? ";
		PreparedStatement pstmt = conn.prepareStatement(updateSQL);
		pstmt.setString(1, tdno);
		pstmt.executeUpdate();
	}

	static void endTODO() {
		System.out.println("종료합니다");
		System.exit(0);
	}

}// class
