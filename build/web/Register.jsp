<%@ page import="java.sql.Connection, java.sql.DriverManager, java.sql.Statement, java.sql.SQLException" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Event Registration</title>
</head>
<body>

    <h2>Register for Event</h2>
<%
    String a1 = request.getParameter("ename");
    String a2 = request.getParameter("enum");
    String a3 = request.getParameter("cardno");
    String a4 = request.getParameter("edate");
    String a5 = request.getParameter("cvv");
    String a6 = request.getParameter("cname");
    if (a1 != null && a2 != null && a3 != null && a4 != null && a5 != null && a6 != null &&
        !a1.trim().isEmpty() && !a2.trim().isEmpty() && !a3.trim().isEmpty() &&
        !a4.trim().isEmpty() && !a5.trim().isEmpty() && !a6.trim().isEmpty()) {
        
        try {
            Class.forName("com.mysql.jdbc.Driver"); // For MySQL 8.x and above
            String conURL = "jdbc:mysql://localhost:3306/EventlyDB";
            String dbusername = "root";
            String dbuserpassword = "";
            Connection con = DriverManager.getConnection(conURL, dbusername, dbuserpassword);
            con.setAutoCommit(false);

            // Insert data into the `card` table
            Statement statement = con.createStatement();
            String mysqlQuery = "INSERT INTO card (event_name, event_number, card_number, expiry_date, cvv, cardholder_name) " +
                                "VALUES ('" + a1 + "', '" + a2 + "', '" + a3 + "', '" + a4 + "', '" + a5 + "', '" + a6 + "')";
            statement.executeUpdate(mysqlQuery);

            // Commit the transaction
            con.commit();
            con.close();

            // Redirect to the Payment page
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Registration Successful!');");
            out.println("window.location.href='Payment.html';");  // Redirect to Payment page after successful registration
            out.println("</script>");

        } catch (ClassNotFoundException | SQLException e) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Database Error: Unable to process registration!');");
            out.println("window.location.href='Registration.html';");  // Redirect to Registration page in case of error
            out.println("</script>");
            e.printStackTrace();
        }
    } else {
        out.println("<script type=\"text/javascript\">");
        out.println("alert('Please Enter All Event Details!!!');");
        out.println("window.location.href='Registration.html';");  // Redirect to Registration page if validation fails
        out.println("</script>");
    }
%>

</body>
</html>
