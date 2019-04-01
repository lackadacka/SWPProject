<#import "headerMenu.ftl" as menu>

<@menu.menu profile="My Profile" profile_ref="/profile" sign="Sign Out" sign_ref="/login" title="My Profile">
    <div class="profile">
        <h1>Name</h1>
        <h2>Email</h2>
        <h2>+79000000000</h2>
        <input class="edit_btn" type="submit" value="Edit">
    </div>
</@menu.menu>