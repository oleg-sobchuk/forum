<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>forum</title>
</head>
<body>
<p>Hello! soberis!</p>
<table>
    <#list users as user>
        <tr>
            <td>${user.id}</td>
            <td>${user.password}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.dateAdd?string("dd-MM-yyyy HH:mm:ss")}</td>
            <td>${user.dateUpdate?string("dd-MM-yyyy HH:mm:ss")}</td>
        </tr>
    </#list>
    <#list comments as comment>
        <tr>
            <td>${comment.text}</td>
            <td>${comment.owner}</td>
            <td>${comment.dateAdd?string("dd-MM-yyyy HH:mm:ss")}</td>
            <td>${comment.dateUpdate?string("dd-MM-yyyy HH:mm:ss")}</td>
        </tr>
    </#list>

</table>
</body>
</html>