<%@ tag import="org.springframework.boot.web.servlet.server.Session" %>
<%@ tag import="com.itis.term.model.PlaceEntity" %>
<%@ tag import="java.util.ArrayList" %>
<%@tag description="Default Layout Tag" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@attribute name="title" %>
<%@attribute name="jsGroup"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
</head>
<body>
<jsp:doBody/>
<c:if test="${jsGroup eq 'place'}">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="<c:url value="/js/places.js"/>"></script>
    <script src="<c:url value="/js/hoursCounter.js"/>"></script>

    <link rel="stylesheet" href="<c:url value="/css/profile.css"/>">
    <link rel="stylesheet" href="<c:url value="/css/secondprof.css"/>">

    <section class="menu">
        <a href="#" class="menu__logo logo">FOCUSED</a>
        <a href="#" class="menu__username">${user.getUserName()}</a>
        <ul class="menu__list list">
            <li class="menu__item item">
                <a href="<c:url value="/welcome"/>" class="menu__link link">
                    <span>Home</span>
                </a>
            </li>
        </ul>
        <ul class="menu__admin admin">
            <li class="admin__item item">
                <a href="<c:url value="/logout"/>" class="admin__link link">

                    <span>Logout</span>
                </a>
            </li>
        </ul>
    </section>
    <section class="content">
    </section>



    <section class="menu2">
            <table class="table1">
                <trIn>In game now </trIn>
                <% ArrayList<PlaceEntity> arr = (ArrayList<PlaceEntity>) request.getSession().getAttribute("notAvailablePlaces");
                session.setAttribute("list",arr);
                %>
                <c:forEach items="${list}" var="notAvailablePlace">
            <tr>
                <td>Place ${notAvailablePlace.id} -</td>
                <td>${notAvailablePlace.current_username}</td>
                <c:if test="${userId == 1}">
                    <td><form  id="deleteBookingOnPlace" action = <c:url value="/deleteBooking"/>  method="POST">
                        <input type="hidden" value="${notAvailablePlace.id}" name="placeId">
                        <input class="link3" form="deleteBookingOnPlace" type="submit" value="X">
                    </form></td>
                </c:if>
            </tr>
                </c:forEach>
            <c:if test="${userId == 1}">
                <form  id="deleteAll" action = <c:url value="/deleteAllBooking"/>  method="POST">
                    <input class="link2" form="deleteAll" type="submit" value="       Take off computers">
                </form>
            </c:if>

            </table>
    </section>
    <section class="content">
    </section>

</c:if>
<c:if test="${jsGroup eq 'login'}">
    <link rel="stylesheet" href="<c:url value="/css/login.css"/>">
</c:if>
<c:if test="${jsGroup eq 'payment'}">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="<c:url value="/css/payment.css"/>">
</c:if>
<c:if test="${jsGroup eq 'signup'}">
    <link rel="stylesheet" href="<c:url value="/css/signup.css"/>">
</c:if>
</body>
</html>
