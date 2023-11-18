<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup</title>
</head>
<body>
	    <!-- Normal Breadcrumb Begin -->
    <section class="normal-breadcrumb set-bg" data-setbg="img/normal-breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="normal__breadcrumb__text">
                        <h2>Sign Up</h2>
                        <p>Welcome to the Movie Booking</p>
                    </div>
                </div>
            </div>
            <c:if test="${not empty param.message and param.message eq 'exist'}">	
				<div class="row">
					<div class="col-lg-12 text-center">
						<div class="alert alert-danger">
	  						<strong>Signup failed!</strong> Username already exists
						</div>
					</div>
				</div>
			</c:if>
        </div>
    </section>
    <!-- Normal Breadcrumb End -->
	 <!-- Signup Section Begin -->
    <section class="signup spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <div class="login__form">
                        <h3>Sign Up</h3>
                        <form action="/signup" name="user" method="post"> 
                            <div class="input__item">
                                <input type="text" placeholder="Username" name="username" required>
                                <span class="icon_mail"></span>
                            </div>
                            <div class="input__item">
                                <input type="text" placeholder="Fullname" name="fullname" required>
                                <span class="icon_profile"></span>
                            </div>
                            <div class="input__item">
                                <input type="text" placeholder="Password" name="password" required>
                                <span class="icon_lock"></span>
                            </div>
                            <button type="submit" class="site-btn">Signup Now</button>
                        </form>
                    </div>
                </div>
                <div class="col-lg-6">
          			<div class="login__register">
						<h3>If You Already Have An Account</h3>
						<a href="/login" class="primary-btn">Login Now</a>
					</div>
                </div>
            </div>
        </div>
    </section>
</body>
</html>