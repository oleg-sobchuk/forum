<#include "../main_templaite.ftl"/>

<#macro content>
 <h1>${topic.name}</h1>
 <p>${topic.desc}</p>
    <#if comments?has_content>

        <#list comments as comment>
            <fieldset>
                <legend align="left">${comment.createdBy} : ${comment.dateUpdate?string("dd-MM-yyyy HH:mm:ss")}</legend>
                <div >${comment.text}</div>
            </fieldset>
        </#list>

    <#else>
        <p>Your coment will be first...</p>
    </#if>
    <form id="comment_form" name="comment" action="/themes/${theme.id}/${topic.id}/createComment" method="post">
        <textarea title="Add comment" form="comment_form" name="text" cols="50" rows="10"></textarea>
        <input type="submit" value="add comment">
    </form>

</#macro>

<@main title="forum topic"/>