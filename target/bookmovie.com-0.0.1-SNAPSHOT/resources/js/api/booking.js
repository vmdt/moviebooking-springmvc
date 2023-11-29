function createBookingAPI(data, rootURL) {
    // Gọi API bằng Ajax
    console.log(data);
    $.ajax({
       url: `${rootURL}/api/bookings`, // Thay thế bằng URL thực tế của API
       type: "POST", // Hoặc "GET" nếu API sử dụng phương thức GET
       data: data, // Dữ liệu gửi lên API
       contentType: "application/json; charset=utf-8", // Đặt kiểu dữ liệu là JSON
       dataType: "json", // Xác định kiểu dữ liệu trả về từ API
       success: function(response) {
           // Xử lý kết quả trả về từ API ở đây
           window.location.href = `${rootURL}/bookings/${response.id}?status=${response.status}`;
       },
       error: function(jqXHR, textStatus, errorThrown) {
           // Xử lý lỗi ở đây
           console.log(window.location.url);
           console.log(errorThrown);
           // window.location.href = `${rootURL}/moives?message=error`;
       }
   });
}

function updateBookingAPI(data, rootURL) {
        // Gọi API bằng Ajax
        console.log(data);
        $.ajax({
           url: `${rootURL}/api/bookings`, // Thay thế bằng URL thực tế của API
           type: "PUT", // Hoặc "GET" nếu API sử dụng phương thức GET
           data: data, // Dữ liệu gửi lên API
           contentType: "application/json; charset=utf-8", // Đặt kiểu dữ liệu là JSON
           dataType: "json", // Xác định kiểu dữ liệu trả về từ API
           success: function(response) {
               // Xử lý kết quả trả về từ API ở đây
               window.location.href = `${rootURL}/bookings/${response.id}?status=${response.status}`;
           },
           error: function(jqXHR, textStatus, errorThrown) {
               // Xử lý lỗi ở đây
               console.log(window.location.url);
               console.log(errorThrown);
               // window.location.href = `${rootURL}/moives?message=error`;
           }
       });
}


function deleteBookingAPI(id, rootURL) {

    $.ajax({
       url: `${rootURL}/api/bookings/${id}`, // Thay thế bằng URL thực tế của API
       type: "DELETE", // Hoặc "GET" nếu API sử dụng phương thức GET
       success: function(response) {
           // Xử lý kết quả trả về từ API ở đây
           window.location.href = `${rootURL}/home`;
       },
       error: function(jqXHR, textStatus, errorThrown) {
           // Xử lý lỗi ở đây
           console.log(window.location.url);
           console.log(errorThrown);
           // window.location.href = `${rootURL}/moives?message=error`;
       }
   });
}
