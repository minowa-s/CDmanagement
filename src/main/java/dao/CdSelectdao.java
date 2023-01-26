package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Cd;

public class CdSelectdao {
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
	public static List<Cd> selectAllCd(){
		String sql ="SELECT * FROM cd";
		
		List<Cd> result = new ArrayList<>();
		try(
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			try(ResultSet rs = pstmt.executeQuery()){
				while (rs.next()) {
					String title = rs.getString("title");
					String composer = rs.getString("composer");
					String onsale = rs.getString("onsale");
					int isbn = rs.getInt("isbn");
					
					Cd cd = new Cd(title,composer,onsale,isbn);
					
					result.add(cd);
					
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(URISyntaxException e) {
			e.printStackTrace();
		}
		return result;
	}
	public static Cd selectCd(int isbn) {
		String sql ="SELECT * FROM cd WHERE title = ?";
		
		try(
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setInt(1, isbn);
			
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					String title = rs.getString("title");
					String composer = rs.getString("composer");
					String onsale = rs.getString("onsale");
					
					Cd result = new Cd(title,composer,onsale,isbn);
					return result;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(URISyntaxException e) {
			e.printStackTrace();
		}
			return null;
	}
	public static int deletebook(String isbn) {
		
		String sql = "Delete From book1 WHERE isbn = ?";
		
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

