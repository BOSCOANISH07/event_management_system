package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public final class Register_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>Event Registration</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    <h2>Register for Event</h2>\n");

    String a1 = request.getParameter("ename");
    String a2 = request.getParameter("enum");
    String a3 = request.getParameter("cardno");
    String a4 = request.getParameter("edate");
    String a5 = request.getParameter("cvv");
    String a6 = request.getParameter("cname");

    // Validate input fields
    if (a1 != null && a2 != null && a3 != null && a4 != null && a5 != null && a6 != null &&
        !a1.trim().isEmpty() && !a2.trim().isEmpty() && !a3.trim().isEmpty() &&
        !a4.trim().isEmpty() && !a5.trim().isEmpty() && !a6.trim().isEmpty()) {
        
        try {
            // Database connection
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
