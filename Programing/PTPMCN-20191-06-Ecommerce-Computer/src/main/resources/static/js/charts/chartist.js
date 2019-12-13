+function($, window){

	var chartistJs = {};

	chartistJs.init = function() {

		new Chartist.Line('#simple-line-chart', {
			labels: ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday'],
			series: [
			  [12, 9, 7, 8, 5],
			  [2, 1, 3.5, 7, 3],
			  [1, 3, 4, 5, 6]
			]
		  }, {
			fullWidth: true,
			chartPadding: {
			  right: 40
			}
		});

		var times = function(n) {
			return Array.apply(null, new Array(n));
		};
			
		var lineScatterdata = times(52).map(Math.random).reduce(function(data, rnd, index) {
			data.labels.push(index + 1);
			data.series.forEach(function(series) {
				series.push(Math.random() * 100)
			});
			
			return data;
		}, {
			labels: [],
			series: times(4).map(function() { return new Array() })
		});
			
		var lineScatterOptions = {
			showLine: false,
			axisX: {
				labelInterpolationFnc: function(value, index) {
				return index % 13 === 0 ? 'W' + value : null;
				}
			}
		};
			
		var lineScatterResponsiveOptions = [
			['screen and (min-width: 640px)', {
				axisX: {
				labelInterpolationFnc: function(value, index) {
					return index % 4 === 0 ? 'W' + value : null;
				}
				}
			}]
		];
			
		new Chartist.Line('#line-scatter-chart', lineScatterdata, lineScatterOptions, lineScatterResponsiveOptions);

		new Chartist.Line('#line-chart-area', {
			labels: [1, 2, 3, 4, 5, 6, 7, 8],
			series: [
			  [5, 9, 7, 8, 5, 3, 5, 4]
			]
		  }, {
				low: 0,
				showArea: true
		});
			
		new Chartist.Line('#bi-polar-chart', {
				labels: [1, 2, 3, 4, 5, 6, 7, 8],
				series: [
					[1, 2, 3, 1, -2, 0, 1, 0],
					[-2, -1, -2, -1, -2.5, -1, -2, -1],
					[0, 0, 0, 1, 2, 2.5, 2, 1],
					[2.5, 2, 1, 0.5, 1, 0.5, -1, -2.5]
				]
			}, {
				high: 3,
				low: -3,
				showArea: true,
				showLine: false,
				showPoint: false,
				fullWidth: true,
				axisX: {
					showLabel: false,
					showGrid: false
				}
		});
		
		var biPolarBarData = {
			labels: ['W1', 'W2', 'W3', 'W4', 'W5', 'W6', 'W7', 'W8', 'W9', 'W10'],
			series: [
				[1, 2, 4, 8, 6, -2, -1, -4, -6, -2]
			]
		};
		
		var biPolarBarOptions = {
			high: 10,
			low: -10,
			axisX: {
				labelInterpolationFnc: function(value, index) {
					return index % 2 === 0 ? value : null;
				}
			}
		};
		
		new Chartist.Bar('#bi-polar-bar', biPolarBarData, biPolarBarOptions);

		var overlappingBarData = {
			labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
			series: [
				[5, 4, 3, 7, 5, 10, 3, 4, 8, 10, 6, 8],
				[3, 2, 9, 5, 4, 6, 4, 6, 7, 8, 7, 4]
			]
		};
		
		var overlappingBarOptions = {
			seriesBarDistance: 10
		};
		
		var overlappingBarResponsiveOptions = [
			['screen and (max-width: 640px)', {
				seriesBarDistance: 5,
				axisX: {
					labelInterpolationFnc: function (value) {
						return value[0];
					}
				}
			}]
		];
		
		new Chartist.Bar('#ovelapping-bar', overlappingBarData, overlappingBarOptions, overlappingBarResponsiveOptions);

		new Chartist.Bar('#multi-line-label', {
			labels: ['First quarter of the year', 'Second quarter of the year', 'Third quarter of the year', 'Fourth quarter of the year'],
			series: [
				[60000, 40000, 80000, 70000],
				[40000, 30000, 70000, 65000],
				[8000, 3000, 10000, 6000]
			]
		}, {
			seriesBarDistance: 10,
			axisX: {
				offset: 60
			},
			axisY: {
				offset: 80,
				labelInterpolationFnc: function(value) {
					return value + ' CHF'
				},
				scaleMinSpace: 15
			}
		});

		new Chartist.Bar('#stacked-bar', {
			labels: ['Q1', 'Q2', 'Q3', 'Q4'],
			series: [
				[800000, 1200000, 1400000, 1300000],
				[200000, 400000, 500000, 300000],
				[100000, 200000, 400000, 600000]
			]
		}, {
			stackBars: true,
			axisY: {
				labelInterpolationFnc: function(value) {
					return (value / 1000) + 'k';
				}
			}
		}).on('draw', function(data) {
			if(data.type === 'bar') {
				data.element.attr({
					style: 'stroke-width: 30px'
				});
			}
		});

		new Chartist.Bar('#horizontal-bar', {
			labels: ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'],
			series: [
				[5, 4, 3, 7, 5, 10, 3],
				[3, 2, 9, 5, 4, 6, 4]
			]
		}, {
			seriesBarDistance: 10,
			reverseData: true,
			horizontalBars: true,
			axisY: {
				offset: 70
			}
		});

		new Chartist.Bar('#extreme-responsive', {
			labels: ['Quarter 1', 'Quarter 2', 'Quarter 3', 'Quarter 4'],
			series: [
				[5, 4, 3, 7],
				[3, 2, 9, 5],
				[1, 5, 8, 4],
				[2, 3, 4, 6],
				[4, 1, 2, 1]
			]
		}, {
			// Default mobile configuration
			stackBars: true,
			axisX: {
				labelInterpolationFnc: function(value) {
					return value.split(/\s+/).map(function(word) {
						return word[0];
					}).join('');
				}
			},
			axisY: {
				offset: 20
			}
		}, [
			// Options override for media > 400px
			['screen and (min-width: 400px)', {
				reverseData: true,
				horizontalBars: true,
				axisX: {
					labelInterpolationFnc: Chartist.noop
				},
				axisY: {
					offset: 60
				}
			}],
			// Options override for media > 800px
			['screen and (min-width: 800px)', {
				stackBars: false,
				seriesBarDistance: 10
			}],
			// Options override for media > 1000px
			['screen and (min-width: 1000px)', {
				reverseData: false,
				horizontalBars: false,
				seriesBarDistance: 15
			}]
		]);

		var pieChartData = {
			series: [5, 3, 4]
		};
		
		var sum = function(a, b) { return a + b };
		
		new Chartist.Pie('#pie-chart', pieChartData, {
			labelInterpolationFnc: function(value) {
				return Math.round(value / pieChartData.series.reduce(sum) * 100) + '%';
			}
		});
	
		var pieCustomLabelData = {
			labels: ['Bananas', 'Apples', 'Grapes'],
			series: [20, 15, 40]
		};
		
		var pieCustomLabelOptions = {
			labelInterpolationFnc: function(value) {
				return value[0]
			}
		};
		
		var pieCustomLabelResponsiveOptions = [
			['screen and (min-width: 640px)', {
				chartPadding: 30,
				labelOffset: 100,
				labelDirection: 'explode',
				labelInterpolationFnc: function(value) {
					return value;
				}
			}],
			['screen and (min-width: 1024px)', {
				labelOffset: 80,
				chartPadding: 20
			}]
		];
		
		new Chartist.Pie('#pie-custom-label', pieCustomLabelData, pieCustomLabelOptions, pieCustomLabelResponsiveOptions);
	
		new Chartist.Pie('#gauge-chart', {
			series: [20, 10, 30, 40]
		}, {
			donut: true,
			donutWidth: 60,
			startAngle: 270,
			total: 200,
			showLabel: false
		});

		new Chartist.Pie('#donut-chart', {
			series: [20, 10, 30, 40]
			}, {
			donut: true,
			donutWidth: 60,
			donutSolid: true,
			startAngle: 270,
			showLabel: true
		});
	};	

	window.chartistJs = chartistJs;

}(jQuery, window);

// initialize app
+function($) {
	chartistJs.init();		
}(jQuery);
