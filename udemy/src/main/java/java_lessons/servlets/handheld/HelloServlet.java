package java_lessons.servlets.handheld;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * Это простой сервлет, который я просто тут создал, а потом компилировал и клал все на сервер руками.
 * Просто тут для удобства
 */
public class HelloServlet extends HttpServlet {

    private Random random;

    public HelloServlet() {
        random = new Random(45);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.print("<H1>" + this.getClass().getName() + "</H1>");
        writer.print("Here you are a random int " + getRandomInt());
        writer.close();
    }

    private int getRandomInt() {
        return random.nextInt();
    }
}
