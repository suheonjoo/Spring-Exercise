package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ResponseHtmlServlet",urlPatterns = "/response-html")
public class ResponseHtmlServlet extends HttpServlet {
    //그냥 intellij 단축키 인데 option 방향키가 단어 단위로 이동임 그리고 이동하면서 드래그는 option shift 방향키임
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Content-type: text/html;charset=utf-8
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");//이렇게 해야 한글 같은 것이 안 깨

        PrintWriter writer = response.getWriter();
        writer.print("<html>");
        writer.print("<body>");
        writer.print("    <div>안녕</div>");
        writer.print("</body>");
        writer.print("</html>");
    }
}
