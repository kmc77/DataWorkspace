package ex23_Board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//글 등록하기
public class BoardDAO_seq {

	public int boardInsert(Board board) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		String sql = "";
		int result = 0;
		try {
			// 1단계 : JDBC 드라이버를 로드한다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2단계 : DB에 연결한다.
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "board", "1234");

			sql = "insert into board "
				+ "(BOARD_NUM,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,"
				+ " BOARD_CONTENT, BOARD_RE_REF,"
				+ " BOARD_RE_LEV,BOARD_RE_SEQ,BOARD_READCOUNT,"
				+ " BOARD_DATE) "
				+ " values(board_seq.nextval,?,?,?,"
				+ " 		?,	board_seq.nextval,"
				+ "			?,?,?,"
				+ " 		sysdate)";

			// 새로운 글을 등록하는 부분입니다.
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBOARD_NAME());
			pstmt.setString(2, board.getBOARD_PASS());
			pstmt.setString(3, board.getBOARD_SUBJECT());
			pstmt.setString(4, board.getBOARD_CONTENT());

			// 원문의 경우 BOARD_RE_LEV, BOARD_RE_SEQ 필드 값은 0 입니다.
			pstmt.setInt(5, 0); // BOARD_RE_LEV 필드
			pstmt.setInt(6, 0); // BOARD_RE_SEQ 필드
			pstmt.setInt(7, 0); // BOARD_READCOUNT 필드

			// 쿼리 실행
			result = pstmt.executeUpdate();

		} catch (Exception ex) {
			System.out.println("boardInsert() 에러: " + ex);
			ex.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			if (conn != null)
				try {
					conn.close(); // 4단계 : DB연결을 끊는다.
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		}
		return result;
	}

	// 글 목록 보기
	public List<Board> getBoardList(int page, int limit) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		/*
		 page : 페이지
		 limit : 페이지 당 목록의 수 
		 BOARD_RE_REF desc, BOARD_RE_SEQ asc 에 의해 정렬한 것을 
		 조건절에 맞는 rnum 의 범위 만큼 가져오는 쿼리문입니다.
		 */

		String board_list_sql = 
				  "select * "
				+ "from "	
				+ "		(select rownum rnum, b.* "
				+ " 	 from (select * from board "
				+ "			   order by BOARD_RE_REF desc, BOARD_RE_SEQ asc) b"
				+ "		 where rownum < = ?) "
				+ "where rnum>=? and rnum<=?";
		
		List<Board> list = new ArrayList<Board>();
		//한 페이지당 10개씩 목록인 경우					1페이지, 2페이지, 3페이지, 4페이지 ...
		int startrow = (page - 1) * limit + 1;  // 읽기 시작할 row 번호(1	11	21	31...
		int endrow = startrow + limit - 1;		// 읽을 마지막 row 번호(10	20	30	40...
		
		try {
			// 1단계 : JDBC 드라이버를 로드한다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "board", "1234");
			pstmt = conn.prepareStatement(board_list_sql);
			pstmt.setInt(1, endrow);
			pstmt.setInt(2, startrow);
			pstmt.setInt(3, endrow);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				Board board = new Board();
				board.setBOARD_NUM(rs.getInt("BOARD_NUM"));
				board.setBOARD_NAME(rs.getString("BOARD_NAME"));
				board.setBOARD_SUBJECT(rs.getString("BOARD_SUBJECT"));
				board.setBOARD_CONTENT(rs.getString("BOARD_CONTENT"));
				// board.setBOARD_(rs.getString("BOARD_CONTENT"));
				board.setBOARD_RE_REF(rs.getInt("BOARD_RE_REF"));
				board.setBOARD_RE_LEV(rs.getInt("BOARD_RE_LEV"));
				board.setBOARD_RE_SEQ(rs.getInt("BOARD_RE_SEQ"));

				board.setBOARD_DATE(rs.getString("BOARD_DATE"));
				list.add(board);
			}
		} catch (Exception ex) {
			System.out.println("boardInsert() 에러: " + ex);
			ex.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			if (conn != null)
				try {
					conn.close(); // 4단계 : DB연결을 끊는다.
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		}
		return list;
	}

	public int update(Board board) {
		
		return 0;
	}
	//글 내용 보기
	public Board getDetail(int num) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		Board board = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "board", "1234");

			pstmt = conn.prepareStatement("select * from board where BOARD_NUM = ?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				board = new Board();
				board.setBOARD_NUM(rs.getInt("BOARD_NUM"));
				board.setBOARD_PASS(rs.getString("BOARD_PASS")); // 비밀번호 확인시 사용됩니다.
				board.setBOARD_SUBJECT(rs.getString("BOARD_SUBJECT"));
				board.setBOARD_CONTENT(rs.getString("BOARD_CONTENT"));
				// board.setBOARD_FILE(rs.getString("BOARD_FILE"));
				board.setBOARD_RE_REF(rs.getInt("BOARD_RE_REF"));
				board.setBOARD_RE_LEV(rs.getInt("BOARD_RE_LEV"));
				board.setBOARD_RE_SEQ(rs.getInt("BOARD_RE_SEQ"));
				board.setBOARD_READCOUNT(rs.getInt("BOARD_READCOUNT"));
				board.setBOARD_DATE(rs.getString("BOARD_DATE"));
			}

		} catch (Exception ex) {
			System.out.println("boardInsert() 에러: " + ex);
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			if (pstmt != null)
				try {
					pstmt.close(); // 4단계 : DB연결을 끊는다.
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		}
		return board;
	}
	//글 수정
	public int boardModify(Board modifyboard) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		String sql = "update board "
				   + "set	 BOARD_SUBJECT= ?, "
				   + "		 BOARD_CONTENT= ? "
				   + "where  BOARD_NUM=? ";
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "board", "1234");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, modifyboard.getBOARD_SUBJECT());
			pstmt.setString(2, modifyboard.getBOARD_CONTENT());
			pstmt.setInt(3, modifyboard.getBOARD_NUM());
			result = pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("boardInsert() 에러: " + ex);
			ex.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			if (conn != null)
				try {
					conn.close(); // 4단계 : DB연결을 끊는다.
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		}
		return result;
	}
}
