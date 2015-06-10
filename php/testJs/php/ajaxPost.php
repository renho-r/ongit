<?php
	date_default_timezone_set("PRC");

	$start = $_POST['start'];
	$limit = $_POST['limit'];
	$responce = new stdClass();
	$responce->start = $start;
	$responce->limit = $limit;
	$responce->date = date("Y-m-d h:i:s", time());
	
	echo json_encode($responce);