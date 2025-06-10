<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String userName = request.getParameter("Ausername");
    String userPassword = request.getParameter("Apassword");

    String adminUserOne = "A101";
    String adminUserOnePassword = "Admin101";

    String adminUserTwo = "A202";
    String adminUserTwoPassword = "Admin202";

    String adminUserThree = "A303";
    String adminUserThreePassword = "Admin303";

    String adminUserFour = "A404";
    String adminUserFourPassword = "Admin404";

    if ((adminUserOne.equals(userName) && adminUserOnePassword.equals(userPassword)) ||
        (adminUserTwo.equals(userName) && adminUserTwoPassword.equals(userPassword)) ||
        (adminUserThree.equals(userName) && adminUserThreePassword.equals(userPassword)) ||
        (adminUserFour.equals(userName) && adminUserFourPassword.equals(userPassword))) {
%>
        <jsp:forward page="AdminEvent.html" />
<%
    } else {
%>
        <script type="text/javascript">
            alert('Please Enter Valid Username & Password for Admin!!!');
        </script>
        <jsp:include page="Alogin.html" />
<%
    }
%>
