<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="description" content="Anime Template">
<meta name="keywords" content="Anime, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Anime | Template</title>

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Oswald:wght@300;400;500;600;700&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Mulish:wght@300;400;500;600;700;800;900&display=swap"
	rel="stylesheet">

<!-- Css Styles -->
<link rel="stylesheet"
	href="<c:url value = "/resources/css/seat/booking.css"/>"
	type="text/css">
<link rel="stylesheet"
	href="<c:url value = "/resources/css/seat/bootstrap.min.css"/>"
	type="text/css">
<link rel="stylesheet"
	href="<c:url value = "/resources/css/seat/font-awesome.min.css"/>"
	type="text/css">
<link rel="stylesheet"
	href="<c:url value = "/resources/css/seat/elegant-icons.css"/>"
	type="text/css">
<link rel="stylesheet"
	href="<c:url value = "/resources/css/seat/plyr.css"/>" type="text/css">
<link rel="stylesheet"
	href="<c:url value = "/resources/css/seat/nice-select.css"/>"
	type="text/css">
<link rel="stylesheet"
	href="<c:url value = "/resources/css/seat/owl.carousel.min.css"/>"
	type="text/css">
<link rel="stylesheet"
	href="<c:url value = "/resources/css/seat/slicknav.min.css"/>"
	type="text/css">
<link rel="stylesheet"
	href="<c:url value = "/resources/css/seat/style.css"/>" type="text/css">

<style>
	.action-button {
            margin-left: 10px;
            padding: 5px 10px;
            background-color: #007BFF;
            color: white;
            border: none;
            border-radius: 5px;
        }
</style>

</head>
<body>
	<c:set var="available" value="available" />
	<div class="booking-process">
		<div class="screen set-bg" data-setbg="./hack/img/bg-screen.png"></div>

		<div class="rows">
			<c:forEach var="seat" items="${seats}">
				<div class="seat" id="${seat.id}"
					<c:if test = "${seat.status ne available}">
         				style="background-color: lightgray; pointer-events: none;" disabled
      				</c:if>>${seat.seatCode}</div>
			</c:forEach>
			<!-- <div class="seat">A1</div>
			<div class="seat">A2</div>
			<div class="seat">A3</div>
			<div class="seat">A4</div>
			<div class="seat">A5</div>
			<div class="seat">A6</div>
			<div class="seat">A7</div>
			<div class="seat">A8</div>
			<div class="seat">A9</div>
			<div class="seat">A10</div>
			<div class="seat">A11</div>
			<div class="seat">A12</div> -->
		</div>
		<!-- 
		<div class="rows">
			<div class="seat">B1</div>
			<div class="seat">B2</div>
			<div class="seat">B3</div>
			<div class="seat">B4</div>
			<div class="seat">B5</div>
			<div class="seat">B6</div>
			<div class="seat">B7</div>
			<div class="seat">B8</div>
			<div class="seat">B9</div>
			<div class="seat">B10</div>
			<div class="seat">B11</div>
			<div class="seat">B12</div>
		</div> -->
	</div>
	
	<div class="bottom-content">
        <div class="booking-info"> 
          <ul >
            <li class="item first">
              <div class="movie-detail">
                <table class="info">
                  <tbody>
                    <tr>
                      <td> 
                        <img src="https://ocwckgy6c1obj.vcdn.cloud/media/catalog/product/cache/1/thumbnail/dc33889b0f8b5da88052ef70de32f1cb/7/0/700x1000_13_1_.jpg" alt="NGƯỜI VỢ CUỐI CÙNG">
                      </td>
                      <td>
                        <table class="movie-content">
                          <tbody>
                            <tr>
                              <td class="label-movie"> NGUOI VO CUOI CUNG </td>
                            </tr>
                            <tr>
                              <td class="label-movie"> 2D</td>
                            </tr>
                            <tr>
                              <td class="label-movie"> T18</td>
                            </tr>
                          </tbody>
                        </table>
                      </td>
                    </tr>
                  </tbody>
                </table> 
              </div>
            </li>
            <li class="item">
              <div class="movie-detail">
                <table class="info">
                  <tbody>
                    <tr>
                      <td class="label-movie">Location: </td>
                      <td>location1</td>
                    </tr>
                    <tr>
                      <td class="label-movie">Room: </td>
                      <td>room1</td>
                    </tr>
                    <tr>    
                      <td class="label-movie">Showtime: </td>
                      <td>17:00 23/11/2023</td>
                    </tr>
                    <tr>
                      <td class="label-movie">seat(s): </td>
                      <td><span id="count">0</span></td>
                    </tr>
                  </tbody>
                </table>
              </div>

            </li>
			<li class="item">
                <div class="movie-detail">
                    <c:forEach var="showTime" items="${times}">
						<a href="<c:url value = "/movies/${movie.id}/seats?timeId=${showTime.id}"/>" type="action-button">${showTime.time}</a>
						<!-- <button href="<c:url value = "/movies/${seats[0].movieId}/seats?timeId=${showTime.id}"/>">${showTime.time}</button> -->
					</c:forEach>
                </div>

				<div class="movie-detail">
                    <form method="post" action="your-action-url">
                        <!-- ... Các trường khác của biểu mẫu ... -->
                        <input type="hidden" id="selectedSeats" name="selectedSeats" value="">
                        <button type="submit">Book</button>
                    </form>
                </div>

            </li>
          </ul>
        </div>
      </div>

	  

	<!-- Js Plugins -->
	<script src="<c:url value = "/resources/js/seat/booking.js"/>"></script>
	<script src="<c:url value = "/resources/js/seat/jquery-3.3.1.min.js"/>"></script>
	<script src="<c:url value = "/resources/js/seat/bootstrap.min.js"/>"></script>
	<script src="<c:url value = "/resources/js/seat/player.js"/>"></script>
	<script
		src="<c:url value = "/resources/js/seat/jquery.nice-select.min.js"/>"></script>
	<script src="<c:url value = "/resources/js/seat/mixitup.min.js"/>"></script>
	<script src="<c:url value = "/resources/js/seat/jquery.slicknav.js"/>"></script>
	<script src="<c:url value = "/resources/js/seat/owl.carousel.min.js"/>"></script>
	<script src="<c:url value = "/resources/js/seat/main.js"/>"></script>
</body>
</html>