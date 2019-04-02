<#import "headerMenu.ftl" as menu>

<@menu.menu signed_in=true title="My Profile">
    <div class="profile">
        <h1>${userProfile.lastName} ${userProfile.firstName}</h1>
        <h2>${userProfile.email}</h2>
        <h2>${userProfile.phoneNumber}</h2>
        <a class="b2" href="/edit_user">EDIT INFORMATION</a>
        <a class="b2" href="/additem">ADD NEW ITEM</a>
    </div>
</@menu.menu>