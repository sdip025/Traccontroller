<%@page import="com.gps21.model.Changepassword"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="true"%>
<html>
<head>
<script type="text/javascript"
	src="<c:url value="/resources/JS/angular/angular.min.js"/>"></script>
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/angular_material/1.0.0/angular-material.min.css">
<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script> -->
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular-animate.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular-aria.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular-messages.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angular_material/1.0.0/angular-material.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>GPS21 NET INDIA SER.</title>


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular-route.js"></script>
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAAN8QH-4D40wZjFEzXq7yacrFQd_iJdiU"
	type="text/javascript"></script>
<script type="text/javascript"
	src="<c:url value="/resources/JS/angular/Ajscript.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/JS/angular/devicelist.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/JS/angular/home.js"/>"></script>
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
	<div ng-app="mapsApp">
		<div ng-controller="MapCtrl as tab">
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
											<a href="#!account"><p>Account</p></a>
										</div>
										<div class="divTableCell">
											<a href="#!message">Message</a>
										</div>
										<div class="divTableCell">
											<li><a href="#!updatepassword">Change
													Password</a></li>
										</div>
										<div class="divTableCell">
											<a href="${pageContext.request.contextPath}/logout">Logout</a>
										</div>

									</div>
									<div class="divTableRow">
										<div class="divTableCell"></div>


										<div class="container">


											<div class="divTableCell">
												<ul class="nav nav-pills">
													<li><a href="#/!">Monitor</a></li>
												</ul>
											</div>
											<div class="divTableCell">
												<ul class="nav nav-pills">
													<li><a href="#!statistics">Statistics</a></li>
												</ul>
											</div>
											<div class="divTableCell">
												<ul class="nav nav-pills">
													<li><a href="#!more">More</a></li>
												</ul>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</header>
			<div>{{getaddress}}</div>
			<div class="dip">
				<div id="map"></div>
				<div id="class" ng-repeat="marker in markers | orderBy : 'title'">
					<a href="#" ng-click="openInfoWindow($event, marker)">{{locations.title}}</a>
				</div>
			</div>
			<div ng-view></div>
			<%-- <div ng-show="tab.isSet(1)">
				<div class="divT">
					<div class="divTableB">
						<div class="divTableR">
							<div class="divTableCe">

								<div class="divTab">
									<div class="divTB">
										<div class="divTRow">
											<div class="divTCell">

												<a href="javascript:void(0);"><%=session.getAttribute("username")%>(/{{devicelist.length}})</a>
											</div>
										</div>
										<div class="divTRow">
											<div class="divTCell">


												<div class="section1" ng-repeat="keys in devicelist">
													<a href="" ng-click="selectdevicedetails(keys)">{{keys}}</a>

												</div>
											</div>
										</div>
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>
				<div>{{getaddress}}</div>
				<div class="dip">
					<div id="map"></div>
					<div id="class" ng-repeat="marker in markers | orderBy : 'title'">
						<a href="#" ng-click="openInfoWindow($event, marker)">{{locations.title}}</a>
					</div>
				</div>
			</div>
 --%>

			<%-- <div ng-show="tab.isSet(2)">
				<form ng-controller="milagereport" name="milagereportform"
					ng-submit="getstatistics(mreport)">
					<table>
						<tr>
							<td>Target Name:<select ng-model="mreport.devicename"
								required="required">

									<option value="" disabled selected>Please Select</option>
									<option ng-repeat="keys in devicelist">{{keys}}</option>

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

												<div class="form-group">

													<div class="col-sm-10">
														<div class="input-group">

															<div>
																From
																<md-datepicker ng-model="mreport.fromdate" name="fdate"
																	md-min-date="minDate" required="required"></md-datepicker>
                                                           </div>
