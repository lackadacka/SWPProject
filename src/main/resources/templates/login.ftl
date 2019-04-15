
<#import "headerMenu.ftl" as menu>

<@menu.menu signed_in=false title="Sign In">
    <div class="container">
        <h1>LOG IN</h1>
        <form action="/login" method="post">
            <div class="tbox">
                <input type="text" placeholder="@username" value="" name="email">
            </div>

            <div class="tbox">
                <input type="password" placeholder="@password" value="" name="password">
            </div>

            <input class="btn" type="submit" placeholder="" value="Sign In" name="submit">
        </form>
        <a class="b2" href="/signup">CREATE AN ACCOUNT</a>
    </div>
</@menu.menu>
