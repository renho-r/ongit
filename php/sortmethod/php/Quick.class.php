<?php
	class Quick implements Sort {
		public function sort($array) {
			$this->msort($array, 0, count($array) - 1);
			return $array;
		}
		private function msort(& $array, $low, $hight) {
			if($low < $hight) {
				$i = $low;
				$j = $hight;
				$value = $array[$low];
				while ($i < $j) {
					while ($i<$j && $array[$j] >= $value) {
						$j--;
					}
					$array[$i] = $array[$j];
					while ($i<$j && $array[$i] <= $value) {
						$i++;
					}
					$array[$j] = $array[$i];
				}
				$array[$i] = $value;
				$this->msort($array, $low, $i);
				$this->msort($array, $i + 1, $hight);
			}
		}
	}