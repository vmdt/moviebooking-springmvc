<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<!-- Hero Section Begin -->
	<section class="hero">
		<div class="container">
			<div class="hero__slider owl-carousel">
				<div class="hero__items set-bg"
					data-setbg="${movies.listMovies[4].thumbnail}">
					<div class="row">
						<div class="col-lg-6">
							<div class="hero__text">
								<div class="label">${movies.listMovies[4].typeName}</div>
								<h2>${movies.listMovies[4].movieName}</h2>
								<a href="<c:url value="/movies/${movies.listMovies[4].id}"/>"><span>Booking Now</span> <i
									class="fa fa-angle-right"></i></a>
							</div>
						</div>
					</div>
				</div>
				<div class="hero__items set-bg"
					data-setbg="${movies.listMovies[1].thumbnail}">
					<div class="row">
						<div class="col-lg-6">
							<div class="hero__text">
								<div class="label">${movies.listMovies[1].typeName}</div>
								<h2>${movies.listMovies[1].movieName}</h2>
								<a href="<c:url value="/movies/${movies.listMovies[1].id}"/>"><span>Booking Now</span> <i
									class="fa fa-angle-right"></i></a>
							</div>
						</div>
					</div>
				</div>
				<div class="hero__items set-bg"
					data-setbg="${movies.listMovies[2].thumbnail}">
					<div class="row">
						<div class="col-lg-6">
							<div class="hero__text">
								<div class="label">${movies.listMovies[2].typeName}</div>
								<h2>${movies.listMovies[2].movieName}</h2>
								<a href="<c:url value="/movies/${movies.listMovies[2].id}"/>"><span>Booking Now</span> <i
									class="fa fa-angle-right"></i></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Hero Section End -->

	<!-- Product Section Begin -->
	<section class="product spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-8">
					<div class="trending__product">
						<div class="row">
							<div class="col-lg-8 col-md-8 col-sm-8">
								<div class="section-title">
									<h4>Now Showing</h4>
								</div>
							</div>
							<div class="col-lg-4 col-md-4 col-sm-4">
								<div class="btn__all"></div>
							</div>
						</div>
						<div class="row">
							<c:forEach var="movie" items="${movies.listMovies}">
								<div class="col-lg-4 col-md-6 col-sm-6">
									<div class="product__item">
										<div class="product__item__pic set-bg"
											data-setbg="${not empty movie.thumbnail ? movie.thumbnail : "https://dummyimage.com/230x325/dee2e6/6c757d.jpg" }">
										</div>
										<div class="product__item__text">
											<h5>
												<a href="<c:url value="/movies/${movie.id}"/>">${movie.movieName}</a>
											</h5>
										</div>
									</div>
								</div> 
							</c:forEach>
						</div>
						<div class="row">
							<div class="col-lg-12">
								<a type="button" class="site-btn" href="<c:url value="/movies-list"/>">View more</a>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</section>
</body>
</html>