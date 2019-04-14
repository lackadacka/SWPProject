<#macro adinfo header action name description timeslot price category>
<div class="container">
    <h1>${header}</h1>
    <form action=${action} method="post">
        <#nested>
        <div class="tbox">
            <input type="text" placeholder="@Name" value="${name?if_exists}" name="name">
        </div>
        <div class="tbox">
            <input type="text" placeholder="@description" value="${description?if_exists}" name="description">
        </div>
        <select class="sel" size="1" name="timeSlots" value=${timeslot?if_exists}>
            <option class="opt" selected disabled hidden>Choose timing</option>
            <option class="opt" value="Per hour">Per Hour</option>
            <option class="opt" value="Per day">Per Day</option>
            <option class="opt" value="Per week">Per Week</option>
            <option class="opt" value="Per month">Per Month</option>
            <option class="opt" value="Per year">Per Year</option>
        </select>
        <div class="tbox">
            <input type="number" placeholder="@Price $" value="${price?if_exists}" name="price">
        </div>
        <select class="sel" size="1" name = "category" value="${category?if_exists}">
            <option class = "opt" selected disabled>Choose category</option>
            <option class = "opt" value="Study">Study</option>
            <option class = "opt" value="Sport">Sport</option>
            <option class = "opt" value="Home">Home</option>
        </select>
        <#--                <input type="text" placeholder="@Category" value="" name="category">-->


        <input class="btn" type="submit" placeholder="" value="Add new item" name="submit">
    </form>
</div>
</#macro>