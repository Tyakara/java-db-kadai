package kadai_004;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Employees_Chapter04 {

	public static void main(String[] args) {
		
		Connection con = null;
		
		Statement statement = null;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("MySQLのユーザー名を入力:");
		String username = scanner.nextLine();
		System.out.println("MySQLのパスワードを入力:");
		String password = scanner.nextLine();
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/challenge_java",
					username,password
					);
		System.out.println("接続成功");
		//SQLクエリを準備する
		statement = con.createStatement();
		String sql ="""
				CREATE TABLE employees(
				id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
				name VARCHAR(60) NOT NULL,
				email VARCHAR(255) NOT NULL,
				age INT(11),
				address VARCHAR(255)
				);
				""";
		//SQLクエリの実行
		int rowCnt = statement.executeUpdate(sql);
		System.out.println("テーブルを作成:rowCnt" + rowCnt);
			scanner.close();
		}catch(SQLException e) {
			System.out.println("エラー発生" + e.getMessage());
			
		}finally {
			if(statement != null) {
				
				try {statement.close();}catch(SQLException ignore) {}
				
			if(con != null) {
				
				try {statement.close();}catch(SQLException ignore) {}
				
			}
				
			}
			
		}

	}

}
