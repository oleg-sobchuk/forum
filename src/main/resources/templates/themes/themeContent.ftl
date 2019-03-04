<#include "../main_templaite.ftl"/>

<#macro content>
 <h1>${theme.name}</h1>

<a href="/themes/${theme.id}/createTopic">create topic</a>
  <#if topics?has_content>
    <table>
        <tr>
            <td>Topic name</a></td>
            <td>Description</td>
            <td>Created by</td>
            <td>Created at</td>
        </tr>
        <#list topics as topic>
            <tr>
            <td><a href="/themes/${theme.id}/${topic.id}" >${topic.name}</a></td>
            <td>${topic.desc}</td>
            <td>${topic.createdBy}</td>
            <td>${topic.dateAdd?string("dd-MM-yyyy HH:mm:ss")}</td>
            <td><a href="/themes/${theme.id}/${topic.id}/deleteTopic">delete</a></td>
            </tr>
        </#list>
    </table>
    <#else>
        <p>There is no topic fo now...</p>
    </#if>
</#macro>

<@main title="forum theme"/>