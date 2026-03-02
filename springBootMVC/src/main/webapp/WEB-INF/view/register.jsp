<%@ page language="java" contentType="text/html; charset=UTF-8" %>

    <html>

    <head>
        <title>Employee Registration</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    </head>

    <body>

        <div class="glass-card">
            <h2>Register Employee</h2>

            <form action="register" method="post">
                <div class="form-group">
                    <label>Name</label>
                    <input type="text" name="name" placeholder="Enter full name" required />
                </div>

                <div class="form-group">
                    <label>Salary</label>
                    <input type="text" name="salary" placeholder="Enter annual salary" required />
                </div>

                <div class="form-group">
                    <label>Role</label>
                    <select name="role">
                        <option value="admin">Admin</option>
                        <option value="user">User</option>
                    </select>
                </div>

                <div class="form-group">
                    <label>Email</label>
                    <input type="email" name="email" placeholder="Enter your email" required />
                </div>

                <div class="form-group">
                    <label>Password</label>
                    <input type="password" name="password" placeholder="Create a password" required />
                </div>

                <input type="submit" value="Register" />
            </form>

            <div class="auth-footer">
                <a href="login">Already Registered? Login Here</a>
            </div>
        </div>

    </body>

    </html>