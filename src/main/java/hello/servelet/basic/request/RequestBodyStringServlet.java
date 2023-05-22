package hello.servelet.basic.request;

import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyStringServlet",urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletInputStream inputStream = req.getInputStream(); // byte 코드로 body 받아온다
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8); // byte body를 UTF-8인코딩으로 해석하여 string으로 가져옴

        System.out.println("messageBody = " + messageBody);

        resp.getWriter().write("ok");
    }
}
