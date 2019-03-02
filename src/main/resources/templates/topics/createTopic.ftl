<#include "../createPages_templaite.ftl"/>

<#macro content>
    <form name="topic" action="/themes/${theme.id}/createTopic" method="post">
        <p>Name</p>
        <input title="Name" type="text" name="name">
        <br>
        <p>Description</p>
        <input class="desc" title="Desc" type="text" name="desc">
        <input type="submit" value="OK">
    </form>
</#macro>

<@form title="Create topic"/>
