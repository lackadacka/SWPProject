<#macro item image name description category>
<div class="item">
    <#if image!="">
        <img src="/img/${image?if_exists}" class="image">
    </#if>
    <div class="text">
        <h2>${name}</h2>
        <h1>${description}</h1>
        <h4>${category}</h4>
    </div>

</div>
</#macro>