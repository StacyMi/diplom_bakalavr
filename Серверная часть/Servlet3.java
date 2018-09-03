

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.nio.charset.StandardCharsets.UTF_8;

/* История запросов */

@WebServlet(name = "Servlet3")
public class Servlet3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataBase database = new DataBase();
		List<myTable4_IDhist> history = database.selectUsers();
        int kol;
	    kol = 0;

        ObjectMapper mapper =  new ObjectMapper();
        //JsonNode rootNode = mapper.createObjectNode();

        ObjectNode rootNode = mapper.createObjectNode(); // создание главного объекта

		for (myTable4_IDhist h: history) {
            DateFormat formatSQL = new SimpleDateFormat("yyyy-MM-dd");

            //JsonNode childNode = mapper.createObjectNode();

            ObjectNode childNode = rootNode.putObject(""+kol+""); // создание дочернего объекта [1]

            //byte[] str = h.getLastname().getBytes();
            ((ObjectNode) childNode).put("lastname", h.getLastname());
            ((ObjectNode) childNode).put("firstname", h.getFirstname());

            if (h.getPatronymic() == null)
                ((ObjectNode) childNode).put("patronymic", "");
            else
                ((ObjectNode) childNode).put("patronymic", h.getPatronymic());

            ((ObjectNode) childNode).put("idhist", h.getIdhist());

            final String data_create = formatSQL.format(h.getData_create());
            ((ObjectNode) childNode).put("data_create", data_create);

            response.setContentType("application/json");
            kol++;
        }
        response.getWriter().write(mapper.writeValueAsString(rootNode));

    }
}
