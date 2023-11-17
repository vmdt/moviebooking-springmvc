<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Chi tiết hóa đơn đặt vé xem phim</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }

        .invoice {
            width: 400px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }

        .header {
            text-align: center;
        }

        .header h1 {
            font-size: 24px;
        }

        .details {
            margin-top: 20px;
        }

        .details p {
            margin: 10px 0;
        }

        .table {
            margin-top: 20px;
            border-collapse: collapse;
            width: 100%;
        }

        .table th, .table td {
            border: 1px solid #ccc;
            padding: 8px;
            text-align: left;
        }

        .table th {
            background-color: #f2f2f2;
        }

        .total {
            margin-top: 20px;
            text-align: right;
        }

        .buttons {
            margin-top: 20px;
            text-align: center;
        }

        .buttons button {
            margin: 0 10px;
            padding: 10px 20px;
            background-color: #333;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div class="invoice">
        <div class="header">
            <h1>Chi tiết hóa đơn đặt vé xem phim</h1>
        </div>
        <div class="details">
            <p><strong>Name:</strong> Tên khách hàng</p>
            <p><strong>Phone:</strong> SĐT khách hàng</p>
            <p><strong>Movie:</strong> Tên phim</p>
            <p><strong>Show timing:</strong> 7h00 PM</p>
        </div>
        <table class="table">
            <tr>
                <th>Seats</th>
                <th>Price</th>
            </tr>
            <tr>
                <td>A1</td>
                <td>50000VND</td>
            </tr>
            <tr>
                <td>A2</td>
                <td>50000VND</td>
            </tr>
        </table>
        <div class="total">
            <p><strong>Total:</strong> 100000VND</p>
        </div>
        <div class="buttons">
            <button type="button" id="thanhToan">Thanh Toán</button>
            <button type="button" id="huyBo">Hủy Bỏ</button>
        </div>
    </div>
</body>
</html>
