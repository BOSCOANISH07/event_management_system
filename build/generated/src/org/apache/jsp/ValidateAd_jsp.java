package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ValidateAd_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    String userName = request.getParameter("Ausername");
    String userPassword = request.getParameter("Apassword");

    String adminUserOne = "A101";
    String adminUserOnePassword = "Admin101";

    String adminUserTwo = "A202";
    String adminUserTwoPassword = "Admin202";

    String adminUserThree = "A303";
    String adminUserThreePassword = "Admin303";

    String adminUserFour = "A404";
    String adminUserFourPassword = "Admin404";

    if ((adminUserOne.equals(userName) && adminUserOnePassword.equals(userPassword)) ||
        (adminUserTwo.equals(userName) && adminUserTwoPassword.equals(userPassword)) ||
        (adminUserThree.equals(userName) && adminUserThreePassword.equals(userPassword)) ||
        (adminUserFour.equals(userName) && adminUserFourPassword.equals(userPassword))) {

      out.write("\n");
      out.write("        ");
      if (true) {
        _jspx_page_context.forward("AdminEvent.html");
        return;
      }
      out.write('\n');

    } else {

      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            alert('Please Enter Valid Username & Password for Admin!!!');\n");
      out.write("        </script>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Alogin.html", out, false);
      out.write('\n');

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
