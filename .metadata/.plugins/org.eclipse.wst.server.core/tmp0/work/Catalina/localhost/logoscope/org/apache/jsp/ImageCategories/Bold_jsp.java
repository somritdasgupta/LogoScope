/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.0.23
 * Generated at: 2022-12-23 07:21:16 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.ImageCategories;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import Logic.*;
import java.util.List;

public final class Bold_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_packages.add("Logic");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
      out.write('\n');
 
//Making sure that the user can't use the back button to enter a logged out panel
//e.g., while using a computer in a public library
//ye below 3 lines ka kaam bas yahi h ki caching na ho webpage ka, aur back button kaam hi naa kare
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setHeader("Expires", "0"); // Proxies

//ye below codes h session object se check kar ke redirect karne ka, login.jsp
//mein, agar koi banda logged in ni h to
Integer user_id = (Integer) request.getSession().getAttribute("user_id");
//Integer isAdmin = (Integer) request.getSession().getAttribute("isAdmin");
if (user_id == null) {
	response.getWriter().print("You have no access to this page. Go back to login page.");
 response.sendRedirect("login.jsp");
}

try {

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=yes\">\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap\"\n");
      out.write("        rel=\"stylesheet\">\n");
      out.write("    <title>Bold</title>\n");
      out.write("    <!-- Bootstrap core CSS -->\n");
      out.write("    <link href=\"vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- Additional CSS Files -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/css/fontawesome.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/css/logoscope-master.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/css/owl.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/css/animate.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://unpkg.com/swiper@7/swiper-bundle.min.css\" />\n");
      out.write("\n");
      out.write("    <style>\n");
      out.write("        .thumbnail {\n");
      out.write("            height: 50%;\n");
      out.write("            width: 50%\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        table {\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    <!-- ***** Header Area Start ***** -->\n");
      out.write("    <header class=\"header-area header-sticky\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-12\">\n");
      out.write("                    <nav class=\"main-nav\">\n");
      out.write("                        <!-- ***** Logo Start ***** -->\n");
      out.write("                        <a href=\"index.jsp\" class=\"logo\">\n");
      out.write("                            <img src=\"assets/images/logo.png\" alt=\"\">\n");
      out.write("                        </a>\n");
      out.write("                        <!-- ***** Logo End ***** -->\n");
      out.write("                        <!-- ***** Menu Start ***** -->\n");
      out.write("                        <ul class=\"nav\">\n");
      out.write("                            <li><a href=\"index.jsp\">HOME</a></li>\n");
      out.write("                            <li><a href=\"SearchImage.jsp\">SEARCH</a></li>\n");
      out.write("                            <li><a href=\"register.jsp\">REGISTER</a></li>\n");
      out.write("                            <li><a href=\"login.jsp\">LOGIN</a></li>\n");
      out.write("                            <li class=\"dropdown\">\n");
      out.write("                                <div class=\"dropbutton\">Categories +\n");
      out.write("                                    <div class=\"dropdown-content\">\n");
      out.write("                                        <a href=\"BlackAndWhite\">Black and White</a>\n");
      out.write("                                        <a href=\"Alphabets\">ALPHABETS</a>\n");
      out.write("                                        <a href=\"Bold\" class=\"active\">BOLD</a>\n");
      out.write("                                        <a href=\"Minimal\">MINIMAL</a>\n");
      out.write("                                        <a href=\"Fancy\">FANCY</a>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </li>\n");
      out.write("                            <!-- <li><a href=\"GrabUserServlet\">Profile<img src=\"assets/images/profile-header.jpg\" alt=\"\"></a></li> -->\n");
      out.write("                            <li><a href=\"GrabUserServlet\">My Profile <img src=\"assets/images/profile.jpg\"></a></li>\n");
      out.write("                        </ul>\n");
      out.write("                        <!-- ***** Menu End ***** -->\n");
      out.write("                    </nav>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </header>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-lg-12\">\n");
      out.write("                <div class=\"page-content\">\n");
      out.write("                    ");
 List<Photo> photos = (List<Photo>) request.getAttribute("listPhotos");
                            //System.out.println(photos.size());
                            DatabaseCrud dao = new DatabaseCrud();
                            
      out.write("\n");
      out.write("                            <div>\n");
      out.write("                                <h1>Bold category logos</h1>\n");
      out.write("                                <table border=\"0\" cellspacing=\"50\" cellpadding=\"50\">\n");
      out.write("                                    ");
 for (int i=0; i < photos.size();) { 
      out.write("\n");
      out.write("                                        <tr>\n");
      out.write("                                            ");
 for(int j=0; j < 3; j++){ 
      out.write("\n");
      out.write("                                                <td>\n");
      out.write("                                                    <img width=\"20%\" height=\"20%\" src=\"data:image/png;base64,");
      out.print(photos.get(i).getBase64Image());
      out.write("\"><br><br>\n");
      out.write("                                                    <p class=\"w3-large\">\n");
      out.write("                                                        ");
      out.print(photos.get(i).getTitle());
      out.write("\n");
      out.write("                                                    </p><br><br>\n");
      out.write("                                                    <a href=\"data:image/png;base64,");
      out.print(photos.get(i).getBase64Image());
      out.write("\" download=\"");
      out.print(photos.get(i).getTitle());
      out.write(".png\"><button>Download</button></a>\n");
      out.write("                                                </td>\n");
      out.write("                                                ");
 i++; } 
      out.write("\n");
      out.write("                                        </tr>\n");
      out.write("                                        ");
 } 
      out.write("\n");
      out.write("                                </table>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            ");
 } catch (Exception e){ e.printStackTrace(); } 
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
