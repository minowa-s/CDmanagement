package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CdDeletedao {
	private static Connection getConnection() throws URISyntaxException, SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    URI dbUri = new URI(System.getenv("DATABASE_URL"));

	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

	    return DriverManager.getConnection(dbUrl, username, password);
	}
	public static int deletecd(String isbn) {
		
		
		String sql = "Delete From cd WHERE isbn = ?";
		
		int result = 0;
		try(
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
					){
			int isbnStr = Integer.parseInt(isbn);
			pstmt.setInt(1, isbnStr);
			result = pstmt.executeUpdate();
			
		}catch(SQLException | URISyntaxException e) {
			e.printStackTrace();
		}finally {
			System.out.println(result + "件削除しました");
			
		}
		return result;
	}
}


