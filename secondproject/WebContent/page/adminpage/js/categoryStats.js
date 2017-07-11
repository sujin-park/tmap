function getCategory(number) {
	document.location.href = "/secondproject/chart?act=categoryChart&number="+number;
}

function getCateAjax(number) {
		$.ajax({
		method: 'get',
		url: '/secondproject/chart',
		data: {
			'act': 'categoryAjax',
			'number': number
		},
		dataType: 'json',
		success: function(data) {
			cateChart.destroy();
			var ctx2 = document.getElementById("categoryChart");
			cateChart = new Chart(ctx2,{
			    type: 'doughnut',
			    data: {  
			    	datasets: [{
			        data: [0, 0, 0, 0, 0],
			        backgroundColor: [
			            'rgba(255, 99, 132, 0.2)',
			            'rgba(54, 162, 235, 0.2)',
			            'rgba(255, 206, 86, 0.2)',
			            'rgba(75, 192, 192, 0.2)',
			            'rgba(153, 102, 255, 0.2)'
			        ]
			    }],
			    labels: [
			        '한식',
			        '중식',
			        '일식',
			        '양식',
			        '기타'
			    ]
			    }
			});
			for (var i=0; i<data.length; i++) {
				cateChart.data.labels[i] = data[i].category;
				cateChart.data.datasets[0].data[i] = data[i].categoryCount;
			}
				cateChart.update();
		}
			
	})
}

function getCateSelect() {
	var number;
	if (document.getElementById("cateyear").value == "") {
		number = document.getElementById("catemonth").value;
		console.log(number);
	} else if (document.getElementById("catemonth").value == "") {
		number = document.getElementById("cateyear").value;
	}
	$.ajax({
		method: 'get',
		url: '/secondproject/chart',
		data: {
			'act': 'categoryAjax',
			'number': number
		},
		dataType: 'json',
		success: function(data) {
			cateChart.destroy();
			var ctx2 = document.getElementById("categoryChart");
			cateChart = new Chart(ctx2,{
			    type: 'doughnut',
			    data: {  
			    	datasets: [{
			        data: [0, 0, 0, 0, 0],
			        backgroundColor: [
			            'rgba(255, 99, 132, 0.2)',
			            'rgba(54, 162, 235, 0.2)',
			            'rgba(255, 206, 86, 0.2)',
			            'rgba(75, 192, 192, 0.2)',
			            'rgba(153, 102, 255, 0.2)'
			        ]
			    }],
			    labels: [
			        '한식',
			        '중식',
			        '일식',
			        '양식',
			        '기타'
			    ]
			    }
			});
			for (var i=0; i<data.length; i++) {
				cateChart.data.labels[i] = data[i].category;
				cateChart.data.datasets[0].data[i] = data[i].categoryCount;
			}
				cateChart.update();
		}
			
	})	
	
}