<#macro menu profile sign profile_ref sign_ref>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="UTF-8">
        <title></title>
        <link rel="stylesheet" href="styles/menuStyle.css">
        <meta name="viewport" content="width-device-width, initial-scale=1">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
    </head>
    <body>
           <div class="header">
               <h2 class="logo">Rental System</h2>
               <input type="checkbox" id="chk">
               <label for="chk" class="show-menu-bar">
                   <i class="fas fa-bars"></i>
               </label>

               <ul class="menu">
                   <a href="{$profile_ref}">{$profile}</a>
                   <a href="{$sign_ref}">{$sign}</a>
                   <label for="chk" class="hide-menu-bar">
                       <i class="fas fa-chevron-circle-down"></i>
                   </label>
               </ul>
           </div>

    <div class="content">
        <#nested >
    </div>

    </body>
</html>
</#macro>