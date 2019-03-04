<#macro form title>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${title}</title>

    <#--<link href='/static/css/forms_style.css' rel='stylesheet'>-->

    <style>
        body{background: font-family: sans-serif; margin: 0;padding: 0;text-align: center;}
        h1{font-style: italic; color: #000080; }
        button, input[type=submit]{ background: #2b92f9; border: 1px solid #bbb;
            border-radius: 6px; transition-duration: 0.3s; cursor: pointer;
            width: 100px; height: 30px; margin: 10px;position: relative; left: 40px;}
        button:hover, input[type=submit]:hover{background: #f9f3fe;}
        input[type=text]{border: 2px solid #ddd}
        input[type=text]:hover{border: 2px solid #bbb;}
        input[type=text]:focus{border: 2px solid #999;}
        div.form-area{width: 500px; margin: 0 auto; text-align: left;}
        p.p_footer{font-size: 70%; font-style: solid; position: relative; left: 60px;}
        a{padding: 10px}
        a:link {text-decoration: none;}
        a:visited {text-decoration: none;}
        a:hover {text-decoration: underline;}
        a:active {text-decoration: underline;}

    </style>

</head>

<body>
    <div class="form-area">
        <@content/>
        <p class="p_footer">forum 2019</p>
    </div>
</body>
</html>
</#macro>