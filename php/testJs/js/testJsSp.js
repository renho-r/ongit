(function(window, document, undefined) {
	p(0);
	(function(factory) {
		"use strict";
		p(1);
		if ( typeof define === 'function' && define.amd ) {
			define( 'datatables', ['jquery'], factory );
		}
	    else if ( typeof exports === 'object' ) {
	        module.exports = factory( require( 'jquery' ) );
	    }
		else if ( jQuery && !jQuery.fn.dataTable ) {
			factory( jQuery );
		}
	}(function($) {
		"use strict";
		p(2);
	 }))
}(window, document));

function p() {
	console.info(arguments);
}