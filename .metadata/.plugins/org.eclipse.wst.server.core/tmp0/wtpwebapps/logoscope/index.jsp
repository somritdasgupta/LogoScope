<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="DatabaseServlets.*" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=yes">
        <link
            href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap"
            rel="stylesheet">
        <title>HOME</title>
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

                        <!-- Welcome -->
                        <header class="w3-container w3-center" style="padding: 128px 16px">
                            <h1 class="w3-margin w3-jumbo">Welcome to Logoscope!</h1>
                            <p class="w3-xlarge">For all your sticker browsing and logo needs.</p>
                        </header>

                        <!-- About Our Service -->
                        <div class="w3-row-padding w3-padding-24 w3-container">
                            <div class="w3-content">
                                <div class="w3-onefourth">
                                    <h1>About our Service</h1>
                                    <p>We provide an easy, secure and
                                        user-friendly way to download logos and stickers online. Go ahead! Try to make
                                        an account and browse to your heart's
                                        content. Feel free to check some of the
                                        exceptional categories images we have here. -- Account login required 😁</p>
                                </div>
                            </div>
                        </div>
                        <!-- ***** Popular Logo Start ***** -->
                        <div class="live-stream">
                            <div class="col-lg-12">
                                <div class="heading-section">
                                    <h4><em>Most Popular</em> Logos</h4>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-3 col-sm-6">
                                    <div class="item">
                                        <div class="thumb">
                                            <a href="GrabImageServlet?id=99">
                                                <img src="assets/images/id 99.png" alt=""><br>
                                            </a>
                                            <p class="w3-center w3-large">Black And White 8</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-3 col-sm-6">
                                    <div class="item">
                                        <div class="thumb">
                                            <a href="GrabImageServlet?id=34">
                                                <img src="assets/images/id 34.png" alt=""><br>
                                            </a>
                                            <p class="w3-center w3-large">L</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-3 col-sm-6">
                                    <div class="item">
                                        <div class="thumb">
                                            <a href="GrabImageServlet?id=118">
                                                <img src="assets/images/id 118.png" alt=""><br>
                                            </a>
                                            <p class="w3-center w3-large">Fancy 36</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-3 col-sm-6">
                                    <div class="item">
                                        <div class="thumb">
                                            <a href="GrabImageServlet?id=85">
                                                <img src="assets/images/id 85.png" alt=""><br>
                                            </a>
                                            <p class="w3-center w3-large">Minimal 5</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- ***** Popular Logo End ***** -->
        </div>


        <!-- Footer -->
        <footer class="w3-container w3-padding-24 w3-center w3-opacity">
            <div class="w3-large w3-padding-28">
            <p>
                Created for Dynamic Web Application Project in TIB by team Aquamarine!
                <br> Want our code? Sorry you can't have it! 😜
            </p>
            </div>
        </footer>

    </body>

    </html>