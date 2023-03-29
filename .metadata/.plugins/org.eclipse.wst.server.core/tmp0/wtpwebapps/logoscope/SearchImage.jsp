<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
Integer isAdmin = (Integer) request.getSession().getAttribute("isAdmin");
if (user_id == null) {
	response.getWriter().print("You have no access to this page. Go back to login page.");
    response.sendRedirect("login.jsp");
}

try {
%>
<!DOCTYPE html>
<html>

<head>
    <style>
        body {
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            font-family: 'Jost', sans-serif;
            background: linear-gradient(to bottom, #0f0c29, #302b63, #24243e);
            text-align: center;
        }

        .main {
            width: 350px;
            height: 500px;
            background: red;
            overflow: hidden;
            background: url("https://doc-08-2c-docs.googleusercontent.com/docs/securesc/68c90smiglihng9534mvqmq1946dmis5/fo0picsp1nhiucmc0l25s29respgpr4j/1631524275000/03522360960922298374/03522360960922298374/1Sx0jhdpEpnNIydS4rnN4kHSJtU1EyWka?e=view&authuser=0&nonce=gcrocepgbb17m&user=03522360960922298374&hash=tfhgbs86ka6divo3llbvp93mg4csvb38") no-repeat center/ cover;
            border-radius: 10px;
            box-shadow: 5px 20px 50px #000;
        }

        #chk {
            display: none;
        }

        .signup {
            position: relative;
            width: 100%;
            height: 100%;
        }

        label {
            color: #fff;
            font-size: 2.3em;
            justify-content: center;
            display: flex;
            margin: 60px;
            font-weight: bold;
            cursor: pointer;
            transition: .5s ease-in-out;
        }

        input {
            width: 60%;
            height: 20px;
            background: #e0dede;
            justify-content: center;
            display: flex;
            margin: 20px auto;
            padding: 10px;
            border: none;
            outline: none;
            border-radius: 5px;
        }

        button {
            width: 60%;
            height: 40px;
            margin: 10px auto;
            justify-content: center;
            display: block;
            color: #fff;
            background: #573b8a;
            font-size: 1em;
            font-weight: bold;
            margin-top: 20px;
            outline: none;
            border: none;
            border-radius: 15px;
            transition: .3s ease-in;
            cursor: pointer;
        }

        button:hover {
            background: #6d44b8;
        }
    </style>
    <title>Searcher</title>
    <link rel="stylesheet" type="text/css" href="slide navbar style.css">
    <link href="https://fonts.googleapis.com/css2?family=Jost:wght@500&display=swap" rel="stylesheet">
</head>

<body>
<% // TODO: make partially text search (basically give user the ability to search for all the images with the input text, even when the text is partially matched to the image's title) %>
    <div class="main">
        <form action="SearchImageResultServlet">
            <label for="chk" aria-hidden="true">Search an image by title </label>
            <input type="text" name="title" id="title" placeholder="Title" required><br> <button>Submit</button>
        </form>

        <% } catch (Exception e){ e.printStackTrace(); } %>
    </div>
</body>

</html>