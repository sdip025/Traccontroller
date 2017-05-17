var myangu = angular.module('mapsApp', []);

myangu.controller('MapCtrl', MapController);

function MapController($scope, $http) {

	this.tab = 1;

	this.setTab = function(tabId) {
		this.tab = tabId;
	};

	this.isSet = function(tabId) {
		return this.tab === tabId;
	};

	var map = null;
	var locations = [];
	var icon = "";
	
	initMap();
	
	function initMap() {
		var map = new google.maps.Map(document.getElementById('map'), {
			zoom : 5,
			center : new google.maps.LatLng(22.471466666666668,
					88.39954333333333)

		});

		
		$http
				.get("/java/devicedetails")
				.then(
						function(positionlist) {
							$scope.polist = positionlist.data;
							var dl = [];

							for ( var prop in positionlist.data) {

								var currMarker = positionlist.data[prop];
								dl.push(currMarker[0]);

								var contentString = '<p><b>Name</b>: '
										+ currMarker[0] + '</br>' +

										'<b>Lat</b>: ' + currMarker[1]
										+ '</br>' + '<b>ID</b>: '
										+ currMarker[2] + '</br>'+'<b>Address</b>: '
										+ '<a>Address</a>' + 
										 '</br>' +

										'<b>Speed</b>: ' +'speed'
										+ '</br>' + '<b>Time And Date</b>: '
										 + '</br>'+'<b>Status</b>: '
										+ '<a >Status</a>'
										 + '</br>' +'<b>History</b>: '
										+ '<a href="">PlayBack</a>'
										
										'</p>';

								locations.push({
									latlon : new google.maps.LatLng(
											currMarker[1], currMarker[2]),
									message : new google.maps.InfoWindow({
										content : contentString,
										maxWidth : 320
									}),
									username : currMarker[0],

								});

							}

							$scope.devicelist = dl;
							$scope.itemsLength = Object.keys($scope.devicelist).length;
						
							locations
									.forEach(function(n) {
										console.log(n);
										var marker = new google.maps.Marker({
											position : n.latlon,
											map : map,

											icon : icon,
											title : n.username
										});

										var devicenamee = $scope.devicename;
                                     google.maps.event
												.addListener(
														marker,
														'click',
														function() {
															

															var mapp = new google.maps.Map(
																	document
																			.getElementById('map'),
																	{
																		zoom : 14,
																		center : new google.maps.LatLng(
																				currMarker[1],
																				currMarker[2])

																	});

															var markerr = new google.maps.Marker(
																	{
																		position : n.latlon,
																		map : mapp,

																		icon : icon,
																		title : n.username
																	});

															
															n.message.open(
																	mapp,
																	markerr);
														});
                                 	
        								var abcd= [];
                                     $http.get("/java/sddetails").then(function(perddetails){
         								
         								var perddetails=perddetails.data;
         								for(var dkey in perddetails.data  ){
         									
         									var dprop=perddetails.data[dkey];
         									abcd.push(dprop);
         									
         									
         									
         								}
         								
         								
         							});


										$scope.devicedetails = function(
												devicename) {
										
											for ( var prop in positionlist.data) {
												
												if (prop == devicename) {

													var devicedetails = positionlist.data[prop];

													var dmapp = new google.maps.Map(
															document
																	.getElementById('map'),
															{
																zoom : 16,
																center : new google.maps.LatLng(
																		devicedetails[1],
																		devicedetails[2])

															});
													var permarkerr = new google.maps.Marker(
															{
																position : new google.maps.LatLng(
																		devicedetails[1],
																		devicedetails[2]),
																map : dmapp,

																icon : icon,
																title : devicedetails[0]
															});
													
																										
													var ddetails = '<p><b>Name</b>: '
													+ devicedetails[0] + '</br>' +

													'<b>Lat</b>: ' + devicedetails[1]
													+ '</br>' + '<b>ID</b>: '
													+ devicedetails[2] + '</br>'+'<b>Address</b>: '
													+ '<a>Address</a>' + 
													 '</br>' +

													'<b>Speed</b>: ' +'speed'
													+ '</br>' + '<b>Time And Date</b>: '
													 + '</br>'+'<b>Status</b>: '
													+ '<a >Status</a>'
													 + '</br>' +'<b>History</b>: '
													+ '<a href="">PlayBack</a>'
													
													'</p>';
													

												}
											
												for ( var propp in positionlist.data) {
													
													
													if(propp!=devicename){
														var alldevices = positionlist.data[propp];
													var mmarkerr = new google.maps.Marker(
															{
																position : new google.maps.LatLng(
																		alldevices[1],
																		alldevices[2]),
																map : dmapp,

																icon : icon,
																title : alldevices[0]
															});

												}
												}
										
												var message = new google.maps.InfoWindow(
														{

															content : ddetails,
														});

												message.open(dmapp, permarkerr);
												
											
											}
											;
											
										};

									});

						});

	}
}



myangu.controller('account', [ '$scope', '$http', function($scope, $http) {
	$scope.detailspassword = function() {
		var data = sessionStorage.getItem('username');

		var formData = {
			confirmpassword : $scope.confirmpassword,
			newpassword : $scope.newpassword,
			existedpassword : $scope.existedpassword,
			username : $scope.username
		};

		var error = function(responce) {
			$scope.errormessage = "Unsuccessful";
			console.log("Unsuccessful");
		};
		var submitvalue = function(request) {
			console.log("successful");
			$scope.success = "success";
		};
		$http.post('/java/updatepassword', formData).then(submitvalue, error);
	};
} ]);
