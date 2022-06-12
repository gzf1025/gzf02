package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DButils {
	private static final String url ="jdbc:mysql://127.0.0.1:3306/springdb?useUnicode=true&characterEncoding=UTF-8";
	private static final String user ="root";
	private static final String password ="123456";
	
	static {
			//注册驱动
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	public static Connection getConnection() throws Exception {
		//获取数据库连接
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}
	public static void main(String[] args) {
		try {
			System.out.println(getConnection());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
