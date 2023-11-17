/**
 * 
 */


function createFeedbackAPI(data, rootURL) {
    // Gọi API bằng Ajax
    $.ajax({
        url: `${rootURL}/api/feedbacks`, // Thay thế bằng URL thực tế của API
        type: "POST", // Hoặc "GET" nếu API sử dụng phương thức GET
        data: data, // Dữ liệu gửi lên API
        contentType: "application/json; charset=utf-8", // Đặt kiểu dữ liệu là JSON
        dataType: "json", // Xác định kiểu dữ liệu trả về từ API
        success: function(response) {
            // Xử lý kết quả trả về từ API ở đây
            window.location.href = `${rootURL}/movies/${response.movieId}?message=success`;
        },
        error: function(jqXHR, textStatus, errorThrown) {
            // Xử lý lỗi ở đây
            window.location.href = `${rootURL}/movies/${JSON.parse(data).movieId}?message=error`;
        }
    });
}

function deleteFeedbackAPI(data, rootURL) {
    // Gọi API bằng Ajax
    $.ajax({
        url: `${rootURL}/api/feedbacks?userId=${data.userId}&movieId=${data.movieId}`, // Thay thế bằng URL thực tế của API
        type: "DELETE", // Hoặc "GET" nếu API sử dụng phương thức GET
        success: function(response) {
            // Xử lý kết quả trả về từ API ở đây
            window.location.href = `${rootURL}/movies/${data.movieId}?message=success`;
        },
        error: function(jqXHR, textStatus, errorThrown) {
            // Xử lý lỗi ở đây
            console.log(errorThrown);
            window.location.href = `${rootURL}/movies/${data.movieId}?message=error`;
        }
    });
}