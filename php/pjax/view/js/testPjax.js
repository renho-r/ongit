$(function() {
	var thisState = {
			title : "renho-testPjax.html",
			url : "testPjax.html",
			otherkey : "othervalue"
	};
	window.history.pushState(thisState, thisState.title, thisState.url);
	
	$("#pushState").click(function() {
		var state = {
				title : "renho",
				url : "/pjax/renho",
				otherkey : "othervalue"
		};
		window.history.pushState(state, state.title, state.url);
		document.title = state.title;
	})
})

window.addEventListener('popstate', function(evt) {
	var state = evt.state;
	var newTitle = state.title;
	document.title = newTitle;
}, false);