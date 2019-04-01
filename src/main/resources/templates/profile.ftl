<#import "headerMenu.ftl" as menu>

<@menu.menu profile="My Profile" profile_ref="/profile" sign="Sign Out" sign_ref="/login" title="My Profile">
    <h1>Result</h1>
    <td>${loginData.login}</td>
    <td>${loginData.password}</td>
</@menu.menu>