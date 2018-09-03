import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.nio.charset.StandardCharsets.UTF_8;

@WebServlet(name = "Servlet6_addIDHist")
public class Servlet6_addIDHist extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestURI();

        String lastname = request.getParameter("lastname");
        System.out.println("lastname = " + new String(lastname.getBytes(ISO_8859_1), UTF_8));
        String firstname = request.getParameter("firstname");
        System.out.println("firstname = " + new String(firstname.getBytes(ISO_8859_1), UTF_8));
        String patronymic = request.getParameter("patronymic");
        System.out.println("patronymic = " + new String(patronymic.getBytes(ISO_8859_1), UTF_8));
        String idhist = request.getParameter("idhist");
        System.out.println("idhist = " + idhist);

        DataBase database = new DataBase();
        database.insertIDhist(lastname, firstname, patronymic, idhist);

        response.setContentType("application/json");
        response.setContentType("text/xml;charset=UTF-8");
        response.getWriter().write("add in history/base");
    }
}
