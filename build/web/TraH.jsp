<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Transactions Page</title>
    <h1 style="text-align: center">Welcome To Evently ... An Event Management Portal!</h1>
    <link rel="stylesheet" href="total.css">
    <link href="https://fonts.googleapis.com/css2?family=Balsamiq+Sans&display=swap" rel="stylesheet">
</head>
<body>
    <center><h1>Transaction Details</h1></center>
    <div>
        <left>
            <p><a href="TransactionDetails.html"><button>Event Details Page</button></a></p>
        </left>
        <center>
            <table border="1" width="50%" height="50%">
                <tr>
                    <th>Event No</th>
                    <th>Event Name</th>
                    <th>Name</th>
                    <th>Payment Date</th>
                </tr>
                <%
                    try {
                        // Load MySQL JDBC Driver
                        Class.forName("com.mysql.jdbc.Driver");

                        // Database connection parameters
                        String conURL = "jdbc:mysql://localhost:3306/eventlydb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
                        String dbusername = "root";
                        String dbuserpassword = "";

                        // Establish connection
                        Connection con = DriverManager.getConnection(conURL, dbusername, dbuserpassword);

                        // Execute query
                        Statement statement = con.createStatement();
                        ResultSet resultSet = statement.executeQuery("SELECT * FROM card");

                        // Process an
                        while (resultSet.next()) {
                              String re = resultSet.getString("event_name");
                            String en = resultSet.getString("event_number");
                          
                            String name = resultSet.getString("card_number");
                            String pd = resultSet.getString("expiry_date");
                %>
                            <tr>
                                <td><%= en %></td>
                                <td><%= re %></td>
                                <td><%= name %></td>
                                <td><%= pd %></td>
                            </tr>
                <%
                        }

                        // Close connection
                        con.close();

                    } catch (ClassNotFoundException e) {
                        out.println("<p style='color: red;'>Error: JDBC Driver not found.</p>");
                        e.printStackTrace();
                    } catch (SQLException e) {
                        out.println("<p style='color: red;'>Error: Unable to fetch data from the database.</p>");
                        e.printStackTrace();
                    }
                %>
            </table>
        </center>
    </div>
</body>
</html>
