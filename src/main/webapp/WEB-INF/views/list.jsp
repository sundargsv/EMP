<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee List</title>
</head>
<body>

	<h1>Employee List</h1>
	 <div align="center">
		<table border="1">
			<thead>
				<th>#</th>
				<th>ID</th>
				<th>NAME</th>
				<th>DEPARTMENT</th>
			</thead>
			
			<tbody>
				<c:forEach var="employee" items="${ employeeList}" varStatus="status">
					<tr>
						<td>${status.index + 1}</td>
						<td>${employee.id}</td>
						<td>${employee.name}</td>
						<td>${employee.department}</td>
						<td>
							<input type="button"  onclick="location.href='/EMP/view?id=${employee.id}'" value="Show" >
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>