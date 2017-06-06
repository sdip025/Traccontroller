var myangu = angular.module('mapsApp', [ 'ngMaterial', 'ngMessages' ]);

myangu.controller('MapCtrl', MapController);

function MapController($scope, $http) {

	this.tab = 1;

	this.setTab = function(tabId) {
		this.tab = tabId;
	};

	this.isSet = function(tabId) {
		return this.tab === tabId;
	};

	var icon ="";
	var lastInfoWindow = null;

	var dl = [];// list of device.

	var getdeviceproperty;

	/* Google Map */
	var mapcenter = new google.maps.LatLng({
		lat : 22.471466666666668,
		lng : 88.39954333333333
	});
	var gmap = new google.maps.Map(document.getElementById('map'), {
		zoom : 5,
		center : mapcenter,
		mapTypeId : google.maps.MapTypeId.ROADMAP
	});

	/* Marker */

	var markerpositions = function(dtitle, lat, long) {
		this.infowindow = new google.maps.InfoWindow();
		this.marker = new google.maps.Marker({

			position : new google.maps.LatLng(lat, long),
			map : gmap,
			title : dtitle
		});

		infowindow.setContent('<b>' + dtitle + '</b>');

		/*
		 * this.deviceinfowindow = new google.maps.InfoWindow({ content : '<b>' +
		 * dtitle + '</b>'
		 * 
		 * });
		 */
		infowindow.open(gmap, marker);
		/*
		 * closeInfoWindo(); lastInfoWindow =infowindow;
		 */
	};

	/* Device List */
	var getdevicelist = function(details) {
		for ( var dkey in details.data) {
			var dproper = details.data[dkey];
			markerpositions(dproper[0], dproper[1], dproper[2]);
			dl.push(dproper[0]);

		}
	};
	var error = function(reason) {
		alert("Error");
	};
	$scope.devicelist = dl;
	$scope.getdevicedetails = $http.get("/java/devicedetails").then(
			getdevicelist, error);
	/* Device Details */

	var deviceposition = function(details) {
		alert("Device position" + details.latitude + "   " + details.latitude);

		gmap.setZoom(15);
		gmap.setCenter(parseFloat(details.latitude),
				parseFloat(details.longitude));
		this.dw = new markerpositions(details.dname, details.latitude,
				details.longitude);

		var details = '<p><b>Name</b>: ' + details.dname + '</br>' +

		'<b>ID</b>: ' + details.imei + '</br>' + '<b>Address</b>: '
				+ details.address + '</br>' + '<b>Current Status</b>: '
				+ details.status + '</br>' +

				'<b>Speed</b>: ' + details.speed + '</br>'
				+ '<b>Last Update</b>: ' + details.lastupdate + '</br>'
				+ '<b>History</b>: ' + '<a href="">PlayBack</a>'

		'</p>';

		google.maps.event.addListener(dw.marker, 'click', function() {

			dw.infowindow.setContent(details);
			dw.infowindow.open(gmap, dw.marker);

		});
		closeInfoWindo();
		dw.infowindow.setContent(details);
		lastInfoWindow = dw.infowindow;
		dw.infowindow.open(gmap, dw.marker);

	};
	var closeInfoWindo = function() {
		if (lastInfoWindow) {
			lastInfoWindow.close();
		}
	};

	/*
	 * var clickevent=google.maps.event.addListener(dw.marker, 'click',
	 * function() { dw.deviceinfowindow.open(gmap, dw.marker); });
	 */

	/* Click to show properties */
	/*
	 * google.maps.event.addListener(dw.marker, 'click', function() {
	 * detailsmessage.open(gmap, dw.marker); });
	 */

	/* Get All properties of a device from DeviceController */
	var getddetails = function(devicename) {

		var getdetails = function(result) {
			var getdevicedata = result.data;
			getdeviceproperty = getdevicedata;
			deviceposition(getdevicedata);
			/* alert("Result" + getdevicedata.lastupdate); */

		};
		var failure = function() {

			alert("Failed");
		};
		var sdevice = {

			selecteddevice : devicename
		};

		$http.post('/java/sddetails', sdevice).then(getdetails, failure);

	};

	/* Invoke from jsp to get all properties */
	$scope.selectdevicedetails = getddetails;

	/*
	 * google.maps.event.addListener(marker, 'click', function() { alert("abcd")
	 * 
	 * });
	 */

	/* End Properties */

}
/* Update Password */
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

/* Milagereport */
myangu.controller('milagereport', function($scope, $http) {

	$scope.getstatistics = function() {
		alert($scope.fromdate);
		alert($scope.devicename + $scope.fuelconsum);

		var giveninputvalue = {
			devicename : $scope.devicename,
			fromdate : $scope.fromdate,
			todate : $scope.todate,
			givenfuelconsumption : $scope.fuelconsum
		};
		var success = function() {
			alert("success");

		};
		var failure = function() {
			alert("failure");

		};
		$http.post('/java/mileagereport', giveninputvalue).then(success,
				failure);

	};

});
