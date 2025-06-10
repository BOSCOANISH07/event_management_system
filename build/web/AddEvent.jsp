<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String a1 = request.getParameter("EventNo");
    String a2 = request.getParameter("EventName");
    String a3 = request.getParameter("CoordinatorName");
    String a4 = request.getParameter("CoordinatorNo");
    String a5 = request.getParameter("Fee");
    String a6 = request.getParameter("Venue");
    String a7 = request.getParameter("Date");

    if (a1 == null || a1.trim().isEmpty() || 
        a2 == null || a2.trim().isEmpty() || 
        a3 == null || a3.trim().isEmpty() || 
        a4 == null || a4.trim().isEmpty() || 
        a5 == null || a5.trim().isEmpty() || 
        a6 == null || a6.trim().isEmpty() || 
        a7 == null || a7.trim().isEmpty()) {
%>
        <script type="text/javascript">
            alert('Please Enter Event Details!!!');
        </script>
        <jsp:include page="CreateE.html" />
<%
    } else {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String conURL = "jdbc:mysql://localhost:3306/EventlyDB";
            String userName = "root";
            String userPassword = "";
            con = DriverManager.getConnection(conURL, userName, userPassword);
            con.setAutoCommit(false);

            Statement statement = con.createStatement();
            String queryStatement = "INSERT INTO Event (EventNo, EventName, CoordinatorName, CoordinatorNo, Fee, Venue, EventDate) "
                                   + "VALUES ('" + a1 + "','" + a2 + "','" + a3 + "','" + a4 + "','" + a5 + "','" + a6 + "','" + a7 + "')";
            statement.executeUpdate(queryStatement);

            con.commit();
%>
            <script type="text/javascript">
                alert('Success! ... Event Details Added To Database!');
            </script>
            <jsp:include page="CreateE.html" />
<%
        } catch (ClassNotFoundException | SQLException e) {
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException rollbackEx) {
                    out.println("Error rolling back transaction: " + rollbackEx.getMessage());
                }
            }
            out.println("Exception caught: " + e.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException closeEx) {
                    out.println("Error closing connection: " + closeEx.getMessage());
                }
            }
        }
    }
%>
