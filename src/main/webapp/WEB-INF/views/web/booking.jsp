<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking</title>
</head>
<body>
	<div class="container">
		<div class="booking-process">
			<div class="screen set-bg"
				data-setbg="<c:url value='/template/hack/img/bg-screen.png'/>"></div>
					<c:set var="available" value="available" />
	      			<c:forEach items="${seats}" var="seat" varStatus="loop">
	      				<c:if test="${loop.index % 12 == 0 }">
	      					<div class = "rows">
	      				</c:if>
						<div class="seat" id="${seat.id}" price="${seat.price}"
							<c:if test = "${seat.status ne available}">
		         				style="background-color: lightgray; pointer-events: none;" disabled
		      				</c:if>>${seat.seatCode}</div>
						<c:if test="${loop.index % 12 == 11 }">
	      					</div>
	      				</c:if>
	      				<c:if test="${loop.index == seatTotal-1 }">
	      					</div>
	      				</c:if>
	      			</c:forEach>
				</div>
				
			<div class="bottom-content">
				<a class="btn-left" href="/movies/${movie.id}" title="Previous">Previous</a>
				<div class="booking-info">
					<ul>
						<li class="item first">
							<div class="movie-detail">
								<table class="info">
									<tbody>
										<tr>
											<td><img
												src="<c:url value="${movie.thumbnail}" />"
												alt="${movie.movieName}"></td>
											<td>
												<table class="movie-content">
													<tbody>
														<tr>
															<td>${movie.movieName}</td>
														</tr>
														<tr>
															<td>${movie.duration} minutes</td>
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
								<c:forEach var="showTime" items="${times}">
									<a
										href="<c:url value = "/movies/${movie.id}/seats?timeId=${showTime.id}"/>"
										type="action-button">${showTime.time}</a>
									<!-- <button href="<c:url value = "/movies/${seats[0].movieId}/seats?timeId=${showTime.id}"/>">${showTime.time}</button> -->
								</c:forEach>
							</div>
						</li>
						<li class="item">
							<div class="movie-detail">
								<table class="info">
									<colgroup>
										<col width="30%">
									</colgroup>
									<tr>
										<td>Seat(s):</td>
										<td><span id="count">0</span></td>
									</tr>
									<tr>
										<td>Price:</td>
										<td><span id="total"> 0,00 ₫</span></td>
										<input type="hidden" id="totalPrice" name="totalPrice" value="">
									</tr>
								</table>
							</div>
						</li>
					</ul>
				</div>
				<button class="btn-right" title="Tiếp theo" type="submit">Book</button>
			        <form id="form-booking">
	                      <input type="hidden" id="selectedSeats" name="selectedSeats" value="">
	                 </form>
			</div>
		</div>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="<c:url value="/resources/js/api/booking.js"/>"></script>
	<script>
		$(document).ready(function() {
		    // Xử lý khi form được nộp (submit)
		    $(".btn-right").click(function(event) {
		        // Ngăn chặn sự kiện mặc định của form
		        event.preventDefault();
		        var seatIds = $("#selectedSeats").val().split(",");
		        var totalPrice = $("#totalPrice").val();
		        var userId = $("#userId").val();
		        
		        console.log(userId);
		        
		        if (userId) {
			        var data = {
			        		userId,
			        		totalPrice,
			        		seatIds
			        }
		        	createBookingAPI(JSON.stringify(data), window.location.origin);
		        } else {
		        	window.location.href = "/login";
		        }
		        	
		      
		    });
		});
	</script>
</body>
</html>