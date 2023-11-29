<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container mt-5">
		<div class="row">
			<div class="col-lg-12 text-center">
				<div class="normal__breadcrumb__text">
					<h2>User Information</h2>
				</div>
			</div>
		</div>
		<div class="row">
			<!-- Phần thông tin người dùng (nửa màn hình) -->
			<div class="col-md-6">
				<form id="formUser">
					<div class="form-group">
						<label for="fullname" class="text-light">Full Name:</label> <input
							type="text" class="form-control" id="fullname"
							value="${user.fullname}">
					</div>
					<div class="form-group">
						<label for="email" class="text-light">Email:</label> <input
							type="email" class="form-control" id="email"
							value="${user.email}">
					</div>
					<div class="form-group">
						<label for="phone" class="text-light">Phone:</label> <input
							type="tel" class="form-control" id="phone"
							value="${user.phone}">
					</div>
					<input type="hidden" id="userId" name="userId" value="${user.id}">
					<input type="hidden" id="roleId" name="roleId" value="${sessionScope.acc.roleId}">
					<button type="submit" class="btn btn-primary">Save</button>
					<c:if test="${sessionScope.acc.roleId == 2}">
						<a href="<c:url value="/admin/movies"/>" class="btn btn-secondary ml-2 text-light">Admin</a>
					</c:if>
				</form>
			</div>

			<!-- Danh sách lịch sử giao dịch (nửa màn hình) -->
			<div class="col-md-6">
				<h2 class="text-light">Payment History</h2>
				<br/>
				<ul class="list-group">
					<c:forEach items="${bookings}" var="booking">
						<li class="list-group-item">Bill ID: ${booking.id}, Total Price: ${booking.totalPrice}
							<a type="button" href="<c:url value="/bookings/${booking.id}?status=${booking.status}"/>" class="btn btn-info btn-sm float-right">Details</a>
						</li>
					</c:forEach>
					<!-- Thêm các mục khác nếu cần -->
				</ul>
			</div>
		</div>

	</div>
	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="<c:url value="/resources/js/api/user.js"/>"></script>
	<script>
	$(document).ready(function() {
	    // Xử lý khi form được nộp (submit)
	    $("#formUser").submit(function(event) {
	        // Ngăn chặn sự kiện mặc định của form
	        event.preventDefault();
	       
	
	        // Lấy dữ liệu từ trường dữ liệu đầu vào 1 và 2
	        var fullname = $("#fullname").val();
	        var email = $("#email").val();
	        var phone = $("#phone").val();
	        var id = $("#userId").val();
	        var roleId = $("#roleId").val();
	        
	        var baseUrl = '${pageContext.request.contextPath}';
	
	        // Tạo đối tượng JSON từ dữ liệu
	        var jsonData = {
	        	id,
				fullname,
				email,
				phone,
				roleId
	        };
	        updateUserAPI(JSON.stringify(jsonData), 1, baseUrl);
	       
	    });
	});
	
   </script>
</body>
</html>