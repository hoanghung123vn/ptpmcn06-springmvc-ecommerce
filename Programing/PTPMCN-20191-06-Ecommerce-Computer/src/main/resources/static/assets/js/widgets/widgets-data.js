+function($, window){
	
	var dataWidgets = {};

	dataWidgets.init = function() {
		
		var sparkLineData1 = [4, 10, 8, 10, 9, 10, 11, 7, 5, 8, 9, 6, 11];

		$("#data-widgets-sparkline-1").sparkline( sparkLineData1,  
		{
			type: 'bar',
			width: '100',
			height: '40',
			barWidth: 3,
			barSpacing: 5,
			barColor: app.colors.info
		});

		$("#data-widgets-sparkline-2").sparkline( sparkLineData1,  
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
		
		$("#data-widgets-sparkline-3").sparkline( sparkLineData1,  
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

		$('#dt-opt').DataTable();
	};	

	window.dataWidgets = dataWidgets;

}(jQuery, window);

// initialize app
+function($) {
	dataWidgets.init();		
}(jQuery);
	


