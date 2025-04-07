package com.question16;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/question16/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] ck = req.getCookies();
        String name=null;
        HttpSession session = req.getSession(false);
        if(session != null) {


            String isLoggedIn = session.getAttribute("username").toString();
            if (isLoggedIn != null) {
                for (Cookie c : ck) {
                    if (c.getName().equals("username")) {
                        name = c.getValue();
                    }
                }
                PrintWriter out = resp.getWriter();
                resp.setContentType("text/html");
                out.println("<h1>Welcome " + name + "</h1>");
                out.println("<form action='logout' >");
                out.println("<input type='submit' value='Logout'>");
                out.println("</form>");
            }
        }
        else
        {
            PrintWriter out = resp.getWriter();
            resp.setContentType("text/html");
            out.println("<h1>You are not logged in</h1>");
        }
    }
}
