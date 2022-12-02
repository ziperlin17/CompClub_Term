<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="Payment Error" jsGroup = 'payment'>
    <div class="center">
        <h1> </h1>
        <img class="imgError" src="${pageContext.request.contextPath}/resourses/money1.jpg">
            <div class="signup_link">
                <a style="opacity: 1; color: #e7002a">Payment error or one place already taken - </a> <a href="<c:url value="/place"/>">Return</a>
            </div>
        </form>
    </div>
</t:mainLayout>
