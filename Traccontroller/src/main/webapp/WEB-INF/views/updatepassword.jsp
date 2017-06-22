<div class="divTable1" align="center">
					<div class="divTablebody">
						<div ng-controller="account">
							<form ng-submit="detailspassword()">
								<%-- <div>
									<%
										Changepassword chpass = new Changepassword();
									%><%=chpass.getMessage()%></div>
								<div>{{errormessage}}</div> --%>
								<div>${messagee}</div>
								<div class="divTableRow">


									<div class="divTableCell">User Name:</div>
									<div class="divTableCell">
										<input type="text" id="username"
											value="<%=session.getAttribute("username")%>"
											ng-init="username = '<%=session.getAttribute("username")%>'"
											readonly="readonly">
									</div>
								</div>
								<div class="divTableRow">
									<div class="divTableCell">Existed password:</div>
									<div class="divTableCell">
										<input type="password" placeholder="Existed Password"
											id="Existedpw" ng-model="existedpassword">
									</div>
								</div>
								<div class="divTableRow">
									<div class="divTableCell">New password:</div>
									<div class="divTableCell">
										<input type="password" placeholder="New Password" id="newpw"
											ng-model="newpassword">
									</div>
								</div>
								<div class="divTableRow">
									<div class="divTableCell">Password Confirmation:</div>
									<div class="divTableCell">
										<input type="password" placeholder="Confirm Password "
											id="confirmpw" ng-model="confirmpassword">
									</div>
								</div>
								<div class="divTableRow">
									<div class="divTableCell">Save</div>
									<div class="divTableCell">
										<input type="submit" id="pwsubmit" name="Submit">
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>