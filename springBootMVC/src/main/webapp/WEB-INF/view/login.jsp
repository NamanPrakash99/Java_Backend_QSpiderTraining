<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<html>
<head>
    <title>Employee Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>

<div class="glass-card">
    <h2>Login</h2>

    <form action="login" method="post">
        <div class="form-group">
            <label>Email</label>
            <input type="email" name="email" placeholder="Enter your email" required/>
        </div>

        <div class="form-group">
            <label>Password</label>
            <input type="password" name="password" placeholder="Enter your password" required/>
        </div>

        <input type="submit" value="Login"/>
    </form>

    <div class="auth-footer">
        <a href="register">New User? Register Here</a>
    </div>
</div>

</body>
</html>