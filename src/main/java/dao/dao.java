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

public class dao {
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
	
	public static int cd(Cd CD) {
		String sql = "INSERT INTO cd VALUES( ?, ?, ?, ?)";
		int result = 0;
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1,CD.getTitle());
			pstmt.setString(2,CD.getComposer());
			pstmt.setString(3,CD.getOnsale());
			pstmt.setInt(4,CD.getIsbn());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
	
	public static List<Cd> selectListCddto(){
		String sql = "SELECT * FROM cd";
		List<Cd> list = new ArrayList<>();
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			try(ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					
					String title = rs.getString("title");
					String composer = rs.getString("composer");
					String onsale = rs.getString("onsale");
					int isbn = rs.getInt("isbn");
					
					Cd dao = new Cd(title,composer,onsale,isbn);
					list.add(dao);
				}
		}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
			
	}
		return list;

	}
	}