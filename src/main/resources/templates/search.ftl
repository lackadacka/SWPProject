<#macro search>
<div class="search">
    <form action="/" method="get">
        <select class="sel" size="1" name = "category">
            <option class = "opt" selected disabled>Category</option>
            <option class = "opt" value="Transport">Transport</option>
            <option class = "opt" value="Home stuff">Home Stuff</option>
            <option class = "opt" value="Electronics">Electronics</option>
            <option class = "opt" value="Travel">Travel</option>
            <option class = "opt" value="Music">Music</option>
            <option class = "opt" value="Education">Education</option>
            <option class = "opt" value="Sport">Sport</option>
            <option class = "opt" value="Wear">Wear</option>
            <option class = "opt" value="For animals">For animals</option>
            <option class = "opt" value="Beauty">Beauty</option>
            <option class = "opt" value="Office">Office</option>
            <option class = "opt" value="Entertainment">Entertainment</option>
        </select>
        <div class="check">
            <input type="checkbox" name="sort" value="sort" id="sort">
            <label for="sort">Sort by Price</label>
        </div>
        <div class="tbox">
            <input type="text" placeholder="@Search" name="text">
        </div>
        <select class="sel" size="1" name="timeSlots">
            <option class="opt" selected disabled hidden>Timing</option>
            <option class="opt" value="Per hour">Per Hour</option>
            <option class="opt" value="Per day">Per Day</option>
            <option class="opt" value="Per week">Per Week</option>
            <option class="opt" value="Per month">Per Month</option>
            <option class="opt" value="Per year">Per Year</option>
        </select>
        <input class="btn" type="submit" placeholder="" value="Search" name="submit">
    </form>
</div>
</#macro>