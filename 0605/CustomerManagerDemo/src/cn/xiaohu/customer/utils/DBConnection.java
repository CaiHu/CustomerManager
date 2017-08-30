package cn.xiaohu.customer.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	private final static String URL="jdbc:sqlserver://localhost:1433;DatabaseName=customerManger";
	private final static String DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private final static String USERNAME="sa";
	private final static String PASSWORD="123456";
	/**
	 * 获取数据库连接对象的方法
	 */
	public static Connection getConnection(){
		Connection conn=null;
		if(conn==null){
			try{
				Class.forName(DRIVER);
				conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return conn;
	}
	/**
	 * 关闭数据库相关连接对象的方法
	 * @param conn 连接
	 * @param pstmt 预处理
	 * @param rs 结果集
	 */
	public void close(Connection conn,PreparedStatement pstmt,ResultSet rs){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

