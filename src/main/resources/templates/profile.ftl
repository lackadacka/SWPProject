<#import "headerMenu.ftl" as menu>

<@menu.menu signed_in=true title="My Profile">
    <div class="profile">
        <h1>${userProfile.lastName} ${userProfile.firstName}</h1>
        <h2>${userProfile.email}</h2>
        <h2>${userProfile.phoneNumber}</h2>
        <input class="btn" placeholder="" type="submit" value="EDIT INFORMATION">
        <a class="b2" href="/additem">ADD NEW ITEM</a>
    </div>
</@menu.menu>