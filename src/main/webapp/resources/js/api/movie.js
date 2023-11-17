/**
 * 
 */

function createMoiveAPI(data, rootURL) {
     // Gọi API bằng Ajax
     $.ajax({
        url: `${rootURL}/api/movies`, // Thay thế bằng URL thực tế của API
        type: "POST", // Hoặc "GET" nếu API sử dụng phương thức GET
        data: data, // Dữ liệu gửi lên API
        contentType: "application/json; charset=utf-8", // Đặt kiểu dữ liệu là JSON
        dataType: "json", // Xác định kiểu dữ liệu trả về từ API
        success: function(response) {
            // Xử lý kết quả trả về từ API ở đây
            window.location.href = `${rootURL}/admin/movies?message=success`;
        },
        error: function(jqXHR, textStatus, errorThrown) {
            // Xử lý lỗi ở đây
            window.location.href = `${rootURL}/admin/movies?message=error`;
        }
    });
}

function updateMovieAPI(data, rootURL) {
    // Gọi API bằng Ajax
    $.ajax({
        url: `${rootURL}/api/movies`, // Thay thế bằng URL thực tế của API
        type: "PUT", // Hoặc "GET" nếu API sử dụng phương thức GET
        data: data, // Dữ liệu gửi lên API
        contentType: "application/json; charset=utf-8", // Đặt kiểu dữ liệu là JSON
        dataType: "json", // Xác định kiểu dữ liệu trả về từ API
        success: function(response) {
            // Xử lý kết quả trả về từ API ở đây
            window.location.href = `${rootURL}/admin/movies?message=success`;
        },
        error: function(jqXHR, textStatus, errorThrown) {
            // Xử lý lỗi ở đây
            window.location.href = `${rootURL}/admin/movies?message=error`;
        }
    });
}

function deleteMovieAPI(id, rootURL) {
    // Gọi API bằng Ajax
    $.ajax({
        url: `${rootURL}/api/movies/${id}`, // Thay thế bằng URL thực tế của API
        type: "DELETE", 
        success: function(response) {
            // Xử lý kết quả trả về từ API ở đây
            window.location.href = `${rootURL}/admin/movies?message=success`;
        },
        error: function(jqXHR, textStatus, errorThrown) {
            // Xử lý lỗi ở đây
            
            window.location.href = `${rootURL}/admin/movies?message=error`;
        }
    });
}

function uploadAPI(file, rootURL) {
    console.log(rootURL);
    var res;
    $.ajax({
        url: `${rootURL}/api/movies/upload`,
        type: 'POST',
        data: file,
        cache: false,
        contentType: false,
        processData: false,
        dataType: "text",
        success: function(response) {
            var imageContainer = document.getElementById('imageContainer');
	        imageContainer.innerHTML = `<img src="${rootURL + response}" alt="Uploaded Image" style="max-width: 100%;" />`;
            document.getElementById('thumbnail').value = response;
        },
        error: function(error) {
          console.log('Error uploading image:', error);
        }
      });
}

