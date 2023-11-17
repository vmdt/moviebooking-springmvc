<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment</title>
</head>
<body>
	<div class="container">
		<div class="trending__product">
			<div class="row">
				<div class="col-lg-2 col-md-2 col-sm-2">
					<div class="section-title">
						<h4>Categories</h4>
					</div>
				</div>
				<div class="col-lg-2 col-md-2 col-sm-2">
					<select class="form-select" aria-label="Default select example" id="typeId">
					  <option selected value="-1">Categories</option>
					  <c:forEach items="${types}" var="type">
					  		<option value="${type.id}">${type.typeName}</option>
					  </c:forEach>
					</select>
				</div>
				<div class="col-lg-2 col-md-2 col-sm-2">
					<div class="section-title">
						<h4>Nations</h4>
					</div>
				</div>
				<div class="col-lg-2 col-md-2 col-sm-2">
					<select class="form-select" aria-label="Default select example" id="nationId">
					  <option selected value="-1">Nations</option>
					  <c:forEach items="${nations}" var="nation">
					  		<option value="${nation.id}">${nation.nationName}</option>
					  </c:forEach>
					</select>
				</div>
				<div class="col-lg-2 col-md-2 col-sm-2">
					<a id="filter" type="button" class="site-btn" onclick="submitFilter()">Filter</a>
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
									<a href="/movies/${movie.id}">${movie.movieName}</a>
								</h5>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>

			<div class="row">
				<form id="formSubmit" action="<c:url value='/movies-list'/>"
					method="get">
					<ul class="pagination" id="pagination"></ul>
					<input type="hidden" value="" id="page" name="page" /> <input
						type="hidden" value="" id="limit" name="limit" />
				</form>
			</div>

		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script
		src="<c:url value="/template/paging/jquery.twbsPagination.js" />"
		type="text/javascript"></script>

	<script type="text/javascript">
	var totalPage = ${movies.totalPage};
	var currentPage = ${movies.page};
	var limit = ${movies.limit};
	
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
	
    function submitFilter() {
        // Get the selected value from the select box
        var typeId = document.getElementById('typeId').value;
        var nationId = document.getElementById('nationId').value;
        
        console.log(typeId);
        console.log(nationId);
        
        // Set the form action with the selected value as a URL parameter
		 document.getElementById('filter').href = '/movies-list?typeId='+typeId+'&nationId='+nationId;

      }
	</script>

</body>
</html>