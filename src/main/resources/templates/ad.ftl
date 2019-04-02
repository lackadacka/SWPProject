<#import "headerMenu.ftl" as menu>


<@menu.menu signed_in=false title="Advertising">
    <div class="ad">
        <h1>${itemProfile.name}</h1>
        <h3>${itemProfile.category}</h3>
        <h2>${itemProfile.description}</h2>
        <div class="timeslots">
            <h1>Possible Timeslots:</h1>
            <h2>${itemProfile.timeSlots}</h2>
        </div>
        <div class="contacts">
            <h1>Contacts:</h1>
            <h2>${userProfile.lastName} ${userProfile.firstName}</h2>
            <h2>${userProfile.phoneNumber}</h2>
            <h2>${userProfile.email}</h2>
        </div>
        <a class="b1" href="/edit_user">EDIT INFORMATION</a>
        <a class="b2" href="/additem">ADD NEW ITEM</a>
    </div>
</@menu.menu>
