<#include "main_templaite.ftl"/>

<#macro content>
<p>Welcome to forum, ${user}</p>
<a href="/themes/createTheme">create theme</a>
<table>
    <#list themes as theme>
        <tr>
            <td><a href="/themes/${theme.id}">${theme.name}</a></td>
            <td>${theme.createdBy}</td>
            <td>${theme.dateAdd?string("dd-MM-yyyy HH:mm:ss")}</td>
            <td>${theme.dateUpdate?string("dd-MM-yyyy HH:mm:ss")}</td>
            <td><a href="/themes/${theme.id}/deleteTheme">delete</a></td>
        </tr>
    </#list>
</table>
</#macro>

<@main title="Forum"/>