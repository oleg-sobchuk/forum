<#ftl output_format="HTML"/>
<#include "./createPages_templaite.ftl"/>
<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]/>

<#macro content>
    <nav>
        <a href="/login">login</a>
    </nav>

    <@sf.form action="/createUser" method="post" modelAttribute="user">
        <table>
            <tbody>
            <tr>
                <td><@sf.label path="name">Name</@sf.label></td>
                <td><@sf.input path="name"/></td>
                <td><@sf.errors path="name"/></td>
            </tr>
            <tr>
                <td><@sf.label path="email">Email</@sf.label></td>
                <td><@sf.input path="email"/></td>
                <td><@sf.errors path="email"/></td>
            </tr>
            <tr>
                <td><@sf.label path="password">Password</@sf.label></td>
                <td><@sf.input type="password" path="password"/></td>
                <td><@sf.errors path="password"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Create user"></td>
            </tr>
            </tbody>
        </table>
    </@sf.form>

    <a href="/">continue as anonimous</a>

</#macro>


<#--


<#include "./createPages_templaite.ftl"/>

<#macro content>
 <h1>For registration fill form</h1>


    <form name="user" action="/createUser" method="post">
        <p>Name</p>
        <input title="Name" type="text" name="name">
        <p>Email</p>
        <input title="Email" type="text" name="email">
        <p>Password</p>
        <input title="Password" type="text" name="password">
        <input type="submit" value="OK">
    </form>
    <br>
    <a href="/">continue as anonymous</a>
</#macro>-->

<@form title="Registration"/>

