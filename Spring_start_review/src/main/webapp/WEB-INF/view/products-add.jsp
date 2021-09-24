<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

    <head>
        <title> Add new product </title>
    </head>

    <body>
        <form:form modelAttribute="product" method="post">
            ID: <form:input path="id"/>
            <br>
            NAME: <form:input path="name"/>
            <br>
            PRICE: <form:input path="price"/>
            <br>
            <input type="submit" value="Save">
        </form:form>
    </body>
</html>
