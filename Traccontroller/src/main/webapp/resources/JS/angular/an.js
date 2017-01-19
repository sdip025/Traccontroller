
var myapp=angular.module('mposition',[])
                  .controller('cposition',["$scope","$http",function(s,h){
                	  
                h.get("/java/position").then(function(response)	  
                {
                	//alert(JSON.stringify(response))
                	s.polist=response.data;
                	
                	
                }
                 ) }]);



var app = angular.module('mapApp', []);

app.controller('mapCtrl', function ($scope, $http) {

    $http.get('/java/position').
        then(function (responce) {
        	alert(JSON.stringify(responce.data))
            $scope.cities =responce.data;
        });
    
    var mapsettings={
    		
    		center:new googles.maps.LatLng(22.474121666666665,88.39709333333333),
    		zoom:4,
    		mapTypeId:gooles.maps.MapTypeId.ROADMAP
    		
    		
    }
    
    
    $scope.map=new google.map.Map(docment.getElementById("map"),mapsettings);
    

});


