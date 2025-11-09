<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.alexanderspetitions.Petition" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>View Petitions</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container my-5">
    <h1 class="text-center mb-4">All Petitions</h1>

    <%
        List<Petition> petitions = (List<Petition>) request.getAttribute("petitions");
        if (petitions == null || petitions.isEmpty()) {
    %>
    <p class="text-center text-muted">No petitions have been created yet.</p>
    <%
    } else {
    %>
    <ul class="list-group">
        <% for (Petition p : petitions) { %>
        <li class="list-group-item">
            <strong><%= p.getTitle() %></strong><br>
            <%= p.getDescription() %>
        </li>
        <% } %>
    </ul>
    <%
        }
    %>

    <div class="text-center mt-4">
        <a href="/create.html" class="btn btn-success">Create New Petition</a>
        <a href="/" class="btn btn-secondary ms-3">Back to Home</a>
    </div>
</div>
</body>
</html>
