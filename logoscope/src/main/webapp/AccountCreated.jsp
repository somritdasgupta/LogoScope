<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="DatabaseServlets.*" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=yes">
        <link
            href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap"
            rel="stylesheet">
        <title>Registered Successfully</title>
        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Additional CSS Files -->
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="assets/css/fontawesome.css">
        <link rel="stylesheet" href="assets/css/logoscope-master.css">
        <link rel="stylesheet" href="assets/css/owl.css">
        <link rel="stylesheet" href="assets/css/animate.css">
        <link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css" />

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

                        <!-- Welcome -->
                        <header class="w3-container w3-center" style="padding: 128px 16px">
                            <h1 class="w3-margin w3-jumbo">Welcome!</h1>
                            <p class="w3-xlarge">
                                Account successfully created under the username: <b>
                                    <%= request.getParameter("uname") %>
                                </b>!<br>
                                The account's email adress is: <b>
                                    <%= request.getParameter("mail") %>
                                </b>.<br>
                                You can now log in using your username and password.
                            </p>
                        </header>
                    </div>
                </div>
            </div>
        </div>

    </body>

    </html>