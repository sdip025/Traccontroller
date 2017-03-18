<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="true"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>GPS21 NET INDIA SER.</title>

<script type="text/javascript"
	src="<c:url value="/resources/JS/angular/angular.min.js"/>"></script>
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAAN8QH-4D40wZjFEzXq7yacrFQd_iJdiU&callback=initMap"
	type="text/javascript"></script>
<script type="text/javascript"
	src="<c:url value="/resources/JS/angular/Ajscript.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/JS/angular/devicelist.js"/>"></script>
<link href="<c:url value="/resources/css/home.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/map.css" />" rel="stylesheet">
<script type="text/javascript"
	src="https://formden.com/static/cdn/formden.js"></script>

<!-- Special version of Bootstrap that is isolated to content wrapped in .bootstrap-iso -->
<link rel="stylesheet"
	href="https://formden.com/static/cdn/bootstrap-iso.css" />

<!--Font Awesome (added because you use icons in your prepend/append)-->
<link rel="stylesheet"
	href="https://formden.com/static/cdn/font-awesome/4.4.0/css/font-awesome.min.css" />

<!-- Inline CSS based on choices in "Settings" tab -->
<style>
.bootstrap-iso .formden_header h2,.bootstrap-iso .formden_header p,.bootstrap-iso form
	{
	font-family: Arial, Helvetica, sans-serif;
	color: black
}

.bootstrap-iso form button,.bootstrap-iso form button:hover {
	color: white !important;
}

.asteriskField {
	color: red;
}
</style>


</head>
<body>
	<div ng-app="mapsApp" ng-controller="MapCtrl as tab">
		<header>
			<div class="divTable1" style="border: 1px solid #000;">
				<div class="divTableBody1">
					<div class="divTableRow1">
						<div class="divTableCell1">
							Welcome
							<%=session.getAttribute("username")%></div>
						<div class="divTableCell2">

							<div class="divTableBody">

								<div class="divTableRow">


									<div class="divTableCell">
										<p>Account</p>
									</div>
									<div class="divTableCell">Message</div>
									<div class="divTableCell">Change Password</div>
									<div class="divTableCell">
										<a href="${pageContext.request.contextPath}/logout">Logout</a>
									</div>

								</div>
								<div class="divTableRow">
									<div class="divTableCell"></div>


									<div class="container">

										<ul class="nav nav-pills">
											<div class="divTableCell">
												<li ng-class="{active:tab.isSet(1)}"><a href
													ng-click="tab.setTab(1)">Monitor</a></li>
											</div>
											<div class="divTableCell">
												<li ng-class="{active:tab.isSet(2)}"><a href
													ng-click="tab.setTab(2)">Statistics</a></li>
											</div>
											<div class="divTableCell">
												<li ng-class="{active:tab.isSet(3)}"><a href
													ng-click="tab.setTab(3)">More</a></li>
											</div>
										</ul>



									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
		</header>
		<div ng-show="tab.isSet(1)">
			<div class="divT">
				<div class="divTableB">
					<div class="divTableR">
						<div class="divTableCe">

							<div class="divTab">
								<div class="divTB">
									<div class="divTRow">
										<div class="divTCell">
											<a href="javascript:void(0);" ng-click="astatus=false"><%=session.getAttribute("username")%></a>
										</div>
									</div>
									<div class="divTRow">
										<div class="divTCell">
											<!-- <div ng-repeat="dlist in udlist " >
										
										{{dlist.name}}</div> -->

											<div class="section1" ng-show="!astatus">Section 1</div>



										</div>
									</div>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
			<div class="dip">
				<div id="map"></div>
				<div id="class" ng-repeat="marker in markers | orderBy : 'title'">
					<a href="#" ng-click="openInfoWindow($event, marker)">{{markerr.title}}</a>
				</div>
			</div>
		</div>



		<div ng-show="tab.isSet(2)">
			<table>
				<tr>
					<td>Target Name:<select>
							<option>Please Select</option>
							<option></option>

					</select>
					</td>
				</tr>
				<tr>
					<td>Query By: <input type="radio" checked="checked">
						Daily Details
					</td>
				</tr>
				<tr>
					<td>
						<div class="bootstrap-iso">
							<div class="container-fluid">
								<div class="row">
									<div class="col-md-6 col-sm-6 col-xs-12">
										<form action="https://formden.com/post/MlKtmY4x/"
											class="form-horizontal" method="post">
											<div class="form-group ">

												<div class="col-sm-10">
													<div class="input-group">
														<div class="input-group-addon">
															<i class="fa fa-calendar"> </i>
														</div>
														<div>

															From : <input class="form-control" id="fdate"
																name="fdate" placeholder="MM/DD/YYYY" type="text" />
														</div>
														<div>
															To:<input class="form-control" id="tdate" name="tdate"
																placeholder="MM/DD/YYYY" type="text" />

														</div>


													</div>
												</div>
											</div>
											<div>

												Fuel Consumption Coefficient/100 Kilometers: <input
													type="text" name="fuelconsum"><label>L</label>
												<button type="button" name="search" value="Search">Search</button>
												<button type="button">To Excel</button>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</td>
				</tr>


			</table>
















		</div>

		<div ng-show="tab.isSet(3)">
			<h4>Tab 3</h4>
		</div>

	</div>


	<script type="text/javascript"
		src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

	<!-- Include Date Range Picker -->
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css" />

	<script>
		$(document).ready(
				function() {
					var date_input = $('input[name="fdate"]');
					var tdate_input = $('input[name="tdate"]');
					var container = $('.bootstrap-iso form').length > 0 ? $(
							'.bootstrap-iso form').parent() : "body";
					date_input.datepicker({
						format : 'mm/dd/yyyy',
						container : container,
						todayHighlight : true,
						autoclose : true,
					})
					tdate_input.datepicker({
						format : 'mm/dd/yyyy',
						container : container,
						todayHighlight : true,
						autoclose : true,
					})
				})
	</script>






</body>
</html>
