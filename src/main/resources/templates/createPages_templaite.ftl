<#macro form title>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <link href='/static/css/forms_style.css' rel='stylesheet'>
</head>

<body>
    <div class="form-area">
    <@content/>
    </div>
</body>
<footer>
    <br>
    <p>forum 2019</p>
</footer>
</html>
</#macro>