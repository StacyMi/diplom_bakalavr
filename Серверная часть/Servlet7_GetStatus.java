import xml_GetStatus.soap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet7_GetStatus")
public class Servlet7_GetStatus extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestURI();
        String idhist = request.getParameter("idhist");
        response.setContentType("application/json");
        response.setContentType("text/xml;charset=UTF-8");

        soap soap = new soap();
        response.getWriter().write(soap.generateSoap(idhist));
        System.out.println("--->GetStatusXML \t" + soap.generateSoap(idhist));
    }
}
