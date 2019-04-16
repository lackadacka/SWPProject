<#import "headerMenu.ftl" as menu>
<#import "item.ftl" as i>
<@menu.menu signed_in="${auth}" title="Main Page">
    <div class="main">
    <form action="/main" method="post">
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