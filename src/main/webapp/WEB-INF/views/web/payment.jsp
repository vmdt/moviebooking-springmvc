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
		<div class="payment-process">
			<c:if test="${sessionScope.acc != null}">
				<div class="normal__breadcrumb__text">
					<h2>Payment</h2>
				</div>
				<table class="details">
					<colgroup>
						<col width="50%">
						<col>
					</colgroup>
					<tbody>
						<tr>
							<td><strong>Name: </strong></td>
							<td>${sessionScope.acc.fullname}</td>
						</tr>
						<tr>
							<td><strong>Phone: </strong></td>
							<td>${sessionScope.acc.phone}</td>
						</tr>
						<tr>
							<td><strong>Movie: </strong></td>
							<td>${bookList[0].movieName}</td>
						</tr>
						<tr>
							<td><strong>Showtime: </strong></td>
							<td>${bookList[0].showTiming}</td>
						</tr>
					</tbody>
				</table>
				<div class="seats">
					<table>
						<c:forEach var="book" items="${bookList}">
							<tr>
								<td>${book.seatCode}</td>
								<td>${book.price}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<div class="total">
					<strong>Total:</strong> ${booking.totalPrice}
				</div>
				
				<c:if test="${booking.status eq 'unpaid'}">
					<div class="confirm-payment">
						<button id="cancel">Cancel</button>
						<input type="hidden" id="bookingId" name="bookingId" value="${booking.id}">
						<input type="hidden" id="totalPrice" name="totalPrice" value="${booking.totalPrice}">
						<button id="pay">Pay</button>
					</div>
				</c:if>
				<c:if test="${booking.status eq 'paid'}">
					<div class="confirm-payment">
						<h5 class="text-light">Your booking order has been paid</h5>
					</div>
				</c:if>
				
			</c:if>
			<c:if test="${sessionScope.acc == null}">

				<div class="row">
					<div class="text-center">
						<div class="normal__breadcrumb__text">
							<p>Please Login To Access</p>
							<br/>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="text-center">
						<div class="normal__breadcrumb__text">
							<a type="button" class="site-btn" href="<c:url value="/login"/>">Login</a>
						</div>
					</div>
				</div>
			</c:if>

		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="<c:url value="/resources/js/api/booking.js"/>"></script>
	<script>
	    $("#cancel").click(function(event) {
	        // Ngăn chặn sự kiện mặc định của form
	        event.preventDefault();
	        var bookingId = $("#bookingId").val();
			
	       	deleteBookingAPI(bookingId, window.location.origin);
	        
	    });
	    
	    // Xử lý khi form được nộp (submit)
	    $("#pay").click(function(event) {
	        // Ngăn chặn sự kiện mặc định của form
	        event.preventDefault();
	        var bookingId = $("#bookingId").val();
	        var totalPrice = $("#totalPrice").val();
	        var status = "paid";
	        
	        var jsonData = {
	        		id: bookingId,
	        		status,
	        		totalPrice
	        }
			
	       updateBookingAPI(JSON.stringify(jsonData), window.location.origin);
	        
	    });
	</script>
</body>
</html>