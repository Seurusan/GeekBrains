<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title> Products </title>
    </head>

    <body>
        <h1> Products </h1>
        <ul>
            <c:forEach items="${products}" var="product">
                <li>
                    <p>ID <c:out value="${product.id}"/></p>
                    <p>NAME <c:out value="${product.name}"/></p>
                    <p>PRICE <c:out value="${product.price}"/></p>
                </li>
            </c:forEach>
        </ul>
    </body>
</html>
