package ch.alni.azure.hello;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.jar.Manifest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A simple servlet printing the manifest entries of the application.
 */
@WebServlet(urlPatterns = {"/version"})
public class VersionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.setContentType("text/plain");

        final PrintWriter writer = resp.getWriter();
        try (InputStream inputStream = getServletContext().getResourceAsStream("/META-INF/MANIFEST.MF")) {
            Manifest manifest = new Manifest(inputStream);
            manifest.getMainAttributes().entrySet().stream()
                    .forEach(entry -> writer.println(String.format("%s: %s", entry.getKey(), entry.getValue())));

            writer.flush();
        }
    }
}
