package javabasic.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

// 데이터베이스에 프로시져와 함수를 생성해 두고 java 에서 호출해서 사용하는 방식
// 성능, 보안면에서 매우 큰 혜택이 있으므로 적극적으로 사용해야 함

// CallableStatement 를 사용해서 데이터베이스의 프로시져, 함수 호출
public class JDBCTest4 {

	public static void main(String[] args) {
		
		Connection conn = ConnectionUtil.getConnection();
		
		try {
			
			
			
			// 프로시져 호출
			// changename의 첫번째 파라미터는 in parameter
			// 두번째 파라미터는 in out parameter
			// in parameter 는 java 에서 설정해서 db 로 보냄
			// out parameter 는 db 에서 보낸 값을 java 에서 받음
			// in out parameter 는 java 에서 설정해서 db 로 보내고 db 에서 보낸 값을 java 에서 받음
			CallableStatement cstmt = conn.prepareCall(" {call changename(?, ?)} ");
			cstmt.registerOutParameter(2, Types.VARCHAR);
			cstmt.setInt(1, 4);
			cstmt.setString(2, "장국영");
			cstmt.execute();
			System.out.println("프로시져의 out parameter 값 : "+ cstmt.getString(2));
			
			// 함수 호출
			cstmt = conn.prepareCall(" {? = call getname(?)} ");
			// 함수의 out parameter 등록
			cstmt.registerOutParameter(1, Types.VARCHAR);
			// 함수의 in parameter 값 설정
			cstmt.setInt(2, 4);
			// 함수 실행
			cstmt.execute();
			System.out.println("함수 리턴값 : "+ cstmt.getString(1));
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		ConnectionUtil.closeConnection(conn);
		
	}// main
	
}// class
