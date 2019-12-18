+function($, window){

	var vectorMap = {};

	vectorMap.init = function() {

		$('#world-map').vectorMap({
			map: 'world_mill',
			backgroundColor: app.colors.white,
			zoomOnScroll: false,
			hoverColor: app.colors.borderColor,
			regionStyle: {
				initial: {
					fill: app.colors.borderColor,
					'cursor': 'pointer'
				},
				hover: {
					fill: app.colors.dark,
					'fill-opacity': 0.3
				}
			}
		});

		$('#canada-map').vectorMap({
			map: 'ca_lcc',
			backgroundColor: app.colors.white,
			zoomOnScroll: false,
			hoverColor: app.colors.borderColor,
			regionStyle: {
				initial: {
					fill: app.colors.borderColor,
					'stroke-width': 2.2,
					'stroke': app.colors.white,
					'cursor': 'pointer'
				},
				hover: {
					fill: app.colors.dark,
					'fill-opacity': 0.3
				}
			}
		});

		$('#us-map').vectorMap({
			map: 'us_aea',
			backgroundColor: app.colors.white,
			zoomOnScroll: false,
			regionStyle: {
				initial: {
					fill: app.colors.white,
					'stroke-width': 2.2,
					'stroke': app.colors.borderColor,
					'cursor': 'pointer'
				},
				hover: {
					'fill-opacity': 0.6
				}
			},
			markerStyle: {
                initial: {
                    fill: app.colors.info,
                    stroke: app.colors.info,
                    'fill-opacity': 1,
                    'stroke-width': 8,
                    'stroke-opacity': 0.3,
                    'cursor': 'pointer',
                    r: 5
                },
                hover: {
                    r: 8,
                    stroke: app.colors.info,
                    'stroke-width': 10
                }
            },
            series: {
                regions: [{
                    values: {
                        "US-NE": app.colors.gradientSuccess,
                        "US-GA": app.colors.gradientSuccess,
                        "US-TX": app.colors.gradientSuccess,
                        "US-UT": app.colors.gradientSuccess
                    },
                    attribute: 'fill'
                }]
            }
		});

		$('#map-marker').vectorMap({
			map: 'us_aea',
			backgroundColor: app.colors.white,
			zoomOnScroll: false,
			regionStyle: {
				initial: {
					fill: app.colors.white,
					'stroke-width': 2.2,
					'stroke': app.colors.borderColor,
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
				style: { fill: app.colors.gradientSuccess, stroke: app.colors.success, 'fill-opacity': 1, 'stroke-width': 10, 'stroke-opacity': 0.3, 'cursor': 'pointer', r: 10}
			}, {
				latLng: [39.41, -111.95],
				name: '(-28.12)',
				style: { fill: app.colors.gradientPrimary, stroke: app.colors.primary, 'fill-opacity': 1, 'stroke-width': 10, 'stroke-opacity': 0.3, 'cursor': 'pointer', r: 10}
			}, {
				latLng: [33.24, -83.44],
				name: '(+18.84%)',
				style: { fill: app.colors.gradientInfo, stroke: app.colors.info, 'fill-opacity': 1, 'stroke-width': 10, 'stroke-opacity': 0.3, 'cursor': 'pointer', r: 10}
			}, {
				latLng: [40.80, -96.68],
				name: '(+3.34%)',
				style: { fill: app.colors.gradientWarning, stroke: app.colors.warning, 'fill-opacity': 1, 'stroke-width': 10, 'stroke-opacity': 0.3, 'cursor': 'pointer', r: 10}
			}]
		});
	};	
	window.vectorMap = vectorMap;

}(jQuery, window);

// initialize app
+function($) {
	vectorMap.init();		
}(jQuery);
