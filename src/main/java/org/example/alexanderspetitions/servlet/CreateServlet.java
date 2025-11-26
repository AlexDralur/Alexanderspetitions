package org.example.alexanderspetitions.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.alexanderspetitions.Petition;
import org.example.alexanderspetitions.PetitionList;

import java.io.IOException;

@WebServlet(name = "CreateServlet", urlPatterns = "/create-petition")
public class CreateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Get the title and the description created by the user
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        // Adds new petition to the list of petitions
        Petition petition = new Petition(title, description);
        PetitionList.addPetition(petition);

        // Return to view page showing all the petitions
        request.getRequestDispatcher("/WEB-INF/views/view.jsp").forward(request, response);
    }
}
