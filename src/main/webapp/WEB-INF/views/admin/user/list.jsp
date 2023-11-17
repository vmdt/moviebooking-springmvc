<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Bảng với JSTL</title>
<style>
table {
	width: 100%;
	border-collapse: collapse;
	border: 1px solid #ccc;
}

th, td {
	border: 1px solid #ccc;
	padding: 8px;
	text-align: center;
}

th {
	background-color: #007BFF;
	color: white;
}

tr:nth-child(even) {
	background-color: #F0F0F0;
}

tr:nth-child(odd) {
	background-color: #E0E0E0;
}

.button-container {
	text-align: right;
}

.action-button {
	margin-left: 10px;
	padding: 5px 10px;
	background-color: #007BFF;
	color: white;
	border: none;
	border-radius: 5px;
}
</style>
<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css"> -->

</head>
<body>
	<div class="main-content">
		<div class="page-content">
			<table border="1">
				<tr>
					<th>ID</th>
					<th>Fullname</th>
					<th>Username</th>
					<th>Email</th>
					<th>Phone</th>
					<th>Status</th>
					<th>Actions</th>
				</tr>
				<c:forEach var="user" items="${users.listUsers}">
					<tr>
						<%-- <td><img src="<c:url value="${movie.thumbnail}" />"
							alt="thumnail" style="width: 150px; height: 180px;"></td> --%>
						<td>${user.id}</td>
						<td>${user.fullname}</td>
						<td>${user.username}</td>
						<td>${user.email}</td>
						<td>${user.phone}</td>
						<td>${user.status}</td>
						<td class="button-container"><a
							href="<c:url value = "/admin/users/manage?id=${user.id}"/>"
							class="action-button">Edit</a>
							<button class="action-button delete-button" id="action-button-${user.id}" data-id="${user.id}">${user.status eq "active" ? "ban":"active"}</button>
					</tr>
				</c:forEach>
			</table>
			<form id="formSubmit" action="<c:url value='/admin/users'/>" method="get">
				<ul class="pagination" id="pagination"></ul>
				<input type="hidden" value="" id="page" name="page"/>
				<input type="hidden" value="" id="limit" name="limit"/>
			</form>
		</div>
	</div>
	
	
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"></script>
<script src="<c:url value="/template/paging/jquery.twbsPagination.js" />" type="text/javascript"></script>
<script src="<c:url value="/resources/js/api/user.js"/>"></script>
	<script>
		$(document)
				.ready(
						function() {
							// Xử lý khi form được nộp (submit)
							$(".delete-button")
									.click(
											function(event) {
												// Ngăn chặn sự kiện mặc định của form
												event.preventDefault();
												var confirmResult = confirm("Bạn có chắc chắn muốn thao tác không?");
												if (confirmResult) {
													var userId = $(this).data(
															"id");
													var action = $(this).html();
													console.log(userId);
													console.log(action);
													actionUser(userId, action, window.location.origin);
												}
											});
						});

		var totalPage = ${users.totalPage};
		var currentPage = ${users.page};
		var limit = ${users.limit};
		
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : totalPage,
				visiblePages : 10,
				startPage: currentPage,
				onPageClick : function(event, page) {
					if (currentPage != page) {
						$('#limit').val(limit);
						$('#page').val(page);
						$('#formSubmit').submit();
					}
				}
			});
		});
	</script>

</body>
</html>


