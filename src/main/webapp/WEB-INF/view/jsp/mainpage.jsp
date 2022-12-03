<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>

    <title>FOCUSED</title>
    <link rel="stylesheet" href="<c:url value="/css/mainpage.css"/>">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="<c:url value="/js/mainpage.js"/>"></script>

</head>
<body>
<header>
    <div class="navbar">
            <c:if test="${user != null}">
                <a href="<c:url value="/place"/>"> Check Places </a>
            </c:if>
            <c:if test="${user == null}">
                <a href="<c:url value="/login"/>"> Login </a>
                <a href="<c:url value="/signup"/>">Register</a>
            </c:if>
        <a href="<c:url value="https://github.com/ziperlin17/CompClub_Term/commits/main"/>">News</a>
        <a href="<c:url value="https://github.com/ziperlin17"/>">Contact</a>
        <b href="#"  > <img width="20" height="20" src="https://im.wampi.ru/2022/11/06/66.png"></b>
    </div>

    <div class="main">
        <p>Some text some text some text some text..</p>
    </div>

    <div id="pic" class="headline">
        <div id="keep" class="inner">
            <h1></h1>
            <p>  keep</p>
        </div>
    </div>
</header>
<section>
    <h2>Where are the best hangouts? At our club.</h2>
    <p>Lorem ipsum sed lectus mi, eleifend quis congue non, lacinia id quam. Cras porta pellentesque nulla, ac auctor ligula scelerisque non. In vel placerat lacus. Nam pretium vitae purus et laoreet. Aliquam erat volutpat. Pellentesque id volutpat sem, et condimentum nisl. Donec bibendum congue mauris, ac commodo tortor volutpat ac. Donec lobortis lorem nisi, sit amet bibendum lacus vestibulum interdum. Donec mollis ligula at semper iaculis.</p>
    <p>Duis et vestibulum turpis. Duis non ultrices quam. Sed volutpat imperdiet sollicitudin. Aliquam erat volutpat. Donec at adipiscing purus. Duis varius metus vitae mattis pellentesque. Etiam tempor urna sed congue vulputate. Nulla neque metus, vulputate a dui ut, suscipit fringilla risus. Suspendisse posuere dignissim vestibulum. Praesent congue vestibulum dolor, quis lobortis libero egestas ac. Sed venenatis bibendum interdum. Curabitur rhoncus urna quis viverra varius. Cras posuere non tortor at volutpat. Suspendisse porta, turpis at ullamcorper imperdiet, felis lacus eleifend sapien, pulvinar elementum ipsum lacus ut elit. Sed ipsum erat, porttitor non malesuada at, interdum at nibh. Mauris ut ornare purus.</p>
    <h2>Nulla vitae lacus</h2>
    <p>Praesent commodo elit vel massa gravida lacinia. Maecenas auctor dignissim porttitor. Donec tincidunt mi eget semper bibendum. Morbi quis sagittis sapien. Fusce ut ligula purus. Nulla tristique augue nec lectus lacinia congue. Nunc tempus eros quam, ac sollicitudin mauris vehicula ac. Vivamus pulvinar elit ac risus placerat rutrum.</p>
    <p>Magna indoctum erroribus no his, alii fabellas eum an. Et tota clita eleifend eum, pri ne euismod eloquentiam, sea ei quas tibique. Ipsum tamquam cum id, tota clita congue ad usu. Ex eos admodum nominati. Eam ei summo dictas nostrum, vim harum graeco apeirian te. Sensibus persequeris nam an, cu legere oblique tincidunt eos, et soleat vivendum indoctum eos.</p>
    <p>Donec lobortis porta ipsum a tristique. Integer sit amet ipsum porta, bibendum mauris vitae, ultricies lectus.</p>
</section>
</body>
</html>
