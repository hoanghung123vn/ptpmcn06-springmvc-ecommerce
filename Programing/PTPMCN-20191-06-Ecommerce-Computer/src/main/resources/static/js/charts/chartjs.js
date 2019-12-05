+function($, window){

	var chartJs = {};

	chartJs.init = function() {

		//Line Chart
		var lineChart = document.getElementById("line-chart");
		var lineCtx = lineChart.getContext('2d');
		lineChart.height = 120;
		var lineConfig = new Chart(lineCtx, {
			type: 'line',
			data: {
			labels: ["January", "February", "March", "April", "May", "June", "July"],
			datasets: [{
				label: 'Series A',
				backgroundColor: app.colors.transparent,
				borderColor: app.colors.success,
				pointBackgroundColor: app.colors.success,
				borderWidth: 2,
				data: [65, 59, 80, 81, 56, 55, 40]
			},
			{
				label: 'Series B',
				backgroundColor: app.colors.transparent,
				borderColor: app.colors.info,
				pointBackgroundColor: app.colors.info,
				borderWidth: 2,
				data: [28, 48, 40, 19, 86, 27, 90]
				}]
			},
			
			options: {
				legend: {
					display: false
				}
			}
		});

		//Stacked Area Chart
		var stackedAreaChart = document.getElementById("stacked-area-chart");
		var stackedAreaCtx = stackedAreaChart.getContext('2d');
		stackedAreaChart.height = 120;
		var stackedAreaConfig = new Chart(stackedAreaCtx, {
			type: 'line',
			data: {
			labels: ["January", "February", "March", "April", "May", "June", "July"],
			datasets: [{
				label: 'Series A',
				backgroundColor: app.colors.successOpacity,
				borderColor: app.colors.success,
				pointBackgroundColor: app.colors.success,
				borderWidth: 2,
				data: [65, 59, 80, 81, 56, 55, 40]
			},
			{
				label: 'Series B',
				backgroundColor: app.colors.infoOpacity,
				borderColor: app.colors.info,
				pointBackgroundColor: app.colors.info,
				borderWidth: 2,
				data: [28, 48, 40, 19, 86, 27, 90]
				}]
			},
			
			options: {
				legend: {
					display: false
				}
			}
		});

		//Bar Chart
		var barChart = document.getElementById("bar-chart");
		var barCtx = barChart.getContext('2d');
		barChart.height = 120;
		var barConfig = new Chart(barCtx, {
			type: 'bar',
			data: {
			labels: [ '2011', '2012', '2013', '2014', '2015', '2016', '2017', '2018'],
			datasets: [{
				label: 'Series A',
				backgroundColor: app.colors.primary,
				borderColor: app.colors.primary,
				pointBackgroundColor: app.colors.primary,
				borderWidth: 2,
				data: [ 56, 55, 40, 37, 54, 76, 63, 62]
			},
			{
				label: 'Series B',
				backgroundColor: app.colors.success,
				borderColor: app.colors.success,
				pointBackgroundColor: app.colors.success,
				borderWidth: 2,
				data: [ 86, 27, 90, 43, 65 ,76, 87, 85]
				}]
			},
			
			options: {
				legend: {
					display: false
				}
			}
		});

		//Radar Chart
		var radarChart = document.getElementById("radar-chart");
		var radarCtx = radarChart.getContext('2d');
		radarChart.height = 292;
		var radarConfig = new Chart(radarCtx, {
			type: 'radar',
			data: {
				labels: ["Eating", "Drinking", "Sleeping", "Designing", "Coding", "Cycling", "Running"],
				datasets: [{
					label: 'label1',
					backgroundColor: app.colors.successOpacity,
					borderColor: app.colors.success,
					pointBackgroundColor: app.colors.success,
					data: [65, 59, 90, 81, 56, 55, 40]
				}, {
					label: 'label2',
					backgroundColor: app.colors.infoOpacity,
					borderColor: app.colors.info,
					pointBackgroundColor: app.colors.info,
					data: [28, 48, 40, 19, 96, 27, 100]
				}]
			},
			options: {
				maintainAspectRatio: false,
				legend: {
					display: false
				}
			}
		});
		
		//Pie Chart
		var pieChart = document.getElementById("pie-chart");
		var pieCtx = pieChart.getContext('2d');
		pieChart.height = 292;
		var pieData = {
			labels: ["Chrome", "IE", "FireFox"],
			datasets: [
				{
					fill: true,
					backgroundColor: [app.colors.successOpacity, app.colors.infoOpacity, app.colors.primaryOpacity],
					data: [6, 2, 5]
				}
			]
		};

		var pieConfig = new Chart(pieCtx, {
			type: 'pie',
			data: pieData,
			options: {
				maintainAspectRatio: false,
				hover: {mode: null},
				legend: {
					display: false
				},
			}
		});

		//Donut Chart
		var donutChart = document.getElementById("donut-chart");
		var donutCtx = donutChart.getContext('2d');
		donutChart.height = 292;
		var donutData = {
			labels: ["Download Sales", "In-Store Sales", "Mail-Order Sales"],
			  datasets: [
				{
					fill: true,
					backgroundColor: [app.colors.success, app.colors.info, app.colors.primary],
					data: [300, 500, 100]
				}
			]
		};
	
		var donutConfig = new Chart(donutCtx, {
			type: 'doughnut',
			data: donutData,
			options: {
				maintainAspectRatio: false,
				hover: {mode: null},
				legend: {
					display: false
				},
				cutoutPercentage: 45
			}
		});

		//Polar Chart
		var polarChart = document.getElementById("polar-chart");
		var polarCtx = polarChart.getContext('2d');
		polarChart.height = 392;
		var polarData = {
			labels: ["Download Sales", "In-Store Sales", "Mail-Order Sales", "Tele Sales", "Corporate Sales"],
			  datasets: [
				{
					fill: true,
					backgroundColor: [app.colors.successOpacity, app.colors.infoOpacity, app.colors.warningOpacity, app.colors.primaryOpacity, app.colors.dangerOpacity],
					data: [300, 400, 100, 200, 100]
				}
			]
		};
	
		var polarConfig = new Chart(polarCtx, {
			type: 'polarArea',
			data: polarData,
			options: {
				maintainAspectRatio: false,
				hover: {mode: null},
				legend: {
					display: false
				}
			}
		});

		var bubbleOptions = {
			type: 'bubble',
			data: {
			  datasets: [
				{
					label: 'John',
					data: [
						{
						x: 3,
						y: 7,
						r: 10
						}
					],
					backgroundColor: app.colors.success
					},
					{
					label: 'Paul',
						data: [
						{
							x: 6,
							y: 2,
							r: 10
						}
						],
						backgroundColor: app.colors.info
					},
					{
					label: 'George',
						data: [
						{
							x: 4,
							y: 6,
							r: 10
						}
						],
						backgroundColor: app.colors.primary
					},
					{
					label: 'Ringo',
						data: [
						{
							x: 5,
							y: 3,
							r: 10
						}
						],
						backgroundColor: app.colors.warning
					},
					{
					label: 'John',
						data: [
						{
							x: 2,
							y: 1,
							r: 10
						}
						],
						backgroundColor: app.colors.danger
					}
				]
			},
			options: {
				legend: {
					display: false
				}
			}
		}
		var bubbleCtx = document.getElementById('bubble-chart').getContext('2d');
		bubbleCtx.height = 80;  
		new Chart(bubbleCtx, bubbleOptions);

		//Gradient Chart
		var gradientCtx = document.getElementById('gradient-chart').getContext('2d');
		gradientCtx.height = 150;;
		var gradientChartGradient = gradientCtx.createLinearGradient(0, 0, 0, 300);
		gradientChartGradient.addColorStop(0, app.colors.success);
		gradientChartGradient.addColorStop(1, app.colors.transparent);
		
		var bar_chart = new Chart(gradientCtx, {
			type: 'line',
			data: {
				labels: ["January", "February", "March", "April", "May", "June", "July"],
				datasets: [{
					data: [65, 59, 80, 81, 56, 55, 40],
					backgroundColor: gradientChartGradient,
					borderColor: app.colors.success
				}]
			},
			options: {
				legend: {
					display: false
				},
				maintainAspectRatio: false
			},
			scales: {
				yAxes: [{
					stacked: true,
					 ticks: {
						min: 0,
						stepSize: 40,
					}
				}]
			}
		});
	};	

	window.chartJs = chartJs;

}(jQuery, window);

// initialize app
+function($) {
	chartJs.init();		
}(jQuery);