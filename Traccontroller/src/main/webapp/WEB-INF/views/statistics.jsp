<div>
	<form ng-controller="milagereport" name="milagereportform"
		ng-submit="getstatistics(mreport)">
		<table>
			<tr>
				<td>Target Name:<select ng-model="mreport.devicename"
					required="required">

						<option value="" disabled selected>Please Select</option>
						<option ng-repeat="keys in sdevicelist">{{keys}}</option>

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
</div>