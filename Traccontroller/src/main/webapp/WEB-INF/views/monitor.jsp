
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
<!--  <div>{{getaddress}}</div>
<div class="dip">
					<div id="map"></div>
					<div id="class" ng-repeat="marker in markers | orderBy : 'title'">
						<a href="#" ng-click="openInfoWindow($event, marker)">{{locations.title}}</a>
					</div>
				</div> -->