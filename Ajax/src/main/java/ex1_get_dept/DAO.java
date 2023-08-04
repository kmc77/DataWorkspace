package ex1_get_dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/*
 DAO(Data Access Object) 클래스
 - 데이터 베이스와 연동하여 레코드의 추가, 수정, 삭제 작업이 이루어지는 클래스 입니다.
 */
public class DAO {
	
	public DataSource ds;
	
	//생성자에게 JNDI 리소스를 참조하여 Connection 객체를 얻어옵니다.
	public DAO() {
		try {
			Context init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		} catch (Exception ex) {
			System.out.println("DB 연결 실패 : " + ex);
		}
	}
	
	public JsonArray getList_lib() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		JsonArray array = new JsonArray();
		try {
			con = ds.getConnection();
			
			
			String sql = "select * from dept order by deptno";
			
			//PreparedStatement 객체 얻기
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) { //더 이상 읽을 데이터가 없을 때까지 반복
				JsonObject obj = new JsonObject();
				obj.addProperty("deptno",  rs.getInt(1));
				obj.addProperty("dname",  rs.getString(2));
				obj.addProperty("loc",  rs.getString(3));
				array.add(obj);
			}
	        } catch (Exception e) {
	            e.printStackTrace();
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
	            if (con != null) {
	                try {
	                    con.close(); //4단계 : DB연결을 끊는다.
	                } catch (Exception e) {
	                    System.out.println(e.getMessage());
	                }
	            }
	        } // finally
		return array;
	}

	public JsonArray getList_lib_search(int deptno) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		JsonArray array = new JsonArray();
		try {
			con = ds.getConnection();

	            String sql = "select * from dept where deptno=?";

	          //PreparedStatement 객체 얻기
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, deptno);
				rs = pstmt.executeQuery();
				
				while (rs.next()) { //더 이상 읽을 데이터가 없을 때까지 반복
					JsonObject obj = new JsonObject();
					obj.addProperty("deptno",  rs.getInt(1));
					obj.addProperty("dname",  rs.getString(2));
					obj.addProperty("loc",  rs.getString(3));
					array.add(obj);
				}
		        } catch (Exception e) {
		            e.printStackTrace();
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
		            if (con != null) {
		                try {
		                    con.close(); //4단계 : DB연결을 끊는다.
		                } catch (Exception e) {
		                    System.out.println(e.getMessage());
		                }
		            }
		        } // finally
			return array;
	}
}
