var device = angular.module('devicelist', []).controller('devicecontoller',
		function($scope, $http) {

			$http.get("/java/dlist").then(function(dlist) {
				alert(JSON.stringify(dlist));
				$scope.delist = dlist.data;
				for (var i = 0; len = $scope.delist.length; i++) {
					var udlist = $scope.delist[i];

				}

			});

		});