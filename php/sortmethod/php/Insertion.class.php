<?php
	class Insertion implements Sort {
		public function sort($array) {
			for ($i=1; $i<count($array); $i++) {
				$j = $i;
				$temp = $array[$j];
				while($j>0 && $array[$j-1]>$temp) {
					$array[$j] = $array[$j-1];
					$j--;
				}
				$array[$j] = $temp;
			}
			return $array;
		}
	}