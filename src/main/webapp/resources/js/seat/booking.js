var seats = document.querySelectorAll('.seat');
var countSpan = document.getElementById('count');

// Khởi tạo biến để lưu số ghế đã chọn và tổng giá trị
var selectedSeats = 0;
var listSelectedId = [];

seats.forEach(function(seat) {
  seat.addEventListener('click', function() {
    // Khi ghế được chọn, kiểm tra xem có lớp "selected" hay không và thay đổi lớp
    seat.classList.toggle('selected');
    var seatId = seat.getAttribute('id');

    // Tính lại số ghế đã chọn và tổng giá trị
    if (seat.classList.contains('selected')) {
      selectedSeats++;
      listSelectedId.push(seatId);
    } else {
      const index = listSelectedId.indexOf(seatId);
      if (index > -1) {
        listSelectedId.splice(index, 1);
      }
      selectedSeats--;
    }

   // Cập nhật nội dung của các phần tử span
    countSpan.textContent = selectedSeats;
    // Cập nhật giá trị của trường ẩn trong biểu mẫu
    document.getElementById('selectedSeats').value = listSelectedId.join(',');

  });
});
