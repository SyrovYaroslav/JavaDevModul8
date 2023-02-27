import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@WebServlet(value = "/time")
public class TimeServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/html; charset=utf-8");
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String timezone = req.getParameter("timezone");
        if (timezone == null) {
            timezone = "UTC";
        }
        try (PrintWriter writer = resp.getWriter()){
            writer.write(time + " " + timezone.replace(" ", "+"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
