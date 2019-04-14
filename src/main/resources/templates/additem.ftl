<#import "headerMenu.ftl" as menu>
<#import "adinfo.ftl" as ad>

<@menu.menu signed_in=false title="Add new item">
    <@ad.adinfo header="ADD NEW ITEM" action="/additem" name=""
    description="" timeslot="" price="" category=""></@ad.adinfo>
</@menu.menu>
