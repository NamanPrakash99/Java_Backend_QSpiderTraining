<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <title>TaskTrack — Task Manager</title>
            <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
        </head>

        <body>
            <!-- NAVBAR -->
            <nav class="navbar">
                <div>
                    <h1>&#10003; TaskTrack</h1>
                    <p>Team Task Manager</p>
                </div>
                <a href="<c:url value='/tasks/new'/>" class="btn btn-primary">+ Add New Task</a>
            </nav>
            <div class="container">
                <!-- STATS ROW -->
                <div class="stats-row">
                    <div class="stat-card">
                        <div class="number">${totalTasks}</div>
                        <div class="label">Total Tasks</div>
                    </div>
                    <div class="stat-card pending">
                        <div class="number">${pendingTasks}</div>
                        <div class="label">Pending</div>
                    </div>
                    <div class="stat-card complete">
                        <div class="number">${completedTasks}</div>
                        <div class="label">Completed</div>
                    </div>
                </div>
                <!-- TASK TABLE -->
                <div class="task-table-wrapper">
                    <div class="table-header">
                        <h2>All Tasks</h2>
                    </div>
                    <c:choose>
                        <c:when test="${empty taskList}">
                            <div class="empty-state">
                                <div class="icon">&#128203;</div>
                                <p>No tasks yet. Click "+ Add New Task" to get started!</p>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <table>
                                <thead>
                                    <tr>
                                        <th>Image</th>
                                        <th>Title</th>
                                        <th>Description</th>
                                        <th>Due Date</th>
                                        <th>Priority</th>
                                        <th>Status</th>
                                        <th>Actions</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="task" items="${taskList}">
                                        <tr>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${not empty task.imageData}">
                                                        <img class="task-img"
                                                            src="<c:url value='/tasks/image/${task.id}'/>">
                                                    </c:when>
                                                    <c:otherwise>
                                                        <div class="no-img">&#128444;</div>
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td><strong>${task.title}</strong></td>
                                            <td>${task.description}</td>
                                            <td>${task.dueDate}</td>
                                            <td>
                                                <span class="badge <c:choose>
                                <c:when test='${task.priority == " HIGH"}'>badge-high</c:when>
                                                    <c:when test='${task.priority == "MEDIUM"}'>badge-medium</c:when>
                                                    <c:otherwise>badge-low</c:otherwise>
                    </c:choose>">
                    ${task.priority}
                    </span>
                    </td>
                    <td>
                        <span class="badge <c:choose>
                                <c:when test='${task.status == " PENDING"}'>badge-pending</c:when>
                            <c:otherwise>badge-complete</c:otherwise>
                            </c:choose>">
                            ${task.status}
                        </span>
                    </td>
                    <td>
                        <a href="<c:url value='/tasks/toggle/${task.id}'/>" class="btn btn-complete"
                            title="Toggle Status">&#10003;</a>
                        <a href="<c:url value='/tasks/delete/${task.id}'/>" class="btn btn-delete" title="Delete Task"
                            onclick="return confirm('Are you sure?')">&#128465;</a>
                    </td>
                    </tr>
                    </c:forEach>
                    </tbody>
                    </table>
                    </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </body>

        </html>