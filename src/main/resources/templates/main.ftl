<#import "headerMenu.ftl" as menu>
<#import "item.ftl" as i>
<#assign
    sign = false>
<@menu.menu signed_in=sign title="Main Page">
    <form action="/main" method="post">
        <#list items as item>
            <a href="/ad">
                <@i.item(name=${item.name} /
                description=${item.description} /
                category=${item.category})/>
            </a>
        </#list>
    </form>
</@menu.menu>