</div>

														<div ng-init="mreport.todate=myDate">
															To:
															<md-datepicker ng-model="mreport.todate" name="todate"
																md-max-date="maxDate"></md-datepicker>


														</div>

													</div>
												</div>
											</div>
											<div ng-init="mreport.fuelconsum=8.00">

												Fuel Consumption Coefficient/100 Kilometers: <input
													type="number" ng-model="mreport.fuelconsum" step="any"
													min="1.00" required="required"><label>L</label> <input
													type="submit" value="Submit" />
												<!-- <md-button ng-disabled="!milagereportform.fdate.$valid"
													class="md-raised md-primary" name="search"
													ng-click="getstatistics(mreport)" value="Search">Search</md-button> -->
												<button type="button">To Excel</button>
											</div>



											<div ng-show="showDiv">
												<table border="2">
													<tr>
														<th ng-repeat="column in cols">{{column}}</th>
													</tr>
													<tr>
														<td><input type="text"></td>
													</tr>
													<tr ng-repeat="row in rows">
														<td ng-repeat="column in cols">{{row[column]}}</td>
													</tr>
												</table>
											</div>
										</div>
									</div>
								</div>
								</div>
							</td>
						</tr>
					</table>
				</form>
			</div> --%>

			<!-- <div ng-show="tab.isSet(3)">
				<h4>Tab 3</h4>
				<div id="navigation">
					<a href="#!test1">test1</a><a href="#!test2">test2</a>
				</div>
			

			</div> -->

			<!-- <div ng-show="tab.isSet(4)">
				<div class="container">

					<ul class="nav nav-pills">
						<div class="divTableCell">
							<li ng-class="{active:tab.isSet(5 )}"><a href
								ng-click="tab.setTab(5)">My Account </a></li>
						</div>
						<div class="divTableCell">
							<li ng-class="{active:tab.isSet(6)}"><a href
								ng-click="tab.setTab(6)">Change Password</a></li>
						</div>
						<div class="divTableCell">
							<li ng-class="{active:tab.isSet(7)}"><a href
								ng-click="tab.setTab(7)">My Service</a></li>
						</div>

					</ul>



				</div>
			</div> -->
			<%-- 	<div ng-show="tab.isSet(5)">


				<div class="container">

					<ul class="nav nav-pills">
						<div class="divTableCell">
							<li ng-class="{active:tab.isSet(5 )}"><a href
								ng-click="tab.setTab(5)">My Account </a></li>
						</div>
						<div class="divTableCell">
							<li ng-class="{active:tab.isSet(6)}"><a href
								ng-click="tab.setTab(6)">Change Password</a></li>
						</div>
						<div class="divTableCell">
							<li ng-class="{active:tab.isSet(7)}"><a href
								ng-click="tab.setTab(7)">My Service</a></li>
						</div>

					</ul>



				</div>
				<div>Tab 6</div>

			</div>
			<div ng-show="tab.isSet(6)">
				<div class="container">

					<ul class="nav nav-pills">
						<div class="divTableCell">
							<li ng-class="{active:tab.isSet(5 )}"><a href
								ng-click="tab.setTab(5)">My Account </a></li>
						</div>
						<div class="divTableCell">
							<li ng-class="{active:tab.isSet(6)}"><a href
								ng-click="tab.setTab(6)">Change Password</a></li>
						</div>
						<div class="divTableCell">
							<li ng-class="{active:tab.isSet(7)}"><a href
								ng-click="tab.setTab(7)">My Service</a></li>
						</div>

					</ul>



				</div>

				


			</div>





			<div ng-show="tab.isSet(7)">
				<div class="container">

					<ul class="nav nav-pills">
						<div class="divTableCell">
							<li ng-class="{active:tab.isSet(5 )}"><a href
								ng-click="tab.setTab(5)">My Account </a></li>
						</div>
						<div class="divTableCell">
							<li ng-class="{active:tab.isSet(6)}"><a href
								ng-click="tab.setTab(6)">Change Password</a></li>
						</div>
						<div class="divTableCell">
							<li ng-class="{active:tab.isSet(7)}"><a href
								ng-click="tab.setTab(7)">My Service</a></li>
						</div>

					</ul>



				</div>
			</div>--%>

		</div>

	</div>

</body>
</html>
