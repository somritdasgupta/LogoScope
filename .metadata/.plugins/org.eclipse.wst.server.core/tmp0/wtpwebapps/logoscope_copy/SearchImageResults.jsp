<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="Logic.*"%>
<%
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
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=yes">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap"
        rel="stylesheet">
    <title>Search Results</title>
    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="assets/css/fontawesome.css">
    <link rel="stylesheet" href="assets/css/logoscope-master.css">
    <link rel="stylesheet" href="assets/css/owl.css">
    <link rel="stylesheet" href="assets/css/animate.css">
    <link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css" />

    <style>
        .thumbnail {
            height: 50%;
            width: 50%
        }

        table {
            text-align: center;
        }
    </style>
</head>

<body>

    <!-- ***** Header Area Start ***** -->
    <header class="header-area header-sticky">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav class="main-nav">
                        <!-- ***** Logo Start ***** -->
                        <a href="index.jsp" class="logo">
                            <img src="assets/images/logo.png" alt="">
                        </a>
                        <!-- ***** Logo End ***** -->
                        <!-- ***** Menu Start ***** -->
                        <ul class="nav">
                            <li><a href="index.jsp">HOME</a></li>
                            <li><a href="SearchImage.jsp">SEARCH</a></li>
                            <li><a href="register.jsp">REGISTER</a></li>
                            <li><a href="login.jsp">LOGIN</a></li>
                            <li class="dropdown">
                                <div class="dropbutton">Categories +
                                    <div class="dropdown-content">
                                        <a href="BlackAndWhite">Black and White</a>
                                        <a href="Alphabets">ALPHABETS</a>
                                        <a href="Bold" class="active">BOLD</a>
                                        <a href="Minimal">MINIMAL</a>
                                        <a href="Fancy">FANCY</a>
                                    </div>
                                </div>
                            </li>
                            <!-- <li><a href="GrabUserServlet">Profile<img src="assets/images/profile-header.jpg" alt=""></a></li> -->
                            <li><a href="GrabUserServlet">My Profile <img src="assets/images/profile.jpg"></a></li>
                        </ul>
                        <!-- ***** Menu End ***** -->
                    </nav>
                </div>
            </div>
        </div>
    </header>


    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="page-content">
                    <% List<Photo> photos = (List<Photo>) request.getAttribute("listPhotos");
                            System.out.println(photos.size());
                            if (photos.size() > 0){
                            DatabaseCrud dao = new DatabaseCrud();
                            %>
                            <div>
                                <h1>Found Photos</h1>
                                <table border="0" cellpadding="5" cellspacing="0">
                                    <tr>
                                        <th>
                                            <p class="w3-large">Preview</p>
                                        </th>
                                        <th>
                                            <p class="w3-large">Image ID</p>
                                        </th>
                                        <th>
                                            <p class="w3-large">Title</p>
                                        </th>
                                        <th>
                                            <p class="w3-large">Tag</p>
                                        </th>
                                        <th>
                                            <p class="w3-large">Full Image Preview and Download</p>
                                        </th>
                                    </tr>
                                    <% for (int i=0; i < photos.size(); i +=1) { %>
                                        <tr>
                                            <td>
                                                <div class="thumbnail">
                                                    <img
                                                        src="data:image/jpg;base64,<%=photos.get(i).getBase64Image()%>">
                                                </div>
                                            </td>
                                            <td>
                                                <p class="w3-large">
                                                    <%=photos.get(i).getId()%>
                                                </p>
                                            </td>
                                            <td>
                                                <p class="w3-large">
                                                    <%=photos.get(i).getTitle()%>
                                                </p>
                                            </td>
                                            <td>
                                                <p class="w3-large">
                                                    <%=photos.get(i).getTag()%>
                                                </p>
                                            </td>
                                            <td><a href="GrabImageServlet?id=<%=photos.get(i).getId()%>"><button>Click
                                                        me</button></a></td>
                                        </tr>
                                        <% } } else { %>
                                            <p class="w3-large">No search result</p>
                                </table>
                            </div>

                            <% }} catch (Exception e){ e.printStackTrace(); } %>
                </div>
            </div>
        </div>
    </div>
</body>

</html>