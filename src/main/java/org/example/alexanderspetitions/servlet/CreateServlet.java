package org.example.alexanderspetitions.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "CreateServlet", urlPatterns = "/create-petition")
public class CreateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String title = request.getParameter("title");
        String description = request.getParameter("description");

        // Check if the print is being made
        System.out.println("Petition created:");
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);

        // Return to main page
        response.sendRedirect("/");
    }
}
