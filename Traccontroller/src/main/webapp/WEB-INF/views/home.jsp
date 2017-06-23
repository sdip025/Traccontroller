<%@page import="com.gps21.model.Changepassword"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="true"%>
<html>
<head>
<script type="text/javascript"
	src="<c:url value="/resources/JS/angular/angular.min.js"/>"></script>
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/angular_material/1.0.0/angular-material.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular-animate.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular-aria.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular-messages.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angular_material/1.0.0/angular-material.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>GPS21 NET INDIA SER.</title>


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular-route.js"></script>
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAAN8QH-4D40wZjFEzXq7yacrFQd_iJdiU"
	type="text/javascript"></script>
<script type="text/javascript"
	src="<c:url value="/resources/JS/angular/Ajscript.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/JS/angular/devicelist.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/JS/angular/home.js"/>"></script>
<link href="<c:url value="/resources/css/home.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/map.css" />" rel="stylesheet">
<script type="text/javascript"
	src="https://formden.com/static/cdn/formden.js"></script>

<!-- Special version of Bootstrap that is isolated to content wrapped in .bootstrap-iso -->
<link rel="stylesheet"
	href="https://formden.com/static/cdn/bootstrap-iso.css" />

<!--Font Awesome (added because you use icons in your prepend/append)-->
<link rel="stylesheet"
	href="https://formden.com/static/cdn/font-awesome/4.4.0/css/font-awesome.min.css" />

<!-- Inline CSS based on choices in "Settings" tab -->
<style>
.bootstrap-iso .formden_header h2,.bootstrap-iso .formden_header p,.bootstrap-iso form
	{
	font-family: Arial, Helvetica, sans-serif;
	color: black
}

.bootstrap-iso form button,.bootstrap-iso form button:hover {
	color: white !important;
}

.asteriskField {
	color: red;
}
</style>
</head>
<body>
	<div ng-app="mapsApp">
		<div ng-controller="MapCtrl as tab">
			<header>
				<div class="divTable1" style="border: 1px solid #000;">
					<div class="divTableBody1">
						<div class="divTableRow1">
							<div class="divTableCell1">
								Welcome
								<%=session.getAttribute("username")%></div>
							<div class="divTableCell2">

								<div class="divTableBody">

									<div class="divTableRow">


										<div class="divTableCell">
											<a href="#!account" ng-click="showme=true"><p>Account</p></a>
										</div>
										<div class="divTableCell">
											<a href="#!message" ng-click="showme=true">Message</a>
										</div>
										<div class="divTableCell">
											<li><a href="#!updatepassword" ng-click="showme=true">Change
													Password</a></li>
										</div>
										<div class="divTableCell">
											<a href="${pageContext.request.contextPath}/logout">Logout</a>
										</div>

									</div>
									<div class="divTableRow">
										<div class="divTableCell"></div>


										<div class="container">


											<div class="divTableCell">
												<ul class="nav nav-pills">
													<li><a href=""   ng-click="showme=false">Monitor</a></li>
												</ul>
											</div>
											<div class="divTableCell">
												<ul class="nav nav-pills">
													<li><a href="#!statistics" ng-click="showme=true">Statistics</a></li>
												</ul>
											</div>
											<div class="divTableCell">
												<ul class="nav nav-pills">
													<li><a href="#!more" ng-click="showme=true">More</a></li>
												</ul>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</header>

			<div>
				<div class="dip" ng-hide="showme" style="width: 100%; height: 100%">
					<div class="divT">
						<div class="divTableB">
							<div class="divTableR">
								<div class="divTableCe">

									<div class="divTab">
										<div class="divTB">
											<div class="divTRow">
												<div class="divTCell">

													<a href="javascript:void(0);"><%=session.getAttribute("username")%>(/{{devicelist.length}})</a>
												</div>
											</div>
											<div class="divTRow">
												<div class="divTCell">


													<div class="section1" ng-repeat="keys in devicelist">
														<a href="" ng-click="selectdevicedetails(keys)">{{keys}}</a>

													</div>
												</div>
											</div>
										</div>
									</div>

								</div>
							</div>
						</div>
					</div>
					<div>{{getaddress}}</div>
					<div class="dip">
						<div id="map"></div>
						<div id="class" ng-repeat="marker in markers | orderBy : 'title'">
							<a href="#" ng-click="openInfoWindow($event, marker)">{{locations.title}}</a>
						</div>
					</div>
				</div>
				<div ng-show="showme">
					<div ng-view></div>
				</div>


			</div>

		</div>
</body>
</html>
