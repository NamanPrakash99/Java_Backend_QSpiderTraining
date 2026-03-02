<%@ page language="java" contentType="text/html; charset=UTF-8" %>
    <html>

    <head>
        <title>Update Employee</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    </head>

    <body>

        <div class="glass-card">
            <h2>Update Employee</h2>

            <form action="update" method="post">
                <div class="form-group">
                    <label>Name</label>
                    <input type="text" name="name" value="${employee.name}" required />
                </div>

                <div class="form-group">
                    <label>Salary</label>
                    <input type="text" name="salary" value="${employee.salary}" required />
                </div>

                <div class="form-group">
                    <label>Role</label>
                    <select name="role">
                        <option value="ADMIN" ${employee.role=='ADMIN' ? 'selected' : '' }>ADMIN</option>
                        <option value="USER" ${employee.role=='USER' ? 'selected' : '' }>USER</option>
                    </select>
                </div>

                <div class="form-group">
                    <label>Email (Read Only)</label>
                    <input type="text" name="email" value="${employee.email}" readonly
                        style="opacity: 0.7; cursor: not-allowed;" />
                </div>

                <div class="form-group">
                    <label>Password</label>
                    <input type="text" name="password" value="${employee.password}" required />
                </div>

                <input type="submit" value="Update Employee" />
            </form>

            <div class="auth-footer">
                <a href="adminDashboard">Back to Dashboard</a>
            </div>
        </div>

    </body>

    </html>