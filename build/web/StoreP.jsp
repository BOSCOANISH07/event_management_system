<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Participant Signup</title>
</head>
<body>
<%
    String participantsName = request.getParameter("Pname");
    String userName = request.getParameter("Pusername");
    String userPassword = request.getParameter("Ppassword");
    String confirmUserPassword = request.getParameter("Cpassword");

    if (participantsName == null || userName == null || userPassword == null || confirmUserPassword == null ||
        participantsName.trim().isEmpty() || userName.trim().isEmpty() ||
        userPassword.trim().isEmpty() || confirmUserPassword.trim().isEmpty()) {
%>
        <script type="text/javascript">
            alert('Please Enter Your Details!!!');
        </script>
        <jsp:include page="Psignup.html" />
<%
    } else {
        if (userPassword.equals(confirmUserPassword)) {
            Connection con = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String conURL = "jdbc:mysql://localhost:3306/EventlyDB";
                String dbusername = "root";
                String dbuserpassword = "";
                con = DriverManager.getConnection(conURL, dbusername, dbuserpassword);

                Statement statement = con.createStatement();
                String mysqlQuery = "INSERT INTO plogindetails (username, password, participant_name) VALUES ('" 
                                     + userName + "', '" + userPassword + "', '" + participantsName + "')";
                statement.executeUpdate(mysqlQuery);

%>
                <script type="text/javascript">
                    alert('Signup Successful! Redirecting to login...');
                </script>
                <jsp:forward page="Plogin.html" />
<%
            } catch (ClassNotFoundException | SQLException e) {
%>
                <script type="text/javascript">
                    alert('Database Error: Unable to save details!');
                </script>
                <jsp:include page="Psignup.html" />
<%
                e.printStackTrace();
            } finally {
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException e) {
                        out.println("Error closing connection: " + e.getMessage());
                    }
                }
            }
        } else {
%>
            <script type="text/javascript">
                alert('Please Enter Password And Confirm Password As Same!!!');
            </script>
            <jsp:include page="Psignup.html" />
<%
        }
    }
%>
</body>
</html>
