package org.example.alexanderspetitions.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.alexanderspetitions.Petition;
import org.example.alexanderspetitions.PetitionList;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "SearchServlet", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Takes the input from the user
        String query = request.getParameter("query");

        //Filters the Petition list into a new one with only the ones containing the term searched
        List<Petition> results = PetitionList.getPetitions().stream()
                .filter(p -> p.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                        p.getDescription().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());

        //Set the attributes to be used by the .jsp file
        request.setAttribute("results", results);
        request.setAttribute("query", query);

        //Forward the attributes to the .jsp so it can load correctly
        request.getRequestDispatcher(request.getContextPath() + "/search-results.jsp").forward(request, response);
    }
}
