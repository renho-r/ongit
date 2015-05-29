<?php
	$method = $_GET["method"];
	$method();

	function getXml() {
		echo '<books><book><title>blah</title></book></books>';
	}

	function getJson() {
		$renho = $_GET["renho"];
		$responce = new StdClass;
		$responce->backJson = $renho;
		echo json_encode($responce);
	}