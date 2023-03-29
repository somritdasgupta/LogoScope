package DatabaseServlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import Logic.*;

@WebServlet("/GrabUserServlet")
public class GrabUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
		if (user_id == null) {
			response.getWriter().print("You have no access to this page. Go back to login page.");
            response.sendRedirect("login.jsp");
		}
        
		try {
		// Create DAO
		DatabaseCrud dao = new DatabaseCrud();

		// The user
		User user = null;

		// Put that user into an object
			user = dao.getUser(user_id);

		 //Put data into attributes
		request.setAttribute("username", user.getUsername());
		request.setAttribute("email", user.getEmail());
		request.setAttribute("user_id", user.getUser_id());
		request.setAttribute("isAdmin", isAdmin);
		

		//Object just in case
		request.setAttribute("user", user);
		
		//Forward to page with the image
		request.getRequestDispatcher("/UserProfile.jsp").include(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
