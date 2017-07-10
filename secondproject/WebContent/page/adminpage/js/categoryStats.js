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
			        data: [0, 0, 0],
			        backgroundColor: [
			            'rgba(255, 99, 132, 0.2)',
			            'rgba(54, 162, 235, 0.2)',
			            'rgba(255, 206, 86, 0.2)'
			        ]
			    }],
			    labels: [
			        'Red',
			        'Yellow',
			        'Blue'
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
