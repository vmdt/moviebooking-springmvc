<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Anime Template">
    <meta name="keywords" content="Anime, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Mulish:wght@300;400;500;600;700;800;900&display=swap"
    rel="stylesheet">

    <!-- Css Styles -->
    <link href="${pageContext.request.contextPath}/template/css/booking.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/template/css/payment.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/template/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/template/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/template/css/elegant-icons.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/template/css/plyr.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/template/css/nice-select.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/template/css/owl.carousel.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/template/css/slicknav.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/template/css/style.css" rel="stylesheet" type="text/css">
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

   <!-- Navigation -->
	<%@ include file="/common/web/header.jsp" %>
	
	<dec:body/>
		
	<!-- Footer -->
	<%@ include file="/common/web/footer.jsp" %>
   

  <!-- Search model Begin -->
  <div class="search-model">
    <div class="h-100 d-flex align-items-center justify-content-center">
        <div class="search-close-switch"><i class="icon_close"></i></div>
        <form class="search-model-form">
            <input type="text" id="search-input" placeholder="Search here.....">
            <a hidden id="searchHref"></a>
        </form>
    </div>
</div>
<!-- Search model end -->

<!-- Js Plugins -->
<script src="${pageContext.request.contextPath}/template/js/booking.js"></script>
<script src="${pageContext.request.contextPath}/template/js/payment.js"></script>
<%-- <script src="${pageContext.request.contextPath}/template/js/jquery-3.3.1.min.js"></script> --%>
<script src="${pageContext.request.contextPath}/template/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/template/js/player.js"></script>
<script src="${pageContext.request.contextPath}/template/js/jquery.nice-select.min.js"></script>
<script src="${pageContext.request.contextPath}/template/js/mixitup.min.js"></script>
<script src="${pageContext.request.contextPath}/template/js/jquery.slicknav.js"></script>
<script src="${pageContext.request.contextPath}/template/js/owl.carousel.min.js"></script>
<script src="${pageContext.request.contextPath}/template/js/main.js"></script>
<script src="${pageContext.request.contextPath}/template/paging/jquery.twbsPagination.js"></script>

<script type="text/javascript">
	var input = document.getElementById("search-input");
	input.addEventListener("keypress", function(event) {
		if (event.key === 'Enter') {
		    event.preventDefault();
		    var query = input.value;
		    console.log(query);
		    document.getElementById("searchHref").href = window.location.origin + "/movies-list?q=" + query;
		    document.getElementById("searchHref").click();
		}
	});
</script>

</body>

</html>