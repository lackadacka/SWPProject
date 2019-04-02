<#import "headerMenu.ftl" as menu>


<@menu.menu signed_in=false title="Advertising">
    <div class="ad">
        <h1>${itemProfile.name}</h1>
        <h2>${itemProfile.description}</h2>
        <h2>${itemProfile.category}</h2>
        <h2>${userProfile.phoneNumber}</h2>
        <h2>${itemProfile.timeSlots}</h2>
        <a class="b1" href="/edit_user">EDIT INFORMATION</a>
        <a class="b2" href="/additem">ADD NEW ITEM</a>
    </div>
</@menu.menu>
