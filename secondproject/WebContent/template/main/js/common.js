var scripts = document.getElementsByTagName('script');
var myScript = scripts[ scripts.length - 1 ];
var queryString = myScript.src.replace(/^[^\?]+\??/,'');
var params = parseQueryString( queryString );

function parseQueryString ( query ) {
	var Params = new Object ();
	if ( ! query ) return Params; // return empty object
	var Pairs = query.split(/[;&]/);
	for ( var i = 0; i < Pairs.length; i++ ) {
		var KeyVal = Pairs[i].split('=');
		if ( ! KeyVal || KeyVal.length != 2 ) continue;
		var key = unescape( KeyVal[0] );
		var val = unescape( KeyVal[1] );
		val = val.replace(/\+/g, ' ');
		Params[key] = val;
	}
	return Params;
}

var CONTEXT_PATH = params.root;
var MODE = 'DEBUG';

function SYSOUT(data) {
	if (MODE === 'DEBUG') {
		console.log(data);
	}
}



var header = $('#header-container');
function checkScrollTop() {
	if ($(window).scrollTop() < 10) {
		header.removeClass('scrollActive');
	} else {
		header.addClass('scrollActive');
	}
}

checkScrollTop();


$(window).on('scroll', checkScrollTop);


SYSOUT('CONTEXT_PATH = ' + CONTEXT_PATH);
SYSOUT('MODE = ' + MODE);