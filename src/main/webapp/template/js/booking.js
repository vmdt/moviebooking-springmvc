var seats = document.querySelectorAll('.seat');
var countSpan = document.getElementById('count');
var totalSpan = document.getElementById('total');

// Khởi tạo biến để lưu số ghế đã chọn và tổng giá trị
var selectedSeats = 0;
var totalAmount = 0;
var listSelectedId = [];

seats.forEach(function(seat) {
  seat.addEventListener('click', function() {
    // Khi ghế được chọn, kiểm tra xem có lớp "selected" hay không và thay đổi lớp
    seat.classList.toggle('selected');

    var seatId = seat.getAttribute('id');
    // Lấy giá trị của ghế
    var seatPrice = parseInt(seat.getAttribute('price'));
    console.log(seatPrice);
    
    // Tính lại số ghế đã chọn và tổng giá trị
    if (seat.classList.contains('selected')) {
      selectedSeats++;
      totalAmount += seatPrice;
      listSelectedId.push(seatId);
    } else {
      const index = listSelectedId.indexOf(seatId);
      if (index > -1) {
        listSelectedId.splice(index, 1);
      }
      selectedSeats--;
      totalAmount -= seatPrice;
    }

    // Cập nhật nội dung của các phần tử span
    countSpan.textContent = selectedSeats;
    totalSpan.textContent = totalAmount;
    // Cập nhật giá trị của trường ẩn trong biểu mẫu
    document.getElementById('selectedSeats').value = listSelectedId.join(',');
    document.getElementById('totalPrice').value = totalAmount;
  });
});