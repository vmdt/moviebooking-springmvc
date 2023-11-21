<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:url var="movieAPI" value="/api/movies" />
<c:url var="rootURL" value="" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
/* CSS cho form */
.form-container {
	width: 300px;
	margin: 0 auto;
}

/* CSS cho input fields */
.form-group {
	margin-bottom: 15px;
}

.form-group label {
	display: block;
	font-weight: bold;
}

.form-group input[type="text"] {
	width: 100%;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
}

/* CSS cho nút submit */
.submit-button {
	background-color: #007BFF;
	color: white;
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}
</style>
</head>
<body>
	<div class="main-content">
		<div class="page-content">
			<div class="form-container">
				<div class="col-xs-6">
					<form name="user" id="formUser">
						<div class="form-group">
							<label for="username">Username:</label> <input type="text"
								id="username" name="username"
								<c:if test="${not empty user.username}">
                		value="${user.username}"
            		</c:if> />
						</div>

						<div class="form-group">
							<label for="email">Email:</label> <input type="text"
								id="email" name="email"
								<c:if test="${not empty user.email}">
                		value="${user.email}"
            		</c:if> />
						</div>
						
						<div class="form-group">
							<label for="phone">Phone:</label> <input type="text"
								id="phone" name="phone"
								<c:if test="${not empty movie.phone}">
                		value="${user.phone}"
            		</c:if> />
						</div>
						
						<div class="form-group">
							<label for="role">Role:</label> <select name="roleId" id="roleId">
								<c:forEach items="${roles}" var="role">
									<c:if test="${user.roleId == role.id}">
										<option value="${user.roleId}" selected="selected">${user.roleName}</option>
									</c:if>
									<c:if test="${user.roleId != role.id}">
										<option value="${role.id}">${role.roleName}</option>
									</c:if>
								</c:forEach>
							</select>
						</div>


						<input type="hidden" id="userId" name="userId"
							value="${user.id}">

						<button type="submit" class="submit-button">Save</button>
					</form>
				</div>
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
	        var username = $("#username").val();
	        var email = $("#email").val();
	        var phone = $("#phone").val();
	        var roleId = $("#roleId").val();
	        var userId = $("#userId").val();
	
	        // Tạo đối tượng JSON từ dữ liệu
	        var jsonData = {
	            username,
	            email,
	            phone,
	            roleId
	        };
	        
	        console.log(jsonData);
	        var baseUrl = '${pageContext.request.contextPath}';

	        if (userId) {
	        	console.log(userId);
	        	jsonData.id = userId;
	            updateUserAPI(JSON.stringify(jsonData), baseUrl);
	        } else {
	        	console.log(window.location.origin);
	            createUserAPI(JSON.stringify(jsonData), baseUrl);
	        }
	       
	    });
	});
	
   </script>
</body>
</html>
