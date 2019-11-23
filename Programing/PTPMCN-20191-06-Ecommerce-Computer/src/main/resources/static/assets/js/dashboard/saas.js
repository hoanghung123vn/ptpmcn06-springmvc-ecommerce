+function($, window){
	
	var saasDashboard = {};

	saasDashboard.init = function() {
		
		//Map
		$('#map').vectorMap({
			map: 'world_mill',
			backgroundColor: app.colors.white,
			zoomOnScroll: false,
			regionStyle: {
				initial: {
					fill: '#e9eaee',
					'stroke-width': 0.5,
					'stroke': app.colors.white,
					'cursor': 'pointer'
				},
				hover: {
					'fill-opacity': 0.6
				}
			},
			markerStyle: {
                hover: {
                    r: 12,
                    stroke: app.colors.borderColor,
                    'stroke-width': 10
                }
            },

			markers: [{
				latLng: [30.27, -93.73],
				name: '(+25.17)',
				style: { 
					fill: app.colors.gradientSuccess, 
					stroke: app.colors.success, 
					'fill-opacity': 1, 
					'stroke-width': 10, 
					'stroke-opacity': 0.3, 
					'cursor': 'pointer', 
					r: 10
				}
			}, {
				latLng: [39.41, 21.95],
				name: '(-28.12)',
				style: { 
					fill: app.colors.warning, 
					stroke: app.colors.warning, 
					'fill-opacity': 1, 
					'stroke-width': 10, 
					'stroke-opacity': 0.3, 
					'cursor': 
					'pointer', 
					r: 10
				}
			}, {
				latLng: [63.24, 83.44],
				name: '(+18.84%)',
				style: { 
					fill: app.colors.info, 
					stroke: app.colors.info,
					'fill-opacity': 1, 
					'stroke-width': 10, 
					'stroke-opacity': 0.3, 
					'cursor': 'pointer', 
					r: 10
				}
			}]
		});

		//Earning Chart
		var earningCtx = document.getElementById('earning-chart').getContext('2d');		
		var earningChartGradient = earningCtx.createLinearGradient(40, 0, 50, 170);
		earningChartGradient.addColorStop(0, app.colors.success);
		earningChartGradient.addColorStop(1, app.colors.transparent);
		var earning_chart = new Chart(earningCtx, {
			type: 'line',
			data: {
				labels: ["W1", "W2", "W3", "W4", "W5", "W6", "W7", "W8", "W9", "W10", "W11", "W12"],
				datasets: [{
					label: 'Series A',
					backgroundColor: earningChartGradient,
					borderColor: app.colors.success,
					data: [52, 66, 64, 71, 68, 74, 66, 73, 68, 72, 70, 78]
				}],
			},
			options: {
				legend: {
					display: false
				},
				maintainAspectRatio: false,
				elements: {
					line: {
						tension: 0.4,
						borderWidth: 2
					}
				},
				scales: {
					xAxes: [{display: false}],
					yAxes: [{display: false}]
				}
			}
		});

		//Statistic Chart
		var statisticCtx = document.getElementById('statistic-chart').getContext('2d');
		var statisticChartGradient = statisticCtx.createLinearGradient(0, 0, 0, 150);
		statisticChartGradient.addColorStop(0, app.colors.gradientSuccessStart);
		statisticChartGradient.addColorStop(1, app.colors.gradientSuccessStop);

		var donutConfig = new Chart(statisticCtx, {
			type: 'doughnut',
			data: {
				labels: ["Sales", "In-Store Sales"],
				datasets: [{
					data: [35, 20, 45],
					backgroundColor: [statisticChartGradient, app.colors.primary, app.colors.info]
				}]
			},
			options: {
				elements: {
                    arc: {
                        borderWidth: 6,
                    }
                },
				maintainAspectRatio: false,
				hover: {mode: null},
				legend: {
					display: false
				},
				cutoutPercentage: 78,
			}
		});

		//Page View Chart
		var pageViewCtx = document.getElementById('page-view-chart').getContext('2d');		
		var pageView_chart = new Chart(pageViewCtx, {
			type: 'line',
			data: {
				labels: ["W1", "W2", "W3", "W4", "W5", "W6", "W7", "W8", "W9", "W10", "W11", "W12"],
				datasets: [{
					label: 'Series A',
					backgroundColor: app.colors.transparent,
					borderColor: app.colors.info,
					data: [52, 66, 64, 71, 68, 74, 66, 73, 68, 72, 70, 78]
				}],
			},
			options: {
				legend: {
					display: false
				},
				maintainAspectRatio: false,
				elements: {
					line: {
						tension: 0,
						borderWidth: 2
					}
				},
				scales: {
					xAxes: [{display: false}],
					yAxes: [{display: false}]
				}
			}
		});

		//Sales Stat Chart
		var salesStatChart = document.getElementById("sales-stat-chart");
		var salesStatCtx = salesStatChart.getContext('2d');
		var salesStatChartGradient = salesStatCtx.createLinearGradient(0, 0, 0, 150);
		salesStatChartGradient.addColorStop(0, app.colors.gradientSuccessStart);
		salesStatChartGradient.addColorStop(1, app.colors.gradientSuccessStop);
		var salesStatConfig = new Chart(salesStatCtx, {
			type: 'bar',
			data: {
				labels: [ '1st', '2nd', '3rd', '4th', '5th', '6th', '7th', '8th', '9th', '10th', '11th', '12th', '13th', '14th', '15th'],
				datasets: [{
					label: 'Series A',
					backgroundColor: salesStatChartGradient,
					pointBackgroundColor: salesStatChartGradient,
					hoverBackgroundColor: salesStatChartGradient,
					data: [ 15, 20, 25, 30, 25, 20, 15, 20, 25, 30, 25, 20, 15, 10, 15, 20]
				},
				{
					label: 'Series B',
					backgroundColor: '#eaeaea',
					pointBackgroundColor: '#eaeaea',
					data: [ 15, 20, 25, 30, 25, 20, 15, 20, 25, 30, 25, 20, 15, 10, 15, 20]
				}]
			},
			
			options: {
				legend: {
					display: false
				},
				scales: {
                    xAxes: [{
                        display: false,
                        gridLines: false,
                        stacked: true
                    }],
                    yAxes: [{
                        display: false,
                        stacked: true,
                        gridLines: false
					}]
				},
				responsive: true,
				maintainAspectRatio: false
			}
		});
	};	

	window.saasDashboard = saasDashboard;

}(jQuery, window);

// initialize app
+function($) {
	saasDashboard.init();		
}(jQuery);
	