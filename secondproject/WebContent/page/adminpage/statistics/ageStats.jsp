<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.secondproject.constant.*"%>
<%
	String json = (String) request.getAttribute("age");
%>
<section class="content page-top row">
  <div align="center" style="padding-top:60px; padding-bottom:10px;">
	<button id="sendAge" class="btn btn-warning" width="100" height="50" onclick="javascript:getAge(0);">연령대별 가입자수</button>
	<button id="sendCategory"  class="btn btn-warning" width="100" onclick="javascript:getCategory(0);">카테고리별 All</button>
	<button id="sendCategory"  class="btn btn-warning" width="100" onclick="javascript:getCategory(1);">카테고리별 여성</button>
	<button id="sendCategory"  class="btn btn-warning" width="100" onclick="javascript:getCategory(2);">카테고리별 남성</button>
	<button id="sendArea"  class="btn btn-warning" width="100" onclick="javascript:getArea(0);">지역별 등록된 매장수</button>
  </div>

  <div class="col-md-3 col-md-push-5"></div>
  
		<div class="panel panel-default" style="margin-left:150px; margin-right:150px;">
				<div class="panel-body">
					<div class="col-md-1"></div>
					<div class="col-md-6" id="chartArea1">
						<canvas id="ageChart" width="700" height="500"></canvas>
					</div>
					<div class="col-md-1"></div>
					<div class="col-md-4" style="padding-top:80px;">
					<div class="table-container table-responsive">
						<table class="table table-filter">
							<tbody>
								<tr class="warning" align="center">
									<td>조건</td>
									<td>기간</td>
								</tr>
								<tr>
									<td align="center">YEAR</td>
									<td align="center">
										<button id="year" class="btn btn-default" width="60" height="30" onclick="javascript:yearStats();">
										YEAR
										<span class="glyphicon glyphicon-calendar" aria-hidden="true"></span></button>
									</td>
								</tr>
								<tr>
									<td align="center">MONTH</td>
									<td align="center">
										<select class="form-control" id="month" name="month" style="width:270px;">
											<option>연도를 선택해주세요</option>
											<% 
												for (int i=2017; i>2000; i--) {
											%>
											  	<option value="<%=i%>"><%=i%></option>
											<%
												}
											%>
										</select> 
									</td>
								</tr>
								<tr>
									<td align="center">FROM</td>
									<td align="center">
										<input type="text" id="from" name="from" style="width:250px;"> <span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
									</td>
								</tr>
								<tr>
									<td align="center">TO</td>
									<td align="center">
										 <input type="text" id="to" name="to" style="width:250px;"> <span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div align="center">
						<button id="today" class="btn btn-danger" width="50" height="50" onclick="javascript:getAjaxAge(50);">TODAY
						<span class="glyphicon glyphicon-stats" aria-hidden="true"></span></button>
						<button id="allday" class="btn btn-warning" width="50" height="50" onclick="javascript:getAjaxAge(0);">ALL
						<span class="glyphicon glyphicon-stats" aria-hidden="true"></span></button>
						<button id="selectday" class="btn btn-default" width="50" height="50" onclick="javascript:getAgeSelect();">SELECT
						</button>
					</div>
					</div>
				</div>
		</div>
	<div class="col-md-3"></div>
</section>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.bundle.min.js"></script>
<script type="text/javascript">
var ctx = document.getElementById("ageChart");
var myChart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: ["10대", "20대", "30대", "40대", "50대"],
        datasets: [{
            label: '연령대별 가입자수',
            data: ["", "", "", "", ""],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)'
            ],
            borderColor: [
                'rgba(255,99,132,1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero:true
                }
            }]
        }
    }
});

<%
if (json != null) { 
%>
var obj = JSON.parse('<%=json%>');

	console.log(obj);
	for (var i = 0; i <obj.length; i++) {
		myChart.data.labels[i] = obj[i].age;	
		myChart.data.datasets[0].data[i] = obj[i].ageCount;	
}
		myChart.update();
<%
}
%>

</script>
<script src="<%=ContextPath.root%>/page/adminpage/js/ageChart.js"></script>
<script src="<%=ContextPath.root%>/page/adminpage/js/categoryStats.js"></script>
<script src="<%=ContextPath.root%>/page/adminpage/js/areaChart.js"></script>