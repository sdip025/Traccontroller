var myangu = angular.module('mapsApp', []);
myangu.controller(
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
						zoom : 15,
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
										 * Retrive Value And Stored it inside
										 * "Value"
										 */
										for (var i = 0, len = $scope.polist.length; i < len; i++) {
											var value = $scope.polist[i];
											console.log("welcome" + value);
											positionmark(value);

										}

									});
					/*
					 * $http.get("/java/dlist").then(function(dlist) {
					 * alert(JSON.stringify(dlist)); $scope.delist = dlist.data;
					 * for (var i = 0,len = $scope.delist.length; i<len; i++) {
					 * var udlist = $scope.delist[i];
					 *  }
					 * 
					 * });
					 */

				});



/*Change password alert*/
myangu.controller('account', function($scope) {
	
	
	alert($scope)
	$scope.detailspassword=function(){
		
		alert($scope.confirmpassword+""+$scope.newpassword+""+$scope.existedpassword)
	}
	
	
	
	
	
	

});
