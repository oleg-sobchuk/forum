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
</#macro>

<@form title="Registration"/>

