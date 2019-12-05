+function($, window){
	
	var bankDashboard = {};

	bankDashboard.init = function() {

		//Account Chart
		var accountCtx = document.getElementById('account-chart').getContext('2d');		
		var accountChart = new Chart(accountCtx, {
			type: 'line',
			data: {
				labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
				datasets: [
				{
					label: 'Series B',
					backgroundColor: app.colors.transparent,
					borderColor: app.colors.success,
					data: [46, 58, 54, 60, 63, 63, 60, 60, 58, 63, 60, 71]
				}],
			},
			options: {
				legend: {
					display: false
				},
				maintainAspectRatio: false,
				elements: {
					line: {
						tension: 0.3,
						borderWidth: 2.2
					}
				},
				scales: {
					xAxes: [{gridLines: { color: app.colors.transparent }}],
					yAxes: [{gridLines: { color: app.colors.borderColor }}]
				}
			}
		});

		//Money Chart
		var moneyCtx = document.getElementById('money-chart').getContext('2d');
		moneyCtx.height = 150;
		var moneyChartGradient = moneyCtx.createLinearGradient(0, 0, 0, 150);
		moneyChartGradient.addColorStop(0, app.colors.gradientSuccessStart);
		moneyChartGradient.addColorStop(1, app.colors.gradientSuccessStop);

		var moneyChartGradient2 = moneyCtx.createLinearGradient(0, 0, 0, 150);
		moneyChartGradient2.addColorStop(0, app.colors.gradientPrimaryStart);
		moneyChartGradient2.addColorStop(1, app.colors.gradientPrimaryStop);

		var donutConfig = new Chart(moneyCtx, {
			type: 'doughnut',
			data: {
				labels: ["Sales", "In-Store Sales"],
				datasets: [{
					data: [35, 20, 45],
					backgroundColor: [moneyChartGradient, moneyChartGradient2, app.colors.info]
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

		//Holdings Chart
		var earningCtx = document.getElementById('holdings-chart').getContext('2d');		
		var bar_chart = new Chart(earningCtx, {
			type: 'line',
			data: {
				labels: ["W1", "W2", "W3", "W4", "W5", "W6", "W7", "W8", "W9", "W10", "W11", "W12"],
				datasets: [{
					label: 'Series A',
					backgroundColor: app.colors.primaryOpacity,
					borderColor: app.colors.primary,
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
	};	

	window.bankDashboard = bankDashboard;

}(jQuery, window);

// initialize app
+function($) {
	bankDashboard.init();		
}(jQuery);
	