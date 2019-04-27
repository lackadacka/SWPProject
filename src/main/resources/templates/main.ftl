<#import "headerMenu.ftl" as menu>
<#import "item.ftl" as i>
<#import "search.ftl" as search>

<@menu.menu signed_in="${auth}" title="Main Page">
    <@search.search category="${searchData.getCategory()?if_exists}"
    check="${searchData.getSort()?if_exists}"
    search="${searchData.getText()?if_exists}"
    timeslot="${searchData.getTimeSlots()?if_exists}"></@search.search>
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
                category="${item.getCategory()}"
                price="${item.getPrice()}"
                timeslot="${item.getTimeSlots()}"/>
            </a>
        </#list>
    </form>
    </div>
</@menu.menu>