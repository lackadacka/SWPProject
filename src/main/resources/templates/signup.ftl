<#import "headerMenu.ftl" as menu>

<@menu.menu signed_in="${auth}" title="Sign Up">
    <div class="container">
        <h1>SIGN UP</h1>
        <form action="/signup" method="post">
            <div class="tbox">
                <input type="text" placeholder="@FirstName" required value="" name="firstName">
            </div>
            <div class="tbox">
                <input type="text" placeholder="@LastName" required value="" name="lastName">
            </div>
            <div class="tbox">
                <input type="email" placeholder="@Email" required value="" name="email">
            </div>
            <div class="tbox">
                <input type="password" placeholder="@Password" required value="" name="password">
            </div>
            <div class="tbox">
                <input type="tel" placeholder="@PhoneNumber +88888888888" pattern="[\+]\d{11}" maxlength="12" required value="" name="phoneNumber">
            </div>


            <input class="btn" type="submit" placeholder="" value="Sign Up" name="submit">
        </form>
        <a class="b2" href="/login  ">Log In</a>
    </div>
</@menu.menu>