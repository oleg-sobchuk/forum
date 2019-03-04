<#ftl output_format="HTML"/>
<#include "../createPages_templaite.ftl"/>
<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]/>

<#macro content>

    <@sf.form action="/themes/createTheme" method="post" modelAttribute="theme">
        <table>
            <tbody>
            <tr>
                <td><@sf.label path="name">Theme name</@sf.label></td>
                <td><@sf.input path="name"/></td>
                <td><@sf.errors path="name"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Create theme"></td>
            </tr>
            </tbody>
        </table>
    </@sf.form>

</#macro>


<@form title="Create theme"/>
