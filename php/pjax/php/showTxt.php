<?php
	function is_pjax() {
		return array_key_exists ( 'HTTP_X_PJAX', $_SERVER ) && $_SERVER ['HTTP_X_PJAX'];
	}
	
	$html = "<br><input type='button' id='next' value='next'>";
	
	if (is_pjax ()) {
		$file = fopen ('a.txt', "r" );
		// $backStr = fread($file, "100");
		$backStr = fgets ( $file );
		fclose ( $file );
		
		$file = fopen ( 'a.txt', "r" );
		fseek ( $file, strlen ( $backStr ) );
		$backStr0 = fgets ( $file );
		fclose ( $file );
		
		echo $backStr . $backStr0 . $html;
	} else {
		$index = $_POST ['index'];
		$str = file_get_contents ( 'a.txt' );
		$strs = preg_split ( '/.{1,5}章/', $str );
// 		echo count($strs);
		echo count ( $strs ).$strs [$index].$html;
	}
	