<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="breadcrumb-option">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="breadcrumb__links">
						<a href="<c:url value="/home"/>"><i class="fa fa-home"></i> Home</a> <a
							href="<c:url value="/movies-list"/>">Movies</a> <span>${movie.typeName}</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Breadcrumb End -->

	<!-- Anime Section Begin -->
	<section class="anime-details spad">
		<div class="container">
			<div class="anime__details__content">
				<div class="row">
					<div class="col-lg-3">
						<div class="anime__details__pic set-bg"
							data-setbg="${not empty movie.thumbnail ? movie.thumbnail : "https://dummyimage.com/230x325/dee2e6/6c757d.jpg" }">
						</div>
					</div>
					<div class="col-lg-9">
						<div class="anime__details__text">
							<div class="anime__details__title">
								<h3>${movie.movieName }</h3>
								<span>${movie.directors }</span>
							</div>
							<div class="anime__details__rating"></div>
							<p>${movie.description}</p>
							<div class="anime__details__widget">
								<div class="row">
									<div class="col-lg-6 col-md-6">
										<ul>
											<li><span>Type:</span>${movie.typeName }</li>
											<li><span>Actors:</span>${movie.actors }</li>
											<li><span>Nation:</span>${movie.nationName }</li>
											<li><span>Language:</span>${movie.language }</li>
											<li><span>Duration:</span>${movie.duration } minutes</li>
										</ul>
									</div>
								</div>
							</div>
							<div class="anime__details__btn">
								<a href="https://www.youtube.com/watch?v=ygvNCEbMusE"
									class="follow-btn"><i></i> trailer</a> <a
									href="<c:url value="/movies/${movie.id}/seats"/>" class="watch-btn"><span>book
										Now</span> <i class="fa fa-angle-right"></i></a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-8 col-md-8">
					<div class="anime__details__review">
						<div class="section-title">
							<h5>Reviews</h5>
						</div>
						<c:forEach var="feedback" items="${feedbacks}">
							<div class="anime__review__item">
								<div class="anime__review__item__text">
									<h6>${feedback.fullname}</h6>
									<p>${feedback.content}</p>
<%-- 									<input type="hidden" id="contentEdit" value="${feedback.content}"> --%>
									<c:if test="${sessionScope.acc.id == feedback.userId}">
<!-- 										<li class="list-inline-item">
											<button class="btn btn-success btn-sm rounded-0"
												id="editFeedback" type="button" data-toggle="tooltip"
												data-placement="top" title="Edit">
												<i class="fa fa-edit"></i>
											</button>
										</li> -->
										<li class="list-inline-item">
											<button class="btn btn-danger btn-sm rounded-0"
												id="deleteFeedback" type="button" data-toggle="tooltip"
												data-placement="top" title="Delete">
												<i class="fa fa-trash"></i>
											</button>
										</li>
									</c:if>
								</div>
							</div>
						</c:forEach>
					</div>
					<div class="anime__details__form">
						<div class="section-title">
							<h5>Your Comment</h5>
						</div>
						<form id="formFeedback">
							<textarea placeholder="Your Comment" id="content"></textarea>
							<input type="hidden" id="userId" name="userId"
								value="${sessionScope.acc.id}"> <input type="hidden"
								id="movieId" name="movieId" value="${movie.id}">
							<button type="submit">
								<i class="fa fa-location-arrow"></i> Review
							</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="<c:url value="/resources/js/api/feedback.js"/>"></script>
	<script>
	$(document).ready(function() {
	    // Xử lý khi form được nộp (submit)
	    $("#formFeedback").submit(function(event) {
	        // Ngăn chặn sự kiện mặc định của form
	        event.preventDefault();
	       
	
	        // Lấy dữ liệu từ trường dữ liệu đầu vào 1 và 2
	        var userId = $("#userId").val();
	        var movieId = $("#movieId").val();
	        var content = $("#content").val();
	
	        // Tạo đối tượng JSON từ dữ liệu
	        var jsonData = {
				userId,
				movieId,
				content
	        };
	        
	        if (!userId) {
	        	window.location.href = window.location.origin + "/login";
	        } else {	        	
	        	createFeedbackAPI(JSON.stringify(jsonData), window.location.origin);
	        }

	       
	    });
	    
	    // Xử lý khi form được nộp (submit)
	    $("#deleteFeedback").click(function(event) {
	        // Ngăn chặn sự kiện mặc định của form
	        event.preventDefault();
	       
	
	        // Lấy dữ liệu từ trường dữ liệu đầu vào 1 và 2
	        var userId = $("#userId").val();
	        var movieId = $("#movieId").val();
	
	        // Tạo đối tượng JSON từ dữ liệu
	        var jsonData = {
				userId,
				movieId
	        };
	        
	        if (!userId) {
	        	window.location.href = window.location.origin + "/login";
	        } else {	        	
	        	deleteFeedbackAPI(jsonData, window.location.origin);
	        }

	       
	    });
	    
/* 	    // Xử lý khi form được nộp (submit)
	    $("#editFeedback").click(function(event) {
	    	var content = $("#contentEdit").val();
	    	
			document.getElementById("content").value = content; 
	       
	    }); */
	    
	});
	</script>
</body>
</html>