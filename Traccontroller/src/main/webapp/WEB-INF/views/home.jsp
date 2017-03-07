<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="true"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>GPS21 NET INDIA SER.</title>

<script type="text/javascript"
	src="<c:url value="/resources/JS/angular/angular.min.js"/>"></script>
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAAN8QH-4D40wZjFEzXq7yacrFQd_iJdiU&callback=initMap"
	type="text/javascript"></script>
<script type="text/javascript"
	src="<c:url value="/resources/JS/angular/Ajscript.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/JS/angular/devicelist.js"/>"></script>
<link href="<c:url value="/resources/css/home.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/map.css" />" rel="stylesheet">

</head>
<body>
	<div ng-app="mapsApp" ng-controller="MapCtrl as tab">
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
										<p>Account</p>
									</div>
									<div class="divTableCell">Message</div>
									<div class="divTableCell">Change Password</div>
									<div class="divTableCell">
										<a href="${pageContext.request.contextPath}/logout">Logout</a>
									</div>

								</div>
								<div class="divTableRow">
									<div class="divTableCell"></div>


									<div class="container">

										<ul class="nav nav-pills">
											<div class="divTableCell">
												<li ng-class="{active:tab.isSet(1)}"><a href
													ng-click="tab.setTab(1)">Monitor</a></li>
											</div>
											<div class="divTableCell">
												<li ng-class="{active:tab.isSet(2)}"><a href
													ng-click="tab.setTab(2)">Statistics</a></li>
											</div>
											<div class="divTableCell">
												<li ng-class="{active:tab.isSet(3)}"><a href
													ng-click="tab.setTab(3)">More</a></li>
											</div>
										</ul>



									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
		</header>
		<div ng-show="tab.isSet(1)">
			<div class="divT">
				<div class="divTableB">
					<div class="divTableR">
						<div class="divTableCe">

							<div class="divTab">
								<div class="divTB">
									<div class="divTRow">
										<div class="divTCell">
											<a href="javascript:void(0);" ng-click="astatus=false"><%=session.getAttribute("username")%></a>
										</div>
									</div>
									<div class="divTRow">
										<div class="divTCell">
											<!-- <div ng-repeat="dlist in udlist " >
										
										{{dlist.name}}</div> -->

											<div class="section1" ng-show="!astatus">Section 1</div>
										


										</div>
									</div>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
			<div class="dip">
				<div id="map"></div>
				<div id="class" ng-repeat="marker in markers | orderBy : 'title'">
					<a href="#" ng-click="openInfoWindow($event, marker)">{{markerr.title}}</a>
				</div>
			</div>
		</div>



		<div ng-show="tab.isSet(2)">TAB2</div>

		<div ng-show="tab.isSet(3)">
			<h4>Tab 3</h4>
		</div>

	</div>








</body>
</html>
