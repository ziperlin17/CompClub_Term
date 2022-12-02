<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="Places" jsGroup = 'signup'>
<div class="center">
    <h1> </h1>
    <form id="signupform" formaction="<c:url value="/signup"/>"  method="POST">
        <div class="txt_field">
            <input name="email" type="text" required>
            <span></span>
            <label>E-mail</label>
        </div>
        <div class="txt_field">
            <input name="username" type="text" required>
            <span></span>
            <label>Username</label>
        </div>
        <div class="txt_field">
            <input name="password" type="password" required>
            <span></span>
            <label>Password</label>
        </div>
        <input form="signupform" type="submit" value="Register">
        <div class="signup_link">
            Already registered? <a href="<c:url value="/login"/>">Login</a>
        </div>
        <div class="signup_link">
            <a href="<c:url value="/welcome"/>">Return</a>
        </div>
    </form>
</div>
</t:mainLayout>
