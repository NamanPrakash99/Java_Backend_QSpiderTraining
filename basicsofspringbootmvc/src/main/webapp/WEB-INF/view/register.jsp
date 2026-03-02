<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <h1>Registration Page</h1>
    <form action="/create-account" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name">
        <br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email">
        <br>
        <label for="Contact">Contact:</label>
        <input type="number" id="contact" name="contact">
        <br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password">
        <input type="submit" value="Register">
    </form>
    <br>
        <button href="login.jsp">Login Page</button>
</body>

</html>