

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/* Авторизация: добавление пользователя в базу */

@WebServlet(name = "Servlet4")
public class Servlet4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println("username = " + username);
        String password = request.getParameter("password");
        System.out.println("password = " + password);

        DataBase database = new DataBase();
        boolean result = database.selectAuth(username, password);
        System.out.println(result);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.createObjectNode();

        if (result == true) {
            ((ObjectNode) rootNode).put("successful", false);
        } else {
            database.insertUser_auth(username,  password);
            ((ObjectNode) rootNode).put("successful", true);
        }
        response.setContentType("application/json");

        response.getWriter().write(mapper.writeValueAsString(rootNode));
    }
}
