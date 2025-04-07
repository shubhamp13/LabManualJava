package com.question16;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/question16/login")
public class LoginServlet extends HttpServlet
{
    final String username = "shubhamp13";
    final String password = "admin";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String user  = req.getParameter("username");
      String pass  = req.getParameter("password");
      HttpSession session = req.getSession();
      resp.setContentType("text/html");
      if(user.equals(username) && pass.equals(password)){
          Cookie cookie = new Cookie("username", username);
          resp.addCookie(cookie);
          session.setAttribute("username", username);
          resp.sendRedirect("WelcomeServlet");
      }
      else
      {
          resp.getWriter().println("<h1>Invalid Username or Password</h1>");
      }

    }
}
