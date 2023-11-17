/**
 * 
 */

function updateUserAPI(data, rootURL) {
    // Gọi API bằng Ajax
    $.ajax({
        url: `${rootURL}/api/users`, // Thay thế bằng URL thực tế của API
        type: "PUT", // Hoặc "GET" nếu API sử dụng phương thức GET
        data: data, // Dữ liệu gửi lên API
        contentType: "application/json; charset=utf-8", // Đặt kiểu dữ liệu là JSON
        dataType: "json", // Xác định kiểu dữ liệu trả về từ API
        success: function(response) {
            // Xử lý kết quả trả về từ API ở đây
            if (response.roleId == 2)
                window.location.href = `${rootURL}/admin/users?message=success`;
            window.location.href = `${rootURL}/users/${response.id}?message=success`;
        },
        error: function(jqXHR, textStatus, errorThrown) {
            // Xử lý lỗi ở đây
            if (data.roleId == 2)
                window.location.href = `${rootURL}/admin/users?message=error`;
            window.location.href = `${rootURL}/users/${data.id}?message=error`;
        }
    });
}

function createUserAPI(data, rootURL) {
    // Gọi API bằng Ajax
    $.ajax({
        url: `${rootURL}/api/users`, // Thay thế bằng URL thực tế của API
        type: "POST", // Hoặc "GET" nếu API sử dụng phương thức GET
        data: data, // Dữ liệu gửi lên API
        contentType: "application/json; charset=utf-8", // Đặt kiểu dữ liệu là JSON
        dataType: "json", // Xác định kiểu dữ liệu trả về từ API
        success: function(response) {
            // Xử lý kết quả trả về từ API ở đây
            window.location.href = `${rootURL}/admin/users?message=success`;
        },
        error: function(jqXHR, textStatus, errorThrown) {
            // Xử lý lỗi ở đây
            window.location.href = `${rootURL}/admin/users?message=error`;
        }
    });
}

function actionUser(id, action, rootURL) {
    console.log(id, action);
    // Gọi API bằng Ajax
    var button = `action-button-${id}`;
    $.ajax({
        url: `${rootURL}/api/users/${id}?action=${action}`, // Thay thế bằng URL thực tế của API
        type: "PATCH", // Hoặc "GET" nếu API sử dụng phương thức GET
        dataType: "json", // Xác định kiểu dữ liệu trả về từ API
        success: function(response) {
            // Xử lý kết quả trả về từ API ở đây
            window.location.href = `${rootURL}/admin/users?message=success`;
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.log(errorThrown);
            // Xử lý lỗi ở đây
            window.location.href = `${rootURL}/admin/users?message=error`;
        }
    });
}