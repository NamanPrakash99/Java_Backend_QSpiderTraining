<%@ page language="java" contentType="text/html; charset=UTF-8" %>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>

        <html>

        <head>
            <title>Admin Dashboard</title>
            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
            <style>
                body {
                    justify-content: flex-start;
                    padding-top: 4rem;
                }

                .dashboard-container {
                    width: 100%;
                    max-width: 1000px;
                    animation: fadeIn 0.6s ease-out;
                }

                .header-section {
                    display: flex;
                    justify-content: space-between;
                    align-items: center;
                    margin-bottom: 2rem;
                }

                .logout-link {
                    color: var(--danger);
                    font-weight: 600;
                }
            </style>
        </head>

        <body>

            <div class="dashboard-container">
                <div class="header-section">
                    <h2>Employee Management</h2>
                    <a href="logout" class="logout-link">Sign Out</a>
                </div>

                <table class="styled-table">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Salary</th>
                            <th>Role</th>
                            <th>Email</th>
                            <th>Password</th>
                            <th>Action</th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach var="emp" items="${employees}">
                            <tr>
                                <td><strong>${emp.name}</strong></td>
                                <td>${emp.salary}</td>
                                <td>${emp.role}</td>
                                <td>${emp.email}</td>
                                <td><code>${emp.password}</code></td>
                                <td>
                                    <a class="btn-small btn-update" href="update?email=${emp.email}">Update</a>
                                    <a class="btn-small btn-delete" href="delete?email=${emp.email}"
                                        onclick="return confirm('Are you sure?');">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

        </body>

        </html>