<?php
	function __autoload($class){
		require_once "$class.class.php";
	}

	$array = array(49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51);
	$method = $_GET['method'];
	req($array, $method);
	
	function req($array, $method) {
		$m = ucfirst($method);
		$sort = new $m;
		$back = $sort->sort($array);
		echo implode(', ', $back);
	}