var app = angular.module('mapApp', []);

app.controller('mapCtrl', function ($scope, $http) {

    var mapOptions = {
        zoom: 4,
        center: new google.maps.LatLng(-25.5349952, 125.8554386),
        mapTypeId: google.maps.MapTypeId.ROADMAP
    }

    $scope.map = new google.maps.Map(document.getElementById('map'), mapOptions);

    $scope.markers = [];
    $scope.cities = [];
   
    var infoWindow = new google.maps.InfoWindow();

    $http.get('https://gist.githubusercontent.com/vgrem/dd818d266445f1a653c1/raw/e768daf280bab0791c2c27ae0f3d5952490bc2a5/cities.json').
        success(function (data) {

            $scope.cities = data.countryList;
            $scope.cities.forEach(function(city) {
                createMarker(city);
            });

        
        });

    var createMarker = function(city) {
        var marker = new google.maps.Marker({
            map: $scope.map,
            position: new google.maps.LatLng(city.latitude, city.longitude),
            title: city.city

        });
        marker.content = '<div class="infoWindowContent">' + city.desc + '</div>';

        google.maps.event.addListener(marker, 'click', function() {
            infoWindow.setContent('<h2>' + marker.title + '</h2>' + marker.content);
            infoWindow.open($scope.map, marker);
        });
        
        $scope.markers.push(marker);
    };

    //$scope.openInfoWindow = function (e, selectedMarker) {
    //    e.preventDefault();
    //    google.maps.event.trigger(selectedMarker, 'click');
    //}

});