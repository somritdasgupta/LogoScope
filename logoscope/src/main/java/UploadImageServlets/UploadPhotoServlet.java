package UploadImageServlets;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import DatabaseServlets.DatabaseConnection;
//import Logic.DatabaseCrud;

@WebServlet("/UploadPhotoServlet")
@MultipartConfig(maxFileSize = 16177215) // This has to be here so that the max upload size is up to 16mb
public class UploadPhotoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		// Making sure that the user can't use the back button to enter a logged out panel
		// e.g., while using a computer in a public library
		// ye below 3 lines ka kaam bas yahi h ki caching na ho webpage ka, aur back button kaam hi naa kare
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0
		response.setHeader("Expires", "0"); // Proxies
		
		// ye below codes h session object se check kar ke redirect karne ka, login.jsp
        // mein, agar koi banda logged in ni h to
		Integer user_id = (Integer) request.getSession().getAttribute("user_id");
		Integer isAdmin = (Integer) request.getSession().getAttribute("isAdmin");
		if (user_id == null || isAdmin != 1) {
			response.getWriter().print("You have no access to this page. Go back to login page.");
            response.sendRedirect("login.jsp");
		}
		
        // TODO: use base64 image encoding to encode the images into a text String and then upload it.
    	try {
            // Establish connection
            Connection con = DatabaseConnection.initializeDatabase();

            // Create DAO
            //DatabaseCrud dao = new DatabaseCrud();
            // aisehi, sexy laga

            // Variables we got from the form
            String title = request.getParameter("title");
            String tag = request.getParameter("tag");

            // Debug
            // System.out.println(request.getSession(false).getAttribute("name"));

            // Photo file from the jsp form
            InputStream inputStream = null;

            // Getting the photo
            // Multipart/Part is required for allowing to access uploaded files
            Part filePart = request.getPart("photo");
            if (filePart != null) {
                // Debug code
                // System.out.println(filePart.getName());
                // System.out.println(filePart.getSize());
                // System.out.println(filePart.getContentType());

                // Assign to variable
                inputStream = filePart.getInputStream();

                // Create SQL statement
                String sql = "INSERT INTO logo (title, logo, tag) VALUES (?, ?, ?)";
                PreparedStatement statement = con.prepareStatement(sql);
                // PreparedStatement statement = con.prepareStatement(sql,
                // Statement.RETURN_GENERATED_KEYS);
                // One way to fetch the keys after the automatic generation is to pass
                // Statement.RETURN_GENERATED_KEYS to the prepareStatement() method:
                statement.setString(1, title);
                statement.setString(3, tag);
                // Calling getSession(false), though, retrieves the current session, and if one
                // doesn't
                // exist yet, returns null.
                if (isAdmin != 1) {
        			response.getWriter().print("You have no access to this page. Go back to login page.");
                    response.sendRedirect("login.jsp");
        		}

                // File upload if it can
                if (inputStream != null) {
                    // Add "blob"
                    statement.setBlob(2, inputStream);
                }

                // Execute it and check if works
                // int row = statement.executeUpdate();
                if (statement.executeUpdate() > 0) {
                	System.out.println("successfull");
                	response.getWriter().println("Successfull");
//                	int id = Integer.parseInt(request.getParameter("id"));
//                    response.sendRedirect("/logoscope/GrabImageServlet?pic_id=" + id);
                } else {
                    response.getWriter().print("Something went wrong.");
                }

                // Close all the connections
                statement.close();
                con.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().print("Something went wrong. You're meant to send a POST request.");
        // hehehehehehehehehe
    }

}
