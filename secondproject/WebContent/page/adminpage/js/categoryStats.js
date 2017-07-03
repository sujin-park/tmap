var ctx2 = document.getElementById('categoryChart').getContext('2d');
var myPieChart = new Chart(ctx2,{
    type: 'pie',
    data: data,
    options: options
});