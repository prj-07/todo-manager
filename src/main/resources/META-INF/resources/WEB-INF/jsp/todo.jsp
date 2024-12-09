<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
<title>TODO PAGE  </title>
</head>
<body>
<%@include file="common/navigation.jspf" %>
<div class = "container">
<h2>WELCOME to todo page  !!</h2>
<h3>your todos are : </h3>
<table class ="table">
<thead>
<tr>


<th>description</th>

<th>target</th>


<th>done ? </th>

<th> delete task</th>>

<th> update task</th>
</tr>
</thead>
<tbody>
<c:forEach items = "${todos}" var = "todos">
<tr>


<td>${todos.description}</td>

<td>${todos.date}</td>


<td>${todos.done}</td>

<td><a href = "delete-todo?id= ${todos.id}" class="btn btn-warning">Delete task</td>


<td><a href = "update-todo?id= ${todos.id}" class="btn btn-success">Update task</td>
</tr>


</c:forEach>
</tbody>
</table>
<a href ="add-todo" class ="btn btn-success">add todo</a>
</div>

<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>