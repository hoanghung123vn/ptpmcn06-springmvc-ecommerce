+function($, window){
	
	var analyticalDashboard = {};

	analyticalDashboard.init = function() {

		//Segment Chart
		var segmentCtx = document.getElementById('segment-chart').getContext('2d');		
		var segmentChart = new Chart(segmentCtx, {
			type: 'line',
			data: {
				labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
				datasets: [{
					label: 'Series A',
					backgroundColor: app.colors.infoOpacity,
					borderColor: app.colors.info,
					data: [5200, 6600, 6100, 7600, 6800, 7400, 6600, 7300, 6800, 7200, 7000, 7800]
				}],
			},
			options: {
				legend: {
					display: false
				},
				maintainAspectRatio: false,
				elements: {
					line: {
						borderWidth: 1.5
					}
				},
				scales: {
					xAxes: [{display: false}],
					yAxes: [{gridLines: { color: app.colors.borderColor }}]
				}
			},
			scales: {
				yAxes: [{
					stacked: true,
					ticks: {
						min: 0,
						stepSize: 30,
					}
				}]
			}
		});

		//Bar Chart
		var statisticChart = document.getElementById("statistic-chart");
		var statisticCtx = statisticChart.getContext('2d');
		var statisticConfig = new Chart(statisticCtx, {
			type: 'bar',
			data: {
				labels: [ 'Model X', 'Model B', 'Model A', 'Model Y'],
				datasets: [{
					label: 'Series A',
					backgroundColor: [app.colors.success , app.colors.info, app.colors.primary, app.colors.warning],
					borderColor: app.colors.transparent,
					pointBackgroundColor: app.colors.primary,
					borderWidth: 4,
					data: [ 56, 48, 45, 50]
				}]
			},
			options: {
				legend: {
					display: false
				},
				scales: {
					xAxes: [{
						barPercentage: 0.6,
						gridLines: { color: app.colors.transparent }
					}],
					yAxes: [{display: false}]
				}	
			}
		});
	};	

	window.analyticalDashboard = analyticalDashboard;

}(jQuery, window);

// initialize app
+function($) {
	analyticalDashboard.init();		
}(jQuery);
	