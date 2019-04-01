<#import "headerMenu.ftl" as menu>

<@menu.menu profile="My Profile" profile_ref="/profile" sign="Sign Out" sign_ref="/login" title="My Profile">
    <div class="profile">
        <h1>Profile information:</h1>
        <h2>${}</h2>
        <h2>Email</h2>
        <h2>+79000000000</h2>
        <a class="b2" href="/edit_user">EDIT INFORMATION</a>
    </div>
</@menu.menu>