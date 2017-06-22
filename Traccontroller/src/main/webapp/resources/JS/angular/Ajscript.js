var myangu = angular.module('mapsApp',
		[ 'ngMaterial', 'ngMessages', 'ngRoute' ]);


//factory to share controller data
myangu.factory('fdevicelist',function(){
	
	var address='';
	
	var dname=[];
	return dname;
	return address;
	
});



myangu.controller('MapCtrl', MapController);

function MapController($scope, $http,fdevicelist) {


	var lastInfoWindow = null;
	var preInfoWindow = null;
	var clickmap;

	var dl = [];// list of device.
	/* Google Map */
	$scope.date = new Date();
	var gmap = new google.maps.Map(document.getElementById('map'), {
		zoom : 5,
		center : new google.maps.LatLng({
			lat : 22.471466666666668,
			lng : 88.39954333333333
		}),

		mapTypeId : google.maps.MapTypeId.ROADMAP
	});
	// Infowindow
	var info = new google.maps.InfoWindow({
		content : ''
	});
	;

	/* Marker with infowindow */

	var markerpositions = function(dtitle, lat, long) {

		this.infowindow = new google.maps.InfoWindow({
			content : ''
		});
		this.marker = new google.maps.Marker({

			position : new google.maps.LatLng(lat, long),
			map : gmap,
			title : dtitle
		});
		clickmarker(marker, dtitle);
		infowindow.setContent('<b>' + dtitle + '</b>');

		infowindow.open(gmap, marker);

	};

	/* Device List with account name */
	var getdevicelist = function(details) {
		for ( var dkey in details.data) {
			var dproper = details.data[dkey];
			markerpositions(dproper[0], dproper[1], dproper[2]);
			dl.push(dproper[0]);
	
			fdevicelist.dname=dl;
		}
	};
	var error = function(reason) {
		alert("Can Not Get Data");
	};
	
	
	
	$scope.devicelist = dl;
	$scope.getdevicedetails = $http.get("/java/devicedetails").then(
			getdevicelist, error);

	/* Device Details after clicked on car name */

	var deviceposition = function(details) {
		/*
		 * alert("Device position" + details.dname + details.latitude + " " +
		 * details.longitude);
		 */

		gmap.setZoom(18);
		gmap.setCenter(new google.maps.LatLng(details.latitude,
				details.longitude));
		var smarker = new google.maps.Marker({

			position : new google.maps.LatLng(details.latitude,
					details.longitude),
			map : gmap,
			title : details.dname
		});

		// selected device address on map
		alert(details.address);
		$scope.getaddress = details.address;
		var details = '<p><b>Name</b>: ' + details.dname + '</br>' +

		'<b>ID</b>: ' + details.imei + '</br>' + '<b>Address</b>: '
				+ details.address + '</br>' + '<b>Current Status</b>: '
				+ details.status + '</br>' +

				'<b>Speed</b>: ' + details.speed + '</br>'
				+ '<b>Last Update</b>: ' + details.lastupdate + '</br>'
				+ '<b>History</b>: ' + '<a href="">PlayBack</a>'

		'</p>';

		google.maps.event.addListener(smarker, 'click', function() {

			info.setContent(details);
			info.open(gmap, smarker);

		});

		closeInfoWindo();

		info.setContent(details);
		lastInfoWindow = info;
		info.open(gmap, smarker);

	};
	// close previous infowindow
	var closeInfoWindo = function() {

		if (lastInfoWindow) {
			lastInfoWindow.close();

		}

	};

	// Get All properties of a device from DeviceController
	var getddetails = function(devicename) {

		var getdetails = function(result) {
			var getdevicedata = result.data;
			getdeviceproperty = getdevicedata;
			deviceposition(getdevicedata);

		};
		var failure = function() {

			alert("Failed");
		};
		var sdevice = {

			selecteddevice : devicename
		};

		$http.post('/java/sddetails', sdevice).then(getdetails, failure);

	};
	// get details after marker click on map
	var clickmarker = function(clkmarker, devname) {
		google.maps.event.addListener(clkmarker, 'click', function() {

			getddetails(devname);

		})
	};

	// Invoke from jsp to get all properties.
	$scope.selectdevicedetails = getddetails;

	/* End Properties */

}
/* Update Password */
myangu.controller('changepassword', [ '$scope', '$http', function($scope, $http) {
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

/* Milagereport */

myangu.controller('milagereport', function($scope, $http,fdevicelist) {

	
  $scope.sdevicelist = fdevicelist.dname;
	$scope.myDate = new Date();
	$scope.maxDate = new Date($scope.myDate.getFullYear(), $scope.myDate
			.getMonth(), $scope.myDate.getDate());
	$scope.minDate = new Date($scope.myDate.getFullYear() - 1, $scope.myDate
			.getMonth(), $scope.myDate.getDate());

	$scope.getstatistics = function(mreport) {
	

		if (angular.isString(mreport.devicename)
				&& angular.isDefined(mreport.fuelconsum)
				&& angular.isDate(mreport.fromdate)
				&& angular.isDate(mreport.todate)) {

			// alert("yes");
			var giveninputvalue = {
				devicename : mreport.devicename,
				fdata : mreport.fromdate,
				tdate : mreport.todate,
				givenfuelconsumption : mreport.fuelconsum
			};
			var success = function() {
				// alert("success");

			};
			var failure = function() {
				alert("Failure");

			};
			$http.post('/java/mileagereport', giveninputvalue).then(success,
					failure);

		} else {

			alert("Please Select a Date");
		}

	};

});

myangu.config(function($routeProvider) {

	$routeProvider.when('/account', {

		templateUrl : '/java/account',
		

	}).when('/message', {

		templateUrl : '/java/message',
		controller : 'message'

	}).when('/updatepassword', {

		templateUrl : '/java/updatepassword',
		controller : 'changepassword'

	}).when('/',{
		
		templateUrl : '/java/monitor',
		controller : 'MapCtrl'
	}).when('/statistics',{
		
		templateUrl : '/java/statistics',
		controller : 'milagereport'
	}).when('/more',{
		
		templateUrl : '/java/more',
		controller : 'more'
		
	});

});
// validation

/*
 * myangu.controller('fuelvalidation',function($scope){
 * 
 * $scope.fuelconnumber = {number: 1, validity: true}; });
 * 
 * myangu.directive('isNumber', function () { return { require: 'ngModel', link:
 * function (scope) { scope.$watch('fuelconnumber.number',
 * function(newValue,oldValue) { var arr = String(newValue).split(""); if
 * (arr.length === 0) return; if (arr.length === 1 && (arr[0] == '-' || arr[0]
 * === '.' )) return; if (arr.length === 2 && newValue === '-.') return; if
 * (isNaN(newValue)) { scope.fuelconnumber.number = oldValue; } }); } }; });
 */