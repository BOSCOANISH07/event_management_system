package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class AddEvent_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write('\n');

    // Retrieve form parameters
    String a1 = request.getParameter("EventNo");
    String a2 = request.getParameter("EventName");
    String a3 = request.getParameter("CoordinatorName"); // Use correct parameter names
    String a4 = request.getParameter("CoordinatorNo");
    String a5 = request.getParameter("Fee");
    String a6 = request.getParameter("Venue");

    // Validate input
    if (a1 == null || a1.trim().isEmpty() || 
        a2 == null || a2.trim().isEmpty() || 
        a3 == null || a3.trim().isEmpty() || 
        a4 == null || a4.trim().isEmpty() || 
        a5 == null || a5.trim().isEmpty() || 
        a6 == null || a6.trim().isEmpty()) {

      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            alert('Please Enter Event Details!!!');\n");
      out.write("        </script>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "CreateE.html", out, false);
      out.write('\n');

    } else {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            // Establish database connection
            Class.forName("com.mysql.jdbc.Driver");
            String conURL = "jdbc:mysql://localhost:3306/EventlyDB";
            String userName = "root";
            String userPassword = "";
            con = DriverManager.getConnection(conURL, userName, userPassword);

            // Insert query using PreparedStatement
            String query = "INSERT INTO Event (EventNo, EventName, CoordinatorName, CoordinatorNo, Fee, Venue) VALUES (?, ?, ?, ?, ?, ?)";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, a1);
            pstmt.setString(2, a2);
            pstmt.setString(3, a3);
            pstmt.setString(4, a4);
            pstmt.setString(5, a5);
            pstmt.setString(6, a6);

            // Execute the query
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {

      out.write("\n");
      out.write("                <script type=\"text/javascript\">\n");
      out.write("                    alert('Success! ... Event Details Added To Database!');\n");
      out.write("                </script>\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "CreateE.html", out, false);
      out.write('\n');

            } else {

      out.write("\n");
      out.write("                <script type=\"text/javascript\">\n");
      out.write("                    alert('Failed to add event details!');\n");
      out.write("                </script>\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "CreateE.html", out, false);
      out.write('\n');

            }
        } catch (ClassNotFoundException | SQLException e) {
            // Handle exceptions
            out.println("Error: " + e.getMessage());
        } finally {
            // Close resources
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException closeEx) {
                    out.println("Error closing statement: " + closeEx.getMessage());
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException closeEx) {
                    out.println("Error closing connection: " + closeEx.getMessage());
                }
            }
        }
    }

      out.write('\n');
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
