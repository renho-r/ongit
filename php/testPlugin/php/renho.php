<?php
	date_default_timezone_set("PRC");
	
	$responce = new stdClass();
	$responce->renho = "renho";
	$responce->now = date('Y-m-d h:i:s');
	
	echo json_encode($responce);