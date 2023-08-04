package ex8_search;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import ex8_dept.Dept;

/*
데이터 액세스 객체 (DAO) 클래스
- 이 클래스는 데이터베이스와 상호작용하여 레코드를 추가, 수정, 삭제하는 작업을 수행합니다.
*/
public class DAO {

    public ArrayList<Dept> select(int inputdeptno) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Dept> list = new ArrayList<Dept>();
        try {

            // context.xml에 설정된 jdbc/OracleDB 리소스를 참조하여 Connection 객체를 가져옵니다.
            Context init = new InitialContext();
            DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
            conn = ds.getConnection();

            String select_sql = "select * from dept where deptno=?";

            // PreparedStatement 객체를 가져옵니다.
            pstmt = conn.prepareStatement(select_sql);
            pstmt.setInt(1, inputdeptno);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Dept dept = new Dept();
                dept.setDeptno(rs.getInt("deptno"));
                dept.setDname(rs.getString("dname"));
                dept.setLoc(rs.getString("loc"));

                list.add(dept);
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
                    conn.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } // finally
        return list;
    }
}
