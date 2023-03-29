package DatabaseServlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import Logic.DatabaseCrud;
import Logic.Photo;

@WebServlet("/GrabImageServlet")
//@MultipartConfig(maxFileSize = 16177215)
public class GrabImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		// Making sure that the user can't use the back button to enter a logged out panel
		// e.g., while using a computer in a public library
		// ye below 3 lines ka kaam bas yahi h ki caching na ho webpage ka, aur back button kaam hi naa kare
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0
		response.setHeader("Expires", "0"); // Proxies
		
		// ye below codes h session object se check kar ke redirect karne ka, login.jsp
        // mein, agar koi banda logged in ni h to
		Integer user_id = (Integer) request.getSession().getAttribute("user_id");
		// Integer isAdmin = (Integer) request.getSession().getAttribute("isAdmin");
		if (user_id == null) {
			response.getWriter().print("You have no access to this page. Go back to login page.");
            response.sendRedirect("login.jsp");
		}
        
		try {
		// Create DAO
		DatabaseCrud dao = new DatabaseCrud();

		// The photo
		Photo photo = null;

		// ID of image
		int id = Integer.valueOf(request.getParameter("id"));

		// Put that image into an object
			photo = dao.getPhoto(id);
		

		 //Put data into attributes
		request.setAttribute("title", photo.getTitle());
		request.setAttribute("logo", photo.getLogo());
		request.setAttribute("base64Image", photo.getBase64Image());
		

		//Object just in case
		request.setAttribute("photo", photo);
		
		
		//Forward to page with the image
		request.getRequestDispatcher("/DisplayImage.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
