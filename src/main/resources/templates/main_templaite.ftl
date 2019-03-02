<#macro main title>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
</head>
<nav>
    <a href="/login">login</a>
    <a href="/logout">logout</a>
    <a href="/createUser">register</a>
</nav>

<body>
    <@content/>
</body>
<footer>
    <br>
    <p>forum 2019</p>
</footer>
</html>
</#macro>