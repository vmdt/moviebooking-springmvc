<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<section class="normal-breadcrumb set-bg"
		data-setbg="img/normal-breadcrumb.jpg">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<div class="normal__breadcrumb__text">
						<h2>Login</h2>
						<p>Welcome to the official Anime blog.</p>
					</div>
				</div>
			</div>
			
			
			<c:if test="${not empty param.message and param.message eq 'incorrect'}">	
				<div class="row">
					<div class="col-lg-12 text-center">
						<div class="alert alert-danger">
	  						<strong>Login failed!</strong> Incorrect username or password
						</div>
					</div>
				</div>
			</c:if>
			
						<c:if test="${not empty param.message and param.message eq 'banned'}">	
				<div class="row">
					<div class="col-lg-12 text-center">
						<div class="alert alert-danger">
	  						<strong>Login failed!</strong>Your account was banned
						</div>
					</div>
				</div>
			</c:if>

		</div>
	</section>
	<!-- Normal Breadcrumb End -->

	<!-- Login Section Begin -->
	<section class="login spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-6">
					<div class="login__form">
						<h3>Login</h3>
						<form action="/login" name="user" method="post">
							<div class="input__item">
								<input type="text" placeholder="Username" name="username"> <span
									class="icon_mail"></span>
							</div>
							<div class="input__item">
								<input type="password" placeholder="Password" name="password"> <span
									class="icon_lock"></span>
							</div>
							<button type="submit" class="site-btn">Login Now</button>
						</form>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="login__register">
						<h3>Dont’t Have An Account?</h3>
						<a href="/signup" class="primary-btn">Register Now</a>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>