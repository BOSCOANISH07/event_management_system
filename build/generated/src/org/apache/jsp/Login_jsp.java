package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=ISO-8859-1");
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
      out.write("    <title>Login</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <h2>User Login</h2>\n");
      out.write("    <form method=\"post\" action=\"Login.jsp\">\n");
      out.write("        Username: <input type=\"text\" name=\"User_Name\" required /><br><br>\n");
      out.write("        Password: <input type=\"password\" name=\"User_Password\" required /><br><br>\n");
      out.write("        <input type=\"submit\" value=\"Login\" />\n");
      out.write("    </form>\n");
      out.write("\n");

    String User_Name = request.getParameter("User_Name");
    String User_Password = request.getParameter("User_Password");
    boolean status = false;
    if (User_Name != null && User_Password != null) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EventlyDB", "root", "")) {
                String query = "SELECT * FROM plogindetails WHERE User_Name = ? AND User_Password = ?";
                try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                    preparedStatement.setString(1, User_Name);
                    preparedStatement.setString(2, User_Password);

                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        status = resultSet.next(); // If a record is found, the user is valid
                    }
                }
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        // Redirect based on validation result
        if (status) {

      out.write("\n");
      out.write("            <script type=\"text/javascript\">\n");
      out.write("                alert('Login Successful!');\n");
      out.write("                window.location = 'Welcome.jsp'; // Redirect to a welcome page or dashboard\n");
      out.write("            </script>\n");

        } else {

      out.write("\n");
      out.write("            <script type=\"text/javascript\">\n");
      out.write("                alert('Invalid username or password. Please try again.');\n");
      out.write("            </script>\n");

        }
    }

      out.write("\n");
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
