<%@ page language="java" contentType="text/html; charset=UTF-8" %>
    <html>

    <head>
        <title>User Exists</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    </head>

    <body>

        <div class="glass-card" style="text-align: center;">
            <h2>Action Required</h2>
            <p style="color: var(--text-muted); margin: 1.5rem 0;">A user with this email already exists in our system.
            </p>

            <div class="auth-footer">
                <a href="register">Back to Registration</a>
                <br /><br />
                <a href="login">Already have an account? Login</a>
            </div>
        </div>

    </body>

    </html>