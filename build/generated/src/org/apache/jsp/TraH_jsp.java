package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class TraH_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Transactions Page</title>\n");
      out.write("    <h1 style=\"text-align: center\">Welcome To Evently ... An Event Management Portal!</h1>\n");
      out.write("    <link rel=\"stylesheet\" href=\"total.css\">\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Balsamiq+Sans&display=swap\" rel=\"stylesheet\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <center><h1>Transaction Details</h1></center>\n");
      out.write("    <div>\n");
      out.write("        <left>\n");
      out.write("            <p><a href=\"TransactionDetails.html\"><button>Event Details Page</button></a></p>\n");
      out.write("        </left>\n");
      out.write("        <center>\n");
      out.write("            <table border=\"1\" width=\"50%\" height=\"50%\">\n");
      out.write("                <tr>\n");
      out.write("                    <th>Event No</th>\n");
      out.write("                    <th>Event Name</th>\n");
      out.write("                    <th>Name</th>\n");
      out.write("                    <th>Payment Date</th>\n");
      out.write("                </tr>\n");
      out.write("                ");

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
                
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td>");
      out.print( en );
      out.write("</td>\n");
      out.write("                                <td>");
      out.print( re );
      out.write("</td>\n");
      out.write("                                <td>");
      out.print( name );
      out.write("</td>\n");
      out.write("                                <td>");
      out.print( pd );
      out.write("</td>\n");
      out.write("                            </tr>\n");
      out.write("                ");

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
                
      out.write("\n");
      out.write("            </table>\n");
      out.write("        </center>\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
