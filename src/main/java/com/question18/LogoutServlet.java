package com.question18;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/question18/logout")
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("AuthenticatedUser".equals(cookie.getName())) {
                    cookie.setMaxAge(0); 
                    cookie.setPath("/");
                    resp.addCookie(cookie);
                    break;
                }
            }
        }

        resp.sendRedirect("studlogin.html");
    }
}
