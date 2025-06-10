package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class ViewEvent1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Event Page</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"total.css\">\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Balsamiq+Sans&display=swap\" rel=\"stylesheet\">\n");
      out.write("</head>\n");
      out.write("<body>\n");

    Connection con = null;
    try {
        Class.forName("com.mysql.jdbc.Driver");
        String conURL = "jdbc:mysql://localhost:3306/EventlyDB";
        String dbusername = "root";
        String dbuserpassword = "";
        con = DriverManager.getConnection(conURL, dbusername, dbuserpassword);
        
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Event");


      out.write("\n");
      out.write("        <h1 style=\"text-align: center\">Welcome To Evently ... An Event Management Portal!</h1>\n");
      out.write("        <center><h1>Event Details</h1></center>\n");
      out.write("        <div>\n");
      out.write("            <center>\n");
      out.write("                <table border=\"1\" width=\"50%\" height=\"50%\">\n");
      out.write("                    <tr>\n");
      out.write("                        <th>Event Number</th>\n");
      out.write("                        <th>Event Name</th>\n");
      out.write("                        <th>Coordinator</th>\n");
      out.write("                        <th>Coordinator Contact</th>\n");
      out.write("                        <th>Fees</th>\n");
      out.write("                        <th>Venue</th>\n");
      out.write("                        <th>Date</th>\n");
      out.write("                    </tr>\n");

        while (resultSet.next()) {
            String eventNumber = resultSet.getString("EventNo");
            String eventName = resultSet.getString("EventName");
            String coordinatorName = resultSet.getString("CoordinatorName");
            String coordinatorContact = resultSet.getString("CoordinatorNo");
            String fee = resultSet.getString("Fee");
            String venue = resultSet.getString("Venue");
            String date = resultSet.getString("EventDate");

      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print( eventNumber );
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( eventName );
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( coordinatorName );
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( coordinatorContact );
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( fee );
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( venue );
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( date );
      out.write("</td>\n");
      out.write("                    </tr>\n");

        }

      out.write("\n");
      out.write("                </table>\n");
      out.write("                <br>\n");
      out.write("            </center>\n");
      out.write("        </div>\n");
      out.write("        <div>\n");
      out.write("            \n");
      out.write("        </div>\n");

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

      out.write("\n");
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
