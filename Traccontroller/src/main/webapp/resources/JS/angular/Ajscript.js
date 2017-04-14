var myangu = angular.module('mapsApp', []);
myangu
		.controller(
				'MapCtrl',
				function($scope, $http) {

					this.tab = 1;

					this.setTab = function(tabId) {
						this.tab = tabId;
					};

					this.isSet = function(tabId) {
						return this.tab === tabId;
					};

					var mapOptions = {
						zoom : 5,
						center : new google.maps.LatLng(22.471466666666668,
								88.39954333333333),
						mapTypeId : google.maps.MapTypeId.ROADMAP

					};
					$scope.map = new google.maps.Map(document
							.getElementById('map'), mapOptions);
					$scope.markers = [];
					$scope.astatus = true;

					$http
							.get("/java/position")
							.then(
									function(positionlist) {

										alert(JSON.stringify(positionlist));
										$scope.polist = positionlist.data;

										var positionmark = function(value) {
											// alert(JSON.stringify(value.latitude+"
											// "+value.longitude+"
											// "+value.address));
											var marker = new google.maps.Marker(
													{

														position : new google.maps.LatLng(
																value.latitude,
																value.longitude),
														map : $scope.map,
														title : value.address

													});
											marker.content = '<div class="infoWindowContent">'
													+ value.address + '</div>';

											google.maps.event
													.addListener(
															marker,
															'click',
															function() {
																infoWindow
																		.setContent('<h2>'
																				+ marker.title
																				+ '</h2>'
																				+ marker.content);
																infoWindow
																		.open(
																				$scope.map,
																				marker);
															});
											$scope.markers.push(marker);

										};
										/*
										 * Retrieve Value And Stored it inside a
										 * variable.
										 * 
										 */
										for (var i = 0, len = $scope.polist.length; i < len; i++) {
											var value = $scope.polist[i];
											console.log("welcome" + value);
											positionmark(value);

										}

									});

					$http
							.get("/java/dlist")
							.then(
									function(dlist) {
										alert(JSON.stringify(dlist));
										$scope.delist = dlist.data;

										alert(lsize);
										for (var i = 0, len = $scope.delist.length; i < len; i++) {
											var udlist = $scope.delist[i];
											$scope.devlist = udlist;
										}

									});

				});

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