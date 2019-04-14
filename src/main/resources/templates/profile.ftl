<#import "headerMenu.ftl" as menu>
<#import "item.ftl" as i>

<@menu.menu signed_in=true title="My Profile">
    <div class="profile">
        <h1>${userProfile.lastName} ${userProfile.firstName}</h1>
        <h2>${userProfile.email}</h2>
        <h2>${userProfile.phoneNumber}</h2>
        <a class="b4" href="/edit_user">EDIT INFORMATION</a>
        <a class="b2" href="/additem">ADD NEW ITEM</a>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <form action="/profile" method="post">
            <#list items as item>
                <#assign
                id = item.id
                name = item.name
                description = item.description
                category = item.category
                >
                <a class="items" href="/ad?id=${item.id}">
                    <@i.item name=name
                    description=description
                    category=category/>
                </a>
            </#list>
        </form>
    </div>
</@menu.menu>