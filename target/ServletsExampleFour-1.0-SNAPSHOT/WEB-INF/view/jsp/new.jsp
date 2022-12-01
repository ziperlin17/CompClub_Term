<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="sucess" jsGroup = 'payment'>
    <form name="myRedirectForm" action="https://processthis.com/process" method="post">
    <input name="name" type="hidden" value="xyz" />
    <input name="phone" type="hidden" value="9898989898" />
    <noscript>
        <input type="submit" value="Click here to continue" />
    </noscript>
    </form>
    <script type="text/javascript">
        $(document).ready(function() {
            document.myRedirectForm.submit();
        });
    </script>

</t:mainLayout>
