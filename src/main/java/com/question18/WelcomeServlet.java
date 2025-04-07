package com.question18;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/question18/welcome")
public class WelcomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        Cookie[] cookies = req.getCookies();
        String username = null;

        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("AuthenticatedUser".equals(c.getName())) {
                    username = c.getValue();
                    break;
                }
            }
        }

        if (username != null) {
            out.println("<h2>Welcome, " + username + "!</h2>");
            out.println("<a href='logout'>Logout</a>");
        } else {
            out.println("<h3>Please login first. <a href='studlogin.html'>Login</a></h3>");
        }
    }
}
