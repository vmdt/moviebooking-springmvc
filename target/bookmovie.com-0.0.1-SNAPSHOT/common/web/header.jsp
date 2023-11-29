<style>
.dropdown {
	overflow-y: scroll;
	max-height: 80px;
}
</style>
<header class="header">
	<div class="container">
		<div class="row">
			<div class="col-lg-2">
				<div class="header__nav">
					<nav class="header__menu mobile-menu">
						<ul>
							<li class="active"><a href="<c:url value="/home"/>">Movie</a></li>
							
						</ul>
					</nav>
				</div>
			</div>
			<div class="col-lg-8">
				<div class="header__right">
					<a href="#" class="search-switch"><span class="icon_search"></span></a>
					<c:if test="${sessionScope.acc != null}">
						<a href="<c:url value="/logout"/>">${sessionScope.acc.fullname} - Logout</a>
						<a href="<c:url value="/users/${sessionScope.acc.id}"/>"><span class="icon_profile"></span></a>
						<input type="hidden" id="userId" name="userId" value="${sessionScope.acc.id}">
					</c:if>
					<c:if test="${sessionScope.acc == null}">
						<a href="<c:url value="/login"/>">Login</a>
						<a href="<c:url value="/login"/>"><span class="icon_profile"></span></a>
					</c:if>
					
					<%-- <a href="#"> <c:if test="${sessionScope.acc != null}">Logout</c:if> --%>
				</div>
			</div>
		</div>
		<div id="mobile-menu-wrap"></div>
	</div>
</header>