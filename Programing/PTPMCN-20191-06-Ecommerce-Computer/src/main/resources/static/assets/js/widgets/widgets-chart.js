+function($, window){
	
	var chartWidgets = {};

	chartWidgets.init = function() {
		
		//chart-widget-1
		var chartWidget1Ctx = document.getElementById('chart-widget-1').getContext('2d');		
		var chartWidget1_chart = new Chart(chartWidget1Ctx, {
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

		//chart-widget-2
		var chartWidget2 = document.getElementById("chart-widget-2");
		var chartWidget2Ctx = chartWidget2.getContext('2d');
		var chartWidget2Gradient = chartWidget2Ctx.createLinearGradient(0, 0, 0, 150);
		chartWidget2Gradient.addColorStop(0, app.colors.gradientSuccessStart);
		chartWidget2Gradient.addColorStop(1, app.colors.gradientSuccessStop);
		var chartWidget2Config = new Chart(chartWidget2Ctx, {
			type: 'bar',
			data: {
				labels: [ '1st', '2nd', '3rd', '4th', '5th', '6th', '7th', '8th', '9th', '10th', '11th', '12th', '13th', '14th', '15th'],
				datasets: [{
					label: 'Series A',
					backgroundColor: chartWidget2Gradient,
					pointBackgroundColor: chartWidget2Gradient,
					hoverBackgroundColor: chartWidget2Gradient,
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


		var sparkLineData = [4, 10, 8, 10, 9, 10, 11, 7, 5, 8, 9, 6, 11];

		//chart-widget-3
		$("#chart-widgets-3").sparkline( sparkLineData,  
		{
			type: 'bar',
			width: '100',
			height: '40',
			barWidth: 3,
			barSpacing: 5,
			barColor: app.colors.info
		});

		//chart-widget-4
		$("#chart-widgets-4").sparkline( sparkLineData,  
		{
			type: 'line',
			width: '120',
			spotColor: false,
			minSpotColor: false,
			maxSpotColor:false,
			lineWidth: 1.5,
			height: '40',
			fillColor: app.colors.transparent,
			lineColor: app.colors.success
		});
		
		//chart-widget-5
		$("#chart-widgets-5").sparkline( sparkLineData,  
		{
			type: 'line',
			width: '120',
			spotColor: false,
			minSpotColor: false,
			maxSpotColor:false,
			lineWidth: 1.5,
			height: '40',
			fillColor: app.colors.primaryOpacity,
			lineColor: app.colors.primary
		});

		//chart-widget-6
		var chartWidget6Ctx = document.getElementById('chart-widgets-6').getContext('2d');
		chartWidget6Ctx.height = 150;
		var chartWidget6Gradient = chartWidget6Ctx.createLinearGradient(0, 0, 0, 150);
		chartWidget6Gradient.addColorStop(0, app.colors.gradientInfoStart);
		chartWidget6Gradient.addColorStop(1, app.colors.gradientInfoStop);

		var donutConfig = new Chart(chartWidget6Ctx, {
			type: 'doughnut',
			data: {
				labels: ["Sales", "In-Store Sales"],
				datasets: [{
					data: [70, 30],
					backgroundColor: [chartWidget6Gradient, app.colors.gray]
				}]
			},
			options: {
				elements: {
					center: {
						text: '70%',
						color: app.colors.dark,
						sidePadding: 70
					}
				},
				maintainAspectRatio: false,
				hover: {mode: null},
				legend: {
					display: false
				},
				cutoutPercentage: 90,
			}
		});

		//chart-widget-7
		var chartWidget7Ctx = document.getElementById('chart-widgets-7').getContext('2d');		
		var chartWidget7 = new Chart(chartWidget7Ctx, {
			type: 'line',
			data: {
				labels: ["W1", "W2", "W3", "W4", "W5", "W6", "W7", "W8", "W9", "W10", "W11", "W12"],
				datasets: [{
					label: 'Series A',
					backgroundColor: app.colors.transparent,
					borderColor: app.colors.success,
					data: [52, 66, 61, 76, 68, 74, 66, 73, 68, 72, 70, 78]
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
						borderWidth: 1.5
					}
				},
				scales: {
					xAxes: [{display: false}],
					yAxes: [{display: false}]
				}
			}
		});

		//chart-widget-8
		var chartWidget8Ctx = document.getElementById('chart-widgets-8').getContext('2d');
		chartWidget8Ctx.height = 150;
		var chartWidget8Gradient = chartWidget8Ctx.createLinearGradient(0, 0, 0, 150);
		chartWidget8Gradient.addColorStop(0, app.colors.gradientSuccessStart);
		chartWidget8Gradient.addColorStop(1, app.colors.gradientSuccessStop);

		var chartWidget8Gradient2 = chartWidget8Ctx.createLinearGradient(0, 0, 0, 150);
		chartWidget8Gradient2.addColorStop(0, app.colors.gradientPrimaryStart);
		chartWidget8Gradient2.addColorStop(1, app.colors.gradientPrimaryStop);

		var donutConfig = new Chart(chartWidget8Ctx, {
			type: 'doughnut',
			data: {
				labels: ["Sales", "In-Store Sales"],
				datasets: [{
					data: [35, 20, 45],
					backgroundColor: [chartWidget8Gradient, chartWidget8Gradient2, app.colors.info]
				}]
			},
			options: {
				elements: {
                    arc: {
                        borderWidth: 4,
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

		//chart-widget-9
		var chartWidget9Ctx = document.getElementById('chart-widgets-9').getContext('2d');		
		var chartWidget9Gradient = chartWidget9Ctx.createLinearGradient(40, 0, 50, 170);
		chartWidget9Gradient.addColorStop(0, app.colors.warning);
		chartWidget9Gradient.addColorStop(1, app.colors.transparent);
		var chartWidget9 = new Chart(chartWidget9Ctx, {
			type: 'line',
			data: {
				labels: ["W1", "W2", "W3", "W4", "W5", "W6", "W7", "W8", "W9", "W10", "W11", "W12"],
				datasets: [{
					label: 'Series A',
					backgroundColor: chartWidget9Gradient,
					borderColor: app.colors.warning,
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

		//chart-widget-10
		var chartWidget10Chart = document.getElementById("chart-widgets-10");
		var chartWidget10Ctx = chartWidget10Chart.getContext('2d');
		var chartWidget10 = new Chart(chartWidget10Ctx, {
			type: 'bar',
			data: {
				labels: [ 'Model X', 'Model B', 'Model A', 'Model Y'],
				datasets: [{
					label: 'Series A',
					backgroundColor: [app.colors.success , app.colors.info, app.colors.primary, app.colors.warning],
					borderColor: app.colors.transparent,
					pointBackgroundColor: app.colors.primary,
					borderWidth: 4,
					data: [ 56, 48, 47, 50]
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

		//chart-widgets-11
		var chartWidget11 = document.getElementById("chart-widgets-11");
		var chartWidget11Ctx = chartWidget11.getContext('2d');
		var chartWidget11Config = new Chart(chartWidget11Ctx, {
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
				},
				scale: {
					ticks: {
					   display: false
					}
				 }	
			 }
		});

		//chart-widget-12
		var chartWidget12Ctx = document.getElementById('chart-widgets-12').getContext('2d');		
		var chartWidget12 = new Chart(chartWidget12Ctx, {
			type: 'line',
			data: {
				labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
				datasets: [{
					label: 'Series A',
					backgroundColor: app.colors.transparent,
					borderColor: app.colors.success,
					data: [52, 66, 61, 76, 68, 74, 66, 73, 68, 72, 70, 78]
				},
				{
					label: 'Series B',
					backgroundColor: app.colors.transparent,
					borderColor: app.colors.info,
					data: [48, 58, 54, 60, 63, 63, 60, 60, 58, 63, 60, 68]
				},
				{
					label: 'Series C',
					backgroundColor: app.colors.transparent,
					borderColor: app.colors.primary,
					data: [45, 50, 50, 50, 53, 53, 50, 52, 51, 54, 55, 50]
				}],
			},
			options: {
				legend: {
					display: false
				},
				maintainAspectRatio: false,
				elements: {
					line: {
						tension: 0.2,
						borderWidth: 1.5
					}
				},
				scales: {
					xAxes: [{gridLines: { color: app.colors.transparent }}],
					yAxes: [{gridLines: { color: app.colors.borderColor }}]
				}
			}
		});

		//chart-widget-13
		var chartWidget13Ctx = document.getElementById('chart-widgets-13').getContext('2d');		
		var chartWidget13 = new Chart(chartWidget13Ctx, {
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

		
	};	

	window.chartWidgets = chartWidgets;

}(jQuery, window);

// initialize app
+function($) {
	chartWidgets.init();		
}(jQuery);
	


