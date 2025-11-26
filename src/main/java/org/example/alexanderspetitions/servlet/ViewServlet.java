package org.example.alexanderspetitions.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.alexanderspetitions.Petition;
import org.example.alexanderspetitions.PetitionList;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ViewServlet", urlPatterns = "/view")
public class ViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Retrieves the list of existing petitions
        List<Petition> petitions = PetitionList.getPetitions();

        //Set the list as an attribute
        request.setAttribute("petitions", petitions);

        // Forward to JSP file to load all the petitions
        request.getRequestDispatcher("/WEB-INF/views/view.jsp").forward(request, response);
    }
}
