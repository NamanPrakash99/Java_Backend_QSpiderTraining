<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f6f9;
        }

        header {
            background-color: #2c3e50;
            color: white;
            padding: 15px;
            text-align: center;
        }

        nav {
            background-color: #34495e;
            padding: 10px;
            text-align: center;
        }

        nav a {
            color: white;
            text-decoration: none;
            margin: 0 15px;
        }

        nav a:hover {
            text-decoration: underline;
        }

        .container {
            padding: 30px;
            text-align: center;
        }

        footer {
            background-color: #2c3e50;
            color: white;
            padding: 10px;
            text-align: center;
            position: fixed;
            width: 100%;
            bottom: 0;
        }
    </style>
</head>
<body>

<header>
    <h2>My Spring Boot Application</h2>
</header>

<nav>
    <a href="/">Home</a>
    <a href="#">About</a>
    <a href="#">Contact</a>
</nav>

<div class="container" >
    <h1>Welcome 👋</h1>
    <p>This is a simple Spring Boot JSP home page.</p>
    <p>Application is running successfully.</p>
</div>

<footer>
    © 2026 My Application | Built with Spring Boot
</footer>

</body>
</html> 