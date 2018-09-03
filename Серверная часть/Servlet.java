

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.tomcat.util.net.URL;
import xml.RequestGKN;

import static java.nio.charset.StandardCharsets.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* Формирование xml запроса */

@WebServlet(name = "Servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //request.getRequestURI();
        //System.out.println(request.getRequestURI());

        /*
        request.setCharacterEncoding("UTF-8");
        String lastname = request.getParameter("lastname");
        System.out.println("lastname = " + lastname);
        String firstname = request.getParameter("firstname");
        System.out.println("firstname = " + firstname);
        String patronymic = request.getParameter("patronymic");
        System.out.println("patronymic = " + patronymic);

        DataBase database = new DataBase();
        List <myTable> base = database.selectUser(lastname,firstname,patronymic);
        System.out.println(base.size());
        if (base.size() == 0) {

            //DataBase BaseHistory = new DataBase();
            Date date = new Date();
            database.insertHistory(lastname, firstname, patronymic,
                  null, null, null, date, false);
            System.out.println("Человек не найден в базе!");
            response.getWriter().write("");

        } else {
        */
        request.getRequestURI();
        //request.setCharacterEncoding("UTF-8");
        /*
         *         Для того чтобы перетаскивать не все элементы, мы будем перетаскивать только rootNode
         *         и брать нужное значение через rootNode.get("нужный нам атрибут").textValue()
         */

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.createObjectNode();

        ((ObjectNode) rootNode).put("mySelect1", request.getParameter("mySelect1"));
        ((ObjectNode) rootNode).put("2_1", request.getParameter("2_1"));

        //сведения об органе власти
        ((ObjectNode) rootNode).put("mySelect2", request.getParameter("mySelect2"));
        ((ObjectNode) rootNode).put("2_2", request.getParameter("2_2"));
        ((ObjectNode) rootNode).put("mySelect3", request.getParameter("mySelect3"));
        ((ObjectNode) rootNode).put("mySelect4", request.getParameter("mySelect4"));
        ((ObjectNode) rootNode).put("2_3", request.getParameter("2_3"));
        ((ObjectNode) rootNode).put("mySelect5", request.getParameter("mySelect5"));
        ((ObjectNode) rootNode).put("2_4", request.getParameter("2_4"));
        ((ObjectNode) rootNode).put("mySelect6", request.getParameter("mySelect6"));
        ((ObjectNode) rootNode).put("2_5", request.getParameter("2_5"));
        ((ObjectNode) rootNode).put("mySelect7", request.getParameter("mySelect7"));
        ((ObjectNode) rootNode).put("2_6", request.getParameter("2_6"));

        //информация о заявителе
        ((ObjectNode) rootNode).put("3_1_1", request.getParameter("3_1_1"));
        ((ObjectNode) rootNode).put("3_1_2", request.getParameter("3_1_2"));
        ((ObjectNode) rootNode).put("3_1_3", request.getParameter("3_1_3"));
        ((ObjectNode) rootNode).put("mySelect8", request.getParameter("mySelect8"));
        ((ObjectNode) rootNode).put("3_1_4", request.getParameter("3_1_4"));
        ((ObjectNode) rootNode).put("3_1_5", request.getParameter("3_1_5"));
        ((ObjectNode) rootNode).put("3_1_6", request.getParameter("3_1_6"));
        ((ObjectNode) rootNode).put("3_1_7", request.getParameter("3_1_7"));
        //____________
        ((ObjectNode) rootNode).put("3_2_1", request.getParameter("3_2_1"));
        ((ObjectNode) rootNode).put("mySelect9", request.getParameter("mySelect9"));
        ((ObjectNode) rootNode).put("mySelect10", request.getParameter("mySelect10"));
        ((ObjectNode) rootNode).put("3_2_2", request.getParameter("3_2_2"));
        ((ObjectNode) rootNode).put("mySelect11", request.getParameter("mySelect11"));
        ((ObjectNode) rootNode).put("3_2_3", request.getParameter("3_2_3"));
        ((ObjectNode) rootNode).put("mySelect12", request.getParameter("mySelect12"));
        ((ObjectNode) rootNode).put("3_2_4", request.getParameter("3_2_4"));
        ((ObjectNode) rootNode).put("mySelect13", request.getParameter("mySelect13"));
        ((ObjectNode) rootNode).put("3_2_5", request.getParameter("3_2_5"));
        ((ObjectNode) rootNode).put("mySelect14", request.getParameter("mySelect14"));
        ((ObjectNode) rootNode).put("3_2_6", request.getParameter("3_2_6"));
        ((ObjectNode) rootNode).put("mySelect15", request.getParameter("mySelect15"));
        ((ObjectNode) rootNode).put("3_2_7", request.getParameter("3_2_7"));
        //___________
        ((ObjectNode) rootNode).put("3_3_1", request.getParameter("3_3_1"));
        ((ObjectNode) rootNode).put("3_3_2", request.getParameter("3_3_2"));
        ((ObjectNode) rootNode).put("3_3_3", request.getParameter("3_3_3"));
        ((ObjectNode) rootNode).put("mySelect16", request.getParameter("mySelect16"));
        //Блок сведений об объекте запроса
        ((ObjectNode) rootNode).put("mySelect17", request.getParameter("mySelect17"));
        ((ObjectNode) rootNode).put("mySelect18", request.getParameter("mySelect18"));
        ((ObjectNode) rootNode).put("4_3", request.getParameter("4_3"));
        ((ObjectNode) rootNode).put("mySelect19", request.getParameter("mySelect19"));
        ((ObjectNode) rootNode).put("4_4", request.getParameter("4_4"));
        ((ObjectNode) rootNode).put("mySelect20", request.getParameter("mySelect20"));
        ((ObjectNode) rootNode).put("4_5", request.getParameter("4_5"));
        ((ObjectNode) rootNode).put("mySelect21", request.getParameter("mySelect21"));
        ((ObjectNode) rootNode).put("4_6", request.getParameter("4_6"));
        //Сведения о приложенных документах
        ((ObjectNode) rootNode).put("5_1", request.getParameter("5_1"));
        ((ObjectNode) rootNode).put("5_2_name", request.getParameter("5_2_name"));
        ((ObjectNode) rootNode).put("5_2_path", request.getParameter("5_2_path"));

        response.setContentType("application/json");
        response.setContentType("text/xml;charset=UTF-8");
        //Soap mySoap = new Soap();
        //response.getWriter().write(mySoap.generateSoap(base));
        RequestGKN RequestGKN = new RequestGKN();


        System.out.println("--->xml \t" + RequestGKN.generateRequestGKN(rootNode));

        // encode data using BASE64
        String encoded_BASE64 = DatatypeConverter.printBase64Binary(RequestGKN.generateRequestGKN(rootNode).getBytes());
        System.out.println("BASE64 \t" + encoded_BASE64);
        // Decode data
        //String decoded = new String(DatatypeConverter.parseBase64Binary(encoded));
        //System.out.println("decoded value is \t" + decoded);

        response.getWriter().write(encoded_BASE64);
    }
}

