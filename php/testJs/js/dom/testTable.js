var myTable = $("#myTable").get(0);
$(function() {
	$("#createCaption").click(function() {
		var captionObj = myTable.createCaption();
		captionObj.innerHTML = "renho";
	})
	
	$("#deleteRow").click(function() {
		myTable.deleteRow(3);
	})
	
	$("#insertRow").click(function() {
		var tableRow = myTable.insertRow();
		var cell0 = tableRow.insertCell(0);
		var cell1 = tableRow.insertCell(1);
		var cell2 = tableRow.insertCell(2)
		cell0.innerHTML = "3";
		cell1.innerHTML = "renho2";
		cell2.innerHTML = "password2";
	})
})