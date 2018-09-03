import xml_result.soap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet5_CreateRequest")
public class Servlet5_CreateRequest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestURI();
        String in_xml = request.getParameter("in_xml");
        //System.out.println(in_xml);
        response.setContentType("application/json");
        response.setContentType("text/xml;charset=UTF-8");

        soap soap = new soap();
        response.getWriter().write(soap.generateSoap(in_xml));
        System.out.println("--->CreateRequestXML \t" + soap.generateSoap(in_xml));
    }
}
