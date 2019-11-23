+function($, window){

	var googleMap = {};

	googleMap.init = function() {

		var latitude = 3.117726, longitude = 101.677358, mapZoom = 15;
		var contentString = '<h4>Info Window</h4>'+
							'<div class="m-t-10">' +
							'<p>Climb leg rub face on everything give attitude nap all day for under the bed. Chase mice attack feet but rub face on everything hopped up on goofballs.</p>' +
							'</div>';

		// Map Configuration
		var basicMapConfig = {
			center: new google.maps.LatLng(latitude, longitude),
			zoom: mapZoom
		};

		var styledMapConfig = {
			center: new google.maps.LatLng(latitude, longitude),
				zoom: mapZoom,
				styles: [
						{
						"featureType": "landscape",
						"stylers": [
							{
								"hue": "#FFBB00"
							},
							{
								"saturation": 43.400000000000006
							},
							{
								"lightness": 37.599999999999994
							},
							{
								"gamma": 1
							}
						]
					},
					{
						"featureType": "road.highway",
						"stylers": [
							{
								"hue": "#FFC200"
							},
							{
								"saturation": -61.8
							},
							{
								"lightness": 45.599999999999994
							},
							{
								"gamma": 1
							}
						]
					},
					{
						"featureType": "road.arterial",
						"stylers": [
							{
								"hue": "#FF0300"
							},
							{
								"saturation": -100
							},
							{
								"lightness": 51.19999999999999
							},
							{
								"gamma": 1
							}
						]
					},
					{
						"featureType": "road.local",
						"stylers": [
							{
								"hue": "#FF0300"
							},
							{
								"saturation": -100
							},
							{
								"lightness": 52
							},
							{
								"gamma": 1
							}
						]
					},
					{
						"featureType": "water",
						"stylers": [
							{
								"hue": "#0078FF"
							},
							{
								"saturation": -13.200000000000003
							},
							{
								"lightness": 2.4000000000000057
							},
							{
								"gamma": 1
							}
						]
					},
					{
						"featureType": "poi",
						"stylers": [
							{
								"hue": "#00FF6A"
							},
							{
								"saturation": -1.0989010989011234
							},
							{
								"lightness": 11.200000000000017
							},
							{
								"gamma": 1
							}
						]
					}
				],
			  mapTypeId: 'roadmap'
		};

		var markerMapConfig = {
			center: new google.maps.LatLng(latitude, longitude),
				zoom: mapZoom,
				styles: [
					{
						"featureType": "landscape.man_made",
						"elementType": "geometry",
						"stylers": [
							{
								"color": "#f7f1df"
							}
						]
					},
					{
						"featureType": "landscape.natural",
						"elementType": "geometry",
						"stylers": [
							{
								"color": "#d0e3b4"
							}
						]
					},
					{
						"featureType": "landscape.natural.terrain",
						"elementType": "geometry",
						"stylers": [
							{
								"visibility": "off"
							}
						]
					},
					{
						"featureType": "poi",
						"elementType": "labels",
						"stylers": [
							{
								"visibility": "off"
							}
						]
					},
					{
						"featureType": "poi.business",
						"elementType": "all",
						"stylers": [
							{
								"visibility": "off"
							}
						]
					},
					{
						"featureType": "poi.medical",
						"elementType": "geometry",
						"stylers": [
							{
								"color": "#fbd3da"
							}
						]
					},
					{
						"featureType": "poi.park",
						"elementType": "geometry",
						"stylers": [
							{
								"color": "#bde6ab"
							}
						]
					},
					{
						"featureType": "road",
						"elementType": "geometry.stroke",
						"stylers": [
							{
								"visibility": "off"
							}
						]
					},
					{
						"featureType": "road",
						"elementType": "labels",
						"stylers": [
							{
								"visibility": "off"
							}
						]
					},
					{
						"featureType": "road.highway",
						"elementType": "geometry.fill",
						"stylers": [
							{
								"color": "#ffe15f"
							}
						]
					},
					{
						"featureType": "road.highway",
						"elementType": "geometry.stroke",
						"stylers": [
							{
								"color": "#efd151"
							}
						]
					},
					{
						"featureType": "road.arterial",
						"elementType": "geometry.fill",
						"stylers": [
							{
								"color": "#ffffff"
							}
						]
					},
					{
						"featureType": "road.local",
						"elementType": "geometry.fill",
						"stylers": [
							{
								"color": "black"
							}
						]
					},
					{
						"featureType": "transit.station.airport",
						"elementType": "geometry.fill",
						"stylers": [
							{
								"color": "#cfb2db"
							}
						]
					},
					{
						"featureType": "water",
						"elementType": "geometry",
						"stylers": [
							{
								"color": "#a2daf2"
							}
						]
					}
				],
			  mapTypeId: 'roadmap'
		};

		var infoWindowMapConfig = {
			center: new google.maps.LatLng(latitude, longitude),
				zoom: mapZoom,
				styles: [
					{
						"featureType": "landscape.natural",
						"elementType": "geometry.fill",
						"stylers": [
							{
								"visibility": "on"
							},
							{
								"color": "#e0efef"
							}
						]
					},
					{
						"featureType": "poi",
						"elementType": "geometry.fill",
						"stylers": [
							{
								"visibility": "on"
							},
							{
								"hue": "#1900ff"
							},
							{
								"color": "#c0e8e8"
							}
						]
					},
					{
						"featureType": "road",
						"elementType": "geometry",
						"stylers": [
							{
								"lightness": 100
							},
							{
								"visibility": "simplified"
							}
						]
					},
					{
						"featureType": "road",
						"elementType": "labels",
						"stylers": [
							{
								"visibility": "off"
							}
						]
					},
					{
						"featureType": "transit.line",
						"elementType": "geometry",
						"stylers": [
							{
								"visibility": "on"
							},
							{
								"lightness": 700
							}
						]
					},
					{
						"featureType": "water",
						"elementType": "all",
						"stylers": [
							{
								"color": "#7dcdcd"
							}
						]
					}
				],
			  mapTypeId: 'roadmap'
		};

		// Create Map
		var basicMap = new google.maps.Map(document.getElementById('basic-map'),basicMapConfig);
		var styledMap = new google.maps.Map(document.getElementById('styled-map'),styledMapConfig);
		var markerMap = new google.maps.Map(document.getElementById('marker-map'),markerMapConfig);
		var customMarkerMap = new google.maps.Map(document.getElementById('custom-marker-map'), {
			zoom: 16,
			center: new google.maps.LatLng(latitude, longitude),
			mapTypeId: 'roadmap'
		});
		var infoWindowMap = new google.maps.Map(document.getElementById('info-window-map'),infoWindowMapConfig);


		// Marker
		var marker = new google.maps.Marker({
			position: new google.maps.LatLng(latitude, longitude),
			map: markerMap,
			visible: true
		});

		var customMarker = new google.maps.Marker({
			position: new google.maps.LatLng(latitude, longitude),
			icon: 'http://themenate.com/images/marker.png',
			map: customMarkerMap,
			visible: true
		});

		var infowindowMarker = new google.maps.Marker({
			position: new google.maps.LatLng(latitude, longitude),
			map: infoWindowMap,
			title: 'Uluru (Ayers Rock)'
		});

		// Info Window 
		infowindowMarker.addListener('click', function() {
			infowindow.open(infoWindowMap, infowindowMarker);
		});

		var infowindow = new google.maps.InfoWindow({
			content: contentString
		});

	};	
	window.googleMap = googleMap;

}(jQuery, window);

// initialize app
+function($) {
	googleMap.init();		
}(jQuery);
