<#include "./createPages_templaite.ftl"/>

<#macro content>
    <h3>Login with Username and Password</h3>
    <#if error??>
        <p>${error}</p>
    </#if>
    <form name="form_login" action="/login" method="POST">
        <table>
            <tbody>
                <tr>
                    <td>User:</td>
                    <td><input type="text" name="name" value=""></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Login"></td>
                </tr>
            </tbody>
        </table>
    </form>
    <a href="/createUser">registretion</a>
    <br>
    <a href="/">continue as anonimous</a>
</#macro>

<@form title="Login"/>

