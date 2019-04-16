<#import "headerMenu.ftl" as menu>
<#import "adinfo.ftl" as ad>

<@menu.menu signed_in="${auth}" title="Edit item">
    <@ad.adinfo header="EDIT ITEM" action="/edititem" name="${itemProfileData.getName()?if_exists}"
    description="${itemProfileData.getDescription()}" timeslot="${itemProfileData.getTimeSlots()?if_exists}"
    price="${itemProfileData.getPrice()?if_exists}" category="${itemProfileData.getCategory()?if_exists}">
    </@ad.adinfo>
</@menu.menu>
