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

@WebServlet(name = "ViewServlet", urlPatterns = "/view")
public class ViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Petition> petitions = PetitionList.getPetitions();
        request.setAttribute("petitions", petitions);

        // Forward to JSP in WEB-INF
        request.getRequestDispatcher("src/main/webapp/WEB-INF/view.jsp").forward(request, response);
    }
}
