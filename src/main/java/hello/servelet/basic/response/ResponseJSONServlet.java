package hello.servelet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servelet.basic.HelloData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="responseJSONServlet",urlPatterns = "/response-json")
public class ResponseJSONServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Content-Type: application/json
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");

        HelloData helloData = new HelloData();
        helloData.setUsername("lux00leo");
        helloData.setAge(29);

        String res = objectMapper.writeValueAsString(helloData);
        resp.getWriter().write(res);
    }
}
