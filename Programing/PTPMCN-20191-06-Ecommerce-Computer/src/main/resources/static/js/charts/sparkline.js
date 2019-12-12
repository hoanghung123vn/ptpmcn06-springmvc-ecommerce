+function($, window){

	var sparklineChart = {};

	sparklineChart.init = function() {

		var sparklineData1 = [8, 10, 8, 10, 9, 10];
		var sparklineData2 = [5, 6, 7, 2, 0, -4, -2, 4 ];
		var sparklineData3 = [ [1,4], [2, 3], [3, 2], [4, 1] ];
		var sparklineData4 = [10, 8, 5, 7, 4, 4];
		var sparklineData5 = [5, 6, 7, 2, 0, 4, 2, 4];
		var sparklineData6 = [4, 6, 7, 7, 4, 3, 2, 1, 4, 4];
		var sparklineData7 = [10, 12, 12, 9, 7];
		var sparklineData8 = [1, 1, 0, 1, -1, -1, 1, -1, 0, 0, 1, 1];
		var sparklineData9 = [4, 27, 34, 52, 54, 59, 61, 68, 78, 82, 85, 87, 91, 93, 100];
		var sparklineData10 = [1, 1, 2];

		$("#sparkline-line-chart").sparkline( sparklineData1,  
		{
			type: 'line',
			width: '130',
			spotColor: false,
			minSpotColor: false,
			maxSpotColor:false,
			lineWidth: 1.5,
			height: '30',
			fillColor: app.colors.successOpacity,
			lineColor: app.colors.success
		});
		
		$("#sparkline-bar-chart").sparkline(sparklineData1,  
		{
			type: 'bar',
			height: '30',
			barWidth: 7,
			barSpacing: 5,
			barColor: app.colors.info
		});
		
		$("#sparkline-negative-bar-chart").sparkline(sparklineData2,  
		{
			type: 'bar',
			height: '30',
			barWidth: 7,
			barSpacing: 5,
			barColor: app.colors.success,
			negBarColor: app.colors.danger
		});

		$("#sparkline-stacked-bar-chart").sparkline(sparklineData3,  
		{
			type: 'bar',
			height: '30',
			barWidth: 7,
			barSpacing: 5,
			stackedBarColor: [app.colors.info,  app.colors.infoOpacity]
		});

		$("#sparkline-composite-chart").sparkline(sparklineData2,  
		{
			type: 'line',
			height: '30',
			width: '100',
			spotColor: false,
			minSpotColor: false,
			maxSpotColor:false,
			fillColor: false,
			lineColor: app.colors.success,
			lineWidth: 1.5
		});

		$("#sparkline-composite-chart").sparkline(sparklineData4,  
		{
			composite: true,
			fillColor: false,
			spotColor: false,
			minSpotColor: false,
			maxSpotColor:false,
			lineColor: app.colors.danger,
			lineWidth: 1.5
		});

		$("#inline-with-range").sparkline(sparklineData4,  
		{
			type: 'line',
			height: '30',
			width: '100',
			spotColor: false,
			minSpotColor: false,
			maxSpotColor:false,
			fillColor: false,
			lineColor: app.colors.info,
			lineWidth: 1.5,
			normalRangeMin: 0,
			normalRangeMax: 10,
			normalRangeColor: app.colors.infoOpacity
		});

		$("#composite-bar-chart").sparkline(sparklineData5,  
		{
			type: 'bar',
			width: '100',
			height: '30',
			barWidth: 7,
			barSpacing: 5,
			barColor: app.colors.successOpacity
		});
	
		$("#composite-bar-chart").sparkline(sparklineData4,  
		{
			type: 'line',
			composite: true,
			fillColor: false,
			spotColor: false,
			minSpotColor: false,
			maxSpotColor:false,
			lineColor: app.colors.success,
			lineWidth: 1.5
		});

		$("#sparkline-discrete-chart").sparkline(sparklineData6,  
		{
			type: 'discrete',
			height: '30',
			lineColor: app.colors.info,
			lineWidth: 1.5
		});

		$("#discrete-threshold-chart").sparkline(sparklineData6,  
		{
			type: 'discrete',
			height: '30',
			lineColor: app.colors.info,
			lineWidth: 1.5,
			thresholdValue: 4,
			thresholdColor: app.colors.danger
		});

		$("#bullet-chart").sparkline(sparklineData6,  
		{
			type: 'bullet',
			height: '30',
			targetColor: app.colors.danger,
			performanceColor: app.colors.success,
    		rangeColors: [app.colors.successOpacity]
		});

		$("#customize-chart").sparkline(sparklineData6,  
		{
			type: 'line',
			width: '130',
			spotColor: app.colors.danger,
			minSpotColor: false,
			maxSpotColor:false,
			lineWidth: 1.5,
			height: '30',
			fillColor: app.colors.infoOpacity,
			lineColor: app.colors.info
		});

		$("#tristate-chart").sparkline(sparklineData8,  
		{
			type: 'tristate',
			height: '30',
			posBarColor: app.colors.success,
			negBarColor: app.colors.danger,
			zeroBarColor: app.colors.info,
			barWidth: 7,
			barSpacing: 5
		});

		$("#box-plot-chart").sparkline(sparklineData9,  
		{
			type: 'box',
			height: '30',
			boxLineColor: app.colors.info,
			boxFillColor: app.colors.infoOpacity,
			medianColor:  app.colors.danger
		});

		$("#sparkline-pie-chart").sparkline(sparklineData10,  
			{
				type: 'pie',
				height: '30',
    			sliceColors: [app.colors.warning, app.colors.primary, app.colors.success]
			});
	};	

	window.sparklineChart = sparklineChart;

}(jQuery, window);

// initialize app
+function($) {
	sparklineChart.init();		
}(jQuery);
