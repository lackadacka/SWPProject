<#macro menu signed_in title>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="UTF-8">
        <title>${title}</title>
        <link rel="stylesheet" type="text/css" href="/static/css/style.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">


    </head>
    <body>
    <div class="header">
        <a class="lg" href="/"><h2 class="logo">Rental System</h2></a>
        <input type="checkbox" id="chk">
        <label for="chk" class="show-menu-bar">
            <i class="fas fa-bars"></i>
        </label>
        <#if signed_in>
            <#assign
                profile_ref = "/login"
                profile = "My Profile"
                sign_ref = "/login"
                sign = "Sign Out">
        <#else>
            <#assign
            profile_ref = "/login"
            profile = "Sign In"
            sign_ref = "/signup"
            sign = "Sign Up">

        </#if>
        <ul class="menu">
            <a href="${profile_ref}">${profile}</a>
            <a href="${sign_ref}">${sign}</a>
            <label for="chk" class="hide-menu-bar">
                <i class="fas fa-chevron-circle-down"></i>
            </label>
        </ul>
    </div>

       <#nested >

    </body>
</html>
</#macro>