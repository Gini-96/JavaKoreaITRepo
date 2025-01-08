package javabasic.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// PreparedStatement 를 이용한 CRUD (Create, 
public class JDBCTest3 {

	public static void main(String[] args) {

		Connection conn = ConnectionUtil.getConnection();

		// insert
		// ? : placeholder (위치지정자)
		// 이클립스에서 쿼리문 작성할때는 소문자로 작성해도 상관없음
//		String insertSQL = " INSERT INTO PERSON VALUES(SEQ_PERSON.NEXTVAL, ?, ?) ";
//		
//		try {
//			PreparedStatement pstmt = conn.prepareStatement(insertSQL);
//			// 1번 위치지정자 설정
//			pstmt.setString(1, "장보고");
//			// 2번 위치지정자 설정
//			pstmt.setInt(2, 40);
//			
//			// 입력된 행의 수를 반환
//			int result = pstmt.executeUpdate();
//			
//			if (result > 0) {
//				System.out.println("한 행의 데이터가 입력됨");
//			}
//			
//			
//		} catch (SQLException sqle) {
//			sqle.printStackTrace();
//		}

		// update
//		String updateSQL = " update person set pname='홍길순' where pid=? ";
//		try {
//			PreparedStatement pstmt = conn.prepareStatement(updateSQL);
//			pstmt.setInt(1, 1);
//			
//			int result = pstmt.executeUpdate();
//
//			if (result > 0) {
//				System.out.println("한 행의 데이터가 수정됨");
//			}
//
//			
//		} catch (SQLException sqle) {
//			sqle.printStackTrace();
//		}
		
		// delete
//		String deleteSQL = " delete person where pid=? ";
//		try {
//			PreparedStatement pstmt = conn.prepareStatement(deleteSQL);
//			pstmt.setInt(1, 1);
//			
//			int result = pstmt.executeUpdate();
//
//			if (result > 0) {
//				System.out.println("한 행의 데이터가 삭제됨");
//			}
//
//			
//		} catch (SQLException sqle) {
//			sqle.printStackTrace();
//		}
		
		//select
		String selectSQL = " SELECT PID, PNAME, PAGE FROM PERSON ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(selectSQL);
			
			rs = pstmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					System.out.println(
							rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)
							);
				}
			}
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				// Connection, Statement, PreparedStatement, CallableStatement
				// ResultSet 은 객체 사용 후 반드시 close 해줘야 함
				// close 하는 순서는 사용한 반대 순서를 따르면 됨
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		
		ConnectionUtil.closeConnection(conn);

	}// main

}// class
