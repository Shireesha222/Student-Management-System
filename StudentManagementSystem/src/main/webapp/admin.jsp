<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Page</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
      rel="stylesheet">
<link rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>

<body class="bg-light">

<jsp:include page="navbar.jsp"></jsp:include>

<div class="container-fluid">
    <div class="row">

<jsp:include page="side-panel.jsp"></jsp:include>
<div class="col p-4">
<!-- heading section -->
<div class="mb-4">
<h3 class="text-center">Admin Profile</h3>

</div>
<!-- admin profilr card -->
<div class="row justify-content-center">
<div class="col-8">
<div class="card shadow bg-success-subtle">
<div class="card-body text-center p-4">
<img src="https://cdn-icons-png.flaticon.com/512/9131/9131529.png"
class="rounded-circle img-fluid mb-3" width="110" alt=Admin Profile"> 
<h3 class="mb-1">${admin.userName }</h3>
<p class="mb-3">Administrator</p>

<!-- admin details -->
<div class="list-group list-group-flush text-start p-4">
<div class="list-group-item d-flex justify-content-between">
<span class="fw-semibold">ID</span>
<span>${admin.id}</span>

</div>

<div class="list-group-item d-flex justify-content-between">
<span class="fw-semibold">Email</span>
<span>${admin.email}</span>

</div>

<div class="list-group-item d-flex justify-content-between">
<span class="fw-semibold">Password</span>
<span>********</span>

</div>


</div>


</div>
</div>

</div>

</div>

</div>

    </div>
</div>

</body>
</html>