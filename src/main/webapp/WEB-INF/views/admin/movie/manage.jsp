<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:url var="movieAPI" value="/api/movies" />
<c:url var="rootURL" value="/" />
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
					<form name="movie" id="formMovie">
						<div class="form-group">
							<label for="movieName">Movie name:</label> <input type="text"
								id="movieName" name="movieName"
								<c:if test="${not empty movie.movieName}">
                		value="${movie.movieName}"
            		</c:if> />
						</div>

						<div class="form-group">
							<label for="description">Description:</label> <input type="text"
								id="description" name="description"
								<c:if test="${not empty movie.description}">
                		value="${movie.description}"
            		</c:if> />
						</div>


						<div class="form-group">
							<label for="type">Type:</label> <select name="typeId" id="typeId">
								<c:forEach items="${types}" var="type">
									<c:if test="${movie.typeId == type.id}">
										<option value="${movie.typeId}" selected="selected">${movie.typeName}</option>
									</c:if>
									<c:if test="${movie.typeId != type.id}">
										<option value="${type.id}">${type.typeName}</option>
									</c:if>
								</c:forEach>
							</select>
						</div>

						<div class="form-group">
							<label for="nation">Nation:</label> <select name="nationId"
								id="nationId">
								<c:forEach items="${nations}" var="nation">
									<c:if test="${movie.nationId == nation.id}">
										<option value="${movie.nationId}" selected="selected">${movie.nationName}</option>
									</c:if>
									<c:if test="${movie.nationId != nation.id}">
										<option value="${nation.id}">${nation.nationName}</option>
									</c:if>
								</c:forEach>
							</select>
						</div>

						<div class="form-group">
							<label for="duration">Duration:</label> <input type="number"
								id="duration" name="duration" value="${not empty movie.duration ? movie.duration : 90}" >
						</div>

						<div class="form-group">
							<label for="language">Language:</label> <input type="text"
								id="language" name="language"
								<c:if test="${not empty movie.language}">
                		value="${movie.language}"
            		</c:if> />
						</div>

						<div class="form-group">
							<label for="directors">Directors:</label> <input type="text"
								id="directors" name="directors"
								<c:if test="${not empty movie.directors}">
                		value="${movie.directors}"
            		</c:if> />
						</div>

						<div class="form-group">
							<label for="actors">Actors:</label> <input type="text"
								id="actors" name="actors"
								<c:if test="${not empty movie.actors}">
                		value="${movie.actors}"
            		</c:if> />
						</div>

						<input type="hidden" id="movieId" name="movieId"
							value="${movie.id}">

						<button type="submit" class="submit-button">Save</button>
					</form>
				</div>
				<div class="col-xs-6">
					<div class="form-container">
						<input type="file" id="fileInput" />
						<button onclick="uploadImage()">Upload</button>
						<div id="imageContainer">
							<c:if test="${not empty movie.thumbnail}">
								<img src="<c:url value="${movie.thumbnail}" />" alt="Uploaded Image" style="max-width: 100%;" />
							</c:if>
						</div>
						<input type="hidden" id="thumbnail" name="thumbnail" value="${movie.thumbnail}">
					</div>
				</div>
			</div>
		</div>

	</div>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="<c:url value="/resources/js/api/movie.js"/>"></script>
	<script>
	$(document).ready(function() {
	    // Xử lý khi form được nộp (submit)
	    $("#formMovie").submit(function(event) {
	        // Ngăn chặn sự kiện mặc định của form
	        event.preventDefault();
	       
	
	        // Lấy dữ liệu từ trường dữ liệu đầu vào 1 và 2
	        var movieName = $("#movieName").val();
	        var description = $("#description").val();
	        var typeId = $("#typeId").val();
	        var nationId = $("#nationId").val();
	        var duration = $("#duration").val();
	        var movieId = $("#movieId").val();
	        var thumbnail = $("#thumbnail").val();
	        var directors = $("#directors").val();
	        var actors = $("#actors").val();
	        var language = $("#language").val();
	
	        // Tạo đối tượng JSON từ dữ liệu
	        var jsonData = {
	            movieName,
	            description,
	            typeId,
	            nationId,
	            duration,
	            thumbnail,
	            directors,
	            actors,
	            language
	        };
	        
	        var baseUrl = '${pageContext.request.contextPath}';

	        if (movieId) {
	        	console.log(movieId);
	        	jsonData.id = movieId;
	            updateMovieAPI(JSON.stringify(jsonData), baseUrl);
	        } else {
	            createMoiveAPI(JSON.stringify(jsonData), baseUrl);
	        }
	       
	    });
	});
	
	function uploadImage() {
		  var fileInput = document.getElementById('fileInput');
		  var file = fileInput.files[0];

		  var formData = new FormData();
		  formData.append('file', file);
		  uploadAPI(formData, window.location.origin);	  
		}

   </script>
</body>
</html>
