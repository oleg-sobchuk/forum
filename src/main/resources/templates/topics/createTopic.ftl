<#ftl output_format="HTML"/>
<#include "../createPages_templaite.ftl"/>
<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]/>

<#macro content>

    <@sf.form action="/themes/${theme.id}/createTopic" method="post" modelAttribute="topic">
        <table>
            <tbody>
            <tr>
                <td><@sf.label path="name">Topic name</@sf.label></td>
                <td><@sf.input path="name"/></td>
                <td><@sf.errors path="name"/></td>
            </tr>
            <tr>
                <td><@sf.label path="desc">Description</@sf.label></td>
                <td><@sf.input path="desc"/></td>
                <td><@sf.errors path="desc"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Create topic"></td>
            </tr>
            </tbody>
        </table>
    </@sf.form>

</#macro>

<@form title="Create topic"/>
