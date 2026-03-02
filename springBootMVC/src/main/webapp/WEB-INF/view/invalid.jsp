<%@ page language="java" contentType="text/html; charset=UTF-8" %>
    <html>

    <head>
        <title>Invalid Login</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    </head>

    <body>

        <div class="glass-card" style="text-align: center;">
            <h1
                style="background: linear-gradient(to right, #f87171, #ef4444); -webkit-background-clip: text; background-clip: text; -webkit-text-fill-color: transparent;">
                Access Denied</h1>
            <p style="color: var(--text-muted); margin: 1.5rem 0;">Invalid email or password. Please check your
                credentials and try again.</p>

            <div class="auth-footer">
                <a href="login">Go Back to Login</a>
            </div>
        </div>

    </body>

    </html>