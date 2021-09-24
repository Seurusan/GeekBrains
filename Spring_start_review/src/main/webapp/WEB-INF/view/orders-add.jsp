<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
    <head>
        <title> Add new product </title>
    </head>

    <body>
        <form:form modelAttribute="order" method="post">
            ID: <form:input path="id"/>
            <br>
            DATE: <form:input path="date"/>
            <br>
            COST: <form:input path="cost"/>
            <br>
            <input type="submit" value="Save">
        </form:form>
    </body>
</html>