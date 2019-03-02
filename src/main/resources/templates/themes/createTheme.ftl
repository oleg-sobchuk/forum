<#include "../createPages_templaite.ftl"/>

<#macro content>
    <form name="theme" action="/themes/createTheme" method="post">
        <p>Name</p>
        <input title="Name" type="text" name="name">
        <input type="submit" value="OK">
    </form>
</#macro>

<@form title="Create theme"/>
