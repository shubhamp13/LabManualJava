package com.question19;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/question19/count")
public class CounterServlet extends HttpServlet {
    public static  Integer counter = 0;
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
     boolean isAvailable=false;
     Cookie[] cookies = req.getCookies();
     if(cookies != null) {
         for(Cookie cookie : cookies) {
             if(cookie.getName().equals("count")) {
                 counter=Integer.parseInt(cookie.getValue());
                 ++counter;
                 cookie.setValue(String.valueOf(counter));
                 isAvailable=true;
                 cookie.setMaxAge(60*60*24*7);
                 resp.addCookie(cookie);
             }
         }
     }
     if(!isAvailable) {
         Cookie cookie = new Cookie("count", String.valueOf(counter));
         cookie.setMaxAge(60*60*24*7);
         resp.addCookie(cookie);

     }
     out.println("<h1>You Have Visited thi page "+counter+" Times</h1>");
    }
}
