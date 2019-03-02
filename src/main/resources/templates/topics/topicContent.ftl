<#include "../main_templaite.ftl"/>

<#macro content>
 <h1>${topic.name}</h1>
 <p>${topic.desc}</p>
    <#if comments?has_content>
    <table>
        <#list comments as comment>
            <tr>
                <td>${comment.text}</td>
                <td>${comment.createdBy}</td>
                <td>${comment.topic.name}</td>
                <td>${comment.dateAdd?string("dd-MM-yyyy HH:mm:ss")}</td>
                <td>${comment.dateUpdate?string("dd-MM-yyyy HH:mm:ss")}</td>
            </tr>
        </#list>
    </table>
    <#else>
        <p>Your coment will be first...</p>
    </#if>
    <form name="comment" action="/themes/${theme.id}/${topic.id}/createComment" method="post">
        <p>New comment</p>
        <input title="Text" type="text" name="text">
        <input type="submit" value="OK">
    </form>

</#macro>

<@main title="forum topic"/>