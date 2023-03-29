package LoginServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import DatabaseServlets.DatabaseConnection;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // POST because it's the user sending stuff
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	// TODO: make a filter servlet, instead of copy pasting all these no caching, admin checking codes
    	
		// Making sure that the user can't use the back button to enter a logged out panel
		// e.g., while using a computer in a public library
		// ye below 3 lines ka kaam bas yahi h ki caching na ho webpage ka, aur back button kaam hi naa kare
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0
		response.setHeader("Expires", "0"); // Proxies

        // html page creation. basically homepage pe redirect karega, /link.html pe
        // response.setContentType("text/html");
        // writer object creation
        PrintWriter out = response.getWriter();
        // print in the navigation bar
        // getServletContext().getRequestDispatcher("/index.jsp").include(request, response);

        // Variables for ease of access
        String name = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            // establish connection to database
            Connection con = DatabaseConnection.initializeDatabase();

            // prepare a SQL statement
            PreparedStatement st = con.prepareStatement("select * from user_database where username = ? and password = ?");

            // set username to what user wrote in the 1st textfield
            st.setString(1, name);
            // set password to what user wrote in the 2nd textfield
            st.setString(2, password);

            // executing the SQL query
            ResultSet rs = st.executeQuery();
            int isAdmin = 0;

            // check karega, agar koi matching record hoga for the provided
            // username/password combination
            while (rs.next()) {

                int user_id = rs.getInt("user_id");
                isAdmin = rs.getInt("isAdmin");

                // Greet the user
                // out.print("Your user ID is " + user_id + ". Welcome, " + name);
                
                HttpSession session = request.getSession();
                session.setAttribute("user_id", user_id);
                //System.out.println((Integer)request.getSession().getAttribute("user_id"));
                session.setAttribute("isAdmin", isAdmin);

            }

            if (isAdmin == 1) {
                response.sendRedirect("AdminLogin.html");
            } else if (isAdmin == 0) {
            	response.sendRedirect("index.jsp");
            } else {
                // (nikal bkl) don't let the user in
                out.print("Sorry, username or password error! Please try again.");
                request.getRequestDispatcher("login.jsp").include(request, response);
                // response.sendRedirect("index.jsp");
            }
            // closing all the connections
            st.close();
            con.close();
            // writer ko bhi close karna hota h
            out.close();

        } catch (Exception e) {
            // classic error print
            e.printStackTrace();
        }

    }

}
