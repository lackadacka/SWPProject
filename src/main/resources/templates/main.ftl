<#import "headerMenu.ftl" as menu>
<#import "item.ftl" as i>
<@menu.menu signed_in="${auth}" title="Main Page">
    <div class="list">
    <form action="/main" method="post">
        <#list items as item>
            <a class="items" href="/ad?id=${item.id}">
                <@i.item image="${item.getFile()?if_exists}"
                name="${item.getName()}"
                description="${item.getDescription()}"
                category="${item.getCategory()}"/>
            </a>
        </#list>
    </form>
    </div>
</@menu.menu>