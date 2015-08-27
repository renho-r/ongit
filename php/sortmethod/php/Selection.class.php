<?php
	class Selection implements Sort {
		public function sort($array) {
			for($i=0; $i<count($array); $i++) {
				$min = $i; 
				for($j=$i; $j<count($array); $j++) {
					if($array[$j]<$array[$min]) {
						$min = $j;
					}
				}
				$temp = $array[$i];
				$array[$i] = $array[$min];
				$array[$min] = $temp;
			}
			return $array;
		}
	}