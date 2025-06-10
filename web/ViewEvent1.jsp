<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Event Page</title>
    <link rel="stylesheet" href="total.css">
    <link href="https://fonts.googleapis.com/css2?family=Balsamiq+Sans&display=swap" rel="stylesheet">
</head>
<body>
<%
    Connection con = null;
    try {
        Class.forName("com.mysql.jdbc.Driver");
        String conURL = "jdbc:mysql://localhost:3306/EventlyDB";
        String dbusername = "root";
        String dbuserpassword = "";
        con = DriverManager.getConnection(conURL, dbusername, dbuserpassword);
        
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Event");

%>
        <h1 style="text-align: center">Welcome To Evently ... An Event Management Portal!</h1>
        <center><h1>Event Details</h1></center>
        <div>
            <center>
                <table border="1" width="50%" height="50%">
                    <tr>
                        <th>Event Number</th>
                        <th>Event Name</th>
                        <th>Coordinator</th>
                        <th>Coordinator Contact</th>
                        <th>Fees</th>
                        <th>Venue</th>
                        <th>Date</th>
                    </tr>
<%
        while (resultSet.next()) {
            String eventNumber = resultSet.getString("EventNo");
            String eventName = resultSet.getString("EventName");
            String coordinatorName = resultSet.getString("CoordinatorName");
            String coordinatorContact = resultSet.getString("CoordinatorNo");
            String fee = resultSet.getString("Fee");
            String venue = resultSet.getString("Venue");
            String date = resultSet.getString("EventDate");
%>
                    <tr>
                        <td><%= eventNumber %></td>
                        <td><%= eventName %></td>
                        <td><%= coordinatorName %></td>
                        <td><%= coordinatorContact %></td>
                        <td><%= fee %></td>
                        <td><%= venue %></td>
                        <td><%= date %></td>
                    </tr>
<%
        }
%>
                </table>
                <br>
            </center>
        </div>
        <div>
            
        </div>
<%
    } catch (ClassNotFoundException | SQLException e) {
        out.println("Exception Caught: " + e.getMessage());
    } finally {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                out.println("Error closing connection: " + e.getMessage());
            }
        }
    }
%>
</body>
</html>
