<?php
	$method = $_POST["method"];
	$method();

	function getXml() {
		echo '<?xml version="1.0" encoding="UTF-8"?><books><book><title>blah</title><bookName>书名</bookName></book></books>';
	}

	function getJson() {
		$renho = $_GET["renho"];
		$responce = new StdClass;
		$responce->backJson = $renho;
		echo json_encode($responce);
	}