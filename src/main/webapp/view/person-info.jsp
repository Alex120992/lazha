<%@ taglib prefix="form" uri="http://jakarta.apache.org/taglibs/standard/permittedTaglibs" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html >
<html lang="ru">
<head>
    <meta charset="utf-8">
    <title>Info</title>
</head>
<body>
<h2> Информация о работнике</h2>

<br>

<form action="save_update" method="get">
    <input type="hidden" value="${person.id}" name="id"/>

    <input name="name" value="${person.name}" placeholder="Введите имя"/><br>

    <input name="surname" value="${person.surname}" placeholder="Фамилия"/><br>

    <input name="age" value="${person.age}" type="number" placeholder="Возраст"/><br>

    <input name="mail" value="${person.mail}" placeholder="мейл"/>

    <br><br>
    <input type="submit" value="Сохранить"/>
</form>

</body>
</html>