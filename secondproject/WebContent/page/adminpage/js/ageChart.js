function getAge() {
	document.location.href = "/secondproject/chart?act=ageChart";
}
/*
function getAge() {
	$.ajax({
		method: 'get',
		url: '/secondproject/chart',
		data: {
			'act': 'ageChart',
		},
		dataType: 'json',
		success: function(data) {
			for (var i = 0; i <data.length; i++) {
					myChart.data.labels[i] = data[i].age;	
					myChart.data.datasets[0].data[i] = data[i].ageCount;	
			}
					myChart.update();
		}
	})
}
*/