<?php
	date_default_timezone_set("PRC");
	
	$responce = new stdClass();
	$responce->date = date("Y-m-d h:i:s", time());
	echo json_encode($responce);