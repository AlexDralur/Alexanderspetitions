<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.alexanderspetitions.Petition" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>View Petitions</title>
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
        <%
            for (org.example.alexanderspetitions.Petition p : petitions) {
        %>
        <li class="list-group-item">
            <strong><%= p.getTitle() %></strong><br>
            <%= p.getDescription() %><br><br>

            <form action="/sign-petition" method="post" class="mt-2">
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

            <% if (!p.getSignatures().isEmpty()) { %>
            <p class="mt-2 mb-0 text-muted small">
                <%= p.getSignatures().size() %> people have signed.
            </p>
            <% } %>
        </li>
        <%
            }
        %>
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
