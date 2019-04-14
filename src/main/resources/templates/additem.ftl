<#import "headerMenu.ftl" as menu>

<@menu.menu signed_in=false title="Add new item">
    <div class="container">
        <h1>ADD NEW ITEM</h1>
        <form action="/additem" method="post">
            <div class="tbox">
                <input type="text" placeholder="@Name" value="" name="name">
            </div>
            <div class="tbox">
                <input type="text" placeholder="@description" value="" name="description">
            </div>
            <select class="sel" size="1" name="timeSlots">
                    <option class="opt" selected disabled>Choose timing</option>
                    <option class="opt" value="Per hour">Per Hour</option>
                    <option class="opt" value="Per day">Per Day</option>
                    <option class="opt" value="Per week">Per Week</option>
                    <option class="opt" value="Per month">Per Month</option>
                    <option class="opt" value="Per year">Per Year</option>
            </select>
            <div class="tbox">
                <input type="number" placeholder="@Price $" value="" name="price">
            </div>
            <select class="sel" size="1" name = "category">
                    <option class = "opt" selected disabled>Choose category</option>
                    <option class = "opt" value="Study">Study</option>
                    <option class = "opt" value="Sport">Sport</option>
                    <option class = "opt" value="Home">Home</option>
            </select>
<#--                <input type="text" placeholder="@Category" value="" name="category">-->


            <input class="btn" type="submit" placeholder="" value="Add new item" name="submit">
        </form>
    </div>
</@menu.menu>
