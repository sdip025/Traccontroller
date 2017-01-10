<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">

.div-table-rowo{
  display:table-row;
  width:100%
  clear:both;
   align:center;
}



</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

    <link rel="stylesheet" href="/maps/documentation/javascript/demos/demos.css">
  </head>
  <body>
    <div id="map"></div>
    <script>
      function initMap() {
        var chicago = {lat: 41.85, lng: -87.65};
        var indianapolis = {lat: 39.79, lng: -86.14};

        var map = new google.maps.Map(document.getElementById('map'), {
          center: chicago,
          scrollwheel: false,
          zoom: 7
        });

        var directionsDisplay = new google.maps.DirectionsRenderer({
          map: map
        });

        // Set destination, origin and travel mode.
        var request = {
          destination: indianapolis,
          origin: chicago,
          travelMode: 'DRIVING'
        };

        // Pass the directions request to the directions service.
        var directionsService = new google.maps.DirectionsService();
        directionsService.route(request, function(response, status) {
          if (status == 'OK') {
            // Display the route on the map.
            directionsDisplay.setDirections(response);
          }
        });
      }

    </script>


</body>
</html>