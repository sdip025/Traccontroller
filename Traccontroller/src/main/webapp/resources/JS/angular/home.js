var mainangu=angular.module("mainangu", ["ngRoute"]);

mainangu.config(function(){
	
	 $routeProvider
	    .when("/", {
	        templateUrl : "monitor.jsp"
	    })
	    .when("/red", {
	        templateUrl : "statistics.jsp"
	    })
	    .when("/green", {
	        templateUrl : "moreoptions.jsp"
	    })
	    .when("/blue", {
	        templateUrl : "blue.htm"
	    });
	
	
	
});
	
	
