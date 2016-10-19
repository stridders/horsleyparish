jQuery(function($){
	'use strict';

	// -------------------------------------------------------------
	//   Force Centered Navigation
	// -------------------------------------------------------------
	(function () {
		var $frame = $('#forcecentered');
		var $wrap  = $frame.parent();
		var $SlideSpeed = 1000;
		
		var $URL_sel = getUrlVars()["sel"];
		if ( $URL_sel == null ) {
			 $URL_sel = 0;
		} else {
			$URL_sel = parseInt($URL_sel);
			$SlideSpeed = 1;
		}

		// Call Sly on frame
		$frame.sly({
			horizontal: 1,
			itemNav: 'forceCentered',
			smart: 1,
			activateMiddle: 1,
			activateOn: 'click',
			dragSource: null,
			mouseDragging: 0,
			touchDragging: 0,
			releaseSwing: 1,
			startAt: $URL_sel,
			scrollSource: "none",
			scrollBar: $wrap.find('.scrollbar'),
			scrollBy: 1,
			speed: $SlideSpeed,
			elasticBounds: 1,
			easing: 'easeOutExpo',
			dragHandle: 0,
			dynamicHandle: 0,
			clickBar: 1,

			// Buttons
			prev: $wrap.find('.prev'),
			next: $wrap.find('.next')
		});
		
		// To Start button
		$wrap.find('.toStart').on('click', function () {
			var item = $(this).data('item');
			// Animate a particular item to the start of the frame.
			// If no item is provided, the whole content will be animated.
			var $SlideSpeed = 1000;
			$frame.sly('toStart', item);
		});

		// To Center button
		$wrap.find('.toCenter').on('click', function () {
			var item = $(this).data('item');
			// Animate a particular item to the center of the frame.
			// If no item is provided, the whole content will be animated.
			var $SlideSpeed = 1000;
			$frame.sly('toCenter', item);
		});

		// To End button
		$wrap.find('.toEnd').on('click', function () {
			var item = $(this).data('item');
			// Animate a particular item to the end of the frame.
			// If no item is provided, the whole content will be animated.
			var $SlideSpeed = 1000;
			$frame.sly('toEnd', item);
		});
		
		
	}());

});