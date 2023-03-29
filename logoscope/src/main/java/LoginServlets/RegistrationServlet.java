package LoginServlets;

import java.io.IOException;
//import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import DatabaseServlets.DatabaseConnection;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		try {
			// TODO: use hashing to hash the password and then store the password in database.
				
			// Establish connection
			Connection con = DatabaseConnection.initializeDatabase();

			// Prepare an insert statement
			PreparedStatement st = con.prepareStatement("insert into test.user_database (username, email, password, isAdmin) values(?, ?, ?, ?)");

			// Set the values for the SQL query
			st.setString(1, request.getParameter("uname"));
			st.setString(2, request.getParameter("mail"));
			st.setString(3, request.getParameter("pass"));
			st.setInt(4, 0);

			// Execute it
			st.executeUpdate();
			// Close all the connections
			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		// content type
		response.setContentType("text/html");
		// generate page
		request.getRequestDispatcher("AccountCreated.jsp").forward(request, response);
	}

}
