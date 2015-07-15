<?php
	class Head implements Sort {
		public function sort($array) {
			$this->createMaxdHeap($array, (count($array)-1)/2, count($array));
			for($i=count($array)-1; $i>0; $i--) {
				$this->swap($array, $i, 0);
				$this->createMaxdHeap($array, 0, $i);
			}
			return $array;
		}
		/**
		 * ×î´ó¶Ñ
		 * @param unknown $a
		 * @param unknown $start
		 * @param unknown $length
		 */
		private function createMaxdHeap(& $a, $start, $length) {
			for(; $start>=0; $start--) {
				$left = 2 * $start + 1;
				$temp = $a[$start];
				while ($left < $length) {
					$maxLeftOrRight = $left;
					$right = 2 * $start + 2;
					if($right<$length && $a[$left] < $a[$right]) {
						$maxLeftOrRight = $right;
					}
					if($a[$maxLeftOrRight] <= $temp) {
						break;
					}
					$a[$start] = $a[$maxLeftOrRight];
					$start = $maxLeftOrRight;
					$left = 2 * $start + 1;
				}
				$a[$start] = $temp;
			}
		}
		
		private function swap(& $array, $a, $b) {
			$temp = $array[$a];
			$array[$a] = $array[$b];
			$array[$b] = $temp;
		}
	}