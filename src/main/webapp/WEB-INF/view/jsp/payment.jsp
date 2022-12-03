<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="Payment" jsGroup = 'payment'>

    <div class="center">
        <h1> </h1>
        <form id="loginform" action = "<c:url value="/payment/check"/>"  method="POST">
            <h2>${toPay} ₽      </h2>
            <div class="txt_field">
                <input name="cardnumber" type="number" maxlength="16" required>
                <span></span>
                <label>Card number</label>
            </div>
            <div class="txt_field">
                <input name="holder" type="text"  required>
                <span></span>
                <label>Cardholder name</label>
            </div>
            <div class="txt_field">
                <input maxlength="3" name="cvv" required type="password">
                <span></span>
                <label>CVC/CVV</label>
            </div>
            <div class="txt_field" style="border-bottom: 0px white; color: white">
                Card Expiration:
                <select name='expireMM' id='expireMM' style="width: 20%; margin-left: 40px">
                    <option value='01'>01</option>
                    <option value='02'>02</option>
                    <option value='03'>03</option>
                    <option value='04'>04</option>
                    <option value='05'>05</option>
                    <option value='06'>06</option>
                    <option value='07'>07</option>
                    <option value='08'>08</option>
                    <option value='09'>09</option>
                    <option value='10'>10</option>
                    <option value='11'>11</option>
                    <option value='12'>12</option>
                </select>
                <select name='expireYY' id='expireYY' style="width: 20%">
                    <option value='22'>22</option>
                    <option value='23'>23</option>
                    <option value='24'>24</option>
                    <option value='25'>25</option>
                    <option value='26'>26</option>
                </select>
                <input class="inputCard" type="hidden" name="expiry" id="expiry" maxlength="4"/>
            </div>
            <div class="txt_field">
                <input name="moneyValue" type="number" maxlength="16" required>
                <span></span>
                <label>how much money do you have?</label>
            </div>
            <input href="<c:url value="/place"/>" type="submit" value="Pay">
            <div class="signup_link">
                <a href="<c:url value="/place"/>">Return</a>
            </div>
        </form>
    </div>
</t:mainLayout>
