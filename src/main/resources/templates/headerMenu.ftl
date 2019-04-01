<#macro menu profile sign profile_ref sign_ref title>
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
        <h2 class="logo">Rental System</h2>
        <input type="checkbox" id="chk">
        <label for="chk" class="show-menu-bar">
            <i class="fas fa-bars"></i>
        </label>

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