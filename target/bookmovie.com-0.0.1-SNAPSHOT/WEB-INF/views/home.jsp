<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>My Homepage</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/homepage.css"/>" />
</head>
<body>
	<c:if test="${sessionScope.acc != null}">
		<h1>Có acc</h1>
	</c:if>
</body>
</html>