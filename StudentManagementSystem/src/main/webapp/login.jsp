<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet">

</head>

<body class="bg-light">

    <div class="container mt-5">
    <div class="row justify-content-center">
    <div class="col-md-6">
    <div class="card shadow p-4">
    <h3 class="text-center mb-4">Admin Login</h3>
    <form method="post" action="login">
    
    <div class="mb-3">
    <label class="form-label">Email</label>
    <input type="email" name="email" class="form-control" required>
    </div>
    
    <div class="mb-3">
    <label class="form-label">Password</label>
    <input type="password" name="password" class="form-control" required>
    
    </div>
    
    <button type="submit" class="btn btn-primary w-100">Login</button>
    
    
    </form>
    
    <c:if test="${not empty errorMsg }">
    <div class="alert-danger text-center">${errorMsg}</div>
    
    </c:if>
    
    </div>
    
    </div>
    
    </div>

    </div>

</body>
</html>