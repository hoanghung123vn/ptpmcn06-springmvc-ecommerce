+function ($, window) {

	var defaultDashboaard = {};

	defaultDashboaard.init = function () {

		//Overview Chart
		var overviewCtx = document.getElementById('customer-overview-chart').getContext('2d');
		const numberOrderOfMonths = document.getElementById("numberOrderOfMonths").getAttribute("value").replace("[", "").replace("]", "").split(",");
		const orderOfMonths = numberOrderOfMonths.map(number => parseInt(number));

		const sumPriceOfMonths = document.getElementById("sumPriceOfMonths").getAttribute("value").replace("[", "").replace("]", "").split(",");
		const priceOfMonths = sumPriceOfMonths.map(price => {
			if (price == "0" || parseInt(price) < 1000000) {
				return 0;
			} else {
				return parseInt(price) / 1000000;
			}
		});
		var overviewChart = new Chart(overviewCtx, {
			type: 'line',
			data: {
				labels: ["Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"],
				datasets: [{
					label: 'Số đơn hàng',
					backgroundColor: app.colors.transparent,
					borderColor: app.colors.success,
					data: orderOfMonths
				},
				{
					label: 'Doanh thu (triệu đồng)',
					backgroundColor: app.colors.transparent,
					borderColor: app.colors.primary,
					data: priceOfMonths
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
					xAxes: [{ gridLines: { color: app.colors.transparent } }],
					yAxes: [{ gridLines: { color: app.colors.borderColor } }]
				}
			}
		});

		//Plugin code for Donut Chart center text
		Chart.pluginService.register({
			beforeDraw: function (chart) {
				if (chart.config.options.elements.center) {
					var ctx = chart.chart.ctx;
					var centerConfig = chart.config.options.elements.center;
					var fontStyle = centerConfig.fontStyle || 'Arial';
					var txt = centerConfig.text;
					var color = centerConfig.color || '#000';
					var sidePadding = centerConfig.sidePadding || 20;
					var sidePaddingCalculated = (sidePadding / 100) * (chart.innerRadius * 2)
					ctx.font = "30px " + fontStyle;
					var stringWidth = ctx.measureText(txt).width;
					var elementWidth = (chart.innerRadius * 2) - sidePaddingCalculated;
					var widthRatio = elementWidth / stringWidth;
					var newFontSize = Math.floor(30 * widthRatio);
					var elementHeight = (chart.innerRadius * 2);
					var fontSizeToUse = Math.min(newFontSize, elementHeight);
					ctx.textAlign = 'center';
					ctx.textBaseline = 'middle';
					var centerX = ((chart.chartArea.left + chart.chartArea.right) / 2);
					var centerY = ((chart.chartArea.top + chart.chartArea.bottom) / 2);
					ctx.font = fontSizeToUse + "px " + fontStyle;
					ctx.fillStyle = color;

					ctx.fillText(txt, centerX, centerY);
				}
			}
		});

		//Goal Chart number order
		const numberOrder = document.getElementById("numberOrder").value;
		const numberOrderReal = parseInt(document.getElementById("numberOrderReal").innerHTML);
		const percentNumberOrder = Math.round(numberOrderReal / numberOrder * 100);
		var goalCtx = document.getElementById('goal-chart-number-order').getContext('2d');
		goalCtx.height = 150;
		var goalChartGradient = goalCtx.createLinearGradient(0, 0, 0, 150);
		goalChartGradient.addColorStop(0, app.colors.gradientInfoStart);
		goalChartGradient.addColorStop(1, app.colors.gradientInfoStop);

		var donutConfig = new Chart(goalCtx, {
			type: 'doughnut',
			data: {
				labels: ["Sales", "In-Store Sales"],
				datasets: [{
					data: [percentNumberOrder, 100 - percentNumberOrder],
					backgroundColor: [goalChartGradient, app.colors.gray]
				}]
			},
			options: {
				elements: {
					center: {
						text: percentNumberOrder + '%',
						color: app.colors.dark,
						sidePadding: 70
					}
				},
				maintainAspectRatio: false,
				hover: { mode: null },
				legend: {
					display: false
				},
				cutoutPercentage: 80,
			}
		});

		//Goal Chart revenue 
		const revenue = document.getElementById("revenue").value;
		const revenueReal = parseInt(document.getElementById("revenueReal").getAttribute("name"));
		const percentRevenue = Math.round(revenueReal / revenue * 100);
		var goalCtx1 = document.getElementById('goal-chart-revenue').getContext('2d');
		goalCtx1.height = 150;
		var goalChartGradient1 = goalCtx1.createLinearGradient(0, 0, 0, 150);
		goalChartGradient1.addColorStop(0, app.colors.gradientInfoStart);
		goalChartGradient1.addColorStop(1, app.colors.gradientInfoStop);

		var donutConfig1 = new Chart(goalCtx1, {
			type: 'doughnut',
			data: {
				labels: ["Sales", "In-Store Sales"],
				datasets: [{
					data: [percentRevenue, 100 - percentRevenue],
					backgroundColor: [goalChartGradient1, app.colors.gray]
				}]
			},
			options: {
				elements: {
					center: {
						text: percentRevenue + '%',
						color: app.colors.dark,
						sidePadding: 70
					}
				},
				maintainAspectRatio: false,
				hover: { mode: null },
				legend: {
					display: false
				},
				cutoutPercentage: 80,
			}
		});

		//Sales Sparkline
		var saleSparkLineData = [4, 10, 8, 10, 9, 10, 11, 7, 5, 8, 9, 6, 11];

		$("#sparkline-line-chart").sparkline(saleSparkLineData,
			{
				type: 'line',
				width: '170',
				spotColor: false,
				minSpotColor: false,
				maxSpotColor: false,
				lineWidth: 1.5,
				height: '40',
				fillColor: app.colors.successOpacity,
				lineColor: app.colors.success
			});

		//Earning Chart
		var earningCtx = document.getElementById('earning-chart').getContext('2d');
		var bar_chart = new Chart(earningCtx, {
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
					xAxes: [{ display: false }],
					yAxes: [{ display: false }]
				}
			}
		});
	};

	window.defaultDashboaard = defaultDashboaard;

}(jQuery, window);

// initialize app
+function ($) {
	defaultDashboaard.init();
}(jQuery);
