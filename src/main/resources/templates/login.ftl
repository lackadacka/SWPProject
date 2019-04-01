<#import "headerMenu.ftl" as menu>

<@menu.menu profile="Sign In" sign="Sign Up" profile_ref="/login" sign_ref="/register" title="Sign In">
    <div class="container">
        <h1>LOG IN</h1>
        <form action="login.ftl" method="post">
            <div class="tbox">
                <input type="text" placeholder="@username" value="">
            </div>

            <div class="tbox">
                <input type="password" placeholder="@password" value="">
            </div>

            <input class="btn" type="submit" placeholder="" value="Sign In">
        </form>
        <a class="b1" href="#">FORGOT PASSWORD</a>
        <a class="b2" href="#">CREATE AN ACCOUNT</a>
    </div>
</@menu.menu>