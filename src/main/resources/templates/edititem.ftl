<#import "headerMenu.ftl" as menu>
<#import "adinfo.ftl" as ad>

<@menu.menu signed_in="${auth}" title="Edit item">
    <@ad.adinfo header="EDIT ITEM" action="/edititem" name="${itemProfile.getName()?if_exists}"
    description="${itemProfile.getDescription()}" timeslot="${itemProfile.getTimeSlots()?if_exists}"
    price="${itemProfile.getPrice()?if_exists}" category="${itemProfile.getCategory()?if_exists}">
    </@ad.adinfo>
</@menu.menu>
