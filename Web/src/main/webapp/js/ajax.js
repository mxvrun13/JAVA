/**
 * ajax.js
 */
function ajaxFnc() {
	console.log("1");

	let xhtp = new XMLHttpRequest();
	xhtp.open("get", "EmpListServlet");
	xhtp.send();
	xhtp.onreadystatechange = function() {
		if (xhtp.readyState == 4 && xhtp.status == 200) {
			let data = JSON.parse(xhtp.responseText);
			console.log(data);
		}
		/*		console.log(xhtp.readyState, xhtp.status);
				console.log("2");*/
	}
	console.log("3");
}