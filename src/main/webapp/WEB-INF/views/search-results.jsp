<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.alexanderspetitions.Petition" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Alexander’s Petitions</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<header class="container text-center">
    <!--- Head --->
    <div class="row">
        <h1 class="display-1">Search Results</h1>
        <p class="lead">Showing petitions matching your search.</p>
    </div>
</header>

<div class="container text-center my-5">

    <!--- Body --->
    <%
        //Retrieve the query attribute sent by the servlet
        String query = (String) request.getAttribute("query");

        //Retrieve the results attribute sent by the servlet
        List<Petition> results = (List<Petition>) request.getAttribute("results");

        //In the case no petitions were found with the term searched
        if (results == null || results.isEmpty()) {
    %>
    <p>No petitions found for "<strong><%= query %></strong>".</p>
    <%
    } else {
    %>
    <ul style="list-style-type: none; padding: 0;">
        <!----- For each petition found with the term searched they are shown in a table ---->
        <% for (Petition p : results) { %>
        <li style="margin-bottom: 2rem;">
            <!---- Title and description of each petition found  ----->
            <h2><%= p.getTitle() %></h2>
            <p><%= p.getDescription() %></p>
        </li>
        <li>
            <!---- Form shown to each petition to allow user to sign all if they wish to do so ---->
            <form action="/sign-petition" method="post" class="mt-2">
                <p>Do you want to sign this petition?</p>
                <input type="hidden" name="title" value="<%= p.getTitle() %>">
                <div class="row g-2 align-items-center">
                    <div class="col">
                        <input type="text" name="name" placeholder="Your name" class="form-control" required>
                    </div>
                    <div class="col">
                        <input type="email" name="email" placeholder="Your email" class="form-control" required>
                    </div>
                    <div class="col-auto">
                        <button type="submit" class="btn btn-success">Sign</button>
                    </div>
                </div>
            </form>
        </li>
        <p class="mt-2 mb-0 text-muted small">
            <!---- Message to show how many people have signed the petition already ---->
            <%= p.getSignatures().size() %> people have signed.
        </p>
        <% } %>
    </ul>
    <%
        }
    %>

    <div class="mt-4">
        <a href="/search.html" class="btn btn-success">New Search</a>
        <a href="/" class="btn btn-secondary ms-3">Back to Home</a>
    </div>
</div>

<footer class="footer mt-5 py-4 bg-light text-center">
    <p class="mb-0 text-muted">&copy; 2025 Alexander’s Petitions — All rights reserved.</p>
</footer>
</body>
</html>
