<%@ page import="java.sql.*" %>
<%@ page import="java.util.logging.Level, java.util.logging.Logger" %>
<%
    response.setContentType("text/html");
    String userName = request.getParameter("Pausername");
    String userPassword = request.getParameter("Papassword");

    // Check if input fields are empty
    if (userName == null || userPassword == null || userName.trim().isEmpty() || userPassword.trim().isEmpty()) {
%>
    <script type="text/javascript">
        alert('Please Enter Your Login Details!!!');
    </script>
    <jsp:include page="Plogin.html" />
<%
    } else {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Establish connection to the database
            Class.forName("com.mysql.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:3306/EventlyDB"; // Database URL
            String dbUsername = "root"; // Database username
            String dbPassword = ""; // Database password
            con = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

            // SQL query to check if username and password exist
            String query = "SELECT * FROM plogindetails WHERE username = ? AND password = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, userName);
            ps.setString(2, userPassword);
            rs = ps.executeQuery();

            // If a record is found, the credentials are valid
            if (rs.next()) {
                // Forward to ParticipantEvent page if login is successful
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("ParticipantEvent.html");
                requestDispatcher.forward(request, response);
            } else {
%>
    <script type="text/javascript">
        alert('Sorry! ... User Name and Password Incorrect!!!');
    </script>
    <jsp:include page="Plogin.html" />
<%
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger("VaPa").log(Level.SEVERE, null, ex);
%>
    <script type="text/javascript">
        alert('An error occurred while validating your credentials. Please try again later.');
    </script>
    <jsp:include page="Plogin.html" />
<%
        } finally {
            // Close database resources to avoid memory leaks
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                Logger.getLogger("VaPa").log(Level.SEVERE, null, ex);
            }
        }
    }
%>
