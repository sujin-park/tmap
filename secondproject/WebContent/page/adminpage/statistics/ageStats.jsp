<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.secondproject.constant.*"%>
<%
	String json = (String) request.getAttribute("age");
%>
<section class="content page-top row">
  <div align="center" style="padding-top:60px;">
	<button id="sendAge" class="btn btn-warning" width="100" height="50" onclick="javascript:getAge();">연령대별 가입자수</button>
	<button id="sendCategory"  class="btn btn-warning" width="100" onclick="javascript:getCategory(0);">카테고리별 All</button>
	<button id="sendCategory"  class="btn btn-warning" width="100" onclick="javascript:getCategory(1);">카테고리별 여성</button>
	<button id="sendCategory"  class="btn btn-warning" width="100" onclick="javascript:getCategory(2);">카테고리별 남성</button>
	<button id="sendArea"  class="btn btn-warning" width="100" onclick="javascript:getArea();">지역별 등록된 매장수</button>
  </div>
  <label for="from">From</label>
	<input type="text" id="from" name="from">
  <label for="to">to</label>
	<input type="text" id="to" name="to">
	<div class="col-md-3 col-md-push-5"></div>
		<div class="panel panel-default" style="margin-left:60px; margin-right:60px;">
				<div class="panel-body">
					<div class="col-md-4">
						<canvas id="ageChart" width="600" height="500"></canvas>
					</div>
					<div class="col-md-4">
						<canvas id="categoryChart" width="400" height="400"></canvas>
					</div>
					<div class="col-md-4">
						<canvas id="areaChart" width="400" height="400"></canvas>
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
        labels: ["Red", "Blue", "Yellow", "Green", "Purple"],
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

var obj = JSON.parse('<%=json%>');

	for (var i = 0; i <obj.length; i++) {
		myChart.data.labels[i] = obj[i].age;	
		myChart.data.datasets[0].data[i] = obj[i].ageCount;	
}
		myChart.update();



</script>
<script src="<%=ContextPath.root%>/page/adminpage/js/ageChart.js"></script>
<script src="<%=ContextPath.root%>/page/adminpage/js/categoryStats.js"></script>
<script src="<%=ContextPath.root%>/page/adminpage/js/areaChart.js"></script>