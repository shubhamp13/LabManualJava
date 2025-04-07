package com.question18;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/question18/stud")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // For demo: hardcoded credentials
        if ("admin".equals(username) && "1234".equals(password)) {
            Cookie cookie = new Cookie("AuthenticatedUser", username);
            cookie.setMaxAge(60 * 30);
            cookie.setPath("/");
            resp.addCookie(cookie);

            resp.sendRedirect("welcome");
        } else {
            resp.setContentType("text/html");
            resp.getWriter().println("<h3>Invalid credentials. <a href='studlogin.html'>Try again</a></h3>");
        }
    }
}
