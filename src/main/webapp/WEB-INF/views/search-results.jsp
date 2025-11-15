<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.alexanderspetitions.Petition" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Search Results</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>

<header class="container text-center">
    <div class="row">
        <h1 class="display-1">Search Results</h1>
        <p class="lead">Showing petitions matching your search.</p>
    </div>
</header>

<div class="container text-center my-5">
    <%
        String query = (String) request.getAttribute("query");
        List<Petition> results = (List<Petition>) request.getAttribute("results");

        if (results == null || results.isEmpty()) {
    %>
    <p>No petitions found for "<strong><%= query %></strong>".</p>
    <%
    } else {
    %>
    <ul style="list-style-type: none; padding: 0;">
        <% for (Petition p : results) { %>
        <li style="margin-bottom: 2rem;">
            <h2><%= p.getTitle() %></h2>
            <p><%= p.getDescription() %></p>
        </li>
        <% } %>
    </ul>
    <%
        }
    %>

    <div class="mt-4">
        <a href="/src/main/resources/static/search.html" class="btn btn-success">New Search</a>
        <a href="/" class="btn btn-secondary ms-3">Back to Home</a>
    </div>
</div>

<footer class="footer mt-5 py-4 bg-light text-center">
    <p class="mb-0 text-muted">&copy; 2025 Alexander’s Petitions — All rights reserved.</p>
</footer>
</body>
</html>
