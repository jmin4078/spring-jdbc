<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Hello Spring JDBC</title>
</head>
<body>
<h1>Hello Spring JDBC</h1>

<section>
    <form method="post">
        계좌ID: <input name="id" readonly value="${account.id}"><br>
        계좌명: <input name="name" placeholder="계좌명" value="${account.name}"><br>
        생성일시: <input name="createdAt " readonly value="${account.createdAt}">
        <button>수정</button>
    </form>
</section>
</body>
</html>