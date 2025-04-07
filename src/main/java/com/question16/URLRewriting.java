package com.question16;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/url")
public class URLRewriting extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>URLRewriting</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>URLRewriting</h1>");
        out.println("<a href='dash?name=shubhampuri'>Dashboard</a>");
        out.println("</body>");
    }
}
