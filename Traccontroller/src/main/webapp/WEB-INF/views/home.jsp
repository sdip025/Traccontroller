<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>GPS21 NET INDIA SER.</title>
 <script  src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAAN8QH-4D40wZjFEzXq7yacrFQd_iJdiU&callback=initMap" type="text/javascript"></script>
  
     
<script>
var map;
function initialize() {
  var mapOptions = {
    zoom: 8,
    center: new google.maps.LatLng(22.473613646596526,88.4000322222732)
  };
  map = new google.maps.Map(document.getElementById('map-canvas'),
      mapOptions);
}

google.maps.event.addDomListener(window, 'load', initialize);
</script>
</head>
<body>
<h1>Welcome</h1>
 <div id="map-canvas" style="height:600px; width:900px"></div>
</body>
</html>
