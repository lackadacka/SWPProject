<#import "headerMenu.ftl" as menu>
<#import "item.ftl" as i>
<#import "search.ftl" as search>

<@menu.menu signed_in="${auth}" title="Main Page">
    <@search.search></@search.search>
    <#if auth="true">
        <a class="b3" href="/additem">+ Add new item</a>
    </#if>
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