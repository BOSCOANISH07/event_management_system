package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class StoreP_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>Participant Signup</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");

    String participantsName = request.getParameter("Pname");
    String userName = request.getParameter("Pusername");
    String userPassword = request.getParameter("Ppassword");
    String confirmUserPassword = request.getParameter("Cpassword");

    if (participantsName == null || userName == null || userPassword == null || confirmUserPassword == null ||
        participantsName.trim().isEmpty() || userName.trim().isEmpty() ||
        userPassword.trim().isEmpty() || confirmUserPassword.trim().isEmpty()) {

      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            alert('Please Enter Your Details!!!');\n");
      out.write("        </script>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Psignup.html", out, false);
      out.write('\n');

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


      out.write("\n");
      out.write("                <script type=\"text/javascript\">\n");
      out.write("                    alert('Signup Successful! Redirecting to login...');\n");
      out.write("                </script>\n");
      out.write("                ");
      if (true) {
        _jspx_page_context.forward("Plogin.html");
        return;
      }
      out.write('\n');

            } catch (ClassNotFoundException | SQLException e) {

      out.write("\n");
      out.write("                <script type=\"text/javascript\">\n");
      out.write("                    alert('Database Error: Unable to save details!');\n");
      out.write("                </script>\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Psignup.html", out, false);
      out.write('\n');

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

      out.write("\n");
      out.write("            <script type=\"text/javascript\">\n");
      out.write("                alert('Please Enter Password And Confirm Password As Same!!!');\n");
      out.write("            </script>\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Psignup.html", out, false);
      out.write('\n');

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
