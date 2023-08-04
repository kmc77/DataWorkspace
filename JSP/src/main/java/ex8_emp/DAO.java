package ex8_emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/*
 DAO(Data Access Object) 클래스
 - 데이터 베이스와 연동하여 레코드의 추가, 수정, 삭제 작업이 이루어지는 클래스 입니다.
 */
public class DAO {
	
	public ArrayList<Emp> selectAll() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Emp> list = new ArrayList<Emp>();
        try {
			
			//context.xml에서 설정한 리소스 jdbc/OracleDB를 참조하여 Connection 객체를 얻어 옵니다.
        	Context init = new InitialContext();
            DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
            conn = ds.getConnection();
			
			String select_sql = "select * from emp";
			
			//PreparedStatement 객체 얻기
			 pstmt = conn.prepareStatement(select_sql.toString());
	            rs = pstmt.executeQuery();

			
			while (rs.next()) { //더 이상 읽을 데이터가 없을 때까지 반복
				  Emp st = new Emp();
	                st.setEmpno(rs.getInt(1));
	                st.setEname(rs.getString(2));
	                st.setJob(rs.getString(3));
	                st.setMgr(rs.getInt(4));
	                st.setHiredate(rs.getDate(5));
	                st.setSal(rs.getInt(6));
	                st.setComm(rs.getInt(7));
	                st.setDeptno(rs.getInt(8));

	                list.add(st);

				
			  }
        } catch (Exception se) {
            se.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close(); // Step 4: Close the DB connection.
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } // finally
        return list;
    }
}