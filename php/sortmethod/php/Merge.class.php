<?php
	class Merge implements Sort {
		public function sort($array) {
			$this->msort($array, 0, count($array) - 1);
			return $array;
		}
		private function msort(& $data, $left, $right) {
			if($left < $right) {
				$center = floor(($left + $right)/2);
				$this->msort($data, $left, $center);
				$this->msort($data, $center+1, $right);
				$this->mergeSort($data, $left, $center, $right);
			}
		}
		
		private function mergeSort(& $data0, $left, $center, $right) {
			$tempData = array();
			$tempIndex = $left;
			$bLeft = $left;
			$mid = $center + 1;
			while($left<=$center && $mid<=$right) {
				if($data0[$left]<$data0[$mid]) {
					$tempData[$tempIndex++] = $data0[$left++];
				}else {
					$tempData[$tempIndex++] = $data0[$mid++];
				}
			}
			while($left<=$center) {
				$tempData[$tempIndex++] = $data0[$left++];
			}
			while($mid<=$right) {
				$tempData[$tempIndex++] = $data0[$mid++];
			}
			while($bLeft<=$right) {
				$aaaa = $tempData[$bLeft];
				$data0[$bLeft] = $aaaa;
				$bLeft++;
				//$data0[$bLeft] = $tempData[$bLeft++];
			}
		}
	}