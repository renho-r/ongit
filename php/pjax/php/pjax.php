<?php
	function is_pjax() {
		return array_key_exists ( 'HTTP_X_PJAX', $_SERVER ) && $_SERVER ['HTTP_X_PJAX'];
	}
	if (is_pjax()) {
		echo "pjax";
	} else {
		echo "not pjax";
	}