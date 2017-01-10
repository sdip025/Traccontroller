var cities = [
    {
        city : 'Kolkata',
        desc : 'This is the Funny city in the world!',
        lat : 22.5726,
        long : 88.3639
    },
    {
        city : 'Digha',
        desc : 'This city is sea!',
        lat : 21.6266,
        long : 87.5074
    },
    {
        city : 'Midnapur',
        desc : 'This is city  of forest!',
        lat : 22.4309,
        long : 87.3215
    },
    {
    	city:'Kashmir',
    	desc:'This is the city of Beauty',
    	lat: 33.7782,
    	long:76.5762
    	
    	
    },
    {
    	city:'Mumbai',
    	desc:'This is the Top city of India',
    	lat: 19.0760,
    	long:72.8777
    	
    	
    	
    }
    
];

//Angular App Module and Controller
angular.module('mapsApp', [])
.controller('MapCtrl', function ($scope) {

    var mapOptions = {
        zoom: 4,
        center: new google.maps.LatLng(22.5726, 88.3639),
        mapTypeId: google.maps.MapTypeId.TERRAIN
    }

    $scope.map = new google.maps.Map(document.getElementById('map'), mapOptions);

    $scope.markers = [];
    
    var infoWindow = new google.maps.InfoWindow();
    
    var createMarker = function (info){
        
        var marker = new google.maps.Marker({
            map: $scope.map,
            position: new google.maps.LatLng(info.lat, info.long),
            title: info.city
        });
        marker.content = '<div class="infoWindowContent">' + info.desc + '</div>';
        
        google.maps.event.addListener(marker, 'click', function(){
            infoWindow.setContent('<h2>' + marker.title + '</h2>' + marker.content);
            infoWindow.open($scope.map, marker);
        });
        
        $scope.markers.push(marker);
        
    }  
    
    for (i = 0; i < cities.length; i++){
        createMarker(cities[i]);
    }

    $scope.openInfoWindow = function(e, selectedMarker){
        e.preventDefault();
        google.maps.event.trigger(selectedMarker, 'click');
    }

});