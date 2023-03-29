package Logic;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import DatabaseServlets.DatabaseConnection;

public class DatabaseCrud {

	public boolean insertPhoto(Photo photo) throws Exception {
		// Insert statement
		String sql = "INSERT INTO logo (title, logo, tag) VALUES (?, ?, ?)";

		// Establish connection
		Connection con = DatabaseConnection.initializeDatabase();

		// Fill out the statement with object data
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, photo.getTitle());
		statement.setBlob(2, photo.getLogo());
		statement.setString(3,  photo.getTag());

		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.close();
		return rowInserted;
	}
	
	public void deletePhoto(int id) throws Exception {
		String sql = "DELETE FROM logo WHERE id=?;";

		// Establish connection
		Connection con = DatabaseConnection.initializeDatabase();

		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1, id);

		// Get data about this particular picture
		if (statement.executeUpdate() > 0) {
			System.out.println("image deleted successfully");
		}
		
		statement.close();
		con.close();
	}

	// Return a SINGLE photo matching the provided primary key (id)
	public Photo getPhoto(int id) throws Exception {
		Photo photo = null;
		String sql = "SELECT * FROM test.logo WHERE id = ?";

		// Establish connection
		Connection con = DatabaseConnection.initializeDatabase();

		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet resultSet = statement.executeQuery();

		// Get data about this particular picture
		if (resultSet.next()) {
			String title = (resultSet.getString("title"));
			String tag = (resultSet.getString("tag"));
			Blob logo = (resultSet.getBlob("logo"));

			// Imagefile
			InputStream inputStream = logo.getBinaryStream();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			byte[] buffer = new byte[4096];
			int bytesRead = -1;

			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}

			byte[] imageBytes = outputStream.toByteArray();

			String base64Image = Base64.getEncoder().encodeToString(imageBytes);

			inputStream.close();
			outputStream.close();
			// And put it into an object
			photo = new Photo(id, title, tag, logo, base64Image );
		}

		resultSet.close();
		statement.close();
		con.close();

		return photo;
	}

	// Return EVERY photo from database
	public List<Photo> listEveryPhoto() throws Exception {
		List<Photo> listPhotos = new ArrayList<>();

		// Query
		String sql = "SELECT * FROM logo";

		// Establish connection
		Connection con = DatabaseConnection.initializeDatabase();

		// Statement
		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			int id = (resultSet.getInt("id"));
			String title = (resultSet.getString("title"));
			String tag = (resultSet.getString("tag"));
			Blob logo = (resultSet.getBlob("logo"));

			// Imagefile
			InputStream inputStream = logo.getBinaryStream();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			byte[] buffer = new byte[4096];
			int bytesRead = -1;

			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}

			byte[] imageBytes = outputStream.toByteArray();

			String base64Image = Base64.getEncoder().encodeToString(imageBytes);

			inputStream.close();
			outputStream.close();
			// And put it into an object
			Photo photo = new Photo(id, title, tag, logo, base64Image);
			listPhotos.add(photo);
		}

		resultSet.close();
		statement.close();
		con.close();

		return listPhotos;

	}
	
	// Return EVERY matching TITLE photo from database
	public List<Photo> listMatchingPhoto(String title) throws Exception {
	    List<Photo> listPhotos = new ArrayList<>();
	    
	    //Query
	    String sql = "select * from logo where title = ?";
	    
		// Establish connection
		Connection con = DatabaseConnection.initializeDatabase();
		
		//Statement
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, title);
		ResultSet resultSet = st.executeQuery();
	     
	    while (resultSet.next()) {
			int id = (resultSet.getInt("id"));
			String tag = (resultSet.getString("tag"));
			Blob logo = (resultSet.getBlob("logo"));
			
			// Imagefile
			InputStream inputStream = logo.getBinaryStream();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			byte[] buffer = new byte[4096];
			int bytesRead = -1;

			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}

			byte[] imageBytes = outputStream.toByteArray();

			String base64Image = Base64.getEncoder().encodeToString(imageBytes);

			inputStream.close();
			outputStream.close();

			// And put it into an object
			Photo photo = new Photo(id, title, tag, logo, base64Image);
	        listPhotos.add(photo);
	    }
	     
		resultSet.close();
		st.close();
		con.close();

		return listPhotos;
		
	}
	
	// Return EVERY matching TAG photo from database
	public List<Photo> listMatchingTagPhoto(String tag) throws Exception {
	    List<Photo> listPhotos = new ArrayList<>();
	    
	    //Query
	    String sql = "select * from logo where tag = ?";
	    
		// Establish connection
		Connection con = DatabaseConnection.initializeDatabase();
		
		//Statement
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, tag);
		ResultSet resultSet = st.executeQuery();
	     
	    while (resultSet.next()) {
			int id = (resultSet.getInt("id"));
			String title = (resultSet.getString("title"));
			Blob logo = (resultSet.getBlob("logo"));
			
			// Imagefile
			InputStream inputStream = logo.getBinaryStream();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			byte[] buffer = new byte[4096];
			int bytesRead = -1;

			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}

			byte[] imageBytes = outputStream.toByteArray();

			String base64Image = Base64.getEncoder().encodeToString(imageBytes);

			inputStream.close();
			outputStream.close();

			// And put it into an object
			Photo photo = new Photo(id, title, tag, logo, base64Image);
	        listPhotos.add(photo);
	    }
	     
		resultSet.close();
		st.close();
		con.close();

		return listPhotos;
		
	}


	// Return a SINGLE user matching the provided primary key (id)
	public User getUser(int user_id) throws Exception {
		User user = null;
		String sql = "SELECT * FROM user_database WHERE user_id=?;";

		// Establish connection
		Connection con = DatabaseConnection.initializeDatabase();

		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1, user_id);

		ResultSet resultSet = statement.executeQuery();

		// Get data about this particular picture
		if (resultSet.next()) {
			String username = (resultSet.getString("username"));
			String password = (resultSet.getString("password"));
			String email = (resultSet.getString("email"));
			int isAdmin = (resultSet.getInt("isAdmin"));

			// And put it into an object
			user = new User(user_id, username, password, email, isAdmin);
		}

		resultSet.close();
		statement.close();
		con.close();
		return user;
	}

	// Return EVERY user from database
		public List<User> listEveryUser() throws Exception {
			List<User> listUsers = new ArrayList<>();

			// Query
			String sql = "SELECT * FROM user_database";

			// Establish connection
			Connection con = DatabaseConnection.initializeDatabase();

			// Statement
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				int user_id = (resultSet.getInt("user_id"));
				String username = (resultSet.getString("username"));
				String password = (resultSet.getString("password"));
				String email = (resultSet.getString("email"));
				int isAdmin = (resultSet.getInt("isAdmin"));
				
				// And put it into an object
				User user = new User(user_id, username, password, email, isAdmin);
				listUsers.add(user);
			}

			resultSet.close();
			statement.close();
			con.close();

			return listUsers;

		}
	
		// Delete SINGLE user from database with matching username
	public void deleteUser(String username) throws Exception {
		String sql = "DELETE FROM user_database WHERE username=?;";

		// Establish connection
		Connection con = DatabaseConnection.initializeDatabase();

		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, username);

		// Get data about this particular picture
		if (statement.executeUpdate() > 0) {
			System.out.println("user deleted successfully");
		}
		
		statement.close();
		con.close();
	}

}