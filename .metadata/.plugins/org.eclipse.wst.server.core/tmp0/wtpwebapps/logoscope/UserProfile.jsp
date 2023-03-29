<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="DatabaseServlets.*, Logic.*" %>
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
    <title>User Profile</title>
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
        .p {
            margin-top: 2.5cm;
            font-size: 1cm;
            font-family: Georgia, 'Times New Roman', Times, serif;
            color: #fff;
            background-color: #e75e8d;
            border-radius: 20px;
            border-style: groove;
            border-color: #fff;
        }

        .user {
            display: inline-block;
            margin-left: 8cm;
            text-align: center;
        }

        .upload {
            display: inline-block;
        }

        button {
            margin-left: 2cm;
            margin-right: 1.5cm;
            margin-top: 3cm;
            font-size: 14px;
            color: #fff;
            background-color: #e75e8d;
            padding: 8px 20px;
            display: inline-block;
            border-radius: 30px;
            border-color: #ffff;
            border-style: groove;
            font-weight: 400;
            text-transform: capitalize;
            letter-spacing: 0.5px;
            margin-bottom: 15cm;

        }

        button:hover {
            background-color: #27292a;
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
                    <header class="w3-container w3-center" style="padding: 80px 16px">
                        <h1 class="w3-jumbo">Welcome to <%=request.getAttribute("username")%>'s profile!</h1>
                    </header>

                    <!-- First Grid -->
                    <div class="w3-row-padding w3-padding-24 w3-container w3-center">
                        <div class="w3-content">
                            <div class="w3-onefourth">
                                <p class="w3-xlarge">Your user id is <%=request.getAttribute("user_id")%>.</p>
                                <p class="w3-xlarge">Contact information: <%=request.getAttribute("email")%>
                                </p>

                                <% Integer isAdmin=(Integer) request.getAttribute("isAdmin"); if(isAdmin==1) { %>
                                    <p class="w3-xlarge">This user is an administrator.</p><br><br>
                                    <a href="AdminLogin.html">Go back to <b>Admin Panel</b></a>
                                    <% } else { %>
                                        <p class="w3-xlarge">This user is an ordinary user.</p>
                                        <% } %>
                                            <form action="LogoutServlet"><button>Logout</button></form>

                            </div>
                        </div>
                    </div>

                    <% } catch (Exception e){ e.printStackTrace(); } %>
                </div>
            </div>
        </div>
    </div>
</body>

</html>