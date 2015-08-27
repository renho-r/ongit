<?php
	class Bubbling implements Sort {
		public function sort($array) {
			for($i=0; $i<count($array); $i++) {
				for($j=$i; $j<count($array); $j++) {
					if($array[$i] > $array[$j]) {
						$temp = $array[$i];
						$array[$i] = $array[$j];
						$array[$j] = $temp;
					}
				}
			}
			return $array;
		}
	}