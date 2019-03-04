<#macro main title>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <style>
        body{background: font-family: sans-serif;}
        h1{font-style: italic; color: #000080; }
        button, input[type=submit]{ background: #2b92f9; border: 1px solid #bbb;
            border-radius: 6px; transition-duration: 0.3s; cursor: pointer;
            width: 100px; height: 30px; margin: 10px;position: relative; left: 40px;}
        td:hover, input[type=submit]:hover{background: #bbbbbb;}
        a{padding: 10px}
        a:link {text-decoration: none;}
        a:visited {text-decoration: none;}
        a:hover {text-decoration: underline;}
        a:active {text-decoration: underline;}

    </style>
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