package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.ChatMessage;
import entity.ChatUser;

@WebServlet(name = "MessageListServlet")
public class MessageListServlet extends ChatServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf8");
        PrintWriter pw = response.getWriter();
        pw.println("<html><head><meta http-equiv='Content-Type' content='text/html; charset=utf-8'/><meta http-equiv='refresh' content='10'></head>");
        pw.println("<body>");
        for (int i = 0; i < messages.size() - 1 ; i++) {
            ChatMessage aMessage = messages.get(i);
            SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
            Date date = new Date(aMessage.getTimestamp());
            String message = new String(aMessage.getMessage());
            pw.println("<div><strong>" + aMessage.getAuthor().getName() + "(" + sdf.format(date) + ")"+"</strong>: " + aMessage.getMessage() + "</div>");
        }
        pw.println("</body></html>");
    }
}
