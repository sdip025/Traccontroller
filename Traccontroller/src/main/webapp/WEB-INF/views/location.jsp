<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"
	src="<c:url value="/resources/JS/angular/angular.min.js"/>"></script>
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAAN8QH-4D40wZjFEzXq7yacrFQd_iJdiU&callback=initMap"
	type="text/javascript"></script>


<link href="<c:url value="/resources/css/map.css" />" rel="stylesheet">

<title>Show On map</title>
</head>

<body>
<h1>Welcome</h1>
<div id="app1" ng-app="mapsApp" ng-controller="MapCtrl">
    <div id="map"></div>
    <div id="class" ng-repeat="marker in markers | orderBy : 'title'">
         <a href="#" ng-click="openInfoWindow($event, marker)">{{marker.title}}</a>
    </div>
</div>
 <c:forEach items="${latlong}" var="user">

<p id="latt">Lat: ${user.latitude}</p>
<p>Long: ${user.longitude}</p>
</c:forEach>



</body>
</html>