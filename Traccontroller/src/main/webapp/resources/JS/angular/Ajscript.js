var myangu = angular.module('mapsApp', []).controller(
		'MapCtrl',
		function($scope, $http) {

			var mapOptions = {
				zoom : 4,
				center : new google.maps.LatLng(22.5726, 88.3639),
				mapTypeId : google.maps.MapTypeId.ROADMAP

			};

			$http.get("/java/position").then(
					function(positionlist) {
						$scope.polist = null;
						alert(JSON.stringify(positionlist));
						$scope.polist = positionlist.data;
						alert(JSON.stringify(positionlist.latitude));

						console.log($scope.polist.length);
						$scope.map = new google.maps.Map(document
								.getElementById('map'), mapOptions);

						angular.forEach($scope.polist, function(value) {

							var mylatlng = new google.maps.LatLng({
								
								lat : value.latitude,
								lng : value.longitude,
								title : value.address

							});

							
							console.log(mylatlng);
						});
						
						 
					    

						function mker(mylatlng) {
							

							var marker = new google.maps.Marker({
								position : mylatlng,
								map : $scope.map,
								title : 'welcome'

							});

						}

					});

		});
