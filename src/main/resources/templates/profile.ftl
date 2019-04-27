<#import "headerMenu.ftl" as menu>
<#import "item.ftl" as i>

<@menu.menu signed_in="${auth}" title="My Profile">
    <div class="profile">
        <h1 class="name">${userProfile.lastName} ${userProfile.firstName}</h1>
        <h2 class="info">${userProfile.email}</h2>
        <h2 class="info">${userProfile.phoneNumber}</h2>
        <#--<a class="b2" href="/edit_user">EDIT INFORMATION</a>-->
        <a class="b2" href="/additem">ADD NEW ITEM</a>
    </div>
    <div class="list">
        <form action="/profile" method="post">
            <#list items as item>
                <a class="items" href="/ad?id=${item.id}">
                    <@i.item image="${item.getFile()?if_exists}"
                    name="${item.getName()}"
                    description="${item.getDescription()}"
                    category="${item.getCategory()}"
                    price="${item.getPrice()}"
                    timeslot="${item.getTimeSlots()}"/>
                </a>
            </#list>
        </form>
    </div>
</@menu.menu>