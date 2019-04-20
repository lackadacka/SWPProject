<#macro adinfo header action name description timeslot price category>
    <div class="container">
        <h1>${header}</h1>
        <form action=${action} method="post" enctype="multipart/form-data">
            <#nested>
            <div class="tbox">
                <input type="text" placeholder="@Name" required value="${name?if_exists}" name="name">
            </div>
            <div class="tbox">
                <input type="text" placeholder="@description" required value="${description?if_exists}" name="description">
            </div>
            <select class="sel" size="1" required name="timeSlots" value=${timeslot?if_exists}>
                <option class="opt" value="" selected disabled hidden>Choose timing</option>
                <option class="opt" value="Per hour" <#if timeslot="Per hour">selected="selected"</#if>>Per Hour</option>
                <option class="opt" value="Per day" <#if timeslot="Per day">selected="selected"</#if>>Per Day</option>
                <option class="opt" value="Per week" <#if timeslot="Per week">selected="selected"</#if>>Per Week</option>
                <option class="opt" value="Per month" <#if timeslot="Per month">selected="selected"</#if>>Per Month</option>
                <option class="opt" value="Per year" <#if timeslot="Per year">selected="selected"</#if>>Per Year</option>
            </select>
            <div class="tbox">
                <input type="number" placeholder="@Price $" required value="${price?if_exists}" name="price">
            </div>
            <select class="sel" size="1" required name = "category" value="${category?if_exists}">
                <option class = "opt" value="" selected disabled>Choose category</option>
                <option class = "opt" value="Transport" <#if category="Transport">selected="selected"</#if>>Transport</option>
                <option class = "opt" value="Home stuff" <#if category="Home stuff">selected="selected"</#if>>Home Stuff</option>
                <option class = "opt" value="Electronics" <#if category="Electronics">selected="selected"</#if>>Electronics</option>
                <option class = "opt" value="Travel" <#if category="Travel">selected="selected"</#if>>Travel</option>
                <option class = "opt" value="Music" <#if category="Music">selected="selected"</#if>>Music</option>
                <option class = "opt" value="Education" <#if category="Education">selected="selected"</#if>>Education</option>
                <option class = "opt" value="Sport" <#if category="Sport">selected="selected"</#if>>Sport</option>
                <option class = "opt" value="Wear" <#if category="Wear">selected="selected"</#if>>Wear</option>
                <option class = "opt" value="For animals" <#if category="For animals">selected="selected"</#if>>For animals</option>
                <option class = "opt" value="Beauty" <#if category="Beauty">selected="selected"</#if>>Beauty</option>
                <option class = "opt" value="Office" <#if category="Office">selected="selected"</#if>>Office</option>
                <option class = "opt" value="Entertainment" <#if category="Entertainment">selected="selected"</#if>>Entertainment</option>
            </select>
            <div class="file">
                <input type="file" name="file">
            </div>
            <#--                <input type="text" placeholder="@Category" value="" name="category">-->


            <input class="btn" type="submit" placeholder="" value="OK" name="submit">
        </form>
    </div>
</#macro>