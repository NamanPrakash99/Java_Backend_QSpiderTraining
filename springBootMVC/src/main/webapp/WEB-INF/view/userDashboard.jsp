<%@ page language="java" contentType="text/html; charset=UTF-8" %>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>

        <html>

        <head>
            <title>User Dashboard</title>
            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
            <style>
                .dashboard-card {
                    width: 100%;
                    max-width: 600px;
                }

                .details-table td:first-child {
                    color: var(--text-muted);
                    font-weight: 600;
                    width: 40%;
                }

                .logout-btn {
                    margin-top: 2rem;
                    display: block;
                    text-align: center;
                    color: var(--danger);
                    font-weight: 600;
                }
            </style>
        </head>

        <body>

            <div class="glass-card dashboard-card">
                <h2>Welcome, ${employee.name}</h2>

                <table class="styled-table details-table">
                    <thead>
                        <tr>
                            <th colspan="2">Employment Details</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Email Address</td>
                            <td>${employee.email}</td>
                        </tr>
                        <tr>
                            <td>Current Role</td>
                            <td><span style="text-transform: capitalize;">${employee.role}</span></td>
                        </tr>
                        <tr>
                            <td>Annual Salary</td>
                            <td>${employee.salary}</td>
                        </tr>
                    </tbody>
                </table>

                <a href="login" class="logout-btn">Sign Out</a>
            </div>

        </body>

        </html>