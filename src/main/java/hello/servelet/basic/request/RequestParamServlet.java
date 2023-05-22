package hello.servelet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 1. 파라미터 전송기능
 * http://localhost:8080/request-param?username=hello&age=20
 *
 */
@WebServlet(name = "requestParamServlet",urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("[전체 파라미터 조회] - start");
        req.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName+" = "+req.getParameter(paramName)));
        System.out.println("[전체 파라미터 조회] - end");
        System.out.println();
        // 단일 파라메터 조회
        System.out.println("[단일 파라미터 조회] - start");
        String username = req.getParameter("username");
        System.out.println("username = " + username);
        String age = req.getParameter("age");
        System.out.println("age = " + age);
        System.out.println("[단일 파라미터 조회] - end");
        // 중복 되는 파라미터 조회 -> http:localhost:8080/request-param?username=hello&age=20&username=lee
        System.out.println("[중복 파라미터 조회] - start");
        String[] usernames = req.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("username = " + name);
        }
        System.out.println("[중복 파라미터 조회] - end");

        resp.getWriter().write("ok");
    }
}
