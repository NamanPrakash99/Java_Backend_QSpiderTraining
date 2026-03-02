<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
   
    <title>Welcome Page</title>
</head>

<body>
<form action="">
<c:forEach var="name" items="${msg}">
    <h1>${name} Welcome to Spring MVC</h1>
 </c:forEach>
</form>
</body>

</html>