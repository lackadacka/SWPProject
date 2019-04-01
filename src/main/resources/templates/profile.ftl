<#import "headerMenu.ftl" as menu>

<@menu.menu signed_in=true title="My Profile">
    <div class="profile">
        <h1>${userProfile.get().lastName} ${userProfile.get().firstName}</h1>
        <h2>${userProfile.get().email}</h2>
        <h2>${userProfile.get().phoneNumber}</h2>
        <a class="b2" href="/edit_user">EDIT INFORMATION</a>
    </div>
</@menu.menu>