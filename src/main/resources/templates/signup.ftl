<#import "headerMenu.ftl" as menu>

<@menu.menu signed_in="${auth}" title="Sign Up">
    <div class="cont">
        <h1>SIGN UP</h1>
        <form action="/signup" method="post">
            <div class="tbox">
                <input type="text" placeholder="@FirstName" value="" name="firstName">
            </div>
            <div class="tbox">
                <input type="text" placeholder="@LastName" value="" name="lastName">
            </div>
            <div class="tbox">
                <input type="email" placeholder="@Email" value="" name="email">
            </div>
            <div class="tbox">
                <input type="password" placeholder="@Password" value="" name="password">
            </div>
            <div class="tbox">
                <input type="tel" placeholder="PhoneNumber" value="" name="phoneNumber">
            </div>


            <input class="btn" type="submit" placeholder="" value="Sign Up" name="submit">
        </form>
        <a class="b2" href="/login  ">Log In</a>
    </div>
</@menu.menu>