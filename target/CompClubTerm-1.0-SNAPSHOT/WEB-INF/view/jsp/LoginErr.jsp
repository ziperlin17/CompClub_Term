<%@ page import="org.springframework.boot.web.servlet.server.Session" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="Places" jsGroup = 'login'>

  <div class="center">
    <h1> </h1>
    <form id="paymentform" action = <c:url value="/login"/>  method="POST">
      <div class="txt_field">
        <input name="email" type="text" required>
        <span></span>
        <label>E-mail</label>
      </div>
      <div class="txt_field">
        <input id="pas" name="password" type="password" required>
        <span></span>
        <label>Password</label>
      </div>

      <h2> no user with that e-mail and password </h2>
      <input type="submit" value="Login">
      <div class="signup_link">
        Not a member? <a href="<c:url value="/signup"/>">Signup</a>
      </div>
      <div class="signup_link">
        <a href="<c:url value="/welcome"/>">Return</a>
      </div>
    </form>
  </div>
</t:mainLayout>
