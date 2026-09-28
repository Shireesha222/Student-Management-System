<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Display Student</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
      rel="stylesheet">

<link rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

</head>

<body class="bg-light">

<jsp:include page="navbar.jsp"></jsp:include>

<div class="container-fluid px-0">

<div class="row">

<jsp:include page="side-panel.jsp"></jsp:include>

<div class="col-10 p-4">

<c:if test="${not empty sessionScope.insertMsg }">
<div class="alert">${sessionScope.insertMsg}</div>
<c:remove var="insertMsg" scope="session"/>
</c:if>

<c:if test="${not empty sessionScope.updateMsg }">
<div class="alert">${sessionScope.updateMsg}</div>
<c:remove var="updateMsg" scope="session"/>
</c:if>

<c:if test="${not empty sessionScope.deleteMsg }">
<div class="alert">${sessionScope.deleteMsg}</div>
<c:remove var="deleteMsg" scope="session"/>
</c:if>

<!-- head section -->
<div class="d-flex justify-content-between mb-3">

<h3>Student List</h3>

<a href="#" class="btn btn-primary">
<i class="bi bi-plus-lg"></i> Add Student</a>

</div>

<table class="table table-sm table-hover table-bordered">

<thead>
  <tr>
  <th>Id</th>
  <th>First Name</th>
  <th>Last Name</th>
  <th>Email</th>
  <th>Phone</th>
  <th>Department</th>
  <th>City</th>
  <th class="text-center">Action</th>
</tr>
</thead>
  <tbody>
   <c:choose>
   <c:when test="${not empty requestScope.studentList }">
   <c:forEach var="s" items="${studentList }">
                
 <tr>
    <td>${s.id}</td>
    <td>${s.firstname}</td>
    <td>${s.lastname}</td>
    <td>${s.email}</td>
    <td>${s.phone}</td>
    <td>${s.department}</td>
    <td>${s.city}</td>
    <td class="text-center">
    <!-- edit icon -->
    <a href="EditStudent?id=${s.id }" class="btn btn-sm btn-outline-primary me-1"><i class="bi bi-pencil-square"></i></a>
    
     <!-- delete icon -->
     <a href="DeleteStudent?id=${s.id }" onclick="return confirm('are you sure do you want to delete student?')" class="btn btn-sm btn-outline-danger"><i class="bi bi-trash"></i></a>
     
     </td>
</tr>
                
</c:forEach>
</c:when>
</c:choose>  
</tbody>

 </table>

</div>

</div>

</div>

</body>
</html>