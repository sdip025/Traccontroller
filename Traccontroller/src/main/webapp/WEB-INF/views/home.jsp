<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
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

<link href="<c:url value="/resources/css/map.css" />" rel="stylesheet">

</head>
<body>
	<div id="app1" ng-app="mapsApp" ng-controller="MapCtrl">
		<div id="map"></div>
		<div id="class" ng-repeat="marker in markers | orderBy : 'title'">
			<a href="#" ng-click="openInfoWindow($event, marker)">{{marker.title}}</a>
		</div>
	</div>






</div>


	<form:form action="/java/redirect" method="GET">
		<table style="position: absolute;">
			<tr>
				<td><input type="submit" value="Details Data" /></td>
			</tr>
		</table>
	</form:form>
</html>
