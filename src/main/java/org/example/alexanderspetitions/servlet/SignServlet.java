package org.example.alexanderspetitions.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.alexanderspetitions.Petition;
import org.example.alexanderspetitions.PetitionList;
import org.example.alexanderspetitions.Signature;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SignServlet", urlPatterns = "/sign-petition")
public class SignServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Get information provided by the website
        String title = request.getParameter("title");
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        //Creates a list of petitions from the one saved
        List<Petition> petitions = PetitionList.getPetitions();
        //Loop to identify the correct petition
        for (Petition p : petitions) {
            if (p.getTitle().equals(title)) {
                //adds the signature to the correct petition
                p.addSignature(new Signature(name, email));
                break;
            }
        }

        //The view page is then returned to the user
        response.sendRedirect(request.getContextPath() + "/WEB-INF/views/view");
    }
}